package kouka;

import java.io.IOException;

import bean.StudentList;
import dao.StudentListDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns={"/kouka/register_complete"})
public class Register_complete extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
    	
    	//リクエストから stuid name courseid を取得
        int id = Integer.parseInt(request.getParameter("stuid"));
        String name = request.getParameter("name");
        int courseId = Integer.parseInt(request.getParameter("courseid"));
        //データベースを生成
        StudentList stu = new StudentList();
        stu.setId(id);
        stu.setName(name);
        stu.setCourseid(courseId);
        //StudentListDaoを生成
        StudentListDAO dao = new StudentListDAO();
        try {
            dao.insert(stu);//データベースにinsertする
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
        
        request.getRequestDispatcher("register-complete.jsp")
               .forward(request, response);
    }
}