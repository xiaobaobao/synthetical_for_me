package com.xb.application;

import android.app.Application;

import com.xb.utils.ExceptionHandler;
import com.xb.utils.FileUtil;


/**
 * @todo: 在当前应用中添加 android:name="android.permission.WRITE_EXTERNAL_STORAGE"
 * @author: xiaobao
 * @time: 2015-9-15上午10:22:49
 */
public class XbAplication extends Application {
	
	
	/** 当前应用 */
	private static XbAplication xbAplication = null;

	/**
	 * 私有构造方法
	 */
	protected XbAplication() {
	
	}

	/**
	 * 获取当前应用
	 */
	public static XbAplication getInstance() {
		if (xbAplication == null) {
			synchronized (XbAplication.class) {
				if (xbAplication == null) {
					xbAplication = new XbAplication();
				}
			}
		}
		return xbAplication;
	}

	
	
	@Override
	public void onCreate() {
		super.onCreate();

		initConfig();
		
	}

	/**
	 * 初始化配置
	 */
	private void initConfig() {
		//必须在setExceptionHandler前
		initCache();
		
		setExceptionHandler();
	}
	
	/**
	 * 初始化file缓存目录
	 */
	private void initCache() {
		FileUtil.initFileDir(getApplicationContext());
	}
	
	/**
	 * 在开启异常监听线程
	 */
	private void setExceptionHandler(){
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(FileUtil.getExceptionCacheDir(), null));
	}
}
