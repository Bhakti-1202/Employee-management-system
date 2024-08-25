package jsp_employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/loginemp")
public class EmployeeLogin extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Login url working");
		EmployeeCrud crud = new EmployeeCrud();
		
		String email =req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
			String dbPassword = crud.login(email);
			PrintWriter out = res.getWriter();
			
			if(dbPassword !=null) {
				if(dbPassword.equals(password)) {
					//To create a cookie
					Cookie cookie1 = new Cookie("cookie1", email);
					res.addCookie(cookie1);
					
					Cookie cookie2 = new Cookie("cookie2", password);
					res.addCookie(cookie2);
					
					Cookie cookie3 = new Cookie("cookie3", dbPassword);
					res.addCookie(cookie3);
					
					//To crate session
					HttpSession session = req.getSession();
					session.setAttribute("session", email);
					System.out.println(session);
					
					req.setAttribute("list",crud.fetch());
					//out.print("Login success");
					RequestDispatcher dispatcher = req.getRequestDispatcher("successEmp.jsp");
					dispatcher.forward(req, res);
				}
				else {
					out.print("Invalid password");
					RequestDispatcher dispatcher = req.getRequestDispatcher("loginEmp.jsp");
					dispatcher.forward(req, res);
				}
			}
			else {
				out.print("user not registered");
				RequestDispatcher dispatcher = req.getRequestDispatcher("signupEmp.jsp");
				dispatcher.forward(req, res);
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}

	}

}
