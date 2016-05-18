package profiles;

public class ClassInfo {
	
	private String myClassName;
	private String myClassTeacher;
	private String myClassDays;
	private String myClassTime;
	private String myClassRoom;
	
	public ClassInfo() {
	}
	
	public ClassInfo(String myClassName, String myClassDays, String myClassTime, String myClassRoom) {
		super();
		this.myClassName = myClassName;
		this.myClassDays = myClassDays;
		this.myClassTime = myClassTime;
		this.myClassRoom = myClassRoom;
	}

	public String getMyClassName() {
		return myClassName;
	}

	public void setMyClassName(String myClassName) {
		this.myClassName = myClassName;
	}

	public String getMyClassDays() {
		return myClassDays;
	}

	public void setMyClassDays(String myClassDays) {
		this.myClassDays = myClassDays;
	}

	public String getMyClassTime() {
		return myClassTime;
	}

	public void setMyClassTime(String myClassTime) {
		this.myClassTime = myClassTime;
	}

	public String getMyClassRoom() {
		return myClassRoom;
	}

	public void setMyClassRoom(String myClassRoom) {
		this.myClassRoom = myClassRoom;
	}

	public String getMyClassTeacher() {
		return myClassTeacher;
	}

	public void setMyClassTeacher(String myClassTeacher) {
		this.myClassTeacher = myClassTeacher;
	}
	
	

}
