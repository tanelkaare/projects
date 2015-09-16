package ee.tanker.tvkava;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ee.tanker.tvkava.KavaReader;

/**
 * Servlet implementation class KavaDisplay
 */
@WebServlet("/KavaDisplay")
public class KavaDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public KavaDisplay() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KavaReader kReader = new KavaReader();
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		kReader.collectElements("a", "b");
		out.println("<h1>testikas</h1><br>");
		out.println(kReader.test + "<br>");
		out.println("<table>");
		for (int i=0; i < kReader.kavaElement.length; i++){
			if (kReader.kavaElement[i] != null){
				out.println("<tr>");
				out.println("<td>" + kReader.kavaElement[i].time + "</td>");
				out.println("<td>" + kReader.kavaElement[i].titleEst + "</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
