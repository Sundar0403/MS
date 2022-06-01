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
import pojo.CustomerDetails;

/**
 * Servlet implementation class UpdateAccount
 */
@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccount() {
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
		System.out.println(customerId);
		int accountId=Integer.parseInt(request.getParameter("accountId"));
		System.out.println(accountId);
		long accountNo=Long.parseLong(request.getParameter("accountNo"));
		String branch=(String)request.getParameter("branch");
		Double balance=Double.parseDouble(request.getParameter("balance"));
		try
		{
			AccountDetails accountObj=new AccountDetails();
			accountObj.setCustomerId(customerId);
			accountObj.setAccountId(accountId);
			accountObj.setBranchName(branch);
			accountObj.setAccountNumber(accountNo);
			accountObj.setAccountBalance(balance);
			Map<Integer,Map<Integer,AccountDetails>> accountMap=bankObj.updateAccountDetails(customerId,accountId,accountObj);
			request.setAttribute("AccountDetails",accountMap);
			RequestDispatcher reqDispatch=request.getRequestDispatcher("AdminOptions.jsp");
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
