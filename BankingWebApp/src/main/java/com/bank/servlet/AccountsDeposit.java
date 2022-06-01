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
import logic.BankLogic;

/**
 * Servlet implementation class AccountsDeposit
 */
@WebServlet("/AccountsDeposit")
public class AccountsDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountsDeposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		BankLogic bankObj=new BankLogic();
		
		//int customerId=(int)request.getSession(false).getAttribute("customerId");
		try
		{
			Map<Integer,Map<Integer,AccountDetails>> accountMap=bankObj.readAccount();
			System.out.println(1);
			request.setAttribute("Account", accountMap);
			System.out.println(2);
			RequestDispatcher reqDispatch=request.getRequestDispatcher("Deposit.jsp");
			System.out.println(3);
			reqDispatch.forward(request,response);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured :"+e.getMessage());
			RequestDispatcher reqDispatch=request.getRequestDispatcher("Error.jsp");
			reqDispatch.forward(request,response);
		}
	}

}
