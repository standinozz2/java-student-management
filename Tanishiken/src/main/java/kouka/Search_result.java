package kouka;

import java.io.IOException;
import java.util.List;

import bean.StudentList;
import dao.StudentListDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/kouka/search_result")
public class Search_result extends HttpServlet {

   
    public void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {

        try {

            //  リクエストパラメータ「name」を取得
            String stuname = request.getParameter("name");
            
            

            //  StudentListDAOを生成
            StudentListDAO dao = new StudentListDAO();

            //  名前と合っている学生の情報を取得
            List<StudentList> list = dao.search(stuname);

            request.setAttribute("studentList", list);
            

        } catch (Exception e) {

            // 6 例外発生時はスタックトレース出力
            e.printStackTrace();
        }

        // 学生の情報を表す画面（search-result.jsp）へフォワード
        request.getRequestDispatcher("search-result.jsp")
               .forward(request, response);
    }
}