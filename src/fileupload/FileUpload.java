package fileupload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logincheck.CheckLogin;

import model.Filemodel;
import model.User;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.UserDao;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String forward = "";
	String FILE_PATH = "D:/eclipsejsp/uploads";
	boolean islogin = false;

	public FileUpload() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		String action = request.getParameter("action");
		// String action2 = request.getQueryString();		
		CheckLogin checkuser = new CheckLogin();
		islogin = checkuser.checkLogin(request);
		if (islogin){			
			if(action ==null){
				forward = "includes/fileupload.jsp";
			}else if (action.equalsIgnoreCase("ajaxform")){
				UserDao userdao = new UserDao();
				List<User> userlist = userdao.getAllUsers();
				request.setAttribute("users", userlist);				
				//System.out.println(userlist);							
				forward = "contentpages/ajaxform.jsp";
			}else{
				forward = "includes/fileupload.jsp";
			}			
			request.setAttribute("weppage", forward);
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}else{
			response.sendRedirect("http://localhost:8080/Integrated/");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CheckLogin checkuser = new CheckLogin();
		islogin = checkuser.checkLogin(request);
		if (islogin) {
			Filemodel filemodel = new Filemodel();
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				try {
					List items = upload.parseRequest(request);
					Iterator iterator = items.iterator();
					while (iterator.hasNext()) {
						FileItem item = (FileItem) iterator.next();
						if (!item.isFormField()) {
							String fileName = item.getName();
							filemodel.setFile_name(fileName);
							System.out.println(fileName);
							File path = new File(FILE_PATH);
							File uploadedFile = new File(path + "/" + fileName);
							item.write(uploadedFile);
						} else {
							// System.out.println("regularForm");
							String name = item.getFieldName();
							String value = item.getString();
							filemodel.setFull_name(value);
							System.out.println(value);
						}
					}
				} catch (FileUploadException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {

			}
			UserDao dao = new UserDao();
			dao.addFile(filemodel);
			request.setAttribute("success","SuccessFully Added File");
			forward = "includes/fileupload.jsp";
			request.setAttribute("weppage", forward);
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("http://localhost:8080/Integrated/");
		}
	}
}
