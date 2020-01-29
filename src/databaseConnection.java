import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class databaseConnection {

	 private Connection connect() 
	 	{
		 	String url = "jdbc:sqlite:DB/PortExportData.db";
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	 
	 public int[][] selectAll()
	 	{
		 	int intArray[][] = new int[100000][13];
		 	int i = 0; 
		 	String sql = "SELECT ID, Year, Month, Day, "
		 			+ "Pacific_Northwest_Wheat, Pacific_Northwest_Corn, Pacific_Northwest_Soybeans, "
		 			+ "Mississippi_Gulf_Wheat, Mississippi_Gulf_Corn, Mississippi_Gulf_Soybeans, "
		 			+ "Texas_Gulf_Wheat, Texas_Gulf_Corn, Texas_Gulf_Soybeans FROM PortExportList";
	        try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql))
	        {
	        	while (rs.next()) 
	        	{
	        		intArray[i][0] = rs.getInt("ID");
	        		intArray[i][1] = rs.getInt("Year");
	        		intArray[i][2] = rs.getInt("Month");
	        		intArray[i][3] = rs.getInt("Day");
	        		intArray[i][4] = rs.getInt("Pacific_Northwest_Wheat");
	        		intArray[i][5] = rs.getInt("Pacific_Northwest_Corn");
	        		intArray[i][6] = rs.getInt("Pacific_Northwest_Soybeans");
	        		intArray[i][7] = rs.getInt("Mississippi_Gulf_Wheat");
	        		intArray[i][8] = rs.getInt("Mississippi_Gulf_Corn");
	        		intArray[i][9] = rs.getInt("Mississippi_Gulf_Soybeans");
	        		intArray[i][10] = rs.getInt("Texas_Gulf_Wheat");
	        		intArray[i][11] = rs.getInt("Texas_Gulf_Corn");
	        		intArray[i][12] = rs.getInt("Texas_Gulf_Soybeans");
	        		i++;
	            }
	        } 
	        catch (SQLException e) 
	        {
	            System.out.println(e.getMessage());
	        }
	        return intArray;
	    }
	 
	 public int[][] selectYearly()
	 	{
		 	int intArray[][] = new int[100000][10];
		 	int i = 0; 
		 	String sql = "SELECT Year, "
		 			+ "Pacific_Northwest_Wheat, Pacific_Northwest_Corn, Pacific_Northwest_Soybeans, "
		 			+ "Mississippi_Gulf_Wheat, Mississippi_Gulf_Corn, Mississippi_Gulf_Soybeans, "
		 			+ "Texas_Gulf_Wheat, Texas_Gulf_Corn, Texas_Gulf_Soybeans FROM PortExportList";
	        try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql))
	        {
	        	while (rs.next()) 
	        	{
	        		intArray[i][0] = rs.getInt("Year");
	        		intArray[i][1] = rs.getInt("Pacific_Northwest_Wheat");
	        		intArray[i][2] = rs.getInt("Pacific_Northwest_Corn");
	        		intArray[i][3] = rs.getInt("Pacific_Northwest_Soybeans");
	        		intArray[i][4] = rs.getInt("Mississippi_Gulf_Wheat");
	        		intArray[i][5] = rs.getInt("Mississippi_Gulf_Corn");
	        		intArray[i][6] = rs.getInt("Mississippi_Gulf_Soybeans");
	        		intArray[i][7] = rs.getInt("Texas_Gulf_Wheat");
	        		intArray[i][8] = rs.getInt("Texas_Gulf_Corn");
	        		intArray[i][9] = rs.getInt("Texas_Gulf_Soybeans");
	        		i++;
	            }
	        } 
	        catch (SQLException e) 
	        {
	            System.out.println(e.getMessage());
	        }
	        return intArray;
	    }
	 
	 public int[][] selectMonthly()
	 	{
		 	int intArray[][] = new int[100000][11];
		 	int i = 0; 
		 	String sql = "SELECT Year, Month, "
		 			+ "Pacific_Northwest_Wheat, Pacific_Northwest_Corn, Pacific_Northwest_Soybeans, "
		 			+ "Mississippi_Gulf_Wheat, Mississippi_Gulf_Corn, Mississippi_Gulf_Soybeans, "
		 			+ "Texas_Gulf_Wheat, Texas_Gulf_Corn, Texas_Gulf_Soybeans FROM PortExportList";
	        try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql))
	        {
	        	while (rs.next()) 
	        	{
	        		intArray[i][0] = rs.getInt("Year");
	        		intArray[i][1] = rs.getInt("Month");
	        		intArray[i][2] = rs.getInt("Pacific_Northwest_Wheat");
	        		intArray[i][3] = rs.getInt("Pacific_Northwest_Corn");
	        		intArray[i][4] = rs.getInt("Pacific_Northwest_Soybeans");
	        		intArray[i][5] = rs.getInt("Mississippi_Gulf_Wheat");
	        		intArray[i][6] = rs.getInt("Mississippi_Gulf_Corn");
	        		intArray[i][7] = rs.getInt("Mississippi_Gulf_Soybeans");
	        		intArray[i][8] = rs.getInt("Texas_Gulf_Wheat");
	        		intArray[i][9] = rs.getInt("Texas_Gulf_Corn");
	        		intArray[i][10] = rs.getInt("Texas_Gulf_Soybeans");
	        		i++;
	            }
	        } 
	        catch (SQLException e) 
	        {
	            System.out.println(e.getMessage());
	        }
	        return intArray;
	    }
}
