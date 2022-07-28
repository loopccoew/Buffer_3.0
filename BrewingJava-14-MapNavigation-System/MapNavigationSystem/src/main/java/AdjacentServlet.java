

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdjacentServlet
 */
public class AdjacentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdjacentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		PrintWriter out = response.getWriter();
		String s = request.getParameter("source");
		MapClass mg = new MapClass();
	    MapGraph g = mg.MD();
	    
	    
	    
	    out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Adjacent Cities</title>");   
        out.println("<link rel='stylesheet' href='adj.css'>");
        out.println("</head>");
        out.println("<body>");
        
	    out.println("<h2>All adjacent cities from "+s+" are : </h2>");
		ArrayList<String> arr = g.displayAllAdj(s);
		out.println("<ol>");
		for(String i:arr) {
			//out.println("<br>");
			out.println("<li><h4>"+i+"</h4></li>");
			
		}
		out.println("</ol>");
		
		 out.println("</body>");
         out.println("</html>");

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	
	
	}

}
