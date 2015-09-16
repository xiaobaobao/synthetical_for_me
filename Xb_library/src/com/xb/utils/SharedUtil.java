package com.xb.utils;

import com.xb.global.Config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;



/**
 * @todo 保存到 SharedPreferences 的数据.
 * @author xiaobao
 * @time 2015-9-15 下午11:51:01
 */
public class SharedUtil {

	private static Context mContext;
	private static final String SHARED_PATH = Config.SHARED_PATH;
	private static SharedPreferences sharedPreferences;

	/**
	 * 在Application中一定要先配置
	 * @param context
	 */
	public static void config(Context context) {
		mContext = context;
	}
	
	public static SharedPreferences getDefaultSharedPreferences() {
		if(sharedPreferences==null){
			sharedPreferences = mContext.getSharedPreferences(SHARED_PATH, Context.MODE_PRIVATE);
		}
		return sharedPreferences;
	}
	
	public static void putInt(Context context,String key, int value) {
		SharedPreferences sharedPreferences = getDefaultSharedPreferences();
		Editor edit = sharedPreferences.edit();
		edit.putInt(key, value);
		edit.commit();
	}

	public static int getInt(Context context,String key) {
		SharedPreferences sharedPreferences = getDefaultSharedPreferences();
		return sharedPreferences.getInt(key, 0);
	}
	
	public static void putString(Context context,String key, String value) {
		SharedPreferences sharedPreferences = getDefaultSharedPreferences();
		Editor edit = sharedPreferences.edit();
		edit.putString(key, value);
		edit.commit();
	}

	public static String getString(Context context,String key) {
		SharedPreferences sharedPreferences = getDefaultSharedPreferences();
		return sharedPreferences.getString(key,null);
	}
	
	public static void putBoolean(Context context,String key, boolean value) {
		SharedPreferences sharedPreferences = getDefaultSharedPreferences();
		Editor edit = sharedPreferences.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}

	public static boolean getBoolean(Context context,String key,boolean defValue) {
		SharedPreferences sharedPreferences = getDefaultSharedPreferences();
		return sharedPreferences.getBoolean(key,defValue);
	}
	
	public static void remove(Context context,String key) {
		SharedPreferences sharedPreferences = getDefaultSharedPreferences();
		Editor edit = sharedPreferences.edit();
		edit.remove(key);
		edit.commit();
	}
	
	
	//rbh 需要加一个清除所有信息的一个方法
	

}
