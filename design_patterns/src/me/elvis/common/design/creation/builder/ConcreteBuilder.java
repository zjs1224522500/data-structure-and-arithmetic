package me.elvis.common.design.creation.builder;

/**
 * Version:v1.0 (description:  ) Date:2017/11/30 0030  Time:22:53
 */
public class ConcreteBuilder implements Builder {

	private Product product;

	public ConcreteBuilder() {
		product = new Product();
	}

	@Override
	public void buildBasic() {
		product.setBasic("打好基础");
	}

	@Override
	public void buildWall() {
		product.setWall("堆砌围墙");
	}

	@Override
	public void buildRoof() {
		product.setRoof("封顶大吉");
	}

	@Override
	public Product buildProduct() {
		return product;
	}
}
