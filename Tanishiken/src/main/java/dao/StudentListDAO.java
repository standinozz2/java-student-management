package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.StudentList;

public class StudentListDAO extends DAO {
	public List<StudentList> showSummary() throws Exception {

        // 1 学生一覧を格納するリスト生成
        List<StudentList> list = new ArrayList<>();

        // 2 DB接続取得
        Connection con = getConnection();

        // 3 全件取得SQLを準備
        PreparedStatement st =
            con.prepareStatement("select * from Student");

        // 4 SQL実行
        ResultSet rs = st.executeQuery();

        // 5 取得データを1件ずつ処理
        while (rs.next()) {

            StudentList stu = new StudentList();
            stu.setId(rs.getInt("STUDENT_ID"));
            stu.setName(rs.getString("STUDENT_NAME"));
            stu.setCourseid(rs.getInt("COURSE_ID"));

            list.add(stu);
        }

        // 6 リソース解放
        st.close();
        con.close();
        
        // 7 一覧を返却
        return list;
    }
	public List<StudentList> search(String name) throws Exception {

	    // 1 データベース接続を取得
	    Connection con = getConnection();

	    // 2 search文を準備
	    PreparedStatement st = con.prepareStatement(
	        "SELECT * FROM STUDENT WHERE STUDENT_NAME LIKE ?"
	    );

	    // 3 プレースホルダへ値を設定
	    st.setString(1, "%" + name + "%");

	    // 4 SQL実行
	    ResultSet rs = st.executeQuery();

	    // Listを作る
	    List<StudentList> list = new ArrayList<>();

	    // 複数データを格納
	    while (rs.next()) {
	        StudentList stu = new StudentList();
	        stu.setId(rs.getInt("STUDENT_ID"));
	        stu.setName(rs.getString("STUDENT_NAME"));
	        stu.setCourseid(rs.getInt("COURSE_ID"));

	        list.add(stu);   
	    }

	    // 5 リソースをクローズ
	    rs.close();
	    st.close();
	    con.close();

	    // 6 Listを返却
	    return list;
	}
	public int insert(StudentList student) throws Exception {

        // 1 データベース接続を取得
        Connection con = getConnection();

        // 2 INSERT文を準備
        PreparedStatement st = con.prepareStatement(
            "insert into student(STUDENT_ID,STUDENT_NAME, COURSE_ID) values( ?, ?, ?)");

        // 3 プレースホルダへ値を設定
        st.setInt(1, student.getId());
        st.setString(2, student.getName());
        st.setInt(3, student.getCourseid());

        // 4 SQL実行（INSERTなのでexecuteUpdate）
        int line = st.executeUpdate();

        // 5 リソースをクローズ
        st.close();
        con.close();

        // 6 追加された行数を返却
        return line;
    }
	public int delete(StudentList student) throws Exception {
		 // 1 データベース接続を取得
		Connection con = getConnection();
		// 2 delete文を準備
		PreparedStatement st = con.prepareStatement(
			    "delete from student where STUDENT_ID = ?"
			);
			st.setInt(1, student.getId());
		// 3 プレースホルダへ値を設定
		
		
		// 4 SQL実行（deleteなのでexecuteUpdate）
		int line = st.executeUpdate();
		
		// 5 リソースをクローズ
		st.close();
		con.close();
		// 6 追加された行数を返却
		return line;
		
	}
	public int update(StudentList student) throws Exception {

	    Connection con = getConnection();

	    PreparedStatement st = con.prepareStatement(
	        "UPDATE STUDENT SET STUDENT_NAME = ?, COURSE_ID = ? WHERE STUDENT_ID = ?"
	    );

	    st.setString(1, student.getName());
	    st.setInt(2, student.getCourseid());
	    st.setInt(3, student.getId());

	    int line = st.executeUpdate();

	    st.close();
	    con.close();

	    return line;
	}
}