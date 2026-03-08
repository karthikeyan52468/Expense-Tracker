package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import expenseDAO.ExpenseDAO;

public class ViewExpense extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int monthyear=Integer.parseInt(req.getParameter("monthyear"));
		
		ExpenseDAO obj=ExpenseDAO.getInstance();
		PrintWriter out = resp.getWriter();
		out.print(obj.display(monthyear));
		
		
	}
}
