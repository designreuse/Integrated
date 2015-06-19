package com.login;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logincheck.Auth;
import logincheck.LoginUser;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String login_page = "login/login.jsp";
	ServletRequest session = null;
	String username = null;
	String forward = "";  
   
    public LoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login");
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("logout")){
			HttpSession session = request.getSession();
			session.invalidate();
			RequestDispatcher view = request
					.getRequestDispatcher("login/login.jsp");
			view.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("UserName");
			System.out.println(username);
			// System.exit(0);
			if (username != null) {
				forward = "includes/dashboard.jsp";
				request.setAttribute("weppage", forward);
				RequestDispatcher view = request
						.getRequestDispatcher("index.jsp");
				view.forward(request, response);
			} else {
				RequestDispatcher view = request
						.getRequestDispatcher("login/login.jsp");
				view.forward(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost login");
		LoginUser user = new LoginUser();
		int userexist = 0;
		Auth auth = new Auth();
		user.setUsername(request.getParameter("Username"));
		user.setPassword(request.getParameter("Password"));
		try {
			userexist = auth.checkUserAuth(user);
		} catch (NoSuchAlgorithmException | SQLException e) {			
			e.printStackTrace();
		}
		if (userexist > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("UserName", user.getUsername());
			forward = "includes/dashboard.jsp";
			request.setAttribute("weppage", forward);
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}else {
			RequestDispatcher view = request
					.getRequestDispatcher("login/login.jsp");
			view.forward(request, response);
		}
	}

}
