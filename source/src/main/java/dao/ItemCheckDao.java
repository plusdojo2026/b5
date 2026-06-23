package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ItemCheck;

public class ItemCheckDao {
	
	//ItemListsからの情報をコピーして児童ごとに格納する（というより最新のリストへの更新の方が正しいかも？）
	public void addItemLists(int student_id, String date) {
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
			
			String sql = "INSERT INTO ITEM_CHECK (student_id, date, item_id, is_checked) "
					   + "SELECT ?, ?, il.item_id, FALSE "
					   + "FROM ITEM_LISTS il "
					   + "JOIN STUDENTS s ON il.grade = s.grade AND il.class_number = s.class_number "
					   + "WHERE s.id = ? AND il.date = ? "
					   + "AND il.item_id NOT IN ("
					   + "	SELECT item_id FROM ITEM_CHECK WHERE student_id = ? AND date = ?"
					   + ")";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, student_id);
			pStmt.setString(2, date);
			pStmt.setInt(3, student_id);
			pStmt.setString(4, date);
			pStmt.setInt(5, student_id);
			pStmt.setString(6, date);
			

			pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { 
				try { 
					conn.close();
				} catch (SQLException e) { 
					e.printStackTrace(); 
				}
			}
		}
	}

	//指定した日付の持ち物を取得する
	public List<ItemCheck> getCheckList(int student_id, String date) {
		List<ItemCheck> checkList = new ArrayList<>();
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
			
			//itemsからitem_name,itemListsからそのほか情報をコピー
			String sql = "SELECT ic.id, ic.student_id, ic.date, ic.item_id, ic.is_checked, i.item_name "
					   + "FROM ITEM_CHECK ic "
					   + "JOIN ITEMS i ON ic.item_id = i.id "
					   + "WHERE ic.student_id = ? AND ic.date = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, student_id);
			pStmt.setString(2, date);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				ItemCheck item = new ItemCheck();
				item.setId(rs.getInt("id"));
				item.setStudent_id(rs.getInt("student_id"));
				item.setItem_id(rs.getInt("item_id"));
				item.setIs_checked(rs.getBoolean("is_checked"));
				item.setItem_name(rs.getString("item_name"));
				
				checkList.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { 
				try { 
					conn.close();
				} catch (SQLException e) { 
					e.printStackTrace(); 
				}
			}
		}
		return checkList;
	}

	//チェックボックスが押されたら更新(StudentHomeServletで呼び出す)
	public void updateCheckBox(int student_id, int item_lists_id) {
		
	}
}