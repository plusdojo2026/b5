package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Teachers;

public class TeachersDao {
	// 引数で指定されたuserIDに対応するTeacherオブジェクトを返す
	public Teachers getTeacherByUserID(int userId) {
		Connection conn = null;
		Teachers teacher = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			//本番環境
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b5?useSSL=false"
//					+ "&allowPublicKeyRetrieval=true&serverTimezone=Asia/Tokyo&connectTimeout=30000"
//					,"b5","3YyniFH6fpR5WMeB");
			
			// SELECT文を準備する
			String sql = "SELECT * FROM TEACHERS WHERE user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//引数のuserIDを上記のSELECT文の?に代入
			pStmt.setString(1, String.valueOf(userId));
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// IDが一致するユーザーがいればオブジェクトに詰める（rs.next() == true → 一致するものがあったということ）
			if(rs.next()) {
				teacher = new Teachers();
				teacher.setId(rs.getInt("id"));
				teacher.setUser_id(rs.getInt("user_id"));
				teacher.setName(rs.getString("name"));
				teacher.setGrade(rs.getInt("grade"));
				teacher.setClass_number(rs.getInt("class_number"));
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
			// teacherを返す
		return teacher;
	}
	
	
}