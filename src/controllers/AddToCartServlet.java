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
 * Servlet implementation class UserModifyServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsersDAO usersDAO; 
    private ProductsDAO productsDAO;
    private int id;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        usersDAO = new UsersDAO();
        productsDAO = new ProductsDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OK");
		if ((request.getParameter("id") != null)) {
			id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
		}
		
		String hashCartOfUser="";
		Cookie[] listCookies=request.getCookies();
		for (int i=0;i<listCookies.length;i++) {
			if (listCookies[i].getName().equals("hashcart")) {
				hashCartOfUser=listCookies[i].getValue();
			}
		}
		System.out.print("hashcart="+hashCartOfUser);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Rien
	}

}
