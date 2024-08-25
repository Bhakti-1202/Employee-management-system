package jsp_employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addemp")
public class AddEmp extends HttpServlet {
	
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
		
		
		//To crate session
		HttpSession session = req.getSession();
		session.setAttribute("session", email);
		System.out.println(session);
		
		try {
			req.setAttribute("list",crud.fetch());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//out.print("Login success");
		RequestDispatcher dispatcher = req.getRequestDispatcher("successEmp.jsp");
		dispatcher.forward(req, res);

	}

	

}
