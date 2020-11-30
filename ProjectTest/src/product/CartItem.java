package product;

public class CartItem {
	private int product_No;
	private int qtyOrdered;//採購數量

	
	public CartItem(int product_No, int qtyOrdered) {
		
		this.product_No = product_No;
		this.qtyOrdered = qtyOrdered;
	}
	
	public int getProduct_No() {
		return product_No;
	}
	public void setProduct_No(int product_No) {
		this.product_No = product_No;
	}
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	
	public String getProduct_Name() {
	      return ProductDB.getProduct_Name(product_No);
	   }
	
	public int getProduct_Price() {
	      return ProductDB.getProduct_Price(product_No);
	   }

	
}
