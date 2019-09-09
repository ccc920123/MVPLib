package com.startdon.resofveh.utils;

import android.app.Activity;
import android.content.Context;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.tools.PictureFileUtils;

import java.io.File;

/**
 * 描述：多图选择框架 PictureSelector的初始化配置
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5 16:13
 * 修改人：
 * 修改时间：
 */

public class PictureSelectorConfig {

    /**
     * @param activity     activity
     * @param path
     * @param maxTotal     最多选择图片的张数
     * @param isEnableCrop 是否裁剪图片
     * @param isCompress   是否压缩图片
     */
    public static void initMultiConfig(Activity activity, String path, int maxTotal, boolean isEnableCrop,
                                       boolean isCompress, int rotiaX, int rotiaY) {
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector pictureSelector = PictureSelector.create(activity);

        pictureSelector.openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
//                .theme()//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .maxSelectNum(maxTotal <= 0 ? 1 : maxTotal)// 最大图片选择数量 int
                .minSelectNum(0)// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .previewVideo(true)// 是否可预览视频 true or false
                .enablePreviewAudio(false) // 是否可播放音频 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
//                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                .enableCrop(isEnableCrop)// 是否裁剪 true or false

                .glideOverride(160, 160)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .isGif(false)// 是否显示gif图片 true or false
                .compressSavePath(path)//压缩图片保存地址
//                .showCropFrame()// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
//                .showCropGrid()// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .openClickSound(false)// 是否开启点击声音 true or false
//                .selectionMedia()// 是否传入已选图片 List<LocalMedia> list
                .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
//                .cropCompressQuality()// 裁剪压缩质量 默认90 int
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
//                .cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
                .videoQuality(1)// 视频录制质量 0 or 1 int
//                .videoMaxSecond(60)// 显示多少秒以内的视频or音频也可适用 int
//                .videoMinSecond(2)// 显示多少秒以内的视频or音频也可适用 int
//                .recordVideoSecond(60)//视频秒数录制 默认60s int
                .isDragFrame(true)// 是否可拖动裁剪框(固定) false
                .withAspectRatio(rotiaX, rotiaY)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示 true or false
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(false)// 是否圆形裁剪 true or false
                .rotateEnabled(true) // 裁剪是否可旋转图片 true or false
                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false

                .compress(isCompress)// 是否压缩 true or false

                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code

    }


    /**
     * @param fragment     fragment
     * @param path
     * @param maxTotal     最多选择图片的张数
     * @param isEnableCrop 是否裁剪图片
     * @param isCompress   是否压缩图片
     */
    public static void initMultiConfig(android.support.v4.app.Fragment fragment, String path, int maxTotal, boolean isEnableCrop,
                                       boolean isCompress, int rotiaX, int rotiaY) {
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector pictureSelector = PictureSelector.create(fragment);

        pictureSelector.openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
//                .theme()//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .maxSelectNum(maxTotal <= 0 ? 1 : maxTotal)// 最大图片选择数量 int
                .minSelectNum(0)// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .previewVideo(true)// 是否可预览视频 true or false
                .enablePreviewAudio(false) // 是否可播放音频 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
//                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                .enableCrop(isEnableCrop)// 是否裁剪 true or false

                .glideOverride(160, 160)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .isGif(false)// 是否显示gif图片 true or false
                .compressSavePath(path)//压缩图片保存地址
//                .showCropFrame()// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
//                .showCropGrid()// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .openClickSound(false)// 是否开启点击声音 true or false
//                .selectionMedia()// 是否传入已选图片 List<LocalMedia> list
                .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
//                .cropCompressQuality()// 裁剪压缩质量 默认90 int
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
//                .cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
                .videoQuality(1)// 视频录制质量 0 or 1 int
//                .videoMaxSecond(60)// 显示多少秒以内的视频or音频也可适用 int
//                .videoMinSecond(2)// 显示多少秒以内的视频or音频也可适用 int
//                .recordVideoSecond(60)//视频秒数录制 默认60s int
                .isDragFrame(true)// 是否可拖动裁剪框(固定) false
                .withAspectRatio(rotiaX, rotiaY)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示 true or false
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(false)// 是否圆形裁剪 true or false
                .rotateEnabled(true) // 裁剪是否可旋转图片 true or false
                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false

                .compress(isCompress)// 是否压缩 true or false

                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code

    }

    /**
     * 删除缓存
     *
     * @param mContext
     */
    public static void deleteCacheDirFile(Context mContext) {

        PictureFileUtils.deleteCacheDirFile(mContext);


    }

    /**
     * 删除文件夹下的文件
     *
     * @param path
     */
    public static void deleteFile(String path) {
        deleteDir(path);

    }

    //删除文件夹和文件夹里面的文件
    public static void deleteDir(final String pPath) {
        File dir = new File(pPath);
        deleteDirWihtFile(dir);
    }

    public static void deleteDirWihtFile(File dir) {
        if (dir == null || !dir.exists() || !dir.isDirectory())
            return;
        for (File file : dir.listFiles()) {
            if (file.isFile())
                file.delete(); // 删除所有文件
            else if (file.isDirectory())
                deleteDirWihtFile(file); // 递规的方式删除文件夹
        }

    }
}
