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
	//CreateListServletというサーブレットを作ります。URLは /CreateListServlet です。//
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// しゅくだい、もちものリスト作成画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_list.jsp");
		// create_list.jspを表示するための案内係(RequestDispatcher)を作る
		dispatcher.forward(request, response);
		// create_list.jspへ処理を引き継いで実際に画面を表示する
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//作ったリストをデータベースに登録する
		//do Postは、更新ボタンが押されたときに呼び出される。
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//文字化け防止
		//取得したいデータ（教師がリスト作成画面で作ったリスト）
		String[] item_ids = request.getParameterValues("item_id");
		// 画面で作成した持ち物リストのitem_idを複数取得する// 更新ボタンが押されたとき、画面上の持ち物ID一覧を受け取る
		
		
		//クラス、学年、item_id、日付を引数として作成した持ち物リストをItemListsに登録するメソッドが必要
		
		ItemListsDao itemListsDao = new ItemListsDao();
		// item_listsテーブルを操作するDAOを使えるようにする

		for(String s:item_ids) {
		//もちものの数だけ、この処理を1件ずつ繰り返す。
			
		}
	}
}


/*
① 教師がヘッダーの「リスト作成」をクリックする
                ↓ doGet
② create_list.jsp（リスト作成画面）を表示する
                ↓
③ 教師が持ち物リストを入力する
（例：絵具セット、水筒）
                ↓
④ 更新ボタンを押す
                ↓ doPost
⑤ サーブレットがJSPから送られてきたデータを受け取る
                ↓
⑥ CreateListServlet.javaが、JSPから送られてきた持ち物のID一覧を受け取り、item_idsという変数に保存する
                ↓
⑦ ItemListsDao.javaを準備する→DAOがMySQLを実行する
                ↓
⑧ 持ち物の数だけ繰り返し処理を行う
                ↓
⑨ item_listsテーブルへ1件ずつ登録する
（未実装）
                ↓
⑩ MySQLに保存される
*/