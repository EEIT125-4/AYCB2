package product;
import java.io.Serializable;
import java.util.Date;

public class OrderBean implements Serializable {
	
	private int  orderNo;
	private String customerId;
	private Date ordertime;
	private int price;
	private int quantity;
	private String status;	
	
	public OrderBean() {
		
	}

	public OrderBean(int orderNo, String customerId, Date ordertime, int price, int quantity, String status) {
		super();
		this.orderNo = orderNo;
		this.customerId = customerId;
		this.ordertime = ordertime;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
