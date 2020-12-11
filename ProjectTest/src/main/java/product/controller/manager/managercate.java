package product.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.ProductBean;
import product.service.ProductService;
import product.service.impl.ProductServiceImpl;


@WebServlet("/managercate")
public class managercate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productcategory = request.getParameter("cate"); 
	
		ProductService ps = new ProductServiceImpl();
		List<ProductBean> list = ps.getCateProduct(productcategory);
		List<ProductBean> brand = ps.getBrand();
		List<ProductBean> series = ps.getSeries();
		List<ProductBean> cate = ps.getCate();
		
		request.setAttribute("Products", list);
		request.setAttribute("Brands", brand);
		request.setAttribute("series", series);
		request.setAttribute("cates", cate);
		request.getRequestDispatcher("manager.jsp").forward(request, response);
		return;
	}

}
