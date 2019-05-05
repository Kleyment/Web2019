package controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductsDAO;
import dao.UsersDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDAO usersDAO;
	private ProductsDAO productsDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String pseudo = request.getParameter("pseudo");
		String password = request.getParameter("password");
		try {
			ResultSet rs = usersDAO.getUser(pseudo, password);
			if(rs.next()) {
				Cookie c = new Cookie("hashcart",rs.getString(5));
				response.addCookie(c);
				if (rs.getString(4).contentEquals("admin")) {
					ResultSet rsUsers = usersDAO.getUsers();
					ResultSet rsProducts = productsDAO.getProducts();
					request.setAttribute("users", rsUsers);
					request.setAttribute("products", rsProducts);
					RequestDispatcher rd = request.getRequestDispatcher("AdminPanel.jsp");
					rd.forward(request, response);
				} else {
					int idUser = rs.getInt(1);
					String pseudoUser = rs.getString(2);
					ResultSet rsProducts = productsDAO.getProducts();
					request.setAttribute("idUser", idUser);
					request.setAttribute("pseudoUser", pseudoUser);
					request.setAttribute("products", rsProducts);
					RequestDispatcher rd = request.getRequestDispatcher("UserPanel.jsp");
					rd.forward(request, response);
				}
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
