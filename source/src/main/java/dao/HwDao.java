package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Hw;

public class HwDao {
	// 引数で指定されたIDに対応するhwオブジェクト(宿題名)を返す
	public Hw getHwByID(int id) {
		Connection conn = null;
		Hw hw = null;
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SELECT文を準備する
			String sql = "SELECT * FROM HW WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のidを上記のSELECT文の?に代入
			pStmt.setString(1, String.valueOf(id));

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// IDが一致するリアクションの名前と画像URLをオブジェクトに詰める
			if(rs.next()) {
				hw = new Hw();
				hw.setId(rs.getInt("id"));
				hw.setHw_name(rs.getString("hw_name"));
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
		return hw;
	}
}