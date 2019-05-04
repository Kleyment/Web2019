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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import dao.UsersDAO;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/44Login.jsp")
public class UserFilter implements Filter {

	private UsersDAO usersDAO;
	//private CartDAO cartDAO;
	
    /**
     * Default constructor. 
     */
    public UserFilter() {
        usersDAO = new UsersDAO();
        //cartDAO = new CartDAO();
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
		String hashCartOfUser=null;
		Cookie[] listCookies=((HttpServletRequest)(request)).getCookies();
		
		for (int i=0;i<listCookies.length;i++) {
			if (listCookies[i].getName().equals("hashcart")) {
				hashCartOfUser=listCookies[i].getValue();
			}
		}
		
		if (hashCartOfUser == null) {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		} else {
			
			ResultSet rs;
			//try {
				/*cartDAO.getUserFromHash(hashCartOfUser);
				if(rs.next()) {
					if (rs.getString(4).contentEquals("admin")) {
						request.setAttribute("users", rs);
						RequestDispatcher rd = request.getRequestDispatcher("AdminPanel.jsp");
						rd.forward(request, response);
					}
				}*/
			//} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
				
			}
		
		
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
