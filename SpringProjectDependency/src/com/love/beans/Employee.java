package com.love.beans;

public class Employee {
	private int eid;
	private String ename;
	private Profile profile;
	/**
	 * @return the eid
	 */
	public int getEid() {
		return eid;
	}
	/**
	 * @param eid the eid to set
	 */
	public void setEid(int eid) {
		this.eid = eid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return ename;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String ename) {
		this.ename = ename;
	}
	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public void show() {
		System.out.println(eid);
		System.out.println(ename);
		System.out.println(profile);

	}
	}
	
	
	


	

