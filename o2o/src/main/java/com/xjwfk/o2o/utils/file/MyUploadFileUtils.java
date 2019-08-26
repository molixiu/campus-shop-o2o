package com.xjwfk.o2o.utils.file;

import java.io.IOException;

import org.csource.common.MyException;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: MyUploadFileUtils
 * @Description: TODO(对文件上传到服务器的操作进行封装的工具类)
 * @author 白巾川
 * @date 2019年8月15日
 */

public class MyUploadFileUtils {

	public static String uploadFile(MultipartFile multipartFile) throws IOException, MyException {
		// 获得上传文件名和上传文件扩展名
		String uploadFileName = multipartFile.getOriginalFilename();
		String uploadFileExtName = MyFileUtils.getFileExtName(uploadFileName);

		// 将文件上传到文件服务器并返回该文件在文件服务器的路径
		String uploadPath = FastDFSClient.uploadFile(multipartFile.getBytes(), uploadFileExtName);
		return uploadPath;
	}
}
