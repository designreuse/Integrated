package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.util.DBUtil;

import model.Filemodel;
import model.User;
import model.VdcList;

public class UserDao {

	public void addUser(User user) {
		Connection conn = null;
		try {

			conn = DBUtil.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("insert into users(firstname,lastname,dob,email) values (?, ?, ?, ? )");
			pStmt.setString(1, user.getFirstName());
			pStmt.setString(2, user.getLastName());
			pStmt.setDate(3, new java.sql.Date(user.getDob().getTime()));
			pStmt.setString(4, user.getEmail());
			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public void deleteUser(int userId) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("delete from users where userid=?");

			pStmt.setInt(1, userId);
			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public void updateUser(User user) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("update users set firstname=?, lastname=?, dob=?, email=?"
							+ "where userid=?");

			pStmt.setString(1, user.getFirstName());
			pStmt.setString(2, user.getLastName());
			pStmt.setDate(3, new java.sql.Date(user.getDob().getTime()));
			pStmt.setString(4, user.getEmail());
			pStmt.setInt(5, user.getUserid());
			pStmt.executeUpdate();
			// System.out.println("here");
			// System.exit(0);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public List<User> getAllUsers() {
		Connection conn = null;
		List<User> users = new ArrayList<User>();
		try {
			conn = DBUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rSet = stmt.executeQuery("select * from users");
			while (rSet.next()) {
				User user = new User();
				user.setUserid(rSet.getInt("userid"));
				user.setFirstName(rSet.getString("firstname"));
				user.setLastName(rSet.getString("lastname"));
				user.setDob(rSet.getDate("dob"));
				user.setEmail(rSet.getString("email"));
				users.add(user);
			}
			//System.out.println(users);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}

		return users;
	}

	public User getUserById(int userId) {
		Connection conn = null;
		User user = new User();
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("select * from users where userid=?");
			pStmt.setInt(1, userId);
			ResultSet rSet = pStmt.executeQuery();

			if (rSet.next()) {
				user.setUserid(rSet.getInt("userid"));
				user.setFirstName(rSet.getString("firstname"));
				user.setLastName(rSet.getString("lastname"));
				user.setDob(rSet.getDate("dob"));
				user.setEmail(rSet.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}

		return user;
	}

	public void addFile(Filemodel filedes) {
		Connection conn = null;
		conn = DBUtil.getConnection();
		try {
			PreparedStatement psmt = conn
					.prepareStatement("insert into file_upload(full_name,file_name) values (?,?)");
			psmt.setString(1, filedes.full_name);
			psmt.setString(2, filedes.file_name);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public List<VdcList> getAllVdc(int dist_id) {
		Connection conn = null;
		 List<VdcList> vdclist = new ArrayList<VdcList>();		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("SELECT * FROM vdc where dist_id=?");
			pStmt.setInt(1, dist_id);
			ResultSet rSet = pStmt.executeQuery();		
			while (rSet.next()) {
				 VdcList vdc = new VdcList();
				 User user = new User();
				//System.out.println(rSet.getInt("vdc_id") + " " + rSet.getString("vdc_name") +" "+rSet.getInt("dist_id"));
							
				vdc.setVdcid(rSet.getInt("vdc_id"));
				vdc.setFirstName(rSet.getString("vdc_name"));
				vdclist.add(vdc);
				//System.out.println(vdc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return vdclist;
	}
}