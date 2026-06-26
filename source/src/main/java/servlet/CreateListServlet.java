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

import dao.HwDao;
import dao.HwListsDao;
import dao.ItemListsDao;
import dao.ItemsDao;
import dto.HwLists;
import dto.ItemLists;
import dto.Teachers;
@WebServlet("/CreateListServlet")
public class CreateListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//CreateListServletというサーブレットを作ります。URLは /CreateListServlet です。//
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Teachers teacher = (Teachers) session.getAttribute("teacherData");
		int grade = teacher.getGrade();
		int class_number = teacher.getClass_number();
		//現在作成済みのリストを取得する必要がある
		//日付について要検討(いったん日付無し)
		ItemListsDao ilDao = new ItemListsDao();
		List<ItemLists> itemList = ilDao.getItemList(grade, class_number);
		HwListsDao hlDao = new HwListsDao();
		List<HwLists> hwList = hlDao.getHwList(grade, class_number);
		
		request.setAttribute("itemList",itemList);
		request.setAttribute("hwList",hwList);
		
		// しゅくだい、もちものリスト作成画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create_list.jsp");
		dispatcher.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//作ったリストをデータベースに登録する
		//do Postは、更新ボタンが押されたときに呼び出される。
		HttpSession session = request.getSession();
		Teachers teacher = (Teachers) session.getAttribute("teacherData");
		int grade = teacher.getGrade();
		int class_number = teacher.getClass_number();
		
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータを取得する
		//文字化け防止
		//取得したいデータ（教師がリスト作成画面で作ったリスト）
		String updateType = request.getParameter("update_type");
		//持ち物更新
		if ("item".equals(updateType)) {
			String[] item_names = request.getParameterValues("item_name");
			ItemListsDao ilDao = new ItemListsDao();
			ItemsDao itemsDao = new ItemsDao();
			
			ilDao.clearClassItemList(grade, class_number);
			
			if (item_names != null) {
				for (String name : item_names) {
					int item_id = itemsDao.getOrInsertItem(name);
					if (item_id != -1) {
						ilDao.addItemList(class_number, grade, item_id);
					}
				}
			}
			
		} else if ("hw".equals(updateType)) {
			String[] hw_names = request.getParameterValues("hw_name");
			HwListsDao hlDao = new HwListsDao();
			HwDao hwDao = new HwDao();

			hlDao.clearClassHwList(grade, class_number);
			
			if (hw_names != null) {
				for (String name : hw_names) {
					int hw_id = hwDao.getOrInsertHw(name);
					if (hw_id != -1) {
						hlDao.addHwList(class_number, grade, hw_id);
					}
				}
			}
		}
		response.sendRedirect("/b5/CreateListServlet");
	}
}