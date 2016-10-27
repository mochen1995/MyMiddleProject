package com.example.mmcc.mymiddleproject.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/**
 * Created by mmcc on 2016/10/25.
 */

public class SDUtil {
    private static final String picDir = "我的图片收藏";

    private static String curSavePath;

    private static String getSdDir() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static boolean DownLoadImage(ByteArrayOutputStream bos) {
        String fileName = System.currentTimeMillis() + ".jpg";
        String dir = getSdDir() + File.separator + picDir;
        File file = new File(dir);
        if (!file.exists())
            file.mkdir();

        String path =file.getAbsolutePath()+ File.separator + fileName;
        File pic = new File(path);
        curSavePath = pic.getAbsolutePath();
        try {
            pic.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = bos.toByteArray();
        Log.e("tag", "path = " + path);
        Log.e("tag", "DownLoadImage size: " + bytes.length);

        FileOutputStream os = null;
        try {
            os = new FileOutputStream(pic);
            os.write(bytes);
            os.flush();
            Log.e("tag","写入成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static String getPath(){
        return curSavePath;
    }
}
