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
		session.getAttribute("stamp_id");
		
		//
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		
		//取得したいデータ（reactionテーブルのid）
		String reactionId = request.getParameter("id");
		StampLogDao stampLogDao = new StampLogDao();
		stampLogDao.addReaction(Integer.parseInt(reactionId));
		
		//リアクションボタンを押すと保護者の通知画面に遷移する
		if (request.getParameter("button").equals("reaction")) {
			response.sendRedirect("/b5/PrentNoticeServlet");
		}
		//ベルマークを押して保護者の通知画面に遷移する
		else if (request.getParameter("button").equals("notice")) {
			response.sendRedirect("/b5/PrentNoticeServlet");
		}
		//リストマークを押して保護者のリスト確認画面に遷移する
		else if(request.getParameter("button").equals("lists")) {
			response.sendRedirect("/b5/ParentViewServlet");
		}
	}
}