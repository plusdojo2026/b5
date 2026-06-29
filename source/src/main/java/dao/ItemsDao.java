package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Items;

public class ItemsDao {
	// 引数で指定されたIDに対応するitemオブジェクト(持ち物名)を返す
	public Items getItemByID(int id) {
		Connection conn = null;
		Items item = null;
		
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
			String sql = "SELECT * FROM ITEMS WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のidを上記のSELECT文の?に代入
			pStmt.setString(1, String.valueOf(id));

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// IDが一致する持ち物名をオブジェクトに詰める
			if(rs.next()) {
				item = new Items();
				item.setId(rs.getInt("id"));
				item.setItem_name(rs.getString("item_name"));
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
		// reactionを返す
		return item;
	}
	
	// テキストを受け取り、既存ならそのIDを、新規なら登録して新しいIDを返すメソッド
	public int getOrInsertItem(String itemName) {
		Connection conn = null;
		int itemId = -1;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true",
					"root", "password");
			
			// 本番環境
//					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b5?useSSL=false"
//							+ "&allowPublicKeyRetrieval=true&serverTimezone=Asia/Tokyo&connectTimeout=30000"
//							,"b5","3YyniFH6fpR5WMeB");
			
			// マスターテーブル（ITEMS）に存在するか確認する
			String checkSql = "SELECT id FROM ITEMS WHERE item_name = ?";
			PreparedStatement checkStmt = conn.prepareStatement(checkSql);
			checkStmt.setString(1, itemName);
			ResultSet rs = checkStmt.executeQuery();
			
			if (rs.next()) {
				// 既に存在する場合はそのIDを取得する
				itemId = rs.getInt("id");
			} else {
				// 存在しない場合は新しくINSERTし、IDを取得する
				String insertSql = "INSERT INTO ITEMS (item_name) VALUES (?)";
				
				// RETURN_GENERATED_KEYS を指定することで、Auto_IncrementされたIDを取得できます
				PreparedStatement insertStmt = conn.prepareStatement(insertSql, java.sql.Statement.RETURN_GENERATED_KEYS);
				insertStmt.setString(1, itemName);
				insertStmt.executeUpdate();
				
				// 作成された新しいIDを取り出す
				ResultSet keys = insertStmt.getGeneratedKeys();
				if (keys.next()) {
					itemId = keys.getInt(1);
				}
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
		
		return itemId;
	}
}