package jsp_employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/update")
public class EmpUpdate extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		EmployeeCrud crud = new EmployeeCrud();
		try {
			EmployeeInfo info = crud.getInfo(id);
			/*if(info != null) {
				/*req.setAttribute("obj", info);
				req.getRequestDispatcher("update.jsp").forward(req, resp);*/
				
				//To validate HttpSession
				HttpSession session = req.getSession();
				String SessionValue = (String) session.getAttribute("session");
				if(info!= null) {
					req.setAttribute("obj", info);
					req.getRequestDispatcher("update.jsp").forward(req, resp);
				}
				else {
					req.setAttribute("message", "Please login");
					req.getRequestDispatcher("loginEmp.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
