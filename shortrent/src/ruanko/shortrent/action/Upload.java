package ruanko.shortrent.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import ruanko.shortrent.biz.Housebiz;
import ruanko.shortrent.entity.House;

public class Upload extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2679166955225720766L;

	/**
	 * Constructor of the object.
	 */
	public Upload() {
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

		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html; charset=UTF-8");
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

		 request.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html; charset=UTF-8"); 
	        int Id = Integer.parseInt(request.getParameter("id"));
			House house=new House();
			String a[] = new String[3];
	          
	        //����·��  
	        String savePath = getServletContext().getRealPath("/upload");  
	        File saveDir = new File(savePath);  
	        // ���Ŀ¼�����ڣ��ʹ���Ŀ¼  
	        if(!saveDir.exists()){  
	            saveDir.mkdir();  
	        }  
	          
	        // �����ļ��ϴ�������  
	        DiskFileItemFactory factory = new DiskFileItemFactory();  
	        ServletFileUpload sfu = new ServletFileUpload(factory);  
	        //���ñ���  
	        sfu.setHeaderEncoding("UTF-8");  
	        // �����ϴ��ĵ����ļ�������ֽ���Ϊ2M  
	        sfu.setFileSizeMax(1024*1024*2);  
	        //����������������ֽ���Ϊ10M  
	        sfu.setSizeMax(1024*1024*10);  
	        int j=0;
	        try{  
	            // ���������  
	            List<FileItem> itemList = sfu.parseRequest(request);  
	            for (FileItem fileItem : itemList) {  
	                // ��Ӧ���еĿؼ���name  
	                String fieldName = fileItem.getFieldName();  
	                System.out.println("�ؼ����ƣ�" + fieldName);  
	                // �������ͨ���ؼ�  
	                if(fileItem.isFormField()){  
	                    String value = fileItem.getString();  
	                    //���±���,�������  
	                    value = new String(value.getBytes("ISO-8859-1"),"UTF-8");  
	                    System.out.println("��ͨ���ݣ�" + fieldName + "=" + value);  
	                // �ϴ��ļ�  
	                }else{  
	                    // ����ļ���С  
	                    Long size = fileItem.getSize();  
	                    // ����ļ���  
	                    String fileName = fileItem.getName();  
	                    System.out.println("�ļ�����"+fileName+"\t��С��" + size + "byte");  
	                    
	                    switch(j){
	                    case 0: a[0]=fileName; break;
	                    case 1: a[1]=fileName; break;
	                    case 2: a[2]=fileName; break;
	                    }
	                    
	                      
	                    //���ò������ϴ����ļ���ʽ  
	                    if(fileName.endsWith(".exe")){  
	                        request.setAttribute("msg", "�������ϴ������ͣ�");  
	                    }else{  
	                        //���ļ����浽ָ����·��  
	                        File file = new File(savePath,fileName);  
	                        fileItem.write(file);
	                        request.setAttribute("msg", "�ϴ��ɹ���");  
	                    }  
	                    j++;
	                }
	                
	                Housebiz addimg = new Housebiz();
	                house.setHouse_img1(a[0]);
	                house.setHouse_img2(a[1]);
	                house.setHouse_img3(a[2]);
	                
	                addimg.addhouseimg(house,Id);
	                
	            }  
	        }catch(FileSizeLimitExceededException e){  
	            request.setAttribute("msg", "�ļ�̫��");  
	        }catch(FileUploadException e){  
	            e.printStackTrace();  
	        }catch(Exception e){  
	            e.printStackTrace();  
	        }  
	        //�ϴ���Ϻ�  ת������ҳ  
	        request.getRequestDispatcher("/success.jsp").forward(request, response);
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
