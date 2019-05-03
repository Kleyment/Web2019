package controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductsDAO;
import dao.UsersDAO;

/**
 * Servlet implementation class ProductModifyServlet
 */
@WebServlet("/ProductModifyServlet")
public class ProductModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDAO usersDAO;
	private ProductsDAO productsDAO;
	private int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductModifyServlet() {
        super();
        usersDAO = new UsersDAO();
        productsDAO = new ProductsDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!(request.getParameter("modif") == null)) {
			id = Integer.parseInt(request.getParameter("id"));
			ResultSet rs;
			try {
				rs = productsDAO.getProduct(id);
				request.setAttribute("product", rs);
				RequestDispatcher rd = request.getRequestDispatcher("ModificationProduct.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			String name = request.getParameter("name");
			Double price = Double.parseDouble(request.getParameter("price"));
			String image = null;
			if (!(request.getParameter("image") == null)) {
				image = request.getParameter("image");
			}
			ResultSet rsProduct;
			try {
				if (image != null) {
					productsDAO.modifyProduct(id, name, price, image);
				} else {
					productsDAO.modifyProduct(id, name, price);
				}
				rsProduct = productsDAO.getProducts();
				ResultSet rsUser = usersDAO.getUsers();
				request.setAttribute("users", rsUser);
				request.setAttribute("products", rsProduct);
				RequestDispatcher rd = request.getRequestDispatcher("AdminPanel.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
