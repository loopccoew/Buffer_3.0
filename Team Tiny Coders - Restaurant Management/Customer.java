public class Customer {
	 String name;
	 int no;
	 Customer(){
		 
	 }
	Customer(String name,int no){
		this.name=name;
		this.no=no;
	}
	public String getname() {
	    return name;
	}
	public void setname(String name) {
	    this.name = name;
	}
	public int getcustno() {
	    return no;
	}
	public void setcustno(int no) {
	    this.no = no;
	}
	@Override
	public String toString(){
	return "\n Customer Name   :"+name+" \n Number of Customers   :"+no+"\n";}
}