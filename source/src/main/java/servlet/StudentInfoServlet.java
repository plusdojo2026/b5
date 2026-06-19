package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReactionsDao;
import dao.StampLogDao;
import dto.Reactions;
import dto.StampLog;

@WebServlet("/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
	    //教師のIDから学年とクラスが一緒の児童を全て引っ張って来る(DAOを編集)
	
	    //仮のメモ↓↓↓
		//教師が児童を選択

		//student_id を取得

		//StampLogDaoでその児童のスタンプ履歴を取得
		      
		//各スタンプ履歴のreaction_idを確認

		//reaction_id がある（NULLでない）ものについて、ReactionsDaoでリアクション情報を取得
		  
		//reaction_id に対応する parent_id（保護者）を特定

		//「〇〇さんがリアクションしました」という通知情報を作る

		//JSPに渡す
		
		//0619↓↓↓
		//選択した児童のスタンプ履歴を表示する
	    // リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int student_id = Integer.parseInt(request.getParameter("student_id"));
		
	    // 児童のスタンプ履歴の取得を行う
		StampLogDao dao = new StampLogDao();
		List<StampLog> stamplog = dao.getStampLogByStudentID(student_id);
		
		
	    // 検索結果をリクエストスコープに格納する
		request.setAttribute("stampLog", stamplog);
		
		//選択した児童の保護者のリアクションを確認する
		//リアクションを取得
		
		ReactionsDao reactionDao = new ReactionsDao();

		List<Reactions> reactionList = new ArrayList<>();

		for (StampLog log : stamplog) {

		    int reaction_id = log.getReaction_id();

		    if (reaction_id != 0) {

		        Reactions reaction =
		                reactionDao.getReactionByID(reaction_id);

		        reactionList.add(reaction);
		    }
		}
		        
		    request.setAttribute("reactionList", reactionList);       
		
		// 保護者の通知画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_info.jsp");
		dispatcher.forward(request, response);}

}