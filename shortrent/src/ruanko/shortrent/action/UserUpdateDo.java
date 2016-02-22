package ruanko.shortrent.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruanko.shortrent.biz.UserBiz;
import ruanko.shortrent.entity.User;

public class UserUpdateDo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 311936098063192606L;

	/**
	 * Constructor of the object.
	 */
	public UserUpdateDo() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); 
	    response.setCharacterEncoding("UTF-8");
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); 
	    response.setCharacterEncoding("UTF-8");

		User user = new User();
		user.setUser_id(Integer.parseInt(request.getParameter("user_id")));
		user.setUser_account(request.getParameter("user_account"));
		user.setUser_name(request.getParameter("user_name"));
		user.setUser_sex(request.getParameter("user_sex"));
		user.setUser_phone(request.getParameter("user_phone"));
		user.setUser_text(request.getParameter("user_text"));
		

		UserBiz userBiz = new UserBiz();
		userBiz.update(user);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
