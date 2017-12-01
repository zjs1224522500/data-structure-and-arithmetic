package me.elvis.common.design.creation.builder;

/**
 * Version:v1.0 (description:  ) Date:2017/11/30 0030  Time:22:47
 */
public class Product {

	private String basic;

	private String wall;

	private String roof;

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getWall() {
		return wall;
	}

	public void setWall(String wall) {
		this.wall = wall;
	}

	public String getRoof() {
		return roof;
	}

	public void setRoof(String roof) {
		this.roof = roof;
	}

	@Override
	public String toString() {
		return "Product{" + "basic='" + basic + '\'' + ", wall='" + wall + '\'' + ", roof='" + roof
				+ '\'' + '}';
	}
}
