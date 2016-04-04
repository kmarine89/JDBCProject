package kr.co.witlab.test.biz.light;

public class LightVO {

	// table의 컬럼과 동일하게
	private String time;
	private double lux;
	private double cct;
	private double x;
	private double y;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getLux() {
		return lux;
	}
	public void setLux(double lux) {
		this.lux = lux;
	}
	public double getCct() {
		return cct;
	}
	public void setCct(double cct) {
		this.cct = cct;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "LightVO [time=" + time + ", lux=" + lux + ", cct=" + cct + ", x=" + x + ", y=" + y + "]";
	}
	
}
