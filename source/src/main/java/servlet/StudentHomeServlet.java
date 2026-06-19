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
		
		//セッションからログイン中の児童データを取得する
		HttpSession session = request.getSession();
		Students student = (Students) session.getAttribute("studentData");
		
		//その児童ごとの持ち物/宿題リストを取得、表示
		ItemCheckDao icDao = new ItemCheckDao();
		icDao.addItemLists(student.getId(), getServletInfo());
		List<ItemCheck> studentItems = icDao.getCheckList(student.getId(), getServletInfo());
		//JSPに渡すためにリクエストスコープに格納
		request.setAttribute("itemList", studentItems);
		
		//クラスのスタンプ数を集計、それに応じて花に使う画像を取得、表示
		//スタンプ数を集計するために、student_idからクラスの全員のスタンプログを取得できるメソッドが必要
		//そのログのリストでfor文を回して、その他以外のスタンプ数を集計する
		//その数に応じて画像を変更する
		
		
		// 児童のホームにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_home.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//セッションからログイン中の児童データを取得する
		HttpSession session = request.getSession();
		Students student = (Students) session.getAttribute("studentData");
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String[] item_lists_id = request.getParameterValues("item_lists_id");
		
		/*選んだ持ち物のチェックボックスを更新するために、
		student_idとitem_lists_idを引数として、ItemCheckのis_checkedをtrueにするメソッド(updateCheckBox(int student_id, int item_lists_id))が必要*/
		ItemCheckDao icDao = new ItemCheckDao();
		for(String i:item_lists_id) {
			icDao.updateCheckBox(student.getId(),Integer.parseInt(i));
		}
		
	}
}
