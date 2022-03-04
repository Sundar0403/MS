package com.bank.servlet;
import java.util.*;
import logic.*;
import pojo.CustomerDetails;
import excep.*;
import account.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
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
		int custId=Integer.parseInt(request.getParameter("custId"));
		int actId=Integer.parseInt(request.getParameter("actId"));
		double amount=Double.parseDouble(request.getParameter("depositAmount"));
		try
		{
			bankObj.deposit(custId,actId,amount);
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
