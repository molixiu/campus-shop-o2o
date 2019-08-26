package com.xjwfk.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjwfk.o2o.entity.Product;
import com.xjwfk.o2o.entity.ProductImg;
import com.xjwfk.o2o.enumes.ExecutionEnum;
import com.xjwfk.o2o.enumes.QueryEnum;
import com.xjwfk.o2o.exceptions.ProductOperationException;
import com.xjwfk.o2o.mapper.ProductImgMapper;
import com.xjwfk.o2o.mapper.ProductMapper;
import com.xjwfk.o2o.service.ProductService;
import com.xjwfk.o2o.utils.PageCalculator;
import com.xjwfk.o2o.utils.file.FastDFSClient;
import com.xjwfk.o2o.vo.PageBean;

/**
 * @ClassName: ProductServiceImpl
 * @Description: TODO(service层关于商品的业务逻辑接口的实现类)
 * @author 白巾川
 * @date 2019年8月4日
 */

@Service
public class ProductServiceImpl implements ProductService {
	/**
	 * @Fields IMAGE_SERVER_URL : TODO(文件服务器的url)
	 */
	private String IMAGE_SERVER_URL;
	@Value("#{config.IMAGE_SERVER_URL}")
	//@Value表示去beans.xml文件中找id="config"的bean，它是通过注解的方式读取properties配置文件的，然后去相应的配置文件中读取key=IMAGE_SERVER_URL的对应的value值
	public void setIMAGE_SERVER_URL(String iMAGE_SERVER_URL) {
		IMAGE_SERVER_URL = iMAGE_SERVER_URL;
		System.out.println("啦啦啦");
	}

	@Autowired
	private ProductMapper productMapper;
	

	@Autowired
	private ProductImgMapper productImgMapper;

	@Override
	@Transactional
	public ExecutionEnum addProduct(Product product) {
		try {
			if (product != null) {
				int insertProduct = productMapper.insertProduct(product);
				if (insertProduct > 0) { // 商品添加成功
					Long productId = product.getProductId(); // 获得商品添加成功后返回的主键
					List<ProductImg> productImgList = product.getProductImgList(); // 获得商品的详情图片集合
					for (ProductImg productImg : productImgList) { // 设置商品详情图片的商品Id(对应数据库里的外键)
						productImg.setProductId(productId);
					}
					ExecutionEnum executionEnum = this.batchAddProductImg(productImgList);
					return executionEnum; // 商品和商品图片添加成功
				} else {
					throw new ProductOperationException(ExecutionEnum.FAIL.getStateInfo());
				}
			} else {
				throw new ProductOperationException(ExecutionEnum.FAIL.getStateInfo());
			}
		} catch (Exception e) {
			// 商品添加失败
			e.printStackTrace();
			throw new ProductOperationException(ExecutionEnum.FAIL.getStateInfo());
		}
	}

	@Override
	@Transactional
	public ExecutionEnum batchAddProductImg(List<ProductImg> productImgList) {
		try {
			if (productImgList != null) {
				int batchInsertProductImg = productImgMapper.batchInsertProductImg(productImgList);
				if (batchInsertProductImg > 0) {
					return ExecutionEnum.SUCCESS; // 批量添加商品详情图成功
				} else {
					throw new ProductOperationException(ExecutionEnum.FAIL.getStateInfo());
				}
			} else {
				throw new ProductOperationException(ExecutionEnum.FAIL.getStateInfo());
			}
		} catch (Exception e) {
			// 批量添加商品详情图失败
			throw new ProductOperationException(ExecutionEnum.FAIL.getStateInfo());
		}

	}

	@Override
	@Transactional
	public ExecutionEnum removeProduct(long productId, long shopId) {
		try {
			//根据商品Id获取该商品对象
			Product product = productMapper.queryProductById(productId);
			//从图片服务器上删除该商品的缩略图
			String thumbnail = product.getImgAddr().replace(IMAGE_SERVER_URL, "");	//要把服务器的地址去掉
			boolean deleteThumbnail = FastDFSClient.deleteFile(thumbnail);
			if (!deleteThumbnail) {	//如果从图片服务器上删除该商品的缩略图 把该图片的URL写入到日志中
				
			}
			//从图片服务器上删除该商品的详情图
			List<ProductImg> productImgList = product.getProductImgList();
			for(ProductImg productImg:productImgList) {
			String	detailImg = productImg.getImgAddr().replace(IMAGE_SERVER_URL, ""); //要把服务器的地址去掉
				boolean deleteDetailImg = FastDFSClient.deleteFile(detailImg);
				if (!deleteDetailImg) {	//如果从图片服务器上删除该商品的详情图 把该图片的URL写入到日志中
					
				}
			}
			
			int deleteProductImgByProductId = productImgMapper.deleteProductImgByProductId(productId);
			int deleteProduct = productMapper.deleteProduct(productId, shopId);
			if (deleteProductImgByProductId >= 0 && deleteProduct > 0) { // 商品详情图片数目可能为0,所以这里>= 0
				return ExecutionEnum.SUCCESS; // 删除商品成功
			} else {
				throw new ProductOperationException(ExecutionEnum.FAIL.getStateInfo());
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 删除商品失败
			throw new ProductOperationException(ExecutionEnum.FAIL.getStateInfo());
		}
	}

	@Override
	public PageBean<Product> getProductList(Product productCondition, int pageIndex, int pageSize) {
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);

		try {
			List<Product> queryProductList = productMapper.queryProductList(productCondition, rowIndex, pageSize);
			int queryProductCount = productMapper.queryProductCount(productCondition);

			PageBean<Product> pageBean = new PageBean<>(queryProductCount, pageSize, queryProductList);
			return pageBean; // 查询商店信息成功
		} catch (Exception e) {
			// 查询商品失败
			throw new ProductOperationException(QueryEnum.FAIL.getStateInfo());
		}
	}

	@Override
	public Product getProduct(long productId) {
		try {
			Product product = productMapper.queryProductById(productId);
			return product; // 查询商品成功
		} catch (Exception e) {
			// 查询商品失败
			throw new ProductOperationException(QueryEnum.FAIL.getStateInfo());
		}
	}

	@Override
	public ExecutionEnum modifyProduct(Product product, List<ProductImg> productImgList) {
		try {
			if (product != null) {
				long productId = product.getProductId();
				if (productImgList != null && productImgList.size() > 0) {	//如果要更改商品的详情图片需要把以前的图片删除然后更新
					productImgMapper.deleteProductImgByProductId(productId);
					productImgMapper.batchInsertProductImg(productImgList);
				}
				productMapper.updateProduct(product);
				return ExecutionEnum.SUCCESS;	//更新商品成功
			} else {
				throw new ProductOperationException(ExecutionEnum.FAIL.getStateInfo());
			}
		} catch (Exception e) {
			// 更新商品失败
			throw new ProductOperationException(ExecutionEnum.FAIL.getStateInfo());
		}
	}
}
