package profiles;

public interface ISchedule {

	public String getMyQuarter();

	public void setMyQuarter(String myQuarter);

	public String getMyCampus();

	public void setMyCampus(String myCampus);

	public int getMyScheduleRowSize();

	public void setMyScheduleRowSize(int myScheduleRowSize);

	public int getMyScheduleColumnSize();

	public void setMyScheduleColumnSize(int myScheduleColumnSize);

	public int[][] getMySchedule();

	public void setMySchedule(int[][] mySchedule);

}
