package kouka;

import java.io.IOException;

import bean.StudentList;
import dao.StudentListDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/kouka/Update_complete"})
public class Update_complete extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // パラメータ取得
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            String name = request.getParameter("name");
            int courseId = Integer.parseInt(request.getParameter("courseid"));

            // StudentListオブジェクト生成
            StudentList student = new StudentList();
            student.setId(studentId);
            student.setName(name);
            student.setCourseid(courseId);

            // DAOで更新
            StudentListDAO dao = new StudentListDAO();
            dao.update(student);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 更新完了ページへ
        request.getRequestDispatcher("update-complete.jsp")
               .forward(request, response);
    }
}
