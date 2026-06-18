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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SELECT文を準備する
			String sql = "SELECT * FROM STAMP_LOG WHERE student_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のIDを上記のSELECT文の?に代入
			pStmt.setString(1, String.valueOf(student_id));

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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文を準備する
			String sql = "INSERT INTO STAMP_LOG(student_id, stamp_id)"
						+"VALUES(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のIDを上記のSELECT文の?に代入
			pStmt.setString(1, String.valueOf(student_id));
			pStmt.setString(2, String.valueOf(stamp_id));

			// INSERT文を実行
			pStmt.executeQuery();
			
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
	
	public void addStampLog(int student_id, int stamp_id, String comment) {
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文を準備する
			String sql = "INSERT INTO STAMP_LOG(student_id, stamp_id, text)"
						+"VALUES(?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のIDを上記のINSERT文の?に代入
			pStmt.setString(1, String.valueOf(student_id));
			pStmt.setString(2, String.valueOf(stamp_id));
			pStmt.setString(3, comment);
			// INSERT文を実行
			pStmt.executeQuery();
			
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
}