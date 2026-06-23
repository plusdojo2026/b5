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
import dto.StampLog;
import dto.Students;

@WebServlet("/ParentNoticeServlet")
public class ParentNoticeServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 保護者の通知画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/parent_notice.jsp");
		dispatcher.forward(request, response);
		
		//セッションスコープのstudent_idを参照し、児童に登録されているstamp_logの内容を取得する
		//ログインしている児童データを取得
		HttpSession session = request.getSession();
		Students student = (Students) session.getAttribute("studentData");
		
		//必要な変数を取得
		int student_id = student.getId();
		StampLogDao logDao = new StampLogDao();
		List<StampLog> stLog = logDao.getStampLogByStudentID(student_id);
		for(StampLog s:stLog) {
			System.out.println(s.getStamp_id());
		}
		request.setAttribute("stLog",stLog);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		
		//取得したいデータ（reactionテーブルのid）
		String reactionId = request.getParameter("id");
		StampLogDao stampLogDao = new StampLogDao();
		
		//リアクションボタンを押すと保護者の通知画面に遷移する
		if (request.getParameter("button").equals("reaction")) {
			stampLogDao.addReaction(Integer.parseInt(reactionId));
			response.sendRedirect("/b5/ParentNoticeServlet");
		}
		//ベルマークを押して保護者の通知画面に遷移する
		else if (request.getParameter("button").equals("notice")) {
			response.sendRedirect("/b5/ParentNoticeServlet");
		}
		//リストマークを押して保護者のリスト確認画面に遷移する
		else if(request.getParameter("button").equals("lists")) {
			response.sendRedirect("/b5/ParentViewServlet");
		}
	}
}