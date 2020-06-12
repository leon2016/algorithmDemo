package com.leon.javase.sort;

public class IntArraySortDemo {

	/**
	 * 2-1交换排序-冒泡排序
	 * 
	 * @param arr
	 */
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 2-2交换排序-快速排序
	 * 
	 * @param arr
	 */
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		doQuickSort(arr, 0, arr.length - 1);
	}

	public static void doQuickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		// 获得中间位置
		int mid = getMid(arr, left, right);
		// 分治递归
		doQuickSort(arr, left, mid - 1);
		doQuickSort(arr, mid + 1, right);
	}

	public static int getMid(int[] arr, int left, int right) {
		int base = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= base) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] <= base) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = base;
		return left;
	}

	/**
	 * 2-1选择排序-简单选择排序
	 * 
	 * @param arr
	 */
	public static void selectSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; i < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			while (minIndex != i) {
				swap(arr, minIndex, i);
			}
		}
	}

	/**
	 * 2-2选择排序-堆排序
	 * 
	 * @param arr
	 */
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 初始建堆
		for (int i = arr.length >> 2; i >= 0; i--) {
			heapAdjust(arr, i, arr.length - 1);
		}

		// 重建堆
		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr, 0, i);
			heapAdjust(arr, 0, i - 1);
		}
	}

	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void heapAdjust(int[] arr, int start, int end) {
		int temp = arr[start];
		for (int i = 2 * start + 1; i < end; i = 2 * i + 1) {
			if (arr[i] < arr[i + 1]) {
				i++;
			}
			if (temp >= arr[i]) {
				break;
			}
			arr[start] = arr[i];
			start = i;
		}
		arr[start] = temp;
	}

	/**
	 * 插入排序
	 * 
	 * @param arr
	 */
	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}
	
	
	
}
