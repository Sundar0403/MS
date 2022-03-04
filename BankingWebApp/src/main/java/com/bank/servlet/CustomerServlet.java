package com.bank.servlet;

import java.io.IOException;

import java.util.Map;

import pojo.*;
import logic.*;
import excep.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
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
		try
		{
			Map<Integer,CustomerDetails> inputMap=bankObj.readCustomer();
			System.out.println("---------------This is in Servlet Layer------------");
			System.out.println(inputMap);
			request.setAttribute("CustomerDetails", inputMap);
			RequestDispatcher req=request.getRequestDispatcher("CustomerDetails.jsp");
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
