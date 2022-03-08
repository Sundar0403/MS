package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import pojo.CustomerDetails;

/**
 * Servlet implementation class AdminOptions
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
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
		AccountDetails accountObj=new AccountDetails();
		CustomerDetails customerObj=new CustomerDetails();
		int fromActId=Integer.parseInt(request.getParameter("fromActId"));
		int toActId=Integer.parseInt(request.getParameter("toActId"));
		double amount=Double.parseDouble(request.getParameter("transferAmount"));
		
		try
		{
			Map<Integer,Map<Integer,AccountDetails>> accountMap=bankObj.readAccount();
			for(int key:accountMap.keySet())
			{	
				bankObj.withdraw(key,fromActId,amount);
			}
			for(int toKey:accountMap.keySet())
			{
				bankObj.deposit(toKey,toActId,amount);
			}	
			accountMap=bankObj.readAccount();
			System.out.println("----------------This is in Servlet Layer------------------");
			System.out.println(accountMap);
			request.setAttribute("AccountDetails",accountMap);
			RequestDispatcher req=request.getRequestDispatcher("AdminOptions.jsp");
			req.forward(request, response);
		}
		catch(CustomException e)
		{
			System.out.println("Can't get the Detils");
		}
		catch(Exception e)
		{
			System.out.println("Can't get the Detils");
		}
	}

}

