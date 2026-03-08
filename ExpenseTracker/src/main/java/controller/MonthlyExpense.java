package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.TextFormat.Printer;

import expenseDAO.Calculate;
import expenseDAO.Monthly;

public class MonthlyExpense extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out = resp.getWriter();
		out.print("mmmmmm");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
	String eName=req.getParameter("eName");
	double amount=Double.parseDouble(req.getParameter("amount"));
	int monthyear=Integer.parseInt(req.getParameter("monthyear"));
	if(Monthly.getInstance().insert(eName, amount, monthyear))
	{
		if(Calculate.getInstance().calculate(amount, monthyear))
		{
	
			out.print("added");
		}
		else {
			out.print("error in calculate");
		}
	}
	else {
		out.print("error in monthlyExpense update");
	}
	}
}
