package com.bank.servlet;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.AccountDetails;
import excep.CustomException;
import logic.BankLogic;
import pojo.CustomerDetails;

/**
 * Servlet implementation class GetAccount
 */
@WebServlet("/GetAccount")
public class GetAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAccount() {
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
			AccountDetails accountObj=bankObj.getAccountDetails(customerId,accountId);
			System.out.println(accountObj);
			request.setAttribute("AccountDetails",accountObj);
			List<String> branch=(List<String>)bankObj.getBranches();
			request.setAttribute("branch",branch);
			RequestDispatcher req=request.getRequestDispatcher("UpdateAccount.jsp");
			req.forward(request,response);
		}
		catch(CustomException e)
		{
			System.out.println("Details Cant be Received :");
		}
		catch(Exception e)
		{
			System.out.println("Details Cant be Received :");
		}
	}

}
