package client;

import java.util.Date;
public class BMI {
    private Date date;
    private float weight;
    private float height;
    //gender
	public BMI(Date date, float weight, float height) {
		super();
		this.date = date;
		this.weight = weight;
		this.height = height;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
    
    
}
