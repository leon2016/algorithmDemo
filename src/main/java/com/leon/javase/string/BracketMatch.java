package com.leon.javase.string;
/**判断给定字符串中的括号是否匹配
 * 思路：利用栈，遍历字符串，遇到左括号入栈，右括号出栈；如果出栈时，栈为空或者出栈的不是相匹配的左括号，则不匹配。
 * @author wangang
 *
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketMatch {
	// 创建括号映射表
	private static final Map<Character, Character> bracketMap = new HashMap<Character, Character>();
	static {
		bracketMap.put('(', ')');
	}
	
	public static boolean isMatch(String str) {
		// 检验参数
		if(str == null) {
			return false;
		}
		
		// 利用栈判断括号匹配(左括号入栈，右括号出栈)
		Stack<Character> stack = new Stack<Character>();
		for(char ch : str.toCharArray()) {
			if(bracketMap.containsKey(ch)) {
				stack.push(ch);
				continue;
			}else if(bracketMap.containsValue(ch)){
				if(stack.isEmpty() ||bracketMap.get(stack.pop()) != ch) {
					return false;
				}
			}
		}
		
		// 如果最终栈为空，说明括号都匹配
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(BracketMatch.isMatch("123(3234)323"));
		System.out.println(BracketMatch.isMatch("123(3234)3)23"));
	}
}

