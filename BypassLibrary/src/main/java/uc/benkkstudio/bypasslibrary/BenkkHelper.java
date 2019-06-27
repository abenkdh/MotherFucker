package uc.benkkstudio.bypasslibrary;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;

import com.chrisplus.rootmanager.RootManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressLint("WrongConstant")
public class BenkkHelper {
    private static RootManager rm = RootManager.getInstance();

    public static void remount() {
        rm.runCommand("mount -o rw,remount /system");
    }

    public static void writeToBuildProp(String s) {
        rm.runCommand(String.format("echo '%s' > /system/build.prop", s));
    }

    public static void reboot() {
        rm.runCommand("reboot");
    }

    public static void clearGameData() {
        rm.runCommand("rm -rf /sdcard/tencent");
        rm.runCommand("rm -rf /sdcard/MidasOversea");
        rm.runCommand("rm -rf /sdcard/.backups");
        rm.runCommand("pm clear com.tencent.ig");
        rm.runCommand("pm clear com.pubg.krmobile");
        rm.runCommand("pm clear com.vng.pubgmobile");
    }

    public static void resetGoogleAd() {
        rm.runCommand("rm -rf /data/data/com.google.android.gms/shared_prefs/adid_settings.xml");
    }

    public static void deleteGenyd() {
        remount();
        rm.runCommand(String.format("rm -rf %s", "/system/bin/genyd"));
    }

    public static void deleteLdLib() {
        remount();
        rm.runCommand("rm -rf /system/lib/libldutils.so");
    }

    public static boolean copyAsset(AssetManager assetManager, String fromAssetPath, String toPath) {
        try {
            InputStream in = assetManager.open(fromAssetPath);
            new File(toPath).createNewFile();
            OutputStream out = new FileOutputStream(toPath);
            copyFile(in, out);
            in.close();
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        while (true) {
            int read = in.read(buffer);
            int read2 = read;
            if (read != -1) {
                out.write(buffer, 0, read2);
            } else {
                return;
            }
        }
    }


    public static void moveFile(String file, String dest) {
        remount();
        rm.runCommand(String.format("cp -R %s %s", file, dest));
        rm.runCommand(String.format("rm -rf %s", file));
    }

}