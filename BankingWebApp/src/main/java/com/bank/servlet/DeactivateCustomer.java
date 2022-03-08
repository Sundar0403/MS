package com.bank.servlet;
import logic.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.CustomerDetails;
import excep.*;
import java.util.Map;


/**
 * Servlet implementation class DeactivateCustomer
 */
@WebServlet("/DeactivateCustomer")
public class DeactivateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeactivateCustomer() {
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
		try
		{
			bankObj.fetchCustomerStatus(customerId);
			Map<Integer,CustomerDetails> inputMap=bankObj.readCustomer();
			request.setAttribute("CustomerDetails",inputMap);
			RequestDispatcher reqDispatch=request.getRequestDispatcher("CustomerDetails.jsp");
			reqDispatch.forward(request,response);
		}
		catch(CustomException e)
		{
			System.out.println("Exception Occured :"+e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured :"+e.getMessage());
		}
	}

}
