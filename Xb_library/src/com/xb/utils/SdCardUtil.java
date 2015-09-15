package com.xb.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import java.io.*;



/**
 * @todo: SD 卡信息
 * @author: xiaobao
 * @time: 2015-9-15上午10:49:42
 */
public class SdCardUtil {
	
    private static final String TAG = SdCardUtil.class.getSimpleName();

	/**
	 * SD卡是否可用
	 * @return 
	 */
	public static boolean isCanUseSD() {
		try {
			return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * SD卡绝对目录
	 * @return
	 */
	public static String getSDAbsolutePath() {
		if (isCanUseSD()) {
			return Environment.getExternalStorageDirectory().getAbsolutePath();
		} else {
			return "";
		}
	}
    
    
	
	/**
	 * 得到SD卡的详情
	 * @return
	 */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static SDCardInfo getSDCardInfo() {
        SDCardInfo sd = new SDCardInfo();
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            sd.isExist = true;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                File sdcardDir = Environment.getExternalStorageDirectory();
                StatFs sf = new StatFs(sdcardDir.getPath());
                sd.totalBlocks = sf.getBlockCountLong();
                sd.blockByteSize = sf.getBlockSizeLong();
                sd.availableBlocks = sf.getAvailableBlocksLong();
                sd.availableBytes = sf.getAvailableBytes();
                sd.freeBlocks = sf.getFreeBlocksLong();
                sd.freeBytes = sf.getFreeBytes();
                sd.totalBytes = sf.getTotalBytes();
            }
        }
        LogUtil.d(TAG, sd.toString());
        return sd;
    }


    /**
     * see more {@link android.os.StatFs}
     */
    public static class SDCardInfo {
        public boolean isExist;
        public long totalBlocks;
        public long freeBlocks;
        public long availableBlocks;
        public long blockByteSize;
        public long totalBytes;
        public long freeBytes;
        public long availableBytes;
        @Override
        public String toString() {
            return "SDCardInfo{" +
                   "isExist=" + isExist +
                   ", totalBlocks=" + totalBlocks +
                   ", freeBlocks=" + freeBlocks +
                   ", availableBlocks=" + availableBlocks +
                   ", blockByteSize=" + blockByteSize +
                   ", totalBytes=" + totalBytes +
                   ", freeBytes=" + freeBytes +
                   ", availableBytes=" + availableBytes +
                   '}';
        }
    }
	
	
}
