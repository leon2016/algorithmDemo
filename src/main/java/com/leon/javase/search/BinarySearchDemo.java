package com.leon.javase.search;

/**
 * 二分查找有序数组
 * 
 * @author leon
 *
 */
public class BinarySearchDemo {
	
	/**
	 * 递归实现二分查找
	 * 记忆思路：递归与中间值比较，相等则返回mid
	 */
	public static int binarySearch(int[] arr,int key) {
		// 参数校验
		if(arr == null || arr.length <=0) {
			return -1;
		}
		// 递归搜索
		return doBinarySearch(arr, key, 0, arr.length-1);
	}

	/** 递归搜索
	 */
	public static int doBinarySearch(int[] arr, int key, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) >> 1;
		if (key > arr[mid]) {
			return doBinarySearch(arr, key, mid + 1, high);
		} else if (key < arr[mid]) {
			return doBinarySearch(arr, key, low, mid - 1);
		} else {
			return mid;
		}
	}
	
	/** 非递归实现二分查找
	 *  记忆思路：循环与中间值比较，相等则返回mid
	 */
	public static int binarySearch2(int[] arr,int key) {
		// 校验参数
		if(arr == null || arr.length<=0) {
			return -1;
		}
		// 非递归二分搜索
		int low = 0;
		int high = arr.length -1;
		while(low<high) {
			int mid = (low + high) >> 1;
			if(key>arr[mid]) {
				low = mid +1;
			}else if(key < arr[mid]) {
				high = mid -1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int index = binarySearch(arr, 5);
		int index2 = binarySearch2(arr, 5);
		System.out.println("binarySeach:" + index);
		System.out.println("binarySeach2:" + index2);
	}
}
