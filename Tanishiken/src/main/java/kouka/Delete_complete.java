package kouka;

import java.io.IOException;

import bean.StudentList;
import dao.StudentListDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/kouka/delete_complete"})
public class Delete_complete extends HttpServlet {

    public  void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //学生の名前をファムから取得
    	int studentId = Integer.parseInt(request.getParameter("studentId"));
    	
        
        //データベースの生成
        StudentList student = new StudentList();
        student.setId(studentId); 
       
        
        // DAOを作成してデータベース操作
        StudentListDAO dao = new StudentListDAO();
        try {
        dao.delete(student); //名前で削除
        
        } catch  (Exception e) {
        	e.printStackTrace();
        }
        // 削除完了ページにフォワード（画面を移動
        request.getRequestDispatcher("delete-complete.jsp")
        .forward(request, response);
            
        }
}
