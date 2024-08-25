package jsp_employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/deleteall")
public class EmpDeleteAll extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmployeeCrud crud = new EmployeeCrud();
		try {
			int result = crud.deleteAll();
			if(result != 0) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
