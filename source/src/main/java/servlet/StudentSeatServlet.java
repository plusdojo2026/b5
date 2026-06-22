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
		
		//テスト用、1年1組で固定
		//セッションからログイン中の教師データを取得する→学年、クラスをintにする
		int grade = 1;
		int class_number = 1;
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
		
		HttpSession session = request.getSession();
		Teachers teacher = (Teachers) session.getAttribute("teacherData");
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		
		//取得したいデータ（スタンプの種類,選択した児童のリスト）
		int stamp_id = (int) session.getAttribute("stamp_id");
		String[] selectedStudents = request.getParameterValues("student");//student_idを取得したい
		
		StampLogDao stampLogDao = new StampLogDao();
		//その他を選んだ時の処理（テキストも挿入する）
		if(stamp_id== 5) {
			String text = (String) session.getAttribute("text");
			for(String s:selectedStudents) {
				stampLogDao.addStampLog(Integer.parseInt(s),stamp_id,text);
			}
		}
		//その対外を選んだ時の処理（スタンプIDとStudentIDを挿入）
		else {
			for(String s:selectedStudents) {
				stampLogDao.addStampLog(Integer.parseInt(s),stamp_id);
			}
		}

	}
}