package uc.benkkstudio.bypassme;

import android.app.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;

import uc.benkkstudio.bypasslibrary.BenkkHelper;
import uc.benkkstudio.bypasslibrary.FakeBuildProp;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    TextView txtLog;
    Button btnBypass, btnRunGame, settingsButton;
    ArrayList<String> hackingList;
    int d = 0;
    Handler handler;
    Runnable runnable;
    ImageView header;
    MaterialSpinner spinner;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        pref = getApplicationContext().getSharedPreferences("phone", Context.MODE_PRIVATE);
        spinner = findViewById(R.id.spinner);
        setSpinner();
        txtLog = findViewById(R.id.textStatus);
        btnBypass = findViewById(R.id.bypassButton);
        btnRunGame = findViewById(R.id.runButton);
        settingsButton = findViewById(R.id.settingsButton);
        header = findViewById(R.id.header);
        Typeface font = Typeface.createFromAsset(getAssets(), "headliner.ttf");
        settingsButton.setTypeface(font);
        btnRunGame.setTypeface(font);
        btnBypass.setTypeface(font);
        initBypass("Ready to bypass.");
        btnRunGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPubg(MainActivity.this);
            }
        });
        btnBypass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                params.setMargins(20,20,20,20);
                txtLog.setLayoutParams(params);
                txtLog.setText("Please Wait..");
                bypass(v);
            }
        });
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.unknowncheats.me");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private void setSpinner(){
        spinner.setItems("Please select phone template", "Xiaomi Redmi Note 5 Pro", "Samsung Galaxy S10", "Samsung Galaxy S9+", "Samsung Galaxy S4");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override public void onItemSelected(MaterialSpinner view, int pos, long id, String item) {
                position = pos;
            }
        });
    }

    public void initBypass(String result) {
        hackingList = new ArrayList<>();
        hackingList.add("\nGetting hook algorithm..");
        hackingList.add("\nGetting root information..");
        hackingList.add("\nPreparing Resault...");
        hackingList.add("\n" + result);
        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                if (d >= hackingList.size()) {
                    txtLog.setTextColor(getResources().getColor(R.color.bypassed));
                    handler.removeCallbacks(runnable);
                    Drawable run = getResources().getDrawable(R.drawable.run_pubgm);
                    Drawable bypass = getResources().getDrawable(R.drawable.bypass_btn);
                    btnBypass.setBackground(bypass);
                    btnRunGame.setBackground(run);
                } else {
                    txtLog.setText(((String) hackingList.get(d)));
                    d++;
                }
                handler.postDelayed(this, 1000);
            }
        };
        runnable.run();
    }

    private void startPubg(MainActivity mainActivity) {
        Intent intent = mainActivity.getPackageManager().getLaunchIntentForPackage("com.tencent.ig");
        mainActivity.startActivity(intent);
    }

    public void bypass(View view) {
        if(position == 0){
            Snackbar.make(view, "Please select phone template!", Snackbar.LENGTH_LONG).show();
        } else  if(position == 1){
            FakeBuildProp.xiaomiRedmiNote5Pro(pref);
            bypassIt();
        } else  if(position == 2){
            FakeBuildProp.samsungGalaxyS10(pref);
            bypassIt();
        } else if(position == 3){
            FakeBuildProp.samsungGalaxyS9(pref);
            bypassIt();
        } else if(position == 4){
            FakeBuildProp.samsungGalaxyS4(pref);
            bypassIt();
        }

    }

    private void bypassIt(){
        //FakeBuildProp.changeBuildProp(pref);
        //BenkkHelper.deleteLdLib();
        //BenkkHelper.clearGameData();
        //BenkkHelper.resetGoogleAd();
        //BenkkHelper.deleteGenyd();
        rebootDialog();
    }

    private void rebootDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setTitle("Bypass Success")
                .setMessage("Please reboot your emu..")
                .setCancelable(true)
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("Reboot", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        BenkkHelper.reboot();
                    }
                })
                .setNegativeButton("Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }
}
