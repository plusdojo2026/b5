package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Students;

@WebServlet("/JSPtestServlet")
public class JSPtestServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Students> st = new ArrayList<Students>();
		for(int i = 0;i<30;i++) {
			Students student = new Students();
			student.setId(i);
			student.setName("須藤");
			st.add(student);
		}
		request.setAttribute("StudentsData",st);	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/StudentSeat.jsp");
		dispatcher.forward(request, response);
	}
}
