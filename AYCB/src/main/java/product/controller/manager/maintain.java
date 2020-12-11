package product.controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.model.ProductBean;
import product.service.ProductService;
import product.service.impl.ProductServiceImpl;

@WebServlet("/maintain")
public class maintain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String NextPage = "";
		String todo = request.getParameter("todo");

		HttpSession session = request.getSession();
		ProductService ps = new ProductServiceImpl();
		int count = 0;
		
		if (todo == null) {
			NextPage = request.getContextPath() + "/Manager";
		} else if (todo.equals("add")) {
			String brandno = request.getParameter("brandno");
			String brandname = request.getParameter("brandname");
			String producttype = request.getParameter("producttype");
			String productname = request.getParameter("productname");
			String productseries = request.getParameter("productseries");
			String productcategory = request.getParameter("productcategory");
			Double productprice = Double.parseDouble(request.getParameter("productprice"));
			
			ProductBean pb = new ProductBean(brandno, brandname, producttype, productname, productseries,
					productcategory, "all", productprice);
			session.setAttribute("pb", pb);
			count = ps.saveproduct(pb);
			if (count == 1) {
				NextPage = request.getContextPath() + "/Manager";
			}
		} else if (todo.equals("remove")) {
			Integer productno = Integer.parseInt(request.getParameter("productno"));
			count = ps.deleteProduct(productno);
			if (count == 1) {
				NextPage = request.getContextPath() + "/Manager";
			}
		} else if (todo.equals("update")) {
			Integer productno = Integer.parseInt(request.getParameter("productno"));
			String brandno = request.getParameter("brandno");
			String brandname = request.getParameter("brandname");
			String producttype = request.getParameter("producttype");
			String productname = request.getParameter("productname");
			String productseries = request.getParameter("productseries");
			String productcategory = request.getParameter("productcategory");
			String skintype = request.getParameter("skintype");
			Double productprice = Double.parseDouble(request.getParameter("productprice"));
			
			ProductBean pb = new ProductBean(productno, brandno, brandname, producttype, productname, productseries,
					productcategory, skintype, productprice);
			session.setAttribute("pb", pb);
			count = ps.updateMember(pb);
			if (count == 1) {
				NextPage = request.getContextPath() + "/Manager";
			}
		}
		response.sendRedirect(response.encodeRedirectURL(NextPage));
	}

}
