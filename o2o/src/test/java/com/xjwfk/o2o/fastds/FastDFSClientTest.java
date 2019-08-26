package com.xjwfk.o2o.fastds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.utils.file.FastDFSClient;

/**
 * @ClassName: FastDFSClient
 * @Description: TODO(测试 调试 FastDFSClient的上传，删除 如何使用 )
 * @author 白巾川
 * @date 2019年7月23日
 */

public class FastDFSClientTest {

	@Test
	// 通过文件的路径上传到服务器
	public void test_uploadFile_byPath() throws FileNotFoundException, IOException, MyException {
		// 1、加载配置文件，配置文件中的内容就是tracker服务的地址。
		String path = this.getClass().getResource("/").getPath();
		ClientGlobal.init(path + "fastdfs_client.conf");
		ClientGlobal.init(path + "fastdfs_client2.conf");
		// 2、创建一个TrackerClient对象。直接new一个。
		TrackerClient trackerClient = new TrackerClient();
		// 3、使用TrackerClient对象创建连接，获得一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 4、创建一个StorageServer的引用，值为null
		StorageServer storageServer = null;
		// 5、创建一个StorageClient对象，需要两个参数TrackerServer对象、StorageServer的引用
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 6、使用StorageClient对象上传图片。
		// 扩展名不带“.”
		String[] strings = storageClient.upload_file("C:/Users/Administrator/Desktop/2.jpg", "jpg", null);
		// 7、返回数组。包含组名和图片的路径。
		for (String string : strings) {
			System.out.println(string);
		}
	}

	@Test
	public void test_deleteFile() throws FileNotFoundException, IOException, MyException {
		// 1、加载配置文件，配置文件中的内容就是tracker服务的地址。
		String classpath = Thread.class.getResource("/").getPath();
		String conf = classpath + "/conf/fastdfs_client.conf";
		ClientGlobal.init(conf);
		// 2、创建一个TrackerClient对象。直接new一个。
		TrackerClient trackerClient = new TrackerClient();
		// 3、使用TrackerClient对象创建连接，获得一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 4、创建一个StorageServer的引用，值为null
		StorageServer storageServer = null;
		// 5、创建一个StorageClient对象，需要两个参数TrackerServer对象、StorageServer的引用
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);

		int i = storageClient.delete_file("group1", "M00/00/00/rBEABF03sd-AN7HhAAhs_nM12dM706.jpg");
		System.out.println(i == 0 ? "删除成功" : "删除失败:" + i);
	}

	@Test
	public void test_FastDFSClient_upload() throws IOException, MyException {
		String uploadFile = FastDFSClient.uploadFile("C:\\Users\\Administrator\\Desktop\\校园商铺\\2.jpg");
		System.out.println(uploadFile);
	}
	
	@Test
	public void test_FastDFSClient_delete() throws IOException, MyException {
		boolean deleteFile = FastDFSClient.deleteFile("group1/M00/00/00/rBEABF1VTGKAPc_7AAhs_nM12dM215.jpg");
		System.out.println(deleteFile);
	}
	
	@Test
	public void test_11() {
		ClassLoader classLoader = FastDFSClientTest.class.getClassLoader();
		URL url = classLoader.getResource("");
		String classpath = url.getPath();
		String conf = classpath + "conf/fastdfs_client.conf";
		
	}
}
