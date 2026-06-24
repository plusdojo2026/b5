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

import dao.StampLogDao;
import dto.StampLog;
import dto.Students;


@WebServlet("/ParentViewServlet")
public class ParentViewServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//ログインしている児童データを取得
		HttpSession session = request.getSession();
		Students student = (Students) session.getAttribute("studentData");
		
		//必要な変数を取得
		int student_id = student.getId();
		StampLogDao logDao = new StampLogDao();
		List<StampLog> stLog = logDao.getStampLogByStudentID(student_id);
		for(StampLog s:stLog) {
			s.setCreated_at(s.getDisplayDate());
		}
		request.setAttribute("stLog",stLog);
		
		// 保護者のリスト画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/parent_view.jsp");
		dispatcher.forward(request, response);
		
		//児童が所属するクラスの持ち物/宿題リストを取得する
		//ItemListsDao,HwListsDaoに、student_idからそのクラスの持ち物,宿題リストを取得できるメソッドが必要
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}

