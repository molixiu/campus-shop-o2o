package com.xjwfk.o2o.utils.file;

/**
* @ClassName: FileUtils
* @Description: TODO(对一些关于文件进行操作的工具类)
* @author 白巾川
* @date 2019年8月15日
*/

public class MyFileUtils {

	
	/**   
	 * @Title: getFileExtName   
	 * @Description: TODO(输入文件名返回文件的扩展名,即后缀)   
	 * @param: @param fileName
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */  
	public static String getFileExtName(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}
}
