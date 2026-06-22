package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Teachers;

@WebServlet("/StudentSeatServlet")
public class StudentSeatServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//セッションからログイン中の教師データを取得する
		HttpSession session = request.getSession();
		Teachers teacher = (Teachers) session.getAttribute("teacherData");
		
		//
		
		
		// スタンプページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/stamp.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		
		//取得したいデータ（スタンプの種類）
		String stampId = request.getParameter("stamp_id");
		
		//セッションスコープにstamp_idを格納
		HttpSession session = request.getSession();
		session.setAttribute("stamp_id",stampId);

	}
}