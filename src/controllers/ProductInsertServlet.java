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
 * Servlet implementation class ProductInsertServlet
 */
@WebServlet("/ProductInsertServlet")
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductsDAO productsDAO;
	private UsersDAO usersDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsertServlet() {
        super();
        productsDAO = new ProductsDAO();
        usersDAO = new UsersDAO();
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
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		String image = null;
		if (!(request.getParameter("image") == null)) {
			image = request.getParameter("image");
		}
		try {
			if (image != null) {
				productsDAO.insertProduct(name, price,image);
			} else {
				productsDAO.insertProduct(name, price);
			}
			ResultSet rsProducts = productsDAO.getProducts();
			ResultSet rsUsers = usersDAO.getUsers();
			request.setAttribute("users", rsUsers);
			request.setAttribute("products", rsProducts);
			RequestDispatcher rd = request.getRequestDispatcher("AdminPanel.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
