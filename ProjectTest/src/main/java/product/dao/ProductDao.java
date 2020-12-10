package product.dao;

import java.util.List;

import product.model.ProductBean;


public interface ProductDao {

	int saveProduct(ProductBean pb);

	List<ProductBean> getAllProducts();
	
	List<ProductBean> getProduct(int no);
	
	List<ProductBean> getBrandProduct(String brandname);
	
	List<ProductBean> getSeriesProduct(String series);

	List<ProductBean> getCateProduct(String cate);
	
	List<ProductBean> getKeyword(String keyword);
	
	List<ProductBean> getBrand();
	
	List<ProductBean> getSeries();
	
	List<ProductBean> getCate();

	int deleteProduct(int no);

	int updateProduct(ProductBean pb);

}