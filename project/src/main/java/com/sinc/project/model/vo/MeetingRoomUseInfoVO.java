package com.sinc.project.model.vo;

public class MeetingRoomUseInfoVO {

	private int		sensorcode, floor;
	private String 	name, useyn;
	
	public MeetingRoomUseInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MeetingRoomUseInfoVO(int sensorcode, int floor, String name, String useyn) {
		super();
		this.sensorcode = sensorcode;
		this.floor = floor;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUseyn() {
		return useyn;
	}

	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}

	@Override
	public String toString() {
		return "MeetingRoomUseInfoVO [sensorcode=" + sensorcode + ", floor=" + floor + ", name=" + name + ", useyn="
				+ useyn + "]";
	}
	
}
