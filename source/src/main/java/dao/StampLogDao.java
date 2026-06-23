package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.StampLog;

public class StampLogDao {
	// 引数で指定されたstudentIDに対応するStampLogオブジェクトのリストを返す
	public List<StampLog> getStampLogByStudentID(int student_id) {
		Connection conn = null;
		List<StampLog> stamplog = new ArrayList<StampLog>();
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
			String sql = "SELECT * FROM STAMP_LOG WHERE student_id=? ORDER BY created_at DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のIDを上記のSELECT文の?に代入
			pStmt.setInt(1, student_id);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 児童IDが一致するスタンプの種類、その他テキスト、リアクションID、既読チェックをオブジェクトに詰める
			while(rs.next()) {
				StampLog log = new StampLog();
				log.setId(rs.getInt("id"));
				log.setStudent_id(rs.getInt("student_id"));
				log.setStamp_id(rs.getInt("stamp_id"));
				log.setText(rs.getString("text"));
				log.setReaction_id(rs.getInt("reaction_id"));
				log.setIsRead(rs.getBoolean("is_read"));
				log.setCreated_at(rs.getString("created_at"));
				
				stamplog.add(log);
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
			// stamplogを返す
		return stamplog;
	}
	
	public void addStampLog(int student_id, int stamp_id) {
		Connection conn = null;
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
			
			// SQL文を準備する
			String sql = "INSERT INTO STAMP_LOG(student_id, stamp_id)"
						+"VALUES(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のIDを上記のSELECT文の?に代入
			pStmt.setInt(1, student_id);
			pStmt.setInt(2, stamp_id);

			// INSERT文を実行
			pStmt.executeUpdate();
			
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
	}
	
	public void addStampLog(int student_id, int stamp_id, String text) {
		Connection conn = null;
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
			
			// SQL文を準備する
			String sql = "INSERT INTO STAMP_LOG(student_id, stamp_id, text)"
						+"VALUES(?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のIDを上記のINSERT文の?に代入
			pStmt.setString(1, String.valueOf(student_id));
			pStmt.setString(2, String.valueOf(stamp_id));
			pStmt.setString(3, text);
			// INSERT文を実行
			pStmt.executeUpdate();
			
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
	}
	
	public void addReaction(int log_id,int reaction_id) {
		Connection conn = null;
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
			
			// SQL文を準備する
			String sql = "UPDATE STAMP_LOG SET reaction_id = ? WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のIDを上記のSELECT文の?に代入
			pStmt.setInt(1, reaction_id);
			pStmt.setInt(2, log_id);

			// INSERT文を実行
			pStmt.executeUpdate();
			
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
	}
	
	public int getStampCount(int student_id, int stamp_id, int month) {
		int count = 0;
		Connection conn = null;
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
			
			// SQL文を準備する
			String sql = "SELECT COUNT(*) FROM STAMP_LOG WHERE student_id = ? AND stamp_id = ? AND MONTH(created_at) = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のIDを上記のSELECT文の?に代入
			pStmt.setInt(1, student_id);
			pStmt.setInt(2, stamp_id);
			pStmt.setInt(3, month);
			// SELECT文を実行
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}
	
	public int getClassStampCount(int grade, int class_number, int month) {
		int count = 0;
		Connection conn = null;
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
			
			// SQL文を準備する
			String sql = "SELECT COUNT(*) FROM STAMP_LOG sl "
					   + "JOIN STUDENTS s ON sl.student_id = s.id "
					   + "WHERE s.grade = ? AND s.class_number = ? "
					   + "AND MONTH(sl.created_at) = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のIDを上記のSELECT文の?に代入
			pStmt.setInt(1, grade);
			pStmt.setInt(2, class_number);
			pStmt.setInt(3, month);
			// SELECT文を実行
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}
}