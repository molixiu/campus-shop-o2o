$(function() {
	var shopId = getQueryString('shopId');
	$('#shopInfo').attr('href', '/o2o/shopadmin/shop/edit?shopId=' + shopId);
	$('#productManage').attr('href', '/o2o/shop/product/manage?shopId=' + shopId);
	$('#productCategoryManage').attr('href', '/o2o/shop/productCategory_manage?shopId=' + shopId);
});