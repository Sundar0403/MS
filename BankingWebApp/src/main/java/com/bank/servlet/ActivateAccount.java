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
 * Servlet implementation class ActivateAccount
 */
@WebServlet("/ActivateAccount")
public class ActivateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		BankLogic bankObj=new BankLogic();
		int customerId=Integer.parseInt(request.getParameter("customerId"));
		int accountId=Integer.parseInt(request.getParameter("accountId"));
		try
		{
			bankObj.activateAccount(customerId,accountId);
			Map<Integer,Map<Integer,AccountDetails>> accountMap=bankObj.readAccount();
			request.setAttribute("AccountDetails", accountMap);
			RequestDispatcher reqDispatch=request.getRequestDispatcher("DeactivatedAccount.jsp");
			reqDispatch.forward(request,response);
		}
		catch(CustomException e)
		{
			System.out.println("Exception Occured :"+e.getMessage());
			RequestDispatcher reqDispatch=request.getRequestDispatcher("Error.jsp");
			reqDispatch.forward(request,response);
		}
	}

}
