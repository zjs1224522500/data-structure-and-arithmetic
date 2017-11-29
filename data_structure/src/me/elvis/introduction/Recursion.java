package me.elvis.introduction;

/**
 * Version:v1.0 (description: 递归 )
 */
public class Recursion {

	public static void main(String[] args){
	    printOutSingleNumber(76234);
	}

	/**
	 * 输出单个数字（获取一个整数对应的每一位）
	 *
	 * @param n 参数
	 */
	public static void printOutSingleNumber(int n) {
		if (n >= 10) {
			printOutSingleNumber(n / 10);
		}
		System.out.println(n % 10);
	}


}
