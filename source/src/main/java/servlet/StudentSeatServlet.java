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

@WebServlet("/StudentSeatServlet")
public class StudentSeatServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*本番用
		//セッションからログイン中の教師データを取得する→学年、クラスをintにする
		HttpSession session = request.getSession();
		Teachers teacher = (Teachers) session.getAttribute("teacherData");
		int grade = teacher.getGrade();
		int class_number = teacher.getClass_number();
		//クラスと学年からクラスの児童一覧を取得
		StudentsDao sDao = new StudentsDao();
		List<Students> st = sDao.getClassMember(grade,class_number);
		//児童一覧をリクエストスコープに格納
		request.setAttribute("StudentsData",st);
		// スタンプページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_seat.jsp");
		dispatcher.forward(request, response);
		*/
		
		//セッションからログイン中の教師データを取得する→学年、クラスをintにする
		HttpSession session = request.getSession();
		Teachers teacher = (Teachers) session.getAttribute("teacherData");
		int grade = teacher.getGrade();
		int class_number = teacher.getClass_number();
		//クラスと学年からクラスの児童一覧を取得
		StudentsDao sDao = new StudentsDao();
		List<Students> st = sDao.getClassMember(grade,class_number);
		//児童一覧をリクエストスコープに格納
		request.setAttribute("StudentsData",st);
		// スタンプページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_seat.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		
		//取得したいデータ（スタンプの種類）
		String stampId = request.getParameter("stamp_id");
		
		//セッションスコープにstamp_idを格納
		HttpSession session = request.getSession();
		session.setAttribute("stamp_id",stampId);

	}
}