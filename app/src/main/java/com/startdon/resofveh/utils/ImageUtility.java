package com.startdon.resofveh.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * 类名: ImageUtility
 * <br/>功能描述: 图像处理类
 * <br/>作者: 陈渝金
 * <br/>时间: 2016/11/9
 * <br/>最后修改者:
 * <br/>最后修改内容:
 */

public class ImageUtility {

    /**
     base64编码字符串
     * @param path   图片路径-具体到文件
     * @return
     * @Description: 将base64编码字符串转换为图片
     * @Author:
     * @CreateTime:
     */
    public static String imageToBase64(String path){
        if(TextUtils.isEmpty(path)){
            return null;
        }
        InputStream is = null;
        byte[] data = null;
        String result = null;
        try{
            is = new FileInputStream(path);
            //创建一个字符流大小的数组。
            data = new byte[is.available()];
            //写入数组
            is.read(data);
            //用默认的编码格式进行编码
            result = Base64.encodeToString(data,Base64.DEFAULT);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null !=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;

    }

    /**
     * 方法名称: convertBitmapToString
     * <br/>方法详述: 将bitmap转换成成base64的字符串
     * <br/>参数:
     * <br/>返回值:
     * <br/>异常抛出 Exception:
     * <br/>异常抛出 NullPointerException:
     */

    public static String convertBitmapToString(Bitmap bitmap) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

        return Base64.encodeToString(out.toByteArray(), Base64.DEFAULT);
    }

    /**
     * 方法名称: convertBitmapStringToByteArray
     * <br/>方法详述: 将bitmap转换成base64的字节流
     * <br/>参数:
     * <br/>返回值:
     * <br/>异常抛出 Exception:
     * <br/>异常抛出 NullPointerException:
     */

    public static byte[] convertBitmapStringToByteArray(String bitmapByteString) {
        return Base64.decode(bitmapByteString, Base64.DEFAULT);
    }

    /**
     * base64转为bitmap
     *
     * @param base64Data
     * @return
     */
    public static Bitmap base64ToBitmap(String base64Data) {
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(base64Data)) {
            byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        return bitmap;
    }

    /**
     * 方法名称: savePicture
     * <br/>方法详述: 将图片保存到sd内存卡
     * <br/>参数: context,bitmap 照片可以用waterMarkPicture（）转换成bitmap，
     * <br/>phoneName：照片名称，phonePath：照片路径。
     * <br/>返回值:String图片地址
     * <br/>异常抛出 Exception:
     * <br/>异常抛出 NullPointerException:
     */

    public static String savePicture(Context context, Bitmap bitmap, String phoneName, String phonePath) {
        int cropHeight;
        bitmap = ThumbnailUtils.extractThumbnail(bitmap, bitmap.getWidth(),
                bitmap.getHeight(), ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        File mediaStorageDir = new File(phonePath);

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }

//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
//                .format(new Date());
        File mediaFile = new File(mediaStorageDir.getPath() + File.separator
                + phoneName + ".jpg");

        // Saving the bitmap
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

            FileOutputStream stream = new FileOutputStream(mediaFile);
            stream.write(out.toByteArray());
            stream.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return mediaFile.getAbsolutePath();
    }





    public static String bitmapToBaseString(Bitmap bitmap) {

        ByteArrayOutputStream currentPhotoBAOS = null;
        String baseString = null;
        try {
            currentPhotoBAOS = new ByteArrayOutputStream();
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 80, currentPhotoBAOS)) {
                // originBitmap.recycle();
                currentPhotoBAOS.flush();
                byte[] imageBytes = currentPhotoBAOS.toByteArray();
                currentPhotoBAOS.close();
                currentPhotoBAOS = null;
                baseString = Base64.encodeToString(imageBytes, Base64.DEFAULT);
                imageBytes = null;

            }

        } catch (Exception e) {
            baseString = "";
        } finally {
            if (currentPhotoBAOS != null) {
                try {
                    currentPhotoBAOS.close();
                    currentPhotoBAOS = null;
                } catch (Exception ee) {
                }
            }
        }
        return baseString;

    }



}