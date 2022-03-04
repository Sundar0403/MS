package com.bank.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excep.CustomException;
import logic.BankLogic;
import pojo.CustomerDetails;

/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomer() {
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
		CustomerDetails custObj=new CustomerDetails();
		
		String custStatus=request.getParameter("custStatus");
		String custName=request.getParameter("custName");
		custObj.setCustomerName(custName);
		String address=request.getParameter("address");
		custObj.setCustomerAddress(address);
		long mobNo=Long.parseLong(request.getParameter("mobNo"));
		custObj.setMobileNumber(mobNo);
		try
		{
			bankObj.addCustomerDetails(custObj);
			Map<Integer,CustomerDetails> newMap=bankObj.readCustomer();
			System.out.println("-------------This is in Servlet Layer--------------");
			System.out.println(newMap);
			request.setAttribute("CustomerDetails",newMap);
			RequestDispatcher reqDispatch=request.getRequestDispatcher("CustomerDetails.jsp");
			reqDispatch.forward(request, response);
		}
		catch(CustomException e)
		{
			System.out.println("Can't Add Customer Now....!!!");
		}
		catch(Exception e)
		{
			System.out.println("Can't Add Customer Now....!!!");
		}
		
	}

}
