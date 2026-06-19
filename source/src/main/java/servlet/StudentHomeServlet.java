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

import dao.ItemCheckDao;
import dto.ItemCheck;
import dto.Students;

@WebServlet("/StudentHomeServlet")
public class StudentHomeServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 児童のホームにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_home.jsp");
		dispatcher.forward(request, response);
		
		// 1. セッションからログイン中の児童データを取得する
		HttpSession session = request.getSession();
		Students student = (Students) session.getAttribute("studentData");
		
		//その児童ごとの持ち物/宿題リストを取得、表示
		ItemCheckDao icDao = new ItemCheckDao();
		icDao.addItemLists(student.getId(), getServletInfo());
		List<ItemCheck> studentItems = icDao.getCheckList(student.getId(), getServletInfo());
		//クラスのスタンプ数を集計、それに応じて花に使う画像を取得、表示
				
	}
}
