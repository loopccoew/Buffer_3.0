package client;

public class DietPlan {
  private String age;
  private String weight;
  
  public DietPlan(String age,String weight) {
	  this.age=age;
	  this.weight=weight;
  }
  
  public String getAge() {
	  return age;
  }
  public String getWeight() {
	  return weight;
  }
  @Override
  public String toString() {
	  return"age=" + age +"Weight:" +weight;
  }
}
