package com.leon.javase.string;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 字符串重排列 思路：找全排列类似于深度优先遍历，深度优先最关键的就是要记住上一个状态，而所谓回溯就是要回到上一没有操作过的状态，再去考虑别的情况。
 * 我们的想法是每次都把一个数固定在前面，让后面的数递归地进行全排列，这样每个数都固定过以后就能找出所有排列。
 * 关键的地方在于，我们把每个数固定在前面并让后面的进行全排列完毕以后，要恢复原来的状态，也就需要交换回来。
 * 
 * @author leon
 *
 */
public class Permutate {
	public static Set<String> generate(String str) {
		// 检验参数
		if (str == null || str.length() == 0) {
			return null;
		}

		// 全排列结果列表(去重)
		Set<String> resultSet = new HashSet<String>();
		
		// 对字符串进行递归全排列
		help(0, str.toCharArray(), resultSet);

		return resultSet;
	}

	/**
	 * 固定位置i对字符串进行递归全排列
	 */
	private static void help(int i, char[] charArray, Set<String> resultSet) {
		if(i == charArray.length) {
			resultSet.add(String.valueOf(charArray));
		}else {
			// 依次选一个字符固定到i，i后面字符进行递归全排列后回溯
			for(int j=i;j<charArray.length;j++) {
				// 交换i，j字符位置
				swap(i,j,charArray);
				help(i+1,charArray,resultSet);
				swap(i,j,charArray);
				
			}
		}
		
	}

	/** 交换i,j元素位置
	 */
	private static void swap(int i, int j, char[] charArray) {
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		
	}

	public static void main(String[] args) {
		Set<String> resultSet = Permutate.generate("accd");
		// 利用treeSet排序
		resultSet = new TreeSet<String>(resultSet);
		System.out.println("数量："+resultSet.size());
		System.out.println(resultSet.toString());
		// 拓展：利用流倒序
		List<String> resultList = resultSet.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(resultList.toString());
		
	}
}
