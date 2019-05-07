package controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
 * Servlet implementation class UserModifyServlet
 */
@WebServlet("/UserModifyServlet")
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsersDAO usersDAO; 
    private ProductsDAO productsDAO;
    private CartDAO cartDAO;
    private int id;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		if (!(request.getParameter("modif") == null)) {
			id = Integer.parseInt(request.getParameter("id"));
			ResultSet rs;
			try {
				rs = usersDAO.getUser(id);
				request.setAttribute("user", rs);
				request.setAttribute("error", "false");
				RequestDispatcher rd = request.getRequestDispatcher("ModificationUser.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			String pseudo = request.getParameter("pseudo");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			ResultSet rsUser;
			ResultSet rs;
			try {
				ResultSet verif = usersDAO.getUser(pseudo);
				if (verif.next()) {
					rs = usersDAO.getUser(id);
					request.setAttribute("user", rs);
					request.setAttribute("error", "true");
					RequestDispatcher rd = request.getRequestDispatcher("ModificationUser.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("error", "false");
					rs = usersDAO.getUser(id);
					rs.next();
					String hashBefore = rs.getString(5);
					usersDAO.modifyUser(id, pseudo, password, role);
					rs = usersDAO.getUser(id);
					rs.next();
					String hashAfter = rs.getString(5);
					cartDAO.updateCart(hashBefore, hashAfter);
					rsUser = usersDAO.getUsers();
					ResultSet rsProduct = productsDAO.getProducts();
					request.setAttribute("users", rsUser);
					request.setAttribute("products", rsProduct);
					RequestDispatcher rd = request.getRequestDispatcher("AdminPanel.jsp");
					rd.forward(request, response);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
