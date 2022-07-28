public class Dish {
	public int price,a;
	public String dish;
	Dish(int price,String dish){
		this.price=price;
		this.dish=dish;
	}
	void display(){
	System.out.println("	"+dish+"	"+price); 
	}
	@Override
	public String toString(){
		return "\n"+dish+" "+price;
}

}
