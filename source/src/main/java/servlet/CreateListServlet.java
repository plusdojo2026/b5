package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemListsDao;

@WebServlet("/CreateListServlet")
public class CreateListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// しゅくだい、もちものリスト作成画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_list.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//作ったリストをデータベースに登録する
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//取得したいデータ（教師がリスト作成画面で作ったリスト）
		String[] item_ids = request.getParameterValues("item_id");//作ったリストのitem_idたちを取得したい
		
		
		//クラス、学年、item_id、日付を引数として作成した持ち物リストをItemListsに登録するメソッドが必要
		
		ItemListsDao ItemListsDao = new ItemListsDao();
		
		for(String s:item_ids) {
			
		}
	}
	
	
}

