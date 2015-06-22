package model;

public class VdcList {
	private int vdcid;
	private String firstName;
	private int distid;
	
	public int getVdcid() {
		return vdcid;
	}
	public void setVdcid(int vdcid) {
		this.vdcid = vdcid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getDistid() {
		return distid;
	}
	public void setDistid(int distid) {
		this.distid = distid;
	}
	@Override
	public String toString() {
		return "VdcList [vdcid=" + vdcid + ", firstName=" + firstName
				+ ", distid=" + distid + "]";
	}
	
	
}
