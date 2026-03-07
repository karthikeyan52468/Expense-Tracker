package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import expenseDAO.Expense;

public class InsertExpense extends HttpServlet{
	private Expense expenseObj;
	@Override
	public void init() throws ServletException {
	 expenseObj = new Expense();
		super.init();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		int monthyear=Integer.parseInt(req.getParameter("monthyear"));
		double amount=Double.parseDouble(req.getParameter("amount"));
		double expense=Double.parseDouble(req.getParameter("expense"));
		if(expenseObj.insert(monthyear, amount, expense))
		{
			out.print("data inserted");
		}
		else {
			out.print(false);
		}
		
	}

}
