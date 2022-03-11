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
 * Servlet implementation class CustomerTransferServlet
 */
@WebServlet("/CustomerTransferServlet")
public class CustomerTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerTransferServlet() {
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
		int fromActId=Integer.parseInt((String)request.getParameter("fromActId"));
		HttpSession session=request.getSession(false);
		
		try
		{
			int sessionId=(int)session.getAttribute("customerId");
			int toActId=Integer.parseInt((String)request.getParameter("toActId"));
			double amount=Double.parseDouble(request.getParameter("transferAmount"));
			if(session.getAttribute("customerId")==null)
			{
				RequestDispatcher reqDispatch=request.getRequestDispatcher("Login.jsp");
				reqDispatch.forward(request,response);
			}
			bankObj.amountTransfer(fromActId,toActId,amount);
			Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=bankObj.readAccount();
			for(int key:customerAccountMap.keySet())
			{
				Map<Integer,AccountDetails> customerAccount=bankObj.getAllAccountDetails(key);
				if(customerAccount.containsKey(fromActId))	
				{	
					System.out.println(customerAccount);
					request.setAttribute("CustomerAccountDetails",customerAccount);
					RequestDispatcher req=request.getRequestDispatcher("CustomerOptions.jsp");
					req.forward(request,response);
				}	
			}	
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
