package crudController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

import model.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String forward = "";  
    public UserController() {
        super();
       
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listuser");
		String action = request.getParameter("action");	
		UserDao userdao = new UserDao();
		if(action ==null){			
			forward = "includes/listUser.jsp";
			List<User> userlist = userdao.getAllUsers();			
			request.setAttribute("users",userlist);
		}else{			
			if(action.equalsIgnoreCase("listUser")){				
				forward = "includes/listUser.jsp";
				List<User> userlist = userdao.getAllUsers();
				//System.out.println(userlist);
				request.setAttribute("users",userlist);
			}else if(action.equalsIgnoreCase("delete")){
				String userid = request.getParameter("userId");
				int useridint = Integer.parseInt(userid);
				userdao.deleteUser(useridint);
				forward = "includes/listUser.jsp";
				List<User> userlist = userdao.getAllUsers();			
				request.setAttribute("users",userlist);
				//System.out.println(userid);
			}else if(action.equalsIgnoreCase("insert")){				
				forward = "includes/user.jsp";				
			}
			else if(action.equalsIgnoreCase("edit")){
				String userid = request.getParameter("userId");
				int useridint = Integer.parseInt(userid);
				User userById = userdao.getUserById(useridint);
				request.setAttribute("user",userById);
				forward = "includes/user.jsp";				
			}
		}
		request.setAttribute("weppage", forward);
		RequestDispatcher view = request
				.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
