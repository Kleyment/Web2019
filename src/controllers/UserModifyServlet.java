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

import dao.UsersDAO;

/**
 * Servlet implementation class UserModifyServlet
 */
@WebServlet("/UserModifyServlet")
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsersDAO usersDAO; 
    private int id;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyServlet() {
        super();
        usersDAO = new UsersDAO();
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
		// TODO Auto-generated method stub
		if (!(request.getParameter("modif") == null)) {
			id = Integer.parseInt(request.getParameter("id"));
			ResultSet rs;
			try {
				rs = usersDAO.getUser(id);
				request.setAttribute("user", rs);
				RequestDispatcher rd = request.getRequestDispatcher("Modification.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			String pseudo = request.getParameter("pseudo");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			ResultSet rs;
			try {
				usersDAO.modifyUser(id, pseudo, password, role);
				rs = usersDAO.getUsers();
				request.setAttribute("users", rs);
				RequestDispatcher rd = request.getRequestDispatcher("AdminPanel.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
