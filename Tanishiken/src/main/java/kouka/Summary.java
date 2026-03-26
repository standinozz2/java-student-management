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


@WebServlet("/kouka/Summary")
public class Summary extends HttpServlet {

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
    	
        try {
        	
        	  // ① StudentListDAOを生成（データベース操作用クラス）
            StudentListDAO dao = new StudentListDAO();

            // ② studentテーブルから全件取得する
            List<StudentList> list = dao.showSummary();

            // ③ 取得した一覧データをrequestスコープに格納する
            //    → JSP側で ${list} として利用できる
            request.setAttribute("list", list);
            

           

        } catch (Exception e) {
            e.printStackTrace();
        }
       //summary.jspへフォワード
        request.getRequestDispatcher("summary.jsp")
               .forward(request, response);
    }
}