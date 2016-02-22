package ruanko.shortrent.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruanko.shortrent.biz.indentBiz;
import ruanko.shortrent.entity.days;

public class daysShow extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5908108165580845480L;

	/**
	 * Constructor of the object.
	 */
	public daysShow() {
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
    int id=Integer.parseInt(request.getParameter("id"));
	String Str="'1900-01-01',";
	indentBiz indentBiz = new indentBiz();
	List<days> days = indentBiz.getday(id);
	for (int i = 0; i < days.size(); i++){
  			days days1 = (days)days.get(i);
  			Str=Str+"'"+ days1.getDays()+"',";
	}
	System.out.print(Str);
	days day=new days();
	day.setDays(Str);
	day.setId(id);
	request.setAttribute("day", day);
	
	
	request.getRequestDispatcher("indent_add.jsp").forward(request, response);
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
		String Str="'1900-01-01',";
		indentBiz indentBiz = new indentBiz();
		List<days> days = indentBiz.getday(id);
		for (int i = 0; i < days.size(); i++){
	  			days days1 = (days)days.get(i);
	  			Str=Str+"'"+ days1.getDays()+"',";
		}
		System.out.print(Str);
		days day=new days();
		day.setDays(Str);
		request.setAttribute("day", day);
		
		
		request.getRequestDispatcher("indent_add.jsp").forward(request, response);
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
