package com.leon.javase.sort;

/**
 * 常见排序算法（升序)
 * 
 * @author wangang
 *
 */
public class IntArraySortUtil {

	/**
	 * 2-1交换排序-冒泡排序 记忆思路：1.进行n-1轮比较 2.每一轮对剩余的数从头到尾两两比较，大的冒泡到后面
	 * 
	 * @param arr
	 */
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j + 1] < arr[j]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void printArr(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}

	/**
	 * 2-2交换排序-快速排序（递归）
	 * 
	 * @param arr
	 */
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		doQuickSort(arr, 0, arr.length - 1);
	}

	private static void doQuickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = getMid(arr, left, right);
		doQuickSort(arr, left, mid - 1);
		doQuickSort(arr, mid + 1, right);
	}

	private static int getMid(int[] arr, int left, int right) {
		int temp = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= temp) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] <= temp) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = temp;
		return left;
	}

	/**
	 * 2-1插入排序-直接插入排序
	 * 记忆思路：拿出第i个元素空出位置往前比较，大的往后移动。
	 * 
	 * @param arr
	 */
	public static void insertSort(int[] arr) {
		if (arr == null || arr.length <=1) {
			return;
		}
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

	/**
	 * 选择排序2-1:简单选择排序
	 * 记忆思路：依次遍历n-1次，选择出最小值的下标交换。
	 * @param arr
	 */
	public static void selectSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(arr, i, minIndex);
			}
		}
	}

	/**
	 * 选择排序2-2：堆排序（升序）
	 * 
	 * 思路：建堆，交换，建堆
	 * 
	 * @param arr
	 */
	/**
	 * 选择排序 记忆思路：1.从第一个非叶子结点从下至上，从右至左调整结构 2.执行n次交换和重建堆（i=2*start+1是start节点的左子节点）
	 * 
	 * @param args
	 */
	public static void heapSort(int[] arr) {
		// 检验参数
		if (arr == null || arr.length <= 1) {
			return;
		}
		// 初建堆
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapAdjust(arr, i, arr.length - 1);
		}
		// 交换建堆
		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapAdjust(arr, 0, i - 1);
		}
	}

	// 调整堆(大顶堆)
	private static void heapAdjust(int[] arr, int start, int end) {
		int temp = arr[start];
		for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
			if (i + 1 <= end && arr[i] < arr[i + 1]) {
				i++;
			}
			// 符合大顶堆规则则跳出
			if (temp >= arr[i]) {
				break;
			}
			arr[start] = arr[i];
			start = i;
		}
		arr[start] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 4, 5, 7, 6, 9, 8 };
		// bubbleSort(arr);
		// quickSort(arr);
		// insertSort(arr);
		// selectSort(arr);
		heapSort(arr);
		printArr(arr);
	}
}
