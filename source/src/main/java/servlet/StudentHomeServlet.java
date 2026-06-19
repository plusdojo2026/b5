package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentHomeServlet")
public class StudentHomeServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 児童のホームにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_home.jsp");
		dispatcher.forward(request, response);
		
		//クラスのスタンプ数を集計、それに応じて花に使う画像を取得、表示
		//その児童ごとの持ち物/宿題リストを取得、表示
	}
}
