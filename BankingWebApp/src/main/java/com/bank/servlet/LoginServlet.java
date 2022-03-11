package com.bank.servlet;

import java.io.IOException;
import utility.*;


import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//response.getWriter().append("Served a3t: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UtilityClass utilObj=new UtilityClass();
		HttpSession session=request.getSession(false);
		try
		{
			int username=Integer.parseInt(request.getParameter("username"));
			utilObj.numCheck(username);
			String password=request.getParameter("password");
			utilObj.stringCheck(password);
			BankLogic bankObj=new BankLogic();
			System.out.println(username);
			System.out.println(password);
			if(username==101&&password.equals("1234"))
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
			else
			{
				Map<Integer,Map<Integer,AccountDetails>> CustomerAccountMap=bankObj.readAccount();
				System.out.println("servlet :"+CustomerAccountMap);
				Map<Integer,AccountDetails> accountMap=bankObj.getAllAccountDetails(username);
				request.setAttribute("CustomerAccountDetails",accountMap);
				session.setAttribute("customerId",username);
				System.out.println("LoginSession:"+session);
				if(session.getAttribute("customerId")==null)
				{
					RequestDispatcher reqDispatch=request.getRequestDispatcher("Login.jsp");
					reqDispatch.forward(request,response);
				}
				RequestDispatcher reqDispatch=request.getRequestDispatcher("CustomerOptions.jsp");
				reqDispatch.forward(request,response);
			}

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

}