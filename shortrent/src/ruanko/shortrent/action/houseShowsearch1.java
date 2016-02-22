package ruanko.shortrent.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruanko.shortrent.biz.Housebiz;
import ruanko.shortrent.entity.House;

public class houseShowsearch1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3210727621560597048L;

	/**
	 * Constructor of the object.
	 */
	public houseShowsearch1() {
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

		String house_type = request.getParameter("house_type");
		String house_price=request.getParameter("house_price");
		String house_suithuman=request.getParameter("house_suithuman");
		String house_address1=request.getParameter("house_address1");
		String house_address2=request.getParameter("house_address2");
		if(house_price.equals(null)) house_price="like'%%'";
		if(house_suithuman.equals(null)) house_suithuman="like'%%'";
		
		Housebiz houseBiz = new Housebiz();
		List<House> house = houseBiz.getsearch1(house_type,house_price,house_suithuman,house_address1,house_address2);
		
		
		request.setAttribute("house", house);
		
		
		request.getRequestDispatcher("houseshowsearch1.jsp").forward(request, response);
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
