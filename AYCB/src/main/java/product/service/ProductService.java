package product.service;

import java.util.List;

import product.model.ProductBean;


public interface ProductService {

	int saveproduct(ProductBean pb);

	List<ProductBean> getAllProducts();
	
	List<ProductBean> getProduct(int no);
	
	List<ProductBean> getBrandProduct(String brandname);
	
	List<ProductBean> getSeriesProduct(String series);
	
	List<ProductBean> getCateProduct(String cate);
	
	List<ProductBean> getkeyword(String keyword);
	
	List<ProductBean> getBrand();
	
	List<ProductBean> getSeries();
	
	List<ProductBean> getCate();

	int deleteProduct(int no);

	int updateMember(ProductBean pb);

}