package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import Model.ExportModel;
import expenseDAO.ExportExpenseDAO;

public class ExportExpense extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		StreamFactory factory=StreamFactory.newInstance();
		factory.load(new File("E:\\Expense Tracker\\ExpenseTracker\\src\\resources\\beanio.xml"));
		
		BeanWriter writer=factory.createWriter("exp", new File("E:\\Expense Tracker\\ExpenseTracker\\src\\resources\\e.csv"));
		
		ArrayList<ExportModel> al=ExportExpenseDAO.getInstance().export();
		
		for(ExportModel o :al)
		{
			writer.write(o);
		}
		writer.close();
		System.out.println("CSV Export Completed");
	}
	}
		
	

