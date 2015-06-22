package ajaxCallServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.VdcList;

import com.dao.UserDao;

@WebServlet(asyncSupported = true, urlPatterns = { "/AjaxCall" })
public class AjaxCall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxCall() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDao userdao = new UserDao();
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		String district = request.getParameter("district");
		int dist_id = Integer.parseInt(district);
		if (action.equalsIgnoreCase("getvdc")) {			
			List<VdcList> vdclist = userdao.getAllVdc(dist_id);
			System.out.println(vdclist);
			// for (Object item : vdclist){
			// System.out.println(item);
			// }
			// out.println("<h2>Button Clicked</h2>");
		}

	}

}
