package com.bank.servlet;

import java.io.IOException;
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
import pojo.CustomerDetails;

/**
 * Servlet implementation class WithdrawServlet
 */
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
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
		int actId=Integer.parseInt((String)request.getParameter("actId"));
		double amount=Double.parseDouble(request.getParameter("withdrawAmount"));
		HttpSession session=request.getSession(false);
		try
		{
			
			Map<Integer,Map<Integer,AccountDetails>> accountMap=bankObj.readAccount();
			for(int key:accountMap.keySet())
			{
				bankObj.withdraw(key,actId,amount);
			}
			accountMap=bankObj.readAccount();
			System.out.println("----------------This is in Servlet Layer------------------");
			System.out.println(accountMap);
			request.setAttribute("AccountDetails",accountMap);
			if(session.getAttribute("customerId")==null)
			{
				RequestDispatcher reqDispatch=request.getRequestDispatcher("Login.jsp");
				reqDispatch.forward(request,response);
			}
			RequestDispatcher req=request.getRequestDispatcher("AdminOptions.jsp");
			req.forward(request, response);
		}
		catch(CustomException e)
		{
			System.out.println("Can't get the Detils");
			RequestDispatcher reqDispatch=request.getRequestDispatcher("Error.jsp");
			reqDispatch.forward(request,response);
		}
		catch(Exception e)
		{
			System.out.println("Can't get the Detils");
			RequestDispatcher reqDispatch=request.getRequestDispatcher("Error.jsp");
			reqDispatch.forward(request,response);
		}
	}

}
