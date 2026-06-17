package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.HwCheck;

public class HwCheckDao {
	//HwListsからの情報をコピーして児童ごとに格納する（というより最新のリストへの更新の方が正しいかも？）
		public void addHwLists(int student_id, int grade, int class_number, String date) {
			Connection conn = null;
			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");
				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B5?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
				
				String sql = "INSERT INTO HW_CHECK (student_id, date, homework_id, is_cheked, hw_range) "
						   + "SELECT ?, ?, homework_id, FALSE FROM HW_LISTS "
						   + "WHERE date = ? AND grade = ? AND class_number = ? "
						   + "AND homework_id NOT IN ("
						   + "SELECT homework_id FROM ITEM_CHECK WHERE student_id = ? AND date = ?"
						   + ")";
				
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, student_id);
				pStmt.setString(2, date);
				pStmt.setString(3, date);
				pStmt.setInt(4, grade);
				pStmt.setInt(5, class_number);
				pStmt.setInt(6, student_id);
				pStmt.setString(7, date);

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

		//指定した日付の宿題を取得する
		public List<HwCheck> getCheckList(int student_id, String date) {
			List<HwCheck> checkList = new ArrayList<>();
			Connection conn = null;

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");
				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B5?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
				
				//itemsからitem_name,itemListsからそのほか情報をコピー
				String sql = "SELECT hc.id, hc.student_id, hc.date, hc.homework_id, hc hw_range, hc.is_cheked, h.hw_name "
						   + "FROM HW_CHECK hc "
						   + "JOIN HW h ON hc.item_id = h.id "
						   + "WHERE hc.student_id = ? AND hc.date = ?";
				
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, student_id);
				pStmt.setString(2, date);

				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {
					HwCheck hw = new HwCheck();
					hw.setId(rs.getInt("id"));
					hw.setStudent_id(rs.getInt("student_id"));
					hw.setRange(rs.getString("hw_range"));
					hw.setIs_checked(rs.getBoolean("is_checked"));
					hw.setHw_name(rs.getString("hw_name"));
					
					checkList.add(hw);
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

		//チェックボックスが押されたら更新
		public void updateCheckStatus(int id, boolean is_checked) {
			Connection conn = null;
			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");
				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/B5?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
				
				String sql = "UPDATE HW_CHECK SET is_checked = ? WHERE id = ?";
				
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setBoolean(1, is_checked);
				pStmt.setInt(2, id);

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

}
