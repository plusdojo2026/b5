package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b5?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
				
				//本番環境
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b5?useSSL=false"
//						+ "&allowPublicKeyRetrieval=true&serverTimezone=Asia/Tokyo&connectTimeout=30000"
//						,"b5","3YyniFH6fpR5WMeB");
				
				// SELECT文を準備する
				String sql = "SELECT * FROM STUDENTS WHERE user_id=?";
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
		
		public List<Students> getClassMember(int grade,int class_number) {
			Connection conn = null;
			List<Students> st = new ArrayList<Students>();
			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b5?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
				
				//本番環境
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b5?useSSL=false"
//						+ "&allowPublicKeyRetrieval=true&serverTimezone=Asia/Tokyo&connectTimeout=30000"
//						,"b5","3YyniFH6fpR5WMeB");
				
				// SELECT文を準備する
				String sql = "SELECT * FROM STUDENTS WHERE grade=? AND class_number=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				//引数のuserIDを上記のSELECT文の?に代入
				pStmt.setInt(1, grade);
				pStmt.setInt(2, class_number);

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();
				// IDが一致するユーザーがいればオブジェクトに詰める（rs.next() == true → 一致するものがあったということ）
				while(rs.next()) {
					Students  student = new Students();
					student.setId(rs.getInt("id"));
					student.setUser_id(rs.getInt("user_id"));
					student.setName(rs.getString("name"));
					student.setGrade(rs.getInt("grade"));
					student.setClass_number(rs.getInt("class_number"));
					
					st.add(student);
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
			return st;
		}
}
