


import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PathServlet
 */
public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public PathServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String s = request.getParameter("source");
		String d = request.getParameter("dest");
		MapClass mg = new MapClass();
		response.setContentType("text/html");
		// response.setContentType("image/jpeg");  
		
		
	    
	    MapGraph g = mg.MD();

        
		ArrayList<String> arr = g.shortestPath(s, d);
		
		
		 out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Shortest Path</title>");  

         out.println("<link rel='stylesheet' href='path.css'>");
         out.println("</head>");
         out.println("<body background-image='/map.jpg' >");
         out.println("<h2>Shortest Path between "+s+" and "+d+" : </h2>");
       
      out.println("<text class='text'>PATH : </text>");
       
         
       	
      
       	
     
     	for(int i=3;i<arr.size()-1;i++) {
       		out.print("<button type='button'>"+arr.get(i)+"</button>");
       		out.print("<text style=\"color:white; font-size:20px;\"><b>➜</b></text>");
       		//out.print("<h3 text-color=white;'>--></h3>");
       	}
     	
     	out.print("<button type='button'>"+arr.get(arr.size()-1)+"</button>");
     	
     out.println("<br><br><br>");
     	out.println("<table style=\"width:fit-content \"color: yellow; padding:20px;\" \"\r\n"
     			+ "  <tr>\r\n"
       			+ "    <th style = 'width:200px' >DISTANCE</th>\r\n"
       			+ "    <th style = 'width:200px'>"+arr.get(1)+"</th>\r\n"  
       			+ "  </tr>\r\n"
       			+ "  <tr>\r\n"
       			+ "    <th style = 'width:200px'>TIME</th>\r\n"
       			+ "    <th style = 'width:200px'>"+arr.get(2)+"</th>\r\n"
       			
       			+ "  </tr>\r\n"
       			+ "</table>\r\n"
       			+ "");
         out.println("</body>");
         out.println("</html>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}




