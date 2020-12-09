package product.cartDao;

import java.util.ArrayList;
import java.util.List;

import product.cartModel.OrderBean;

public interface OrderDao {

	List<OrderBean> selectOrderitem(String name);

	boolean insertOrderitem(OrderBean order);

	boolean updateOrderitem(OrderBean order);

	boolean deleteOrderitem(int no);

	OrderBean selectUpdateitem(int ino);

}