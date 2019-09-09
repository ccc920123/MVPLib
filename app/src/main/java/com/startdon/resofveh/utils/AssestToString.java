/**
 * @文件名：AssestToString.java
 * @author Administrator user=chenpan
 * @创建日期  2015-10-22
 * @功能描述：
 */
package com.startdon.resofveh.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * @类名 :AssestToString.java
 * @author Administrator
 * @功能描述:
 * @创建时间:2015-10-22
 */
public class AssestToString {

	public static String xmltoString(Context context, String stringName) {
		InputStream xml=null;
		String result =null;
		try {
			xml = context.getResources().getAssets().open(stringName);

			int length = xml.available();// 获取文字字数
			byte[] buffer = new byte[length];
			xml.read(buffer);// 读到数组中
			// 设置编码
//			 result = EncodingUtils.getString(buffer, "UTF-8");
			result=new String(buffer, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
