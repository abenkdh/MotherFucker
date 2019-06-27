package uc.benkkstudio.bypasslibrary;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.chrisplus.rootmanager.RootManager;

import org.joda.time.DateTimeConstants;

import java.util.Arrays;
import java.util.Date;

import io.bloco.faker.Faker;

public class FakeBuildProp {
    private static Editor editor;
    private static RandomDataGenerator random_data = new RandomDataGenerator();
    private static RootManager rm = RootManager.getInstance();

    public static void samsungGalaxyS10(SharedPreferences pref){
            String buildId = "PPR1." + random_data.randomNumber(6) + "." + random_data.randomNumber(3); //PPR1.180610.011
            String displayId = random_data.randomStringg(13); // G970FXXU1ASCA
            String buildFlavor = random_data.randomStringg(12).toLowerCase(); //beyond0ltexx
            editor = pref.edit();
            editor.clear();
            editor.putString("ro.build.id", buildId);
            editor.putString("ro.build.display.id", buildId + "." + displayId);
            editor.putString("ro.build.version.incremental", displayId);
            editor.putString("ro.build.version.security_patch", "2019-03-01");
            editor.putString("ro.build.date", random_data.randomDates());
            editor.putString("ro.build.date.utc", String.valueOf(new Date().getTime()));
            editor.putString("ro.build.time", String.valueOf(new Date().getTime()));
            editor.putString("ro.build.type", "user");
            editor.putString("ro.build.user", "dpi");
            editor.putString("ro.build.host", random_data.randomWord());
            editor.putString("ro.build.flavor", String.format("%s-user", buildFlavor));
            editor.putString("ro.product.model", "SM-G970F");
            editor.putString("ro.product.brand", "samsung");
            editor.putString("ro.product.name", buildFlavor);
            editor.putString("ro.product.device", removeLastChar(buildFlavor, 5));
            editor.putString("ro.build.product", removeLastChar(buildFlavor, 2));
            editor.putString("ro.product.board", "universal" + random_data.randomInt(5000, 10000));
            editor.putString("ro.product.manufacturer", "samsung");
            editor.putString("ro.product.locale.language", Faker.DEFAULT_LOCALE);
            editor.putString("ro.product.locale.region", "US");
            editor.putString("ro.board.platform", "exynos" + random_data.randomInt(1, 10));
            editor.putString("ro.build.description", String.format("%s-user 9 %s %s release-keys", buildFlavor, buildId, displayId));
            editor.putString("ro.build.fingerprint", String.format("samsung/%s/%s:9/%s/%s:user/release-keys", buildFlavor, removeLastChar(buildFlavor, 5), buildId, displayId));
            editor.putString("ro.build.characteristics", "phone");
            editor.apply();
    }

    public static void xiaomiRedmiNote5Pro(SharedPreferences pref){
            String buildId = "OPM1." + random_data.randomNumber(6) + "." + random_data.randomNumber(3); //OPM1.171019.011
            String incremental = "V10.2.1.0." + random_data.randomString(7); // OEIMIXM
            String buildFlavor = random_data.randomStringg(6).toLowerCase(); //beyond0ltexx
            String board = "sdm" + random_data.randomInt(600, 700);
            editor = pref.edit();
            editor.clear();
            editor.putString("ro.build.id", buildId);
            editor.putString("ro.build.display.id", buildId);
            editor.putString("ro.build.version.incremental", incremental);
            editor.putString("ro.build.version.security_patch", "2019-03-01");
            editor.putString("ro.build.date", random_data.randomDates());
            editor.putString("ro.build.date.utc", String.valueOf(new Date().getTime()));
            editor.putString("ro.build.time", String.valueOf(new Date().getTime()));
            editor.putString("ro.build.type", "user");
            editor.putString("ro.build.user", "builder");
            editor.putString("ro.build.host", "mi-server");
            editor.putString("ro.build.flavor", String.format("%s-user", buildFlavor));
            editor.putString("ro.product.model", "Redmi Note 5");
            editor.putString("ro.product.brand", "xiaomi");
            editor.putString("ro.product.name", buildFlavor);
            editor.putString("ro.product.device", buildFlavor);
            editor.putString("ro.build.product", buildFlavor);
            editor.putString("ro.product.board", board);
            editor.putString("ro.product.manufacturer", "xiaomi");
            editor.putString("ro.product.locale.language", Faker.DEFAULT_LOCALE);
            editor.putString("ro.product.locale.region", "US");
            editor.putString("ro.board.platform", board);
            editor.putString("ro.build.description", String.format("%s-user 8.1.0 %s %s release-keys", buildFlavor, buildId, incremental)); // whyred-user 8.1.0 OPM1.171019.011 V10.2.1.0.OEIMIXM release-keys
            editor.putString("ro.build.fingerprint", String.format("xiaomi/%s/%s:8.1.0/%s/%s:user/release-keys", buildFlavor, buildFlavor, buildId, incremental));
            editor.putString("ro.build.characteristics", "phone");
            editor.apply();
    }

    public static void samsungGalaxyS4(SharedPreferences pref){
        String build_id = random_data.randomBuildId();
        String build_version_inc = random_data.randomVersionIncremental();
        String build_date = random_data.randomDate();
        String build_time = random_data.randomTime();
        String build_device = random_data.randomString(5);
        String build_platform = "MSM" + random_data.randomInt(1000, 9000);
        String product_name = random_data.randomString(7);
        String build_flavor = random_data.randomWord();
        editor = pref.edit();
        editor.clear();
        editor.putString("ro.build.id", build_id);
        editor.putString("ro.build.display.id", build_id);
        editor.putString("ro.build.version.incremental", build_version_inc);
        editor.putString("ro.build.version.security_patch", build_date);
        editor.putString("ro.build.date", String.format("%s %s", build_date, build_time));
        editor.putString("ro.build.date.utc", String.valueOf(new Date().getTime()));
        editor.putString("ro.build.time", String.valueOf(new Date().getTime()));
        editor.putString("ro.build.type", "user");
        editor.putString("ro.build.user", random_data.randomWord());
        editor.putString("ro.build.host", random_data.randomWord());
        editor.putString("ro.build.flavor", String.format("%s-user", build_flavor));
        editor.putString("ro.product.model", "GT-I9505");
        editor.putString("ro.product.brand", "samsung");
        editor.putString("ro.product.name", product_name);
        editor.putString("ro.product.device", build_device);
        editor.putString("ro.build.product", build_device);
        editor.putString("ro.product.board", build_platform);
        editor.putString("ro.product.manufacturer", "samsung");
        editor.putString("ro.product.locale.language", Faker.DEFAULT_LOCALE);
        editor.putString("ro.product.locale.region", "US");
        editor.putString("ro.board.platform", build_platform.toLowerCase());
        editor.putString("ro.build.description", String.format("%s-user 5.1.1 %s %s release-keys", build_flavor, build_id, build_version_inc));
        editor.putString("ro.build.fingerprint", String.format("samsung/%s/%s:5.1.1/%s/%s:user/release-keys", product_name, build_device, build_id, build_version_inc));
        editor.putString("ro.build.characteristics", "phone");
        editor.apply();

    }

    public static void samsungGalaxyS9(SharedPreferences pref){
        String build_id = random_data.randomBuildId();
        String build_version_inc = random_data.randomVersionIncremental();
        String build_date = random_data.randomDate();
        String build_time = random_data.randomTime();
        String build_device = random_data.randomString(5);
        String build_platform = "MSM" + random_data.randomInt(1000, 9000);
        String product_name = random_data.randomString(7);
        String build_flavor = random_data.randomWord();
        editor = pref.edit();
        editor.clear();
        editor.putString("ro.build.id", build_id);
        editor.putString("ro.build.display.id", build_id);
        editor.putString("ro.build.version.incremental", build_version_inc);
        editor.putString("ro.build.version.security_patch", build_date);
        editor.putString("ro.build.date", String.format("%s %s", build_date, build_time));
        editor.putString("ro.build.date.utc", String.valueOf(new Date().getTime()));
        editor.putString("ro.build.time", String.valueOf(new Date().getTime()));
        editor.putString("ro.build.type", "user");
        editor.putString("ro.build.user", random_data.randomWord());
        editor.putString("ro.build.host", random_data.randomWord());
        editor.putString("ro.build.flavor", String.format("%s-user", build_flavor));
        editor.putString("ro.product.model", "SM-G965F");
        editor.putString("ro.product.brand", "samsung");
        editor.putString("ro.product.name", product_name);
        editor.putString("ro.product.device", build_device);
        editor.putString("ro.build.product", build_device);
        editor.putString("ro.product.board", build_platform);
        editor.putString("ro.product.manufacturer", "samsung");
        editor.putString("ro.product.locale.language", Faker.DEFAULT_LOCALE);
        editor.putString("ro.product.locale.region", "US");
        editor.putString("ro.board.platform", build_platform.toLowerCase());
        editor.putString("ro.build.description", String.format("%s-user 8.1.0 %s %s release-keys", build_flavor, build_id, build_version_inc));
        editor.putString("ro.build.fingerprint", String.format("samsung/%s/%s:8.1.0/%s/%s:user/release-keys", product_name, build_device, build_id, build_version_inc));
        editor.putString("ro.build.characteristics", "phone");
        editor.apply();

    }

    private static String removeLastChar(String str, int lenght) {
        return str.substring(0, str.length() - lenght);
    }

    public static void changeBuildProp(SharedPreferences pref) {
        String[] params_to_remove = new String[]{"ro.hardware.gps", "ro.hardware.sensors"};
        StringBuilder param_value_out = new StringBuilder();
        String[] lines = rm.runCommand("cat /system/build.prop").getMessage().split("\n");
        int length = lines.length;
        int i = 0;
        while (i < length) {
            RootManager rm2;
            String line = lines[i];
            String str = "";
            if (line.equals(str)) {
                rm2 = rm;
            } else if (line.contains("#")) {
                rm2 = rm;
            } else {
                String[] param_value = line.split("=");
                String value = "";
                if (param_value.length == 2) {
                    value = param_value[1];
                }
                String str2 = "%s=%s\n";
                if (pref.contains(param_value[0])) {
                    Object[] objArr = new Object[2];
                    objArr[0] = param_value[0];
                    rm2 = rm;
                    objArr[1] = pref.getString(param_value[0], str);
                    param_value_out.append(String.format(str2, objArr));
                } else {
                    rm2 = rm;
                    if (!Arrays.asList(params_to_remove).contains(param_value[0])) {
                        param_value_out.append(String.format(str2, param_value[0], value));
                    }
                }
            }
            i++;
            rm = rm2;
        }
        String out = String.format("\n%s", param_value_out.toString());
        BenkkHelper.remount();
        BenkkHelper.writeToBuildProp(out);
    }
}
