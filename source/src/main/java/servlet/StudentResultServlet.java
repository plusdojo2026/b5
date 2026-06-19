package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentResultServlet")
public class StudentResultServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//student_idから、その児童が各スタンプを何回押されたかを取得する
		//その回数に応じてスタンプ画像の大きさを変える
		
		//クラスのスタンプ数を集計、それに応じて花に使う画像を取得、表示
		//スタンプ数を集計するために、student_idからクラスの全員のスタンプログを取得できるメソッドが必要
		//そのログのリストでfor文を回して、その他以外のスタンプ数を集計する
		//その数に応じて画像を変更する
		
		
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_result.jsp");
		dispatcher.forward(request, response);
	}
}
