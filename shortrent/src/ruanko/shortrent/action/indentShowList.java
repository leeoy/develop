package ruanko.shortrent.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruanko.shortrent.biz.indentBiz;
import ruanko.shortrent.entity.indent;

public class indentShowList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3146098152759571612L;

	/**
	 * Constructor of the object.
	 */
	public indentShowList() {
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
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8"); 
			response.setCharacterEncoding("UTF-8");

			int id=Integer.parseInt(request.getParameter("id"));
			indentBiz indentBiz = new indentBiz();
			List<indent> indent = indentBiz.getAll(id);
			
			
			request.setAttribute("indent", indent);
			
			
			request.getRequestDispatcher("indent_show.jsp").forward(request, response);
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
		int id=Integer.parseInt(request.getParameter("id"));
		
		indentBiz indentBiz = new indentBiz();
		List<indent> indent = indentBiz.getAll(id);
		
		
		request.setAttribute("indent", indent);
		
		
		request.getRequestDispatcher("indent_show.jsp").forward(request, response);
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
