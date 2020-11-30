package product;
import java.io.Serializable;

public class ProductDB implements Serializable {
	
	
	//JavaBean
	private static String[] product_Names;	//陣列
	private static Integer[] product_Prices;
	
	public static void setProduct_Name(String[] pproduct_Names) {
		product_Names=pproduct_Names;
	}
	
	public static void setProduct_Price(Integer[] pproduct_Prices) {
		product_Prices=pproduct_Prices;
	}
	
	public static int size() {
	       return product_Names.length;
	}//陣列長度
	
	public static String getProduct_Name(int product_No) {
	       return product_Names[product_No-1];
	}
	
	public static int getProduct_Price(int product_No) {
	      return product_Prices[product_No-1].intValue();//intValue取值
	}
	
}
