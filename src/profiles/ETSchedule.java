package profiles;

public class ETSchedule implements ISchedule{

	
	private int myPriorityLevel;
	private Schedule mySchedule;
	
	public ETSchedule() {
	}

	public ETSchedule(int myPriorityLevel) {
		super();
		this.myPriorityLevel = myPriorityLevel;
	}

	public int getMyPriorityLevel() {
		return myPriorityLevel;
	}

	public void setMyPriorityLevel(int myPriorityLevel) {
		this.myPriorityLevel = myPriorityLevel;
	}

	public boolean equals(Object obj) {
		return mySchedule.equals(obj);
	}

	public String getMyQuarter() {
		return mySchedule.getMyQuarter();
	}

	public void setMyQuarter(String myQuarter) {
		mySchedule.setMyQuarter(myQuarter);
	}

	public String getMyCampus() {
		return mySchedule.getMyCampus();
	}

	public void setMyCampus(String myCampus) {
		mySchedule.setMyCampus(myCampus);
	}

	public int getMyScheduleRowSize() {
		return mySchedule.getMyScheduleRowSize();
	}

	public int getMyScheduleColumnSize() {
		return mySchedule.getMyScheduleColumnSize();
	}

	public int[][] getMySchedule() {
		return mySchedule.getMySchedule();
	}

	public int hashCode() {
		return mySchedule.hashCode();
	}

	public void setMyScheduleRowSize(int myScheduleRowSize) {
		mySchedule.setMyScheduleRowSize(myScheduleRowSize);
	}

	public void setMyScheduleColumnSize(int myScheduleColumnSize) {
		mySchedule.setMyScheduleColumnSize(myScheduleColumnSize);
	}

	public void setMySchedule(int[][] theSchedule) {
		mySchedule.setMySchedule(theSchedule);
	}

	public String toString() {
		return mySchedule.toString();
	}

	
	
}
