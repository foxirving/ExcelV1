package profiles;

import java.awt.Point;
import java.util.List;

public class SessionSchedule implements ISchedule{

	private int myPriorityLevel;
	private ClassInfo myClass;
	private List<Point> mySessionSchedule;
	
	public SessionSchedule(String theQuarter, String theCampus, int theScheduleRowSize, int theScheduleColumnSize,
			int[][] theSchedule, int thePriorityLevel, ClassInfo theClass) {
		super(theQuarter, theCampus, theScheduleRowSize, theScheduleColumnSize, theSchedule);
		this.myPriorityLevel = thePriorityLevel;
		this.myClass = theClass;	
	}

	public int getMyPriorityLevel() {
		return myPriorityLevel;
	}

	public void setMyPriorityLevel(int myPriorityLevel) {
		this.myPriorityLevel = myPriorityLevel;
	}

	public ClassInfo getMyClass() {
		return myClass;
	}

	public void setMyClass(ClassInfo myClass) {
		this.myClass = myClass;
	}
	
	

}
