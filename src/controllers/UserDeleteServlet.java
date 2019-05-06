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

import dao.CartDAO;
import dao.ProductsDAO;
import dao.UsersDAO;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDAO usersDAO;
	private ProductsDAO productsDAO;
	private CartDAO cartDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
		usersDAO = new UsersDAO();
		productsDAO = new ProductsDAO();
		cartDAO = new CartDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultSet rsUser;
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			ResultSet rs = usersDAO.getUser(id);
			rs.next();
			String hashCart = rs.getString(5);
			usersDAO.deleteUser(id);
			cartDAO.deleteCart(hashCart);
			rsUser = usersDAO.getUsers();
			ResultSet rsProduct = productsDAO.getProducts();
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
