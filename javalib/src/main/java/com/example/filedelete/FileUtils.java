package com.example.filedelete;


import java.io.File;
/**
 * Created by weikailaing on 2016/6/28.
 * 文件管理类
 */

public class FileUtils {
    
//    public static final String NEW_PATH = Environment.getExternalStorageDirectory().getPath() + "/meiyaoni/customerComment";
    public static final String NEW_PATH = "D:"+File.separator+"新建文件夹";

    //创建路径
    public static  void createSDCardDir() {
//        if (!SDCardUtils.isSDCardEnable()) {
//            System.out.println("未找到SD卡");
//            return;
//        }
        //得到一个路径，内容是sdcard的文件夹路径和名字
        File path = new File(NEW_PATH);
        if (!path.exists()) {
            //若不存在，创建目录，可以在应用启动的时候创建
            path.mkdirs();
            System.out.println("paht ok,path:" + NEW_PATH);
        }
    }
    //删除图片
    public void deleteBitmapByName(String name) {
        File file = new File(NEW_PATH + name);
        if (file.exists()) {
            file.delete();
        }
    }

//    //保存图片
//    public static void savaBitmap(Bitmap bitmap, String bitmapName) {
//        //创建路径
//        createSDCardDir();
//        File file = new File(NEW_PATH + bitmapName);
//        try {
//            FileOutputStream out = new FileOutputStream(file);
//            if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)) {
//                out.flush();
//                out.close();
//            }
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODOm Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    //删除文件
    public static void deleteFile(File file) {
        if (file.exists() == false) {
            return;
        } else {
            //是否是一个标准文件
            if (file.isFile()) {
                file.delete();
                return;
            }
            //是否是一个目录
            if (file.isDirectory()) {
                File[] childFile = file.listFiles();
                if (childFile == null || childFile.length == 0) {
                    file.delete();
                    return;
                }
                for (File f : childFile) {
                    //删除children file
                    deleteFile(f);
                }
                //删除父file 对象
                file.delete();
            }
        }
    }
    
  
}
