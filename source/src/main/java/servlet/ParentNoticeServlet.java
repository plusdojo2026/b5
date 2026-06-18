package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StampLogDao;

@WebServlet("/ParentNoticeServlet")
public class ParentNoticeServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 保護者の通知画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/parent_notice.jsp");
		dispatcher.forward(request, response);
		
		//児童に登録されているstamp_logの内容を取得する
		
		//stamp_idからstampの画像を取得
		
		//リアクション画像を取得(reactionsテーブルから)
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String postcode = request.getParameter("postcode");
		String company = request.getParameter("company");
		
		//取得したいデータ（リアクションID）
		String reactionName = request.getParameter("reaction_name");
		String[] selectedStudents = request.getParameterValues("student");//student_idを取得したい
		
		StampLogDao stampLogDao = new StampLogDao();
		
		for(String s:selectedStudents) {
			stampLogDao.addStampLog(Integer.parseInt(s),Integer.parseInt(stampId));
		}
	}
	
}