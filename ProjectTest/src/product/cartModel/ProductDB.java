package product.cartModel;
import java.io.Serializable;

public class ProductDB implements Serializable {
	
	
	//JavaBean
	private static String[] productNames;	//陣列
	private static Integer[] productPrices;
	
	public static void setProductName(String[] pproductNames) {
		productNames=pproductNames;
	}
	
	public static void setProductPrice(Integer[] pproductPrices) {
		productPrices=pproductPrices;
	}
	
	public static int size() {
	       return productNames.length;
	}//陣列長度
	
	public static String getProductName(int productNo) {
	       return productNames[productNo-1];
	}
	
	public static int getProductPrice(int productNo) {
	      return productPrices[productNo-1].intValue();//intValue取值
	}
	
}
