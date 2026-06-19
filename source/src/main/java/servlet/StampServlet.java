package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StampLogDao;
import dto.Teachers;

@WebServlet("/StampServlet")
public class StampServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//セッションからログイン中の教師データを取得する
		HttpSession session = request.getSession();
		Teachers teacher = (Teachers) session.getAttribute("teacherData");
		
		// スタンプページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/stamp.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		
		//取得したいデータ（スタンプの種類、誰に付与するか）
		String stampId = request.getParameter("stamp_id");
		String[] selectedStudents = request.getParameterValues("student");//student_idを取得したい
		
		StampLogDao stampLogDao = new StampLogDao();
		
		for(String s:selectedStudents) {
			stampLogDao.addStampLog(Integer.parseInt(s),Integer.parseInt(stampId));
		
		//セッションからログイン中の教師データを取得する
		HttpSession session = request.getSession();
		Teachers teacher = (Teachers) session.getAttribute("teacherData");
		
		//セッションスコープにstamp_idを格納
		
		
		//StampLogテーブルにstamp_id,student_idを格納、（テキストも）
		
		
		//セッションスコープからstamp_idの情報を破棄
		session.removeAttribute("stamp_id");
		
			
			
		}
	}
}

//