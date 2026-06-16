package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Users;

public class UsersDao {
	// 引数で指定されたloginId,loginPassでログインOKならid,ｔｙpeを入れたUsersオブジェクトを返す
	public Users login(String loginId,String loginPass) {
		Connection conn = null;
		Users user = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B5?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SELECT文を準備する
			String sql = "SELECT id, type FROM USERS WHERE login_id=? AND login_pass=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//引数のloginID,loginPassを上記のSELECT文の?に代入
			pStmt.setString(1, loginId);
			pStmt.setString(2, loginPass);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいればidとtypeをオブジェクトに詰める（rs.next() == true → 一致するものがあったということ）
			if(rs.next()) {
				user = new Users();
				user.setId(rs.getInt("id"));
				user.setType(rs.getInt("type"));
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

		// userを返す
		return user;
	}
}
