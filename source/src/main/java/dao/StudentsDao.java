package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Students;

public class StudentsDao {
	// 引数で指定されたuserIDに対応するStudentオブジェクトを返す
		public Students getStudentByUserID(int userId) {
			Connection conn = null;
			Students student = null;
			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");
				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B5?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
				// SELECT文を準備する
				String sql = "SELECT * FROM studentS WHERE user_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				//引数のuserIDを上記のSELECT文の?に代入
				pStmt.setString(1, String.valueOf(userId));

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();
				// IDが一致するユーザーがいればオブジェクトに詰める（rs.next() == true → 一致するものがあったということ）
				if(rs.next()) {
					student = new Students();
					student.setId(rs.getInt("id"));
					student.setUser_id(rs.getInt("user_id"));
					student.setName(rs.getString("name"));
					student.setGrade(rs.getInt("grade"));
					student.setClass_number(rs.getInt("class_number"));
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
				// studentを返す
			return student;
		}
}
