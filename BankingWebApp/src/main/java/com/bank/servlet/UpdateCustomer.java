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
 * Servlet implementation class UpdateCustomer
 */
@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomer() {
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
		int customerId=Integer.parseInt(request.getParameter("custId"));
		String customerName=request.getParameter("custName");
		String customerAddress=request.getParameter("address");
		long mobNo=Long.parseLong(request.getParameter("mobNo"));
		try
		{
			CustomerDetails custObj=new CustomerDetails();
			custObj.setCustomerId(customerId);
			custObj.setCustomerName(customerName);
			custObj.setCustomerAddress(customerAddress);
			custObj.setMobileNumber(mobNo);
			Map<Integer,CustomerDetails> customerMap=bankObj.updateDetails(customerId,custObj);
			request.setAttribute("CustomerDetails",customerMap);
			RequestDispatcher reqDispatch=request.getRequestDispatcher("CustomerDetails.jsp");
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
