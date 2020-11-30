package product;


import java.io.Serializable;

public class Product implements Serializable{
	
	private String brand_No;
	private String brand_Name;
	private String product_Type;
	private int product_No;
	private String product_Name;
	private String product_Series;
	private String product_Category;
	private String skintype;
	private int product_Price;
	
	public Product() {
		
	}
	
	public Product(String brand_Name, String product_Series, String product_Category, String product_Name, int product_Price) {
		this.brand_Name = brand_Name;
		this.product_Series = product_Series;
		this.product_Category = product_Category;
		this.product_Name = product_Name;
		this.product_Price = product_Price;
	}
	
	public String getBrand_No() {
		return brand_No;
	}
	public void setBrand_No(String brand_No) {
		this.brand_No = brand_No;
	}
	public String getBrand_Name() {
		return brand_Name;
	}
	public void setBrand_Name(String brand_Name) {
		this.brand_Name = brand_Name;
	}
	public String getProduct_Type() {
		return product_Type;
	}
	public void setProduct_Type(String product_Type) {
		this.product_Type = product_Type;
	}
	public int getProduct_No() {
		return product_No;
	}
	public void setProduct_No(int product_No) {
		this.product_No = product_No;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getProduct_Series() {
		return product_Series;
	}
	public void setProduct_Series(String product_Series) {
		this.product_Series = product_Series;
	}
	public String getProduct_Category() {
		return product_Category;
	}
	public void setProduct_Category(String product_Category) {
		this.product_Category = product_Category;
	}
	public String getSkintype() {
		return skintype;
	}
	public void setSkintype(String skintype) {
		this.skintype = skintype;
	}
	public int getProduct_Price() {
		return product_Price;
	}
	public void setProduct_Price(int product_Price) {
		this.product_Price = product_Price;
	}

}
