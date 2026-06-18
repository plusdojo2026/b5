package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StampLogDao;

@WebServlet("/StampServlet")
public class StampServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// スタンプページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB_INF/jsp/stamp.jsp");
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
		}
	}
	
}
