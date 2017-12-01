package me.elvis.common.design.creation.builder;

/**
 * Version:v1.0 (description:  ) Date:2017/11/30 0030  Time:22:55
 */
public class Director {

	public Product constructProduct(ConcreteBuilder builder) {
		builder.buildBasic();
		builder.buildWall();
		builder.buildRoof();
		return builder.buildProduct();
	}

	public static void main(String[] args) {
		ConcreteBuilder concreteBuilder = new ConcreteBuilder();
		System.out.println(new Director().constructProduct(concreteBuilder));
	}
}
