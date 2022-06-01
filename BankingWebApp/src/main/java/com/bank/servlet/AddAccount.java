package com.bank.servlet;
import logic.*;
import account.*;
import excep.*;
import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccount() {
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
		AccountDetails accObj=new AccountDetails();
		HttpSession session=request.getSession(false);
		int customerId=Integer.parseInt(request.getParameter("customerId"));
		double accountBalance=Double.parseDouble(request.getParameter("accountBalance"));
		accObj.setAccountBalance(accountBalance);
		String accountBranch=request.getParameter("accountBranch");
		accObj.setBranchName(accountBranch);
		try
		{
			bankObj.addAccountDetails(accObj,customerId);
			Map<Integer,Map<Integer,AccountDetails>> accountMap=bankObj.readAccount();
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
			System.out.println("Account Addition Can't be Done");
			RequestDispatcher reqDispatch=request.getRequestDispatcher("Error.jsp");
			reqDispatch.forward(request,response);
		}
		catch(Exception e)
		{
			System.out.println("Account Addition Can't be Done");
			RequestDispatcher reqDispatch=request.getRequestDispatcher("Error.jsp");
			reqDispatch.forward(request,response);
		}
		
		
	}

}
