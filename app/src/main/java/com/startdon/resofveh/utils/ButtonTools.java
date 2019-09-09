package com.startdon.resofveh.utils;
/**
 * 描述：判断按钮是否多次点击
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5 16:31
 * 修改人：
 * 修改时间：
 */
public class ButtonTools {
    private static long lastClickTime;
/**
 * 
 * @param waitTime  时间
 * 判断按钮是否多次点击
     * @return  true表示在短时间内点击到的按钮  false表示在指定的时间后点击有效果
 * @return
 * @throws 
 * @throw
 */
    public static boolean isFastDoubleClick(int waitTime) {
        long time = System.currentTimeMillis();   
        if ( time - lastClickTime < waitTime) {   
            return true;   
        }   
        lastClickTime = time;   
        return false;   
    }
}