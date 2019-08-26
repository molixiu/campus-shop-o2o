package com.xjwfk.o2o.utils.file;

import java.io.IOException;
import java.net.URL;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import com.xjwfk.o2o.fastds.FastDFSClientTest;

/**
* @ClassName: FastDFSClient
* @Description: TODO(这个工具类里面包装好 对文件上传到服务器和删除服务器文件的方法,可以直接调用不用实例化对象,
* 因为静态代码块已经读取过默认的配置文件,如果想自定义加载指定的配置文件可以通过实例化对象来加载
* )
* @author 白巾川
* @date 2019年7月24日
*/
public class FastDFSClient {

	public FastDFSClient(String conf) {
		if (conf.contains("classpath:")) {
			conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
		}
		try {
			ClientGlobal.init(conf);
		} catch (IOException | MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**   
	 * @Title: uploadFile   
	 * @Description: TODO(根据文件路径上传文件)   
	 * @param: @param filePath(文件路径)
	 * @param: @return	上传到服务器的文件路径
	 * @param: @throws IOException
	 * @param: @throws MyException      
	 * @return: String      
	 * @throws   
	 */  
	public static String uploadFile(String filePath) throws IOException, MyException {
		// 获得文件扩展名
		String uploadFileExtName = filePath.substring(filePath.lastIndexOf(".") + 1);

		// 6、使用StorageClient对象上传图片。
		StorageClient storageClient = getStorageClient();
		String[] returnFilePaths = storageClient.upload_file(filePath, uploadFileExtName, null);
		return String.join("/", returnFilePaths);
	}
	
	/**   
	 * @Title: uploadFile   
	 * @Description: TODO(通过IO流上传文件)   
	 * @param: @param fileContent(文件内容,数据类型为字节数组)
	 * @param: @param extName(文件扩展名)
	 * @param: @return
	 * @param: @throws IOException
	 * @param: @throws MyException      
	 * @return: String 上传到服务器的文件路径
	 * @throws   
	 */  
	public static String uploadFile(byte[] fileContent, String extName) throws IOException, MyException {
		// 6、使用StorageClient对象上传图片。
		StorageClient1 storageClient1 = getStorageClient1();
		String[] returnFilePaths = storageClient1.upload_appender_file(fileContent, extName, null);
		return String.join("/", returnFilePaths);
	}

	/**   
	 * @Title: deleteFile   
	 * @Description: TODO(删除文件)   
	 * @param: @param filePath
	 * @param: @return 删除成功返回true 否则返回false
	 * @param: @throws IOException
	 * @param: @throws MyException      
	 * @return: boolean      
	 * @throws   
	 */  
	public static boolean deleteFile(String filePath) throws IOException, MyException {
		// 分别获得文件在哪个组存储和 在这个组的路径
		String group = filePath.substring(0, filePath.indexOf("/"));
		String path = filePath.substring(filePath.indexOf("/") + 1);

		// 6、使用StorageClient对象上传图片。
		StorageClient storageClient = getStorageClient();
		int delete_file = storageClient.delete_file(group, path);
		return delete_file == 0 ? true : false;
	}

	/**
	 * @Title: getStorageClient @Description:
	 * TODO(获得StorageClient存储对象 这个对象只能通过文件路径上传) @param: @return @param: @throws
	 * IOException @return: StorageClient @throws
	 */
	private static StorageClient getStorageClient() throws IOException {
		// 2、创建一个TrackerClient对象。直接new一个。
		TrackerClient trackerClient = new TrackerClient();
		// 3、使用TrackerClient对象创建连接，获得一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 4、创建一个StorageServer的引用，值为null
		StorageServer storageServer = null;
		// 5、创建一个StorageClient对象，需要两个参数TrackerServer对象、StorageServer的引用
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		return storageClient;
	}
	
	/**   
	 * @Title: getStorageClient1   
	 * @Description: TODO(获得StorageClient1对象 这个对象可以通过IO流进行上传)   
	 * @param: @return
	 * @param: @throws IOException      
	 * @return: StorageClient1      
	 * @throws   
	 */  
	private static StorageClient1 getStorageClient1() throws IOException{
		// 2、创建一个TrackerClient对象。直接new一个。
		TrackerClient trackerClient = new TrackerClient();
		// 3、使用TrackerClient对象创建连接，获得一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 4、创建一个StorageServer的引用，值为null
		StorageServer storageServer = null;
		// 5、创建一个StorageClient对象，需要两个参数TrackerServer对象、StorageServer的引用
		StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
		return storageClient1;
	}

	static {
		// 1、加载配置文件，配置文件中的内容就是tracker服务的地址。
		ClassLoader classLoader = FastDFSClient.class.getClassLoader();
		URL url = classLoader.getResource("");
		String classpath = url.getPath();
		String conf = classpath + "conf/fastdfs_client.conf";
		try {
			ClientGlobal.init(conf);
		} catch (IOException | MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
