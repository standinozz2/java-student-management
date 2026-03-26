package bean;

public class StudentList implements java.io.Serializable {

	private int id;
	private String name;
	private int courseid;

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getCourseid() {
		return courseid;
	}

	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setCourseid(int courseid) {
		this.courseid=courseid;
	}
	
}
