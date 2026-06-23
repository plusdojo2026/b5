package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StampLogDao;
import dto.Students;

@WebServlet("/StudentResultServlet")
public class StudentResultServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//ログインしている児童データを取得
		HttpSession session = request.getSession();
		Students student = (Students) session.getAttribute("studentData");
		
		//必要な変数を取得
		int student_id = student.getId();
		int grade = student.getGrade();
		int class_number = student.getClass_number();
		System.out.println(student_id);
		// 現在の日付を取得
		LocalDate now = LocalDate.now();
		// 現在の月を整数値で取得
		int month = now.getMonthValue();
		//student_idから、その児童が各スタンプを何回押されたかを取得する
		//その回数に応じてスタンプ画像の大きさを変える
		StampLogDao logDao = new StampLogDao();
		int[] stampCounts = new int[5];
		
		for(int i = 1; i <= stampCounts.length; i++){
			stampCounts[i-1] = logDao.getStampCount(student_id, i, month);
			System.out.println(stampCounts[i-1]);
		}
		//スタンプ数をリクエストスコープに格納
		request.setAttribute("stampCounts",stampCounts);
		
		//クラスのスタンプ数を集計、それに応じて花に使う画像を取得、表示
		//スタンプ数を集計するために、学年、クラスを引数としてクラスの全員のスタンプログを取得できるメソッドが必要（getTotalClassStamp）
		//その数に応じて画像を変更する
		int classStampCount = logDao.getClassStampCount(grade, class_number, month);
		request.setAttribute("classStampCount",classStampCount);
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_result.jsp");
		dispatcher.forward(request, response);
	}
}
