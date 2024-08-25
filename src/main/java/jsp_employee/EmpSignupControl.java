package jsp_employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signupemp")
public class EmpSignupControl extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeInfo info = new EmployeeInfo();
		EmployeeCrud crud = new EmployeeCrud();

		System.out.println("signup employee url working");
		int id = Integer.parseInt(req.getParameter("ID"));
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		info.setId(id);
		info.setName(name);
		info.setAddress(address);
		info.setPhone(phone);
		info.setEmail(email);
		info.setPassword(password);

		int op = 0;
		try {
			op = crud.signUp(info);
		} catch (Exception e) {
			System.out.println("Exception occured");
		}
		if (op != 0) {
			req.setAttribute("message","SignUp success , please login ");
			//res.getWriter().print("Signed up successfully");
			RequestDispatcher dispatcher = req.getRequestDispatcher("loginEmp.jsp");
			dispatcher.forward(req, res);
		} else {
			req.setAttribute("message2","SignUp failed , please try again ");
			//res.getWriter().print("Sign up failed");
			RequestDispatcher dispatcher = req.getRequestDispatcher("signupEmp.jsp");
			dispatcher.forward(req, res);
		}
	}

	

}
