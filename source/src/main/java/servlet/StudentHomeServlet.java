package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemListsDao;
import dao.StampLogDao;
import dao.StudentsDao;
import dto.ItemLists;
import dto.Students;

@WebServlet("/StudentHomeServlet")
public class StudentHomeServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//セッションからログイン中の児童データを取得する
		HttpSession session = request.getSession();
		Students student = (Students) session.getAttribute("studentData");

		int grade = student.getGrade();
		int class_number = student.getClass_number();
		//現在作成済みのリストを取得する必要がある
		//日付について要検討(いったん日付無し)
		ItemListsDao ilDao = new ItemListsDao();
		List<ItemLists> itemList = ilDao.getItemList(grade, class_number);
		
		request.setAttribute("itemList",itemList);
		
		//クラスのスタンプ数を集計、それに応じて花に使う画像を取得、表示
		//スタンプ数を集計するために、student_idからクラスの全員のスタンプログを取得できるメソッドが必要
		//そのログのリストでfor文を回して、その他以外のスタンプ数を集計する
		//その数に応じて画像を変更す
		//ログインしている児童データを取
		// 現在の日付を取得
		LocalDate now = LocalDate.now();
		// 現在の月を整数値で取得
		int month = now.getMonthValue();
		//student_idから、その児童が各スタンプを何回押されたかを取得する
		//その回数に応じてスタンプ画像の大きさを変える
		StampLogDao logDao = new StampLogDao();
		
		//クラスのスタンプ数を集計、それに応じて花に使う画像を取得、表示
		//スタンプ数を集計するために、学年、クラスを引数としてクラスの全員のスタンプ数を取得できるメソッドが必要（getTotalClassStamp）
		//その数に応じて画像を変更する
		StudentsDao studentsDao = new StudentsDao();
		int classStampCount = logDao.getClassStampCount(grade, class_number, month);
		int classMemberCount = studentsDao.getClassMember(grade, class_number).size();
		
		int schoolDays = 20; // ひと月の登校日
		int fifthValue = classMemberCount * schoolDays; // 5段階目の目標値
		
		int flowerLevel = 1; // 初期の花のレベル（1〜8）
		
		if (fifthValue > 0) {
			// 現在のスタンプ数が、目標値に対して何%か（割合）を計算する
			double percent = (double) classStampCount / fifthValue;
			
			// 割合に応じて8段階に振り分ける
			// （目標達成の 1.00 でレベル5になるように、0.25刻みで設定）
			if (percent >= 1.75) {
				flowerLevel = 8;      // 175%以上（最大レベル）
			} else if (percent >= 1.50) {
				flowerLevel = 7;      // 150%以上
			} else if (percent >= 1.25) {
				flowerLevel = 6;      // 125%以上
			} else if (percent >= 1.00) {
				flowerLevel = 5;      // 100%以上(５段階目）
			} else if (percent >= 0.75) {
				flowerLevel = 4;      // 75%以上
			} else if (percent >= 0.50) {
				flowerLevel = 3;      // 50%以上
			} else if (percent >= 0.25) {
				flowerLevel = 2;      // 25%以上
			} else {
				flowerLevel = 1;      // 25%未満（初期状態）
			}
		}
		request.setAttribute("flowerLevel", flowerLevel);
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/student_home.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
