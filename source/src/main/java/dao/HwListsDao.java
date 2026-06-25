package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.HwLists;

public class HwListsDao {
	// 引数で指定された日付、学年、クラスに対応するhwlistオブジェクトを返す
	public List<HwLists> getHwList(String date, int grade, int class_number) {
		Connection conn = null;
		List<HwLists> hwlist = new ArrayList<HwLists>();
		
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
			String sql = "SELECT * FROM HW_LISTS WHERE date=? AND grade=? AND class_number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のidを上記のSELECT文の?に代入
			pStmt.setString(1, date);
			pStmt.setString(2, String.valueOf(grade));
			pStmt.setString(3, String.valueOf(class_number));

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 日付、学年、クラスが一致する宿題リストをオブジェクトに詰める
			while(rs.next()) {
				HwLists hlist = new HwLists();
				hlist.setId(rs.getInt("id"));
				hlist.setDate(rs.getString("date"));
				hlist.setHw_range(rs.getString("hw_range"));
				hlist.setGrade(rs.getInt("grade"));
				hlist.setClass_number(rs.getInt("class_number"));
				hlist.setHomework_id(rs.getInt("homework_id"));
				hlist.setHomework_name(rs.getString("homework_name"));
				
				hwlist.add(hlist);
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
		// hwlistを返す
		return hwlist;
	}
	
	// 引数で指定された学年、クラスに対応するhwlistオブジェクトを返す
		public List<HwLists> getHwList(int grade, int class_number) {
			Connection conn = null;
			List<HwLists> hwlist = new ArrayList<HwLists>();
			
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
				String sql = "SELECT * FROM HW_LISTS WHERE grade=? AND class_number=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				//引数のidを上記のSELECT文の?に代入
				pStmt.setString(1, String.valueOf(grade));
				pStmt.setString(2, String.valueOf(class_number));

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();
				
				// 日付、学年、クラスが一致する宿題リストをオブジェクトに詰める
				while(rs.next()) {
					HwLists hlist = new HwLists();
					hlist.setId(rs.getInt("id"));
					hlist.setDate(rs.getString("date"));
					hlist.setHw_range(rs.getString("hw_range"));
					hlist.setGrade(rs.getInt("grade"));
					hlist.setClass_number(rs.getInt("class_number"));
					hlist.setHomework_id(rs.getInt("homework_id"));
					hlist.setHomework_name(rs.getString("homework_name"));
					
					hwlist.add(hlist);
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
			// hwlistを返す
			return hwlist;
		}
		public void addHwList(int class_number, int grade, int homework_id) {
			Connection conn = null;
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
				
				// INSERT文を準備する
				String sql = "INSERT INTO HW_LISTS (date, grade, class_number, homework_id) VALUES (?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				// 現在の日付を取得（yyyy-MM-dd形式）
				String today = java.time.LocalDate.now().toString();
				
				// 引数の値を上記のINSERT文の?に代入
				pStmt.setString(1, today);
				pStmt.setInt(2, grade);
				pStmt.setInt(3, class_number);
				pStmt.setInt(4, homework_id);

				// INSERT文を実行する
				pStmt.executeUpdate();
				
			} catch (Exception e) {
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
		
		// 持ち物リストの全データを完全に消去する
			public void clearAllHwList() {
				Connection conn = null;
				try {
					// JDBCドライバを読み込む
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b5?"
							+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
							"root", "password");
					
					// 本番環境
//					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b5?useSSL=false"
//							+ "&allowPublicKeyRetrieval=true&serverTimezone=Asia/Tokyo&connectTimeout=30000"
//							,"b5","3YyniFH6fpR5WMeB");
					
					// 全削除用のSQL文を準備する（WHERE句なし）
					String sql = "DELETE FROM HW_LISTS";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// DELETE文を実行する
					pStmt.executeUpdate();
					
				} catch (Exception e) {
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