package jsp_employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/editinfo")
public class EditController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		EmployeeInfo info = new EmployeeInfo();
		info.setId(id);
		info.setName(name);
		info.setAddress(address);
		info.setPhone(phone);
		info.setEmail(email);
		info.setPassword(password);
		
		EmployeeCrud crud = new EmployeeCrud();
		try {
			int count = crud.update(id, info);
			if(count != 0) {
				//To use Cookies
				Cookie[] cookies = req.getCookies();
				String value = null;
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("cookie")) {
						value = cookie.getValue();
					}
				}
				req.setAttribute("tracking", value);
				
				
				List<EmployeeInfo> emp = crud.fetch();
				req.setAttribute("list",emp);
				req.getRequestDispatcher("successEmp.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
