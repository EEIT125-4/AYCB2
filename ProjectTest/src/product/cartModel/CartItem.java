package product.cartModel;

public class CartItem {
	
	private int productNo;
	private int qtyOrdered;// 採購數量

	public CartItem(int productNo, int qtyOrdered) {

		this.productNo = productNo;
		this.qtyOrdered = qtyOrdered;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProduct_No(int productNo) {
		this.productNo = productNo;
	}

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	public String getProductName() {
		return ProductDB.getProductName(productNo);
	}

	public int getProductPrice() {
		return ProductDB.getProductPrice(productNo);
	}

}
