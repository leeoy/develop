package ruanko.shortrent.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ruanko.shortrent.biz.Housebiz;
import ruanko.shortrent.entity.House;

public class houseshowlogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9165173443753351267L;

	/**
	 * 
	 */


	/**
	 * Constructor of the object.
	 */
	public houseshowlogin() {
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

	String a=request.getParameter("state");
	Housebiz houseBiz = new Housebiz();
	List<House> house = houseBiz.getAll(a);
	
	HttpSession session = request.getSession();
	session.setAttribute("house", house);
	
	
	request.getRequestDispatcher("house_show_login.jsp").forward(request, response);
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

	
doGet(request,response);
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
