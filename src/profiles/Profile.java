package profiles;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Profile {

	private String myFirstName;
	private String myLastName;

	public Profile() {
	}
	
	public Profile(String myFirstName, String myLastName) {
		super();
		this.myFirstName = myFirstName;
		this.myLastName = myLastName;
	}

	public Profile(String myFirstName, String myLastName, Schedule mySchedule) {
		super();
		this.myFirstName = myFirstName;
		this.myLastName = myLastName;
	}

	public String getMyFirstName() {
		return myFirstName;
	}

	public void setMyFirstName(String myFirstName) {
		this.myFirstName = myFirstName;
	}

	public String getMyLastName() {
		return myLastName;
	}

	public void setMyLastName(String myLastName) {
		this.myLastName = myLastName;
	}

	@Override
	public String toString() {
		return "GeneralProfile: [ " + myFirstName + " " + myLastName + "]";
	}

}
