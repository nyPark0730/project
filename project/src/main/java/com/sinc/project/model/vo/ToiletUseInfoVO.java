package com.sinc.project.model.vo;

public class ToiletUseInfoVO {

	private int		sensorcode, floor, position;
	private String 	gender, useyn;
	
	public ToiletUseInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToiletUseInfoVO(int sensorcode, int floor, int position, String gender, String useyn) {
		super();
		this.sensorcode = sensorcode;
		this.floor = floor;
		this.position = position;
		this.gender = gender;
		this.useyn = useyn;
	}

	public int getSensorcode() {
		return sensorcode;
	}

	public void setSensorcode(int sensorcode) {
		this.sensorcode = sensorcode;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUseyn() {
		return useyn;
	}

	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}

	@Override
	public String toString() {
		return "ToiletUseInfoVO [sensorcode=" + sensorcode + ", floor=" + floor + ", position=" + position + ", gender="
				+ gender + ", useyn=" + useyn + "]";
	}
	
}
