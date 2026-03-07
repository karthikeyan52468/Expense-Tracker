package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import expenseDAO.GenerateCSV;

public class Generate extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	int date=	Integer.parseInt(req.getParameter("monthyear"));
	GenerateCSV.getInstance().generateReport(date);
	}
}
