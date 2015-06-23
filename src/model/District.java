package model;

public class District {
	private int dist_id;
	private String dist_name;
	public int getDist_id() {
		return dist_id;
	}
	public void setDist_id(int dist_id) {
		this.dist_id = dist_id;
	}
	public String getDist_name() {
		return dist_name;
	}
	public void setDist_name(String dist_name) {
		this.dist_name = dist_name;
	}
	@Override
	public String toString() {
		return "District [dist_id=" + dist_id + ", dist_name=" + dist_name
				+ "]";
	}
	
}
