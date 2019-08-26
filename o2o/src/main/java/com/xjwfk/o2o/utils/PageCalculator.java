package com.xjwfk.o2o.utils;

public class PageCalculator {
	
	/**   
	 * @Title: calculateRowIndex   
	 * @Description: TODO(把前端里传来的页码转换为数据库里的行码)   
	 * @param: @param pageIndex
	 * @param: @param pageSize
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */  
	public static int calculateRowIndex(int pageIndex, int pageSize) {
		return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
	}
}
