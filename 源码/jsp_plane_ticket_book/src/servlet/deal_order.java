package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.db_conn;

/********************
 *@author created by matou
 *@date  2019年6月14日---下午8:57:39
 *@IDE	eclipse
 *@jdk	1.8.0_161
 *********************/
public class deal_order extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		if(session.getAttribute("user_id")!=null) {
			String user_id=session.getAttribute("user_id").toString();
			String f_i=req.getParameter("flight_id");
			String passenger_name=req.getParameter("passenger_name");
			String date=req.getParameter("date");
			String grade=req.getParameter("grade");
			String passenger_id=req.getParameter("passenger_id");
			String contact=req.getParameter("contact");
			String contact_phone=req.getParameter("contact_phone");


			/*
			 * System.out.println(f_i); System.out.println(passenger_name);
			 * System.out.println(date); System.out.println(grade);
			 * System.out.println(passenger_id); System.out.println(contact);
			 * System.out.println(contact_phone);
			 */

			if(f_i!=""&&passenger_name!=""&&date!=""&&grade!=""&&passenger_id!=""&&contact!=""&&contact_phone!="") {
				db_conn conn=new db_conn();
				String sql="insert into t_order (f_n,order_user,p_name,date,grade,p_id,contact,c_p,status) values('"+f_i+"','"+user_id+"','"+passenger_name+"','"+date+"','"+grade+"','"+passenger_id+"','"+contact+"','"+contact_phone+"',0)";
				Integer res=conn.executeInsert(sql);
				System.out.println(res);
				if(res.equals(1)) {
					resp.sendRedirect("default/order_list.jsp");
				}else {
					resp.sendRedirect("default/order.jsp");
				}

			}else {
				resp.sendRedirect("default/order.jsp");
			}

		}else {
			resp.sendRedirect("default/order.jsp");
		}	

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(req.getParameter("id"));
		int flag = 0;
		try {
			flag=Integer.parseInt(req.getParameter("flag"));
		} catch (NumberFormatException e1) {
			flag = 0;
		}
		int status=0;
		try {
			status = Integer.parseInt(req.getParameter("status"));
		} catch (NumberFormatException e) {
			status = 0;
		}

		db_conn conn= new db_conn();
		String sql="update t_order set status="+status+" "
				+ "where id="+id;
		int res=conn.Update(sql);
		if(flag == 1) {
			resp.sendRedirect("admin/order_list.jsp");
		}else {
			resp.sendRedirect("default/order_list.jsp");
		}
		



	}
}
