package com.online.controller;

import javax.servlet.http.*;

import com.online.constants.GlobalConstants;
import com.online.dao.UserService;
import com.online.model.Login;
import com.online.model.Registration;

public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 4481510681863866579L;
	private UserService userServices = new UserService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String action = request.getParameter("action");
			doPostAction(action, request, response);
		} catch (Exception e) {
			System.out.println("Error in Input Output " + e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			String action = request.getParameter("action");
			doGetAction(action, request, response);
		} catch (Exception e) {
			System.out.println("Error in Input Output " + e);
		}
	}

	public void doPostAction(String action, HttpServletRequest request, HttpServletResponse response) {		
		try {
			action = action.toLowerCase();
			if (action.equals("login")) {
				Login login = new Login();
				login.setUserName(request.getParameter("username"));
				login.setPassword(request.getParameter("password"));

				if (userServices.checkLogin(login)) {					
					HttpSession session = request.getSession();
					System.out.println(login);
					session.setAttribute(GlobalConstants.USER, login);
					GlobalConstants.JSP_PAGE = "Examscreen.jsp";
				} else {
					GlobalConstants.MESSAGE = GlobalConstants.ERROR_INVALID_CREDS;
					GlobalConstants.JSP_PAGE = "login.jsp";
				}
				response.sendRedirect(GlobalConstants.JSP_PAGE);
			}
			
			if(action.equals("register")) {
				Registration register= new Registration();
				String username=request.getParameter("username");
				register.setUsername(username);
				register.setEmail(request.getParameter("email"));
				register.setPassword(request.getParameter("password"));
			
				if(userServices.registation(register)) {
					HttpSession session = request.getSession();
					session.setAttribute(GlobalConstants.USER, username);
					GlobalConstants.JSP_PAGE = "login.jsp";
				}
			} else {
				GlobalConstants.MESSAGE = GlobalConstants.ERROR_INVALID_CREDS;
				GlobalConstants.JSP_PAGE = "login.jsp";
			}
			response.sendRedirect(GlobalConstants.JSP_PAGE);
			
		
		}catch(

	Exception e)
	{
		System.out.println("Error in doPostAction() " + e);
		e.printStackTrace();
	}
	}

	public void doGetAction(String action, HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("Action in doGet " + action);
		} catch (Exception e) {
			System.out.println("Error in doGetAction - " + e);
		}

	}
}