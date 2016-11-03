package visitors;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String operation = request.getParameter("operation");
		// visit visitorObject
		visiterClass visitorObject = new visiterClass();
		if (operation.equals("add")) {
			String Name = request.getParameter("Name");
			String Address = request.getParameter("Address");
			String mobileNumber = request.getParameter("mobileNumber");
			String EmailId = request.getParameter("EmailId");
			String Purpose = request.getParameter("Purpose");

			JSONObject result;
			try {
				result = visitorObject.Addvisitors(Name, Address, mobileNumber, EmailId, Purpose);
				response.getWriter().print(result);

			} catch (JSONException e) {

				e.printStackTrace();
			}

		} else if (operation.equals("getAllvisitors")) {
			JSONArray result = null;
			try {
				result = visitorObject.getAllVisitors();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(result);
		}
	}

	



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
