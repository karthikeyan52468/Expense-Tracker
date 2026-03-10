package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import config.Jwt;

public class JwtAuthenticationFilter implements Filter{
	static Logger log = Logger.getLogger(JwtAuthenticationFilter.class.getName());
	FileHandler handler=null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		try {
			handler = new FileHandler("E:\\Expense Tracker\\ExpenseTracker\\src\\resources\\logger.log",true);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		handler.setFormatter(new SimpleFormatter());
		log.addHandler(handler);
		Filter.super.init(filterConfig);
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		String token=req.getHeader("Authorization");
		//System.out.println(token);
		
		if(token==null|| token.isEmpty() &&!token.startsWith("Bearer "))
		{
			chain.doFilter(request, response);
		
			
		}
		else {
			token = token.substring(7);
			System.out.println(token);
		Jwt obj=Jwt.getInstance();
			if(obj.validate(token))
			{
				chain.doFilter(request, response);
			}
			else {
				PrintWriter out = response.getWriter();
				log.warning("invalid");
				out.print("invalid");
			}
			
			
			
		
			// TODO Auto-generated catch block
			
		
		}
		
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		handler.close();
		Filter.super.destroy();
	}

}
