$(function() {
	//获取地址栏的shopId
	var shopId = getQueryString('shopId');
	// 获取当前店铺设定的商品类别列表的URL
	var categoryUrl = '/o2o/shopManage/productCategory/list?shopId=' + shopId;
	

	getCategory();
	// 为商品添加操作提供该店铺下的所有商品类别列表
	function getCategory() {
		$.getJSON(categoryUrl, function(result) {
			if (result.success) {
				var productCategoryList = result.data;
				var optionHtml = '';
				productCategoryList.map(function(item, index) {
					optionHtml += '<option value="'
							+ item.productCategoryId + '">'
							+ item.productCategoryName + '</option>';
				});
				$('#category').html(optionHtml);
			}
		});
	}

	// 针对商品详情图控件组，若该控件组的最后一个元素发生变化（即上传了图片），
	// 且控件总数未达到6个，则生成新的一个文件上传控件
	$('.detail-img-div').on('change', '.detail-img:last-child', function() {
		if ($('.detail-img').length < 6) {
			$('#detail-img').append('<input type="file" class="detail-img" name="detailImgs">');
		}
	});

	//在表单里的隐藏<input>赋值
	$('#inputShopId').attr('value', shopId);
	//返回商品管理按钮 
	$('#back').attr('href', '/o2o/shop/product/manage?shopId=' + shopId);
});