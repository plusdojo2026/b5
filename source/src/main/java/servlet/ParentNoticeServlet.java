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

@WebServlet("/ParentNoticeServlet")
public class ParentNoticeServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 保護者の通知画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/parent_notice.jsp");
		dispatcher.forward(request, response);
		
		
		//セッションスコープのstudent_idを参照し、児童に登録されているstamp_logの内容を取得する
		HttpSession session = request.getSession();
		session.getAttribute("student_id");
			response.sendRedirect("/webapp/LoginServlet");
			return;
		
		//リアクション画像を取得(reactionsテーブルから)
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		
		//取得したいデータ（reactionテーブルのid）
		String reactionId = request.getParameter("id");
		StampLogDao stampLogDao = new StampLogDao();
		stampLogDao.addReaction(Integer.parseInt(reactionId));

		//画面更新
		response.sendRedirect("/b5/ParentNoticeServlet");
	}
}