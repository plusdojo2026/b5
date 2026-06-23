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
		
		//セッションスコープのstudent_idを参照し、児童に登録されているstamp_logの内容を取得する
		//ログインしている児童データを取得
		HttpSession session = request.getSession();
		Students student = (Students) session.getAttribute("studentData");
		
		//必要な変数を取得
		int student_id = student.getId();
		StampLogDao logDao = new StampLogDao();
		List<StampLog> stLog = logDao.getStampLogByStudentID(student_id);
		for(StampLog s:stLog) {
			s.setCreated_at(s.getDisplayDate());
		}
		request.setAttribute("stLog",stLog);
		
		// 保護者の通知画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/parent_notice.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		
		// logのIDと押されたリアクションのIDを取得
		String logIdStr = request.getParameter("id");
		String reactionIdStr = request.getParameter("reaction_id");
		
		String buttonAction = request.getParameter("button");
		StampLogDao stampLogDao = new StampLogDao();
		
		if (reactionIdStr != null) {
			int logId = Integer.parseInt(logIdStr);
			int reactionId = Integer.parseInt(reactionIdStr);
			stampLogDao.addReaction(logId, reactionId);
			response.sendRedirect("/b5/ParentNoticeServlet");
		}
		// ベルマークを押して保護者の通知画面に遷移する
		else if ("notice".equals(buttonAction)) {
			response.sendRedirect("/b5/ParentNoticeServlet");
		}
		// リストマークを押して保護者のリスト確認画面に遷移する
		else if ("lists".equals(buttonAction)) {
			response.sendRedirect("/b5/ParentViewServlet");
		}
	}
}