package com.bank.servlet;

import java.io.IOException;


import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.AccountDetails;
import excep.CustomException;
import logic.BankLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served a3t: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		if(username.equals("Mani")&&password.equals("1234"))
		{
			BankLogic bankObj=new BankLogic();
			try
			{
				Map<Integer,Map<Integer,AccountDetails>> accountMap=bankObj.readAccount();
				System.out.println("servlet :"+accountMap);
				request.setAttribute("AccountDetails",accountMap);
				System.out.println("1");
				RequestDispatcher reqDispatch=request.getRequestDispatcher("AdminOptions.jsp");
				System.out.println("2");
				reqDispatch.forward(request,response);
				System.out.println("3");
			}
			catch(CustomException e)
			{
				System.out.println("Details Can't Received");
				e.printStackTrace();
			}
			catch(Exception e)
			{
				System.out.println("Details Can't Received");
				e.printStackTrace();
			}
		}
		else
		{
			RequestDispatcher reqDispatch=request.getRequestDispatcher("CustomerOptions.jsp");
			reqDispatch.forward(request,response);
		}	
	}

}