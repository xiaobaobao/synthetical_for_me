
package com.xb.utils;

import java.io.File;

import com.xb.global.Config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Environment;


/**
 * @todo: 文件操作类.
 * @author: xiaobao
 * @time: 2015-9-15上午10:46:08
 */
public class FileUtil {
	
	/** 默认APP根目录. */
	private static  String downloadRootDir = null;
	
    /** 默认下载图片文件目录. */
	private static  String imageDownloadDir = null;
    
    /** 默认下载文件目录. */
	private static  String fileDownloadDir = null;
	
	/** 默认缓存目录.*/
	private static  String cacheDownloadDir = null;
	
	/** 默认下载数据库文件的目录. */
	private static  String dbDownloadDir = null;
	
	/** 默认异常保存目录  */
	private static String exceptionCacheDir = null;
	
	/** 剩余空间大于200M才使用SD缓存. */
	private static int freeSdSpaceNeededToCache = 200*1024*1024;
	
	
	
	
	
	/**
	 * 描述：初始化存储目录.
	 * @param context the context
	 */
	public static void initFileDir(Context context){
		
		PackageInfo info = AppUtil.getPackageInfo(context);
		
		//默认下载文件根目录. 
		String downloadRootPath="";
		
		if(SdCardUtil.isCanUseSD()){
			downloadRootPath = SdCardUtil.getSDAbsolutePath()+File.separator+"Android"+ File.separator+ "data" + File.separator+info.packageName+File.separator;
		}else{
			downloadRootPath = File.separator + "data"+ File.separator + "data" + File.separator+info.packageName+File.separator;
		}
		
		downloadRootDir = downloadRootPath;
		
	    //默认下载图片文件目录. 
		String imageDownloadPath = downloadRootPath + Config.DOWNLOAD_IMAGE_DIR + File.separator;
	    
	    //默认下载文件目录.
		String fileDownloadPath = downloadRootPath + Config.DOWNLOAD_FILE_DIR + File.separator;
		
		//默认缓存目录.
		String cacheDownloadPath = downloadRootPath + Config.CACHE_DIR + File.separator;
		
		//默认DB目录.
		String dbDownloadPath = downloadRootPath + Config.DB_DIR + File.separator;
		
		//默认异常目录.
		String cacheExceptionPath = downloadRootPath + Config.EXCEPTION_DIR + File.separator;
	    
		
		File cacheDownloadDirFile = new File(cacheDownloadPath);
		if(!cacheDownloadDirFile.exists()){
			cacheDownloadDirFile.mkdirs();
		}
		cacheDownloadDir = cacheDownloadDirFile.getPath();
				
		File imageDownloadDirFile = new File(imageDownloadPath);
		if(!imageDownloadDirFile.exists()){
			imageDownloadDirFile.mkdirs();
		}
		imageDownloadDir = imageDownloadDirFile.getPath();
				
		File fileDownloadDirFile = new File(fileDownloadPath);
		if(!fileDownloadDirFile.exists()){
			fileDownloadDirFile.mkdirs();
		}
		fileDownloadDir = fileDownloadDirFile.getPath();
				
		File dbDownloadDirFile = new File(dbDownloadPath);
		if(!dbDownloadDirFile.exists()){
			dbDownloadDirFile.mkdirs();
		}
		dbDownloadDir = dbDownloadDirFile.getPath();
		
		File cacheExceptionFile = new File(cacheExceptionPath);
		if(!cacheExceptionFile.exists()){
			cacheExceptionFile.mkdirs();
		}
		exceptionCacheDir = cacheExceptionFile.getPath();
	}


	public static String getDownloadRootDir() {
		return downloadRootDir;
	}

	public static String getImageDownloadDir() {
		return imageDownloadDir;
	}

	public static String getFileDownloadDir() {
		return fileDownloadDir;
	}

	public static String getCacheDownloadDir() {
		return cacheDownloadDir;
	}

	public static String getDbDownloadDir() {
		return dbDownloadDir;
	}

	public static String getExceptionCacheDir() {
		return exceptionCacheDir;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
