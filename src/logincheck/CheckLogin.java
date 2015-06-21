package logincheck;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CheckLogin {
	public boolean checkLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("UserName");
		if (username != null) {
			return true;
		}else{
			return false;
		}
		
	}
}
