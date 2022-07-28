import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;
public class Hospital {
	private String hospitalName;
	private int citycode;
	private int areacode;
	private Area loc;
	private int hospitalcode;
	ArrayList <Receiver> all_receivers = new ArrayList<Receiver>(); 
	PriorityQueue<Receiver> pq;
	Hospital (int code ,String hospitalName,int a_code,int c_code){
		this.hospitalcode = code;
		this.hospitalName = hospitalName;
		this.areacode = a_code;
		this.citycode = c_code;
	}
	public Hospital(String hospitalName, Area loc) {
		super();
		this.hospitalName = hospitalName;
		this.loc = loc;
		this.pq = pq;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public int getHospitalCode() {
		return hospitalcode;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Area getLoc() {
		return loc;
	}
	public void setLoc(Area loc) {
		this.loc = loc;
	}
	public PriorityQueue<Receiver> getPq() {
		return pq;
	}
	public void setPq(PriorityQueue<Receiver> pq) {
		this.pq = pq;
	}
	
	 public PriorityQueue<Receiver> addToQueue(){
	        ListIterator<Receiver> ReceiverIterator = this.all_receivers.listIterator();
	        this.pq = new PriorityQueue<Receiver>(Collections.reverseOrder(new ReceiverComparator()));
	        // Traversing elements
	        while (ReceiverIterator.hasNext()) {
	            Receiver r = ReceiverIterator.next();
	            //System.out.println("Priority queue: "+r.getEmergency());
	            
	            pq.add(r);
	            
	        }
	         return this.pq;
	    }
 
	 
	class ReceiverComparator implements Comparator<Receiver>{
	           @Override
	            public int compare(Receiver s1, Receiver s2) {
	   
	                if (s1.getEmergency() > s2.getEmergency())
	                    return 1;
	                else 
	                    return -1;
	                                
	                }
	        	   
	        }
	}
	
