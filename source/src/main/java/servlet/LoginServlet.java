package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentsDao;
import dao.TeachersDao;
import dao.UsersDao;
import dto.Students;
import dto.Teachers;
import dto.Users;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("login_id");
		String loginPass = request.getParameter("login_pass");
		String loginType = request.getParameter("user_type");
		// ログイン処理を行う
		Users user = new Users();
		user = new UsersDao().login(loginId, loginPass);
		if (user != null) { // 一致する人いる
			// セッションスコープにオブジェクトを格納する
			HttpSession session = request.getSession();
			//教師タブを選んで教師なら教師画面にログイン
			if(user.getType() == 0 && Integer.valueOf(loginType) == 0) {
				Teachers teacher = new Teachers();
				teacher = new TeachersDao().getTeacherByUserID(user.getId());
				session.setAttribute("teacherData", teacher);
				response.sendRedirect("/b5/StampServlet");
			}
			//児童タブを選んで児童なら児童画面にログイン
			else if(user.getType() == 1 && Integer.valueOf(loginType) == 1) {
				Students student = new Students();
				student = new StudentsDao().getStudentByUserID(user.getId());
				session.setAttribute("studentData", student);
				response.sendRedirect("/b5/StudentHomeServlet");
			}
			//保護者タブを選んで児童なら保護者画面にログイン
			else if(user.getType() == 1 && Integer.valueOf(loginType) == 2) {
				Students student = new Students();
				student = new StudentsDao().getStudentByUserID(user.getId());
				session.setAttribute("studentData", student);
				response.sendRedirect("/b5/ParentNoticeServlet");
			}
			//その他の場合はログイン画面を再読み込み
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
				dispatcher.forward(request, response);
			}
			
		} else { // ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			//request.setAttribute("result", new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/webappAns/LoginServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
