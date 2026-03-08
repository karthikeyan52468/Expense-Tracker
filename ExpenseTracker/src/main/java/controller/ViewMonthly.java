package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MonthlyModel;
import expenseDAO.ViewMonthlyeDAO;


public class ViewMonthly extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int monthyear=Integer.parseInt(req.getParameter("monthyear"));
		ViewMonthlyeDAO obj= ViewMonthlyeDAO.getInstance();
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		for(MonthlyModel e:obj.display(monthyear))
		{
			out.print(e);
		}
		
	}
}
