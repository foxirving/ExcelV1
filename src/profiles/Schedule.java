package profiles;

public class Schedule implements ISchedule{

	private String myQuarter;
	private String myCampus;
	
	private int myScheduleRowSize;
	private int myScheduleColumnSize;
	private int[][] mySchedule;
	
	public Schedule() {
	}
	
	public String getMyQuarter() {
		return myQuarter;
	}

	public void setMyQuarter(String myQuarter) {
		this.myQuarter = myQuarter;
	}

	public String getMyCampus() {
		return myCampus;
	}

	public void setMyCampus(String myCampus) {
		this.myCampus = myCampus;
	}

	public int getMyScheduleRowSize() {
		return myScheduleRowSize;
	}

	public void setMyScheduleRowSize(int myScheduleRowSize) {
		this.myScheduleRowSize = myScheduleRowSize;
	}

	public int getMyScheduleColumnSize() {
		return myScheduleColumnSize;
	}

	public void setMyScheduleColumnSize(int myScheduleColumnSize) {
		this.myScheduleColumnSize = myScheduleColumnSize;
	}

	public int[][] getMySchedule() {
		return mySchedule;
	}

	public void setMySchedule(int[][] mySchedule) {
		this.mySchedule = mySchedule;
	}
	
	
}
