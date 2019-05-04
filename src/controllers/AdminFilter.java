package controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import dao.UsersDAO;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/AdminPanel.jsp")
public class AdminFilter implements Filter {

	private UsersDAO usersDAO;
    /**
     * Default constructor. 
     */
    public AdminFilter() {
        usersDAO = new UsersDAO();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String pseudo = request.getParameter("pseudo");
		String password = request.getParameter("mdp");
		if (!(pseudo == null && password == null)){
			ResultSet rs;
			try {
				rs = usersDAO.getUser(pseudo, password);
				if(rs.next()) {
					if (rs.getString(4).contentEquals("admin")) {
						request.setAttribute("users", rs);
						RequestDispatcher rd = request.getRequestDispatcher("AdminPanel.jsp");
						rd.forward(request, response);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
