package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HwCheckServlet")
public class HwCheckServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 宿題チェック画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/hw_check.jsp");
		dispatcher.forward(request, response);
		
		//宿題を一覧表示するために、teacher_idから担当クラスの宿題一覧を取得できるメソッドが必要
		//児童を一覧表示するために、teacher_idから担当クラスの児童一覧を取得できるメソッドが必要
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		
		/*選んだ児童に選んだ宿題の完了スタンプを付与するために、
		student_idとhw_lists_idを引数として、HwCheckのis_checkedをtrueにするメソッドが必要*/
	}
}