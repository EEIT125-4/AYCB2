package product;
import java.io.Serializable;
import java.util.Date;

public class OrderBean implements Serializable {
	
	private int  order_No;
	private String customer_Id;
	private Date order_time;
	private int price;
	private int quantity;
	private String status;	
	
	public OrderBean() {
		
	}
	
	public OrderBean(int order_No, String customer_Id, Date order_time, int price, int quantity, String status) {
		super();
		this.order_No = order_No;
		this.customer_Id = customer_Id;
		this.order_time = order_time;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}
	
	public int getOrder_No() {
		return order_No;
	}
	public void setOrder_No(int order_No) {
		this.order_No = order_No;
	}
	public String getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		this.customer_Id = customer_Id;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
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
	@Override
	public String toString() {
		return "OrderBean [order_No=" + order_No + ", customer_Id=" + customer_Id + ", order_time=" + order_time
				+ ", price=" + price + ", quantity=" + quantity + ", status=" + status + "]";
	}

	
	
	
	
}
