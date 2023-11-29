package servlet;
/********************
 *@author created by matou
 *@date  2019��6��12��---����8:33:28
 *@IDE	eclipse
 *@jdk	1.8.0_161
 *********************/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.sun.javafx.binding.StringFormatter;

import javabean.db_conn;
public class upload_file extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//GET��ʽ�ύ�����ݻ������ǷǷ����������ô�����ֱ�ӷ���edit_infoҳ��Ϳ���
		resp.sendRedirect("/plane_ticket_book/index/edit_info.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//ָ���ļ����λ��
		String filePath = "index/upload";//�����б�ܱ�ʾ��Ŀ��Ŀ¼
		//�����ļ��ж���δ���������ļ��У�
		File file = new File(filePath);
		//���ָ��·���ļ��в����ھʹ���һ���ļ���
		if(!file.exists()) {
			file.mkdirs();
			/*file.createNewFile();//������ļ����󴴽�ʱ����Ҫ����file��*/     
		}
		//����SmartUpload����
		SmartUpload su = new SmartUpload();
		com.jspsmart.upload.Request r= su.getRequest();

		HttpSession session=request.getSession();
		//��ʼ��SmartUpload����
		su.initialize(getServletConfig(),request,response);
		//�����ϴ��ļ������ֵ
		su.setMaxFileSize(1024*1024*10);
		//�����ϴ��ļ��������ֵ
		su.setTotalMaxFileSize(1024*1024*100);
		//���������ϴ��ļ�����
		su.setAllowedFilesList("jpg,gif,jpeg,png");
		String filename = UUID.randomUUID().toString();
		try {
			//���ò������ϴ����ļ�����
			//su.setDeniedFilesList("rar,txt,mp4,mp3,zip");
			//�ϴ�
			su.upload();
			Files files = su.getFiles(); 
			com.jspsmart.upload.File file1;

			for(int i=0;i<files.getCount();i++ ) {
				file1 = files.getFile(i);

				//�����ϴ��������ļ��������ļ��������������Լ�д��һ��������UniqueId����Ψһid��ΪͼƬ��id�ļ���
				file1.saveAs("index/upload/"+filename+"."+file1.getFileExt());
				filename = filename+"."+file1.getFileExt();
				//�����ļ���ָ��·���������ϴ��˶��ٸ��ļ�
				//int n = su.save(filePath);
				//System.out.println("�ϴ���"+n+"���ļ�");
				System.out.println(file1.getFieldName());//������nameֵ
				System.out.println(file1.getFileName());//�ļ���
				System.out.println(file1.getSize());//�ļ���С
				System.out.println(file1.getFilePathName());//�ļ�ԭʼ·�����ļ���
				System.out.println(file1.getFileExt());//�ļ�����
				System.out.println("___________________________________");
				System.out.println("___________________________________");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ϴ�ʧ�ܣ�");
			System.out.println(e.getMessage());
		}
		String city = r.getParameter("city");
		String sfz = r.getParameter("sfz");
		String phone = r.getParameter("phone");
		String email = r.getParameter("email");
		String qq = r.getParameter("qq");
		db_conn conn= new db_conn();
		String sql_re = "";
		System.out.println(filename.length());
		if(!filename.endsWith(".")) {
			sql_re = "avatar_img='"+filename+"',";
		}else {
			sql_re = "";
		}

		String sql="update common_user set "+sql_re+" city='"+city+"', "+" sfz='"+sfz+"', "+" phone='"+phone+"', "+" email='"+email+"', "+" qq='"+qq+"' "
				+ "where user_name='"+session.getAttribute("user_id")+"'";
		int res=conn.Update(sql);
 		session.setAttribute("city", city);
		session.setAttribute("sfz", sfz);
		session.setAttribute("phone", phone);
		session.setAttribute("email", email);
		session.setAttribute("qq", qq);
		//System.out.println(res);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		if(res!=0) {
			response.sendRedirect("/plane_ticket_book/index/user_info.jsp");
		}else {

			out.println("�ļ��ϴ�ʧ�ܣ��������bug������ϵ������Ա�޸�bug");
			response.setHeader("refresh", "2;url=/plane_ticket_book/index/user_info.jsp");
		}


	}

}

