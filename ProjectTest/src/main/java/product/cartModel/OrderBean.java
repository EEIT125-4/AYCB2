package product.cartModel;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "orders_item")

public class OrderBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  orderNo;
	@Column(name = "customerId", columnDefinition = "nvarchar(20) NOT NULL")
	private String customerId;
	@Column(name = "Date", columnDefinition = "datetime NOT NULL")
	private Date orderTime;
	@Column(name = "price", columnDefinition = "int NOT NULL")
	private Integer price;
	@Column(name = "quantity", columnDefinition = "int NOT NULL")
	private Integer quantity;
	@Column(name = "status", columnDefinition = "nvarchar(10) NOT NULL")
	private String status;	
	
	public OrderBean() {
		
	}

	public OrderBean(Integer orderNo, String customerId, Date orderTime, Integer price, Integer quantity,
			String status) {
		super();
		this.orderNo = orderNo;
		this.customerId = customerId;
		this.orderTime = orderTime;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getOrderTtime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("OrderBean [orderNo=");
		builder.append(orderNo);
		builder.append(", customerId=");
		builder.append(customerId);
		builder.append(", ordertime=");
		builder.append(orderTime);
		builder.append(", price=");
		builder.append(price);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
}
