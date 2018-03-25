package pl.bockowsk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class TestDBServer
 */
@WebServlet("/TestDBServer")
public class TestDBServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="obockows";
		String password="";
		String jdbcUrl="jdbc:postgresql://localhost:5432/web_customer_tracker?useSSL=false";
		String driver="org.postgresql.Driver";
		
		try {
			PrintWriter out=response.getWriter();
			out.println("connecting to db: "+jdbcUrl);
			Class.forName(driver);
			Connection myConn=DriverManager.getConnection(jdbcUrl, user, password);
			out.println("SUCCESS!!!");
			myConn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
