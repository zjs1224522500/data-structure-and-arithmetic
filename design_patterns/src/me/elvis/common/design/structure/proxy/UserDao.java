package me.elvis.common.design.structure.proxy;

/**
 * Version:v1.0 (description:  ) Date:2017/12/1 0001  Time:11:31
 */
public class UserDao implements IUserDao {

	public void save() {
		System.out.println("已经保存数据");
	}
}
