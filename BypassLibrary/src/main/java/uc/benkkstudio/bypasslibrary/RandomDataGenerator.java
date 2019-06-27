package uc.benkkstudio.bypasslibrary;

import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import io.bloco.faker.Faker;


public class RandomDataGenerator {
    private Faker faker = new Faker();
    private static final String NUMBER = "0123456789";
    private static final String CHAR = "ABCDEF0123456789";

    private static Random RANDOM = new Random();
    public String randomBuildId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(faker.lorem.characters(3));
        stringBuilder.append(faker.number.number(2));
        stringBuilder.append(faker.lorem.characters(1));
        return stringBuilder.toString().toUpperCase();
    }

    public String randomVersionIncremental() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(faker.lorem.characters(1));
        stringBuilder.append(faker.number.between(1000, 9999));
        stringBuilder.append(faker.lorem.characters(3));
        stringBuilder.append(faker.number.number(1));
        stringBuilder.append(faker.lorem.characters(3));
        stringBuilder.append(faker.number.number(1));
        return stringBuilder.toString().toUpperCase();
    }

    public String randomDates() {
        SimpleDateFormat dfDateTime  = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.getDefault());
        int year = randBetween(2019, 2019);// Here you can set Range of years you need
        int month = randBetween(0, 11);
        int hour = randBetween(9, 22); //Hours will be displayed in between 9 to 22
        int min = randBetween(0, 59);
        int sec =randBetween(0, 59);
        GregorianCalendar gc = new GregorianCalendar(year, month, 1);
        int day = randBetween(1, gc.getActualMaximum(gc.DAY_OF_MONTH));
        gc.set(year, month, day, hour, min,sec);

        return dfDateTime.format(gc.getTime());
    }

    public  int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public String randomStringg(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHAR.charAt(RANDOM.nextInt(CHAR.length())));
        }
        return sb.toString();
    }

    public String randomNumber(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(NUMBER.charAt(RANDOM.nextInt(NUMBER.length())));
        }
        return sb.toString();
    }

    public String randomDate() {
        String date_from = "2015-01-01";
        String date_to = "2015-12-31";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.format(faker.date.between(formatter.parse(date_from), formatter.parse(date_to)));
        } catch (ParseException e) {
            e.printStackTrace();
            return formatter.format(new Date());
        }
    }

    public String randomTime() {
        int hour = this.faker.number.between(0, 23);
        int minutes = this.faker.number.between(0, 59);
        String hour_ = String.valueOf(hour);
        String minutes_ = String.valueOf(minutes);
        String str = "0";
        if (hour >= 0 && hour <= 9) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(hour);
            hour_ = stringBuilder.toString();
        }
        if (minutes >= 0 && minutes <= 9) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(minutes);
            minutes_ = stringBuilder2.toString();
        }
        return String.format("%s:%s", hour_, minutes_);
    }

    public String randomString(int length) {
        return this.faker.lorem.characters(length);
    }

    public String randomWord() {
        return this.faker.lorem.word();
    }

    public String randomInt(int from, int to) {
        return String.valueOf(this.faker.number.between(from, to));
    }
}
