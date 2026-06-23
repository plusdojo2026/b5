package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentsDao;
import dto.Students;
import dto.Teachers;

@WebServlet("/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//ログインしている教師データを取得
		HttpSession session = request.getSession();
		Teachers teacher = (Teachers) session.getAttribute("teacherData");
		
		//StudentsDaoを使えるようにする
		StudentsDao studentDao = new StudentsDao();
		
		//児童一覧を取得
		List<Students> studentList =
		    studentDao.getClassMember(
		        teacher.getGrade(),  //ログイン中の教師の学年を取得
		        teacher.getClass_number()); //ログイン中の教師のクラスを取得

		request.setAttribute("studentList", studentList);

		
		// 保護者の通知画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_info.jsp");
		dispatcher.forward(request, response);}

}