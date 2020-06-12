package com.leon.javase.sort;

public class IntArraySortDemos {

	/**
	 * 交换排序2-1-冒泡排序
	 * 
	 * 记忆：1.要进行n-1次冒泡 2.每次冒泡长度递减i次
	 * 
	 * @param Array
	 */
	public static void bubbleSort(int[] array) {

		if (array == null || array.length <= 1) {
			return;
		}

		for (int i = 0; i < array.length - 1; i++) {// 一共要进行len-1轮比较
			for (int j = 0; j < array.length - 1 - i; j++) {// 比较次数为len-1-i
				if (array[j] > array[j + 1]) {// 大则冒泡到后面
					swap(array, j, j + 1);
				}
			}
		}

	}

	/**
	 * 交换排序2-2-快速排序（记牢）
	 * 
	 * @param array
	 */
	public static void quickSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		doQuickSort(array, 0, array.length - 1);

	}

	// 快排递归处理
	public static void doQuickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = getMid(array, left, right);
		doQuickSort(array, left, mid - 1);
		doQuickSort(array, mid + 1, right);
	}

	// 快排第一次划分
	public static int getMid(int[] array, int left, int right) {
		int base = array[left];// 取第一个值作为中间值
		while (left < right) {
			while (left < right && array[right] >= base) {
				right--;
			}
			array[left] = array[right];
			while (left < right && array[left] <= base) {
				left++;
			}
			array[right] = array[left];
		}

		array[left] = base;
		return left;
	}

	/**
	 * 插入排序2-1-直接插入 记忆：1.从1开始插入 2.插入位置为j>=0 && temp<array[j]
	 * 
	 * @param array
	 */
	public static void insertSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}

	/**
	 * 选择排序2-1-简单选择排序 记忆：1.进行n-1次选择排序 2.每次选择先找到minIndex,再交换i,minIndex位置
	 * 
	 * @param array
	 */
	public static void selectSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(array, i, minIndex);
			}
		}
	}

	/**
	 * 选择排序2-2-堆排序
	 * 
	 * 记忆：1.建立大顶堆  2.交换堆顶元素重建大顶堆
	 * 
	 * @param array
	 */
	public static void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		// 建立大顶堆
		for (int i = array.length / 2; i >= 0; i--) {
			heapAdjust(array, i, array.length - 1);
		}

		// 交换堆顶元素后重建堆
		for (int i = array.length - 1; i >= 0; i--) {
			swap(array, 0, i);
			heapAdjust(array, 0, i - 1);
		}
	}

	private static void heapAdjust(int[] array, int start, int end) {
		int temp = array[start];
		for (int i = 2 * start + 1; i < end; i = 2 * i + 1) {
			if (array[i] < array[i + 1]) {
				i++;
			}
			if (temp > array[i]) {
				break;
			}
			array[start] = array[i];
			start = i;
		}
		array[start] = temp;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void print(int[] array) {
		if (array != null) {
			for (int e : array) {
				System.out.print(e + ", ");
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 5, 6, 0, 1, 8, 9, 0, 2, 5, 3, 12, 33, 2, 43, 55, 11 };
		System.out.println("排序前:");
		print(array);
		// bubbleSort(array);
		// insertSort(array);
		// selectSort(array);
		// quickSort(array);
		heapSort(array);
		System.out.println();
		System.out.println("排序后:");
		print(array);
	}
}
