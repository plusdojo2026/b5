package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ItemLists;

public class ItemListsDao {
	// 引数で指定された日付、学年、クラスに対応するitemlistオブジェクトを返す
	public List<ItemLists> getItemList(String date, int grade, int class_number) {
		Connection conn = null;
		List<ItemLists> itemlist = new ArrayList<ItemLists>();		
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
			String sql = "SELECT L.id, L.date, L.grade, L.class_number, L.item_id, I.item_name "
					   + "FROM ITEM_LISTS L "
					   + "JOIN ITEMS I ON L.item_id = I.id "
					   + "WHERE L.date=? AND L.grade=? AND L.class_number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のidを上記のSELECT文の?に代入
			pStmt.setString(1, date);
			pStmt.setString(2, String.valueOf(grade));
			pStmt.setString(3, String.valueOf(class_number));

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 日付、学年、クラスが一致する持ち物リストをオブジェクトに詰める
			while(rs.next()) {
				ItemLists ilist  = new ItemLists();
				ilist.setId(rs.getInt("id"));
				ilist.setDate(rs.getString("date"));
				ilist.setGrade(rs.getInt("grade"));
				ilist.setClass_number(rs.getInt("class_number"));
				ilist.setItem_id(rs.getInt("item_id"));
				ilist.setItem_name(rs.getString("item_name"));
				
				itemlist.add(ilist);
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
		return itemlist;
	}
	// 引数で指定された学年、クラスに対応するitemlistオブジェクトをすべて返す
	public List<ItemLists> getItemList(int grade, int class_number) {
		Connection conn = null;
		List<ItemLists> itemlist = new ArrayList<ItemLists>();		
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
			String sql = "SELECT L.id, L.date, L.grade, L.class_number, L.item_id, I.item_name "
					   + "FROM ITEM_LISTS L "
					   + "JOIN ITEMS I ON L.item_id = I.id "
					   + "WHERE L.grade=? AND L.class_number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のidを上記のSELECT文の?に代入
			pStmt.setString(1, String.valueOf(grade));
			pStmt.setString(2, String.valueOf(class_number));

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 日付、学年、クラスが一致する持ち物リストをオブジェクトに詰める
			while(rs.next()) {
				ItemLists ilist  = new ItemLists();
				ilist.setId(rs.getInt("id"));
				ilist.setDate(rs.getString("date"));
				ilist.setGrade(rs.getInt("grade"));
				ilist.setClass_number(rs.getInt("class_number"));
				ilist.setItem_id(rs.getInt("item_id"));
				ilist.setItem_name(rs.getString("item_name"));
				
				itemlist.add(ilist);
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
		return itemlist;
	}
	
	public void addItemList(int class_number, int grade, int item_id) {
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
			
			// INSERT文を準備する
			String sql = "INSERT INTO ITEM_LISTS (date, grade, class_number, item_id) VALUES (?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// 現在の日付を取得（yyyy-MM-dd形式）
			String today = java.time.LocalDate.now().toString();
			
			// 引数の値を上記のINSERT文の?に代入
			pStmt.setString(1, today);
			pStmt.setInt(2, grade);
			pStmt.setInt(3, class_number);
			pStmt.setInt(4, item_id);

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
	public void clearClassItemList(int grade ,int class_number) {
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// 本番環境
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b5?useSSL=false"
//						+ "&allowPublicKeyRetrieval=true&serverTimezone=Asia/Tokyo&connectTimeout=30000"
//						,"b5","3YyniFH6fpR5WMeB");
			
			// 全削除用のSQL文を準備する（WHERE句なし）
			String sql = "DELETE FROM ITEM_LISTS WHERE grade=? AND class_number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, grade);
			pStmt.setInt(2, class_number);
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