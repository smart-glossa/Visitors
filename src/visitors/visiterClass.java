package visitors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class visiterClass {

	public JSONObject Addvisitors(String Name, String Address, String mobileNumber, String EmailId, String Purpose)
			throws JSONException {
		JSONObject result = new JSONObject();

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/visitors", "root", "root");
			Statement statement = connection.createStatement();
			String query = "insert into visitor(Name,Address,mobileNumber,EmailId,Purpose) values('" + Name + "','"+ Address + "','" + mobileNumber + "','" + EmailId + "','" + Purpose + "')";
			statement.execute(query);
			result.put("status", "1");

		} catch (Exception e) {
			JSONObject error = new JSONObject();
			error.put("Status", "0");
			error.put("Message", e.getMessage());

		}

		return result;
	}

	public JSONArray getAllVisitors() throws JSONException {
		JSONArray result = new JSONArray();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/visitors", "root", "root");
			Statement statement = connection.createStatement();

			String query = "select * from visitor";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {

				JSONObject visitor = new JSONObject();
				visitor.put("Name", rs.getString("Name"));
				visitor.put("Address", rs.getString("Address"));
				visitor.put("mobileNumber", rs.getString("mobileNumber"));
				visitor.put("EmailId", rs.getString("EmailId"));
				visitor.put("Purpose", rs.getString("Purpose"));
				result.put(visitor);

			}
		} catch (Exception e) {

			JSONObject error = new JSONObject();
			error.put("Status", "0");
			error.put("Message", e.getMessage());

		}
		return result;
	}
}

