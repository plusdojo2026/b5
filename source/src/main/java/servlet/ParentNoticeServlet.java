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

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("login_id") == null) {
			response.sendRedirect("/b5/LoginServlet");
			return;
		}

		// 保護者の通知ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/parent_notice.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("login_id") == null) {
			response.sendRedirect("/b5/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String company = request.getParameter("company");
		String department = request.getParameter("department");
		String position = request.getParameter("position");
		String name = request.getParameter("name");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String fax = request.getParameter("fax");
		String email = request.getParameter("email");
		String remarks = request.getParameter("remarks");

		// 検索処理を行う
		BcDAO bDao = new BcDAO();
		List<Bc> cardList = bDao.select(new Bc(0, company,  department, position, name, zipcode, address, 
				phone, fax, email, remarks));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
		dispatcher.forward(request, response);
	}
}
