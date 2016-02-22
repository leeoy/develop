package ruanko.shortrent.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ruanko.shortrent.biz.indentBiz;
import ruanko.shortrent.entity.User;
import ruanko.shortrent.entity.indent;

public class indentAdd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6225544406298489731L;

	/**
	 * Constructor of the object.
	 */
	public indentAdd() {
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
	
		indent indent = new indent();
		
		indent.setRenter_id(Integer.parseInt((request.getParameter("renter_id"))));
		indent.setIndent_check_in_time((request.getParameter("indent_check_in_time")));
		indent.setIndent_leave_time((request.getParameter("indent_leave_time")));
		indent.setIndent_state("n");
		indent.setHouse_id(Integer.parseInt((request.getParameter("house_id"))));

		//创建业务逻辑对象并执行添加新闻操作
		indentBiz indentBiz = new indentBiz();
		indentBiz.add(indent);
		
		//跳转到主页
		//不过好像这里跳转到新闻列表页会更合适一些
		//也许这个问题会在下一版的《最小新闻发布系统》在解决吧
		request.getRequestDispatcher("succeed.jsp").forward(request, response);
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
