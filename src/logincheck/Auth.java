package logincheck;
import com.util.DBUtil;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth {

	public int checkUserAuth(LoginUser user) throws SQLException,
			NoSuchAlgorithmException {
		String hashPass = MD5(user.getPassword());
		Connection conn = null;
		int size = 0;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("select * from loginuser where  username =? and hashpass = ?");
			pStmt.setString(1, user.getUsername());
			pStmt.setString(2, hashPass);
			ResultSet rSet = pStmt.executeQuery();
			rSet.last();
			size = rSet.getRow();
			// System.out.println(size);
			// System.exit(0);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return size;
	}

	public String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
}
