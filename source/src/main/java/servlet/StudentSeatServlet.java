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

import dao.StampLogDao;
import dao.StudentsDao;
import dto.Students;
import dto.Teachers;
@WebServlet("/StudentSeatServlet")
public class StudentSeatServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("★★★ StudentSeatServletのdoGetが呼ばれました！ ★★★");
		//本番用
		//セッションからログイン中の教師データを取得する→学年、クラスをintにする
		HttpSession session = request.getSession();
		Teachers teacher = (Teachers) session.getAttribute("teacherData");
		int grade = teacher.getGrade();
		int class_number = teacher.getClass_number();
		
		System.out.println(grade);
		System.out.println(class_number);
		//クラスと学年からクラスの児童一覧を取得
		StudentsDao sDao = new StudentsDao();
		List<Students> st = sDao.getClassMember(grade,class_number);
		//児童一覧をリクエストスコープに格納
		request.setAttribute("StudentsData",st);
		// Student_seatページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_seat.jsp");
		dispatcher.forward(request, response);
		
		
//		//テスト用、1年1組で固定
//		//セッションからログイン中の教師データを取得する→学年、クラスをintにする
//		int grade = 1;
//		int class_number = 1;
//		//クラスと学年からクラスの児童一覧を取得
//		StudentsDao sDao = new StudentsDao();
//		List<Students> st = sDao.getClassMember(grade,class_number);
//		//児童一覧をリクエストスコープに格納
//		request.setAttribute("StudentsData",st);
//		// スタンプページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_seat.jsp");
//		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Teachers teacher = (Teachers) session.getAttribute("teacherData");
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		
		//取得したいデータ（スタンプの種類,選択した児童のリスト）
		String stamp_id = (String) session.getAttribute("stamp_id");
		String[] selectedStudents = request.getParameterValues("student");//student_idを取得したい
		//stamp_id = "1";
		StampLogDao stampLogDao = new StampLogDao();
		
		if(selectedStudents == null || selectedStudents.length == 0) {
			request.setAttribute("errorMessage", "児童を選んでください。");
			int grade = teacher.getGrade();
			int class_number = teacher.getClass_number();
			
			System.out.println(grade);
			System.out.println(class_number);
			//クラスと学年からクラスの児童一覧を取得
			StudentsDao sDao = new StudentsDao();
			List<Students> st = sDao.getClassMember(grade,class_number);
			//児童一覧をリクエストスコープに格納
			request.setAttribute("StudentsData",st);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_seat.jsp");
			dispatcher.forward(request, response);
			
			return;
		}
		
		//その他を選んだ時の処理（テキストも挿入する）
		if(stamp_id.equals("6")) {
			String text = (String) session.getAttribute("text");
			for(String s:selectedStudents) {
				stampLogDao.addStampLog(Integer.parseInt(s),Integer.parseInt(stamp_id),text);
			}
			session.removeAttribute("text");
			session.removeAttribute("stamp_id");
		}
		//その対外を選んだ時の処理（スタンプIDとStudentIDを挿入）
		else {
			for(String s:selectedStudents) {
				stampLogDao.addStampLog(Integer.parseInt(s),Integer.parseInt(stamp_id));		}
				session.removeAttribute("stamp_id");
		}

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/stamp.jsp");
		dispatcher.forward(request, response);
	}
}