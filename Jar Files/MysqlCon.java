import java.sql.*;

class MysqlCon{
	public static void main(String args[]){
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2","root","");
			Statement stmt = con.createStatement();
			//ResultSet rs = stmt.executeQuery("select * from user");
			String name = "Rakib";
			String age = "30";
			int id		= 2;
			String sql = "INSERT INTO `user`(`id`, `name`, `age`) VALUES ("+id+",'"+name+"',"+"'"+age+"')";
			
			
			
			int a = stmt.executeUpdate(sql);
			System.out.println(a);
			/* while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			} */
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}