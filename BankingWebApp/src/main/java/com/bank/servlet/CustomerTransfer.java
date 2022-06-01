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

/**
 * Servlet implementation class CustomerTransfer
 */
@WebServlet("/CustomerTransfer")
public class CustomerTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerTransfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		BankLogic bankObj=new BankLogic();
		AccountDetails accountObj=new AccountDetails();
		HttpSession session=request.getSession(false);
		
		try
		{
			int customerId=(int)session.getAttribute("customerId");
			if(session.getAttribute("customerId")==null)
			{
				RequestDispatcher reqDispatch=request.getRequestDispatcher("Login.jsp");
				reqDispatch.forward(request,response);
			}
			Map<Integer,AccountDetails> inputMap=bankObj.getAllAccountDetails(customerId);
			request.setAttribute("accountMap",inputMap);
			Map<Integer,Map<Integer,AccountDetails>> accountMap=bankObj.readAccount();
			request.setAttribute("customerAccount", accountMap);
			RequestDispatcher reqDispatch=request.getRequestDispatcher("CustomerTransferAmount.jsp");
			reqDispatch.forward(request,response);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured :"+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		BankLogic bankObj=new BankLogic();
		AccountDetails accountObj=new AccountDetails();
		int customerId=(int)request.getSession(false).getAttribute("customerId");
		try
		{
			Map<Integer,AccountDetails> inputMap=bankObj.getAllAccountDetails(customerId);
			request.setAttribute("accountMap",inputMap);
			RequestDispatcher reqDispatch=request.getRequestDispatcher("CustomerTransferAmount.jsp");
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
