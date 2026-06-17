package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.HwLists;

public class HwListsDao {
	// 引数で指定された日付、学年、クラスに対応するhwlistオブジェクトを返す
	public HwLists getHwList(String date, int grade, int class_number) {
		Connection conn = null;
		HwLists hwlist = null;
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SELECT文を準備する
			String sql = "SELECT * FROM HW_LISTS WHERE date=? AND grade=? AND class_number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のidを上記のSELECT文の?に代入
			pStmt.setString(1, date);
			pStmt.setString(2, String.valueOf(grade));
			pStmt.setString(3, String.valueOf(class_number));

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 日付、学年、クラスが一致する宿題リストをオブジェクトに詰める
			if(rs.next()) {
				hwlist = new HwLists();
				hwlist.setId(rs.getInt("id"));
				hwlist.setDate(rs.getString("date"));
				hwlist.setHw_range(rs.getString("hw_range"));
				hwlist.setGrade(rs.getInt("grade"));
				hwlist.setClass_number(rs.getInt("class_number"));
				hwlist.setHomework_id(rs.getInt("homework_id"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// itemlistを返す
		return hwlist;
	}
}