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
import dao.StudentsDao;
import dto.Students;
import dto.Teachers;

@WebServlet("/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//ログインしている教師データを取得
		HttpSession session = request.getSession();
		Teachers teacher = (Teachers) session.getAttribute("teacherData");
		
		//StudentsDaoを使えるようにする
		StudentsDao studentDao = new StudentsDao();
		
		//児童一覧を取得
		List<Students> studentList = studentDao.getClassMember(teacher.getGrade(),teacher.getClass_number());

		request.setAttribute("studentList", studentList);

		String studentIdStr = request.getParameter("student_id");
		if (studentIdStr != null && !studentIdStr.isEmpty()) {
			int student_id = Integer.parseInt(studentIdStr);
			
			// 選択状態を保持するためにリクエストスコープに格納
			request.setAttribute("selectedStudentId", student_id);
			
			// StampLogDaoを利用してスタンプ数を取得（StudentResultServletと同様の処理）
			StampLogDao logDao = new dao.StampLogDao();
			int[] stampCounts = new int[6];
			
			// 当月のデータを取得する想定
			java.time.LocalDate now = java.time.LocalDate.now();
			int month = now.getMonthValue();
			
			for(int i = 1; i <= 6; i++){
				stampCounts[i-1] = logDao.getStampCount(student_id, i, month);
			}
			
			// 集計した配列をリクエストスコープに格納
			request.setAttribute("stampCounts", stampCounts);
		}
		
		// 保護者の通知画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_info.jsp");
		dispatcher.forward(request, response);}

}