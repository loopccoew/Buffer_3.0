import java.util.ArrayList;

public class Receiver {

	//add matched donor name
	private String ReceiverName;
	private String ReceiverBloodGroup;
	private String birthDate;
	private char gender;
	private float weight;
	private Area areaOfReceiver;
	private long contactNum;
	private int Emergency;
	private boolean approvedReceiver;
	private String Organ;
	private String enrolled_hosp;
	private int hosp_code;
	private String allotmentStatus;
	private String donarAlloted;
	long donorphno;
	
	public Receiver(String receiverName, String receiverBloodGroup, String birthDate, char gender, float weight,
			String hosp, long contactNum, int emergency,String Org) {
		super();
		ReceiverName = receiverName;
		ReceiverBloodGroup = receiverBloodGroup;
		this.birthDate = birthDate;
		this.gender = gender;
		this.weight = weight;
		this.enrolled_hosp = hosp;
		this.contactNum = contactNum;
		Emergency = emergency;
		this.Organ = Org;
		//this.allotmentStatus="not alloted";
		
	}
	public Receiver() {
		
	}
	public String getorganName() {
		return Organ;
	}
	public void setorganName(String organName) {
		this.Organ = organName;
	}
	public void sethospital(String name) {
		this.enrolled_hosp= name;
	}
	public void sethospitalcode(int code) {
		this.hosp_code= code;
	}
	public int gethospitalcode() {
		return this.hosp_code;
	}
	public String gethospitalName() {
		return enrolled_hosp;
	}
	public String getReceiverName() {
		return ReceiverName;
	}
	
	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}
	public String getReceiverBloodGroup() {
		return ReceiverBloodGroup;
	}
	public void setReceiverBloodGroup(String receiverBloodGroup) {
		ReceiverBloodGroup = receiverBloodGroup;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public Area getAreaOfReceiver() {
		return areaOfReceiver;
	}
	public void setAreaOfReceiver(Area areaOfReceiver) {
		this.areaOfReceiver = areaOfReceiver;
	}
	public long getContactNum() {
		return contactNum;
	}
	public void setContactNum(long contactNum) {
		this.contactNum = contactNum;
	}
	public int getEmergency() {
		return Emergency;
	}
	public void setEmergency(int emergency) {
		Emergency = emergency;
	}
	public boolean isApprovedReceiver() {
		return approvedReceiver;
	}
	public void setApprovedReceiver(boolean approvedReceiver) {
		this.approvedReceiver = approvedReceiver;
	}
	public String getAllotmentStatus() {
		return allotmentStatus;
	}
	public void setAllotmentStatus(String allotmentStatus) {
		this.allotmentStatus = allotmentStatus;
	}
	public String getDonarAlloted() {
		return donarAlloted;
	}
	public void setDonarAlloted(String donarAlloted) {
		this.donarAlloted = donarAlloted;
	}
	


}