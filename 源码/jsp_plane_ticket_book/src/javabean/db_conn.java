package javabean;
/********************
*@author created by matou
*@date  2020��1��8��---����6:31:28
*@IDE	eclipse
*@jdk	1.8.0_161
*********************/
import java.sql.*;

public class db_conn {
	public Connection conn = null;
	public ResultSet res = null;
	public Statement st = null;
	
 	public  db_conn() {
		String URL="jdbc:mysql://www.icodedock.com:3306/plane_ticket_book?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8";
		String USER="plane_ticket_book";
		String PWD="plane_ticket_book";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}try{
			conn = DriverManager.getConnection(URL,USER,PWD);
			st=conn.createStatement();
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	
 	public int executeInsert(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			e.printStackTrace();
 		}
		return num;
	}
	
	public ResultSet executeQuery(String sql){
		res=null;
		try{
			res=st.executeQuery(sql);
		}
		catch(SQLException e){e.printStackTrace();
 		}
		return res;
	}
	
	public int Update(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return num;
	}
	
	public int executeDelete(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return num;
	}
	
	public void closeDB(){
		try{
			st.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
