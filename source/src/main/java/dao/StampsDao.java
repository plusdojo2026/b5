package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Stamps;

public class StampsDao {
	// 引数で指定されたIDに対応するstampオブジェクト(スタンプ名と画像URL)を返す
	public Stamps getStampByID(int id) {
		Connection conn = null;
		Stamps stamp = null;
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SELECT文を準備する
			String sql = "SELECT * FROM STAMPS WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のidを上記のSELECT文の?に代入
			pStmt.setString(1, String.valueOf(id));

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// IDが一致するスタンプ名と画像URLをオブジェクトに詰める
			if(rs.next()) {
				stamp = new Stamps();
				stamp.setId(rs.getInt("id"));
				stamp.setStamp_name(rs.getString("stamp_name"));
				stamp.setStamp_url(rs.getString("stamp_url"));
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
		return stamp;
	}
}