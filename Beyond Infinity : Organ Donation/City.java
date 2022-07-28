import java.util.*;
public class City {
	private String cityname;
	private int cityCode;
	ArrayList<Area> lst;
	public City(String cityname, int cityCode) {

		this.cityname = cityname;
		this.cityCode = cityCode;
		lst = new ArrayList<>();
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

}
