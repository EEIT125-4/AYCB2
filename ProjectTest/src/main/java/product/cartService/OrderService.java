package product.cartService;

import java.util.List;

import product.cartModel.OrderBean;
import product.cartModel.ProductDB;

public interface OrderService {

	List<OrderBean> selectOrderitem(String name);

	boolean insertOrderitem(OrderBean order);

	boolean updateOrderitem(OrderBean order);

	boolean deleteOrderitem(int no);

	OrderBean selectUpdateitem(int ino);
	
	ProductDB getProductDB();

}