package ruanko.shortrent.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruanko.shortrent.biz.Housebiz;
import ruanko.shortrent.entity.House;

public class Houseshow extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3736138386483532506L;

	/**
	 * Constructor of the object.
	 */
	public Houseshow() {
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
		String state = request.getParameter("state");
		String i = request.getParameter("i");
		Housebiz houseshow=new Housebiz();
		Vector<House> house=houseshow.foundhousebystate(state);
		request.setAttribute("houselis",house);
		response.setCharacterEncoding("utf-8");
		if("1".equals(i)){
			 if(state.equals("yes"))
		     request.getRequestDispatcher("houseshow2.jsp").forward(request, response);
			 else
				 request.getRequestDispatcher("houseshow.jsp").forward(request, response);
		     }
			else if(i.equals("2")){
				request.getRequestDispatcher("housesh.jsp").forward(request, response);
			}
			else
				request.getRequestDispatcher("houseseshlogin.jsp").forward(request, response);
		
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
