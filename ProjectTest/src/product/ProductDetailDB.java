package product;

public class ProductDetailDB {
	
	private static String[] brand_No;
	private static String[] brand_Name;
	private static String[] product_Type;
	private static Integer[] product_No;
	private static String[] product_Name;
	private static String[] product_Series;
	private static String[] product_Category;
	private static String[] skintype;
	private static Integer[] product_Price;
	
	
	public static String getBrand_No(int ID) {
		return brand_No[ID];
	}
	public static void setBrand_No(String[] brand_No) {
		ProductDetailDB.brand_No = brand_No;
	}
	public static String getBrand_Name(int ID) {
		return brand_Name[ID];
	}
	public static void setBrand_Name(String[] brand_Name) {
		ProductDetailDB.brand_Name = brand_Name;
	}
	public static String getProduct_Type(int ID) {
		return product_Type[ID];
	}
	public static void setProduct_Type(String[] product_Type) {
		ProductDetailDB.product_Type = product_Type;
	}
	public static Integer getProduct_No(int ID) {
		return product_No[ID];
	}
	public static void setProduct_No(Integer[] product_No) {
		ProductDetailDB.product_No = product_No;
	}
	public static String getProduct_Name(int ID) {
		return product_Name[ID];
	}
	public static void setProduct_Name(String[] product_Name) {
		ProductDetailDB.product_Name = product_Name;
	}
	public static String getProduct_Series(int ID) {
		return product_Series[ID];
	}
	public static void setProduct_Series(String[] product_Series) {
		ProductDetailDB.product_Series = product_Series;
	}
	public static String getProduct_Category(int ID) {
		return product_Category[ID];
	}
	public static void setProduct_Category(String[] product_Category) {
		ProductDetailDB.product_Category = product_Category;
	}
	public static String getSkintype(int ID) {
		return skintype[ID];
	}
	public static void setSkintype(String[] skintype) {
		ProductDetailDB.skintype = skintype;
	}
	public static Integer getProduct_Price(int ID) {
		return product_Price[ID];
	}
	public static void setProduct_Price(Integer[] product_Price) {
		ProductDetailDB.product_Price = product_Price;
	}
	public static int size() {
	       return product_Name.length;
	}
}
