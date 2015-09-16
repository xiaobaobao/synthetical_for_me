package com.xb.global;

import android.app.Application;

import com.xb.utils.ExceptionHandler;
import com.xb.utils.FileUtil;
import com.xb.utils.SharedUtil;


/**
 * @todo: 在当前应用中添加 android:name="android.permission.WRITE_EXTERNAL_STORAGE"
 * @author: xiaobao
 * @time: 2015-9-15上午10:22:49
 */
public class GlobalContext extends Application {
	
	
	/** 当前应用 */
	private static GlobalContext globalContext = null;

	/**
	 * 私有构造方法
	 */
	protected GlobalContext() {
	
	}

	/**
	 * 获取当前应用
	 */
	public static GlobalContext getInstance() {
		if (globalContext == null) {
			synchronized (GlobalContext.class) {
				if (globalContext == null) {
					globalContext = new GlobalContext();
				}
			}
		}
		return globalContext;
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
		
		//SharedPreferences 中的Context 必须在这里初始化
		SharedUtil.config(this);
		
		//设置缓存的路径,必须在setExceptionHandler前
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
