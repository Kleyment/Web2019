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

import dao.CartDAO;
import dao.ProductsDAO;
import dao.UsersDAO;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/Login.jsp")
public class UserFilter implements Filter {

	private UsersDAO usersDAO;
	private CartDAO cartDAO;
	private ProductsDAO productsDAO;
	
    /**
     * Default constructor. 
     */
    public UserFilter() {
        usersDAO = new UsersDAO();
        cartDAO = new CartDAO();
        productsDAO = new ProductsDAO();
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
		
		if (listCookies != null) {
			for (int i=0;i<listCookies.length;i++) {
				if (listCookies[i].getName().equals("hashcart")) {
					hashCartOfUser=listCookies[i].getValue();
					System.out.println("hash trouvé : "+hashCartOfUser);
				}
			}
		}
		
		if (hashCartOfUser == null) {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		} else {
			ResultSet rs;
			try {
				rs=cartDAO.getUserFromHash(hashCartOfUser);
				if(rs != null && rs.next()) {
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
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
