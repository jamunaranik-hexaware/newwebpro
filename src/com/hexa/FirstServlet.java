package com.hexa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/serv")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		PrintWriter pw=response.getWriter();
		//request.getParameter("userid");
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		HttpSession session =request.getSession();
		ServletContext context=getServletContext();
		pw.println("Username : "+username);
		if(username.equals("jamuna")&&password.equals("hexaware"))
		{
			//System.out.println();
			pw.println("Login Successfull");
			request.setAttribute("uname",username);
			session.setAttribute("uname",username);
			context.setAttribute("uname",username);
			//response.sendRedirect("SuccessServlet");
		    RequestDispatcher rd=request.getRequestDispatcher("SuccessServlet");
			rd.forward(request, response);
			//rd.include(request, response);
		}
		else
		{
			pw.println("Login Failed");
			RequestDispatcher rd=request.getRequestDispatcher("Error.html");
			rd.forward(request, response);
			//response.sendRedirect("Error.html");
		}
	}

}
