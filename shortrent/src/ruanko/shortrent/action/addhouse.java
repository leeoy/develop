package ruanko.shortrent.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruanko.shortrent.biz.Housebiz;
import ruanko.shortrent.entity.House;

public class addhouse extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4635016639582296889L;

	/**
	 * Constructor of the object.
	 */
	public addhouse() {
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
	    String state=null;
	    String address1=null,address2=null,house_address=null,address3=null;
	    state="no";
		House house=new House();
		house.setHouse_name(request.getParameter("house_name"));
		address1=request.getParameter("house_address1");
		address2=request.getParameter("house_address2");
		address3=request.getParameter("address3");
		house_address=address1+address2+address3;
		house.setHouse_address(house_address);
		house.setHouse_price(Double.parseDouble(request.getParameter("house_price")));
		house.setHouse_suithuman(Integer.parseInt(request.getParameter("house_suithuman")));
		house.setHouse_support(request.getParameter("house_support"));
		house.setHouse_type(request.getParameter("house_type"));
		house.setHouse_state(state);
		house.setOwner_id(Integer.parseInt(request.getParameter("owner_id")));
		Housebiz add=new Housebiz();
		try {
			add.addhouse(house);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("center.html").forward(request, response);
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
