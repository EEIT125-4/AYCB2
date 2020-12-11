package tool;

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


@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductService ps = new ProductServiceImpl();
		List<ProductBean> cate = ps.getCate();
		
		request.setAttribute("cates", cate);
		request.getSession().setAttribute("cates", cate);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
