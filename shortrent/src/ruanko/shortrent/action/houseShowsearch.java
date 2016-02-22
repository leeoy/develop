package ruanko.shortrent.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruanko.shortrent.biz.Housebiz;
import ruanko.shortrent.entity.House;

public class houseShowsearch extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4953704269218290180L;

	/**
	 * Constructor of the object.
	 */
	public houseShowsearch() {
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

	String a = request.getParameter("a");
	Housebiz houseBiz = new Housebiz();
	List<House> house = houseBiz.getsearch(a);
	
	
	request.setAttribute("house", house);
	
	
	request.getRequestDispatcher("houseshowsearch.jsp").forward(request, response);
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



String a = request.getParameter("a");
if(a.equals(null)) a="1";
Housebiz houseBiz = new Housebiz();
List<House> house = houseBiz.getsearch(a);


request.setAttribute("house", house);


request.getRequestDispatcher("houseshowsearch.jsp").forward(request, response);
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
