package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Reactions;

public class ReactionsDao {
	// 引数で指定されたIDに対応するreactionオブジェクトを返す
	public Reactions getReactionByID(int id) {
		Connection conn = null;
		Reactions reaction = null;
		
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
			String sql = "SELECT * FROM REACTIONS WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//引数のidを上記のSELECT文の?に代入
			pStmt.setString(1, String.valueOf(id));

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// IDが一致するリアクションの名前と画像URLをオブジェクトに詰める（rs.next() == true → 一致するものがあったということ）
			if(rs.next()) {
				reaction = new Reactions();
				reaction.setId(rs.getInt("id"));
				reaction.setReaction_name(rs.getString("reaction_name"));
				reaction.setReaction_url(rs.getString("reaction_url"));
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
		return reaction;
	}
}