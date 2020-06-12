package com.leon.javase.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*字符串-全组合算法
 * 
 * 基本思路：求全组合，则假设原有元素n个，则最终组合结果是2^n-1个。原因是：
 * 用位操作方法：假设元素原本有：a,b,c三个，则1表示取该元素，0表示不取。故去a则是001，取ab则是011.
 * 所以一共三位，每个位上有两个选择0,1.所以是2^n个结果。
 * 这些结果的位图值都是0,1,2....2^n-1。所以可以类似全真表一样，从值0到值2^n-1依次输出结果：即：
 * 000,001,010,011,100,101,110,111 。对应输出组合结果为： 空,a, b ,ab,c,ac,bc,abc.
 * 这个输出顺序刚好跟数字0~2^n-1结果递增顺序一样 取法的二进制数其实就是从0到2^n-1的十进制数
 * 
 * @author leon
 *
 */
public class Combination {

	public static List<String> generate(String str) {
		// 校验参数
		if (str == null || str.length() == 0) {
			return new ArrayList<String>();
		}

		// 位图法生成组合
		List<String> resultList = new ArrayList<String>();
		int bitNum = 1 << (str.length());
		char[] strArray = str.toCharArray();
		StringBuilder temp = new StringBuilder();
		for (int i = 1; i < bitNum; i++) {
			// 判断位图上是否有该字符
			for (int j = 0; j < str.length(); j++) {
				if ((i & (1 << j)) > 0) {
					temp.append(strArray[j]);
				}
			}
			resultList.add(temp.toString());
			temp.delete(0, temp.length());
		}

		return resultList;
	}

	public static void main(String[] args) {

		String str = "abbc";
		List<String> resultList = Combination.generate(str);
		// 利用treeSet去重排序
		Set<String> resultSet = new TreeSet<String>(resultList);
		System.out.println("全组合结果个数为：" + resultSet.size());
		resultSet.forEach(System.out::println);
	}
}
