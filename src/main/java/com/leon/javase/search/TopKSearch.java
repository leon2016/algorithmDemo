package com.leon.javase.search;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * topK问题
 * 记忆思路：1.利用PriorityQueue(默认最小堆) 
 * 2.
 * 
 * @author wangang
 *
 */
public class TopKSearch {
	public static PriorityQueue<Integer> getTopK(int[] arr, int k) {
		// 参数校验
		if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
			return null;
		}
		// 初建k节点的小根堆
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		// 堆顶元素替换
		for (int j = k; j < arr.length; j++) {
			if (arr[j] > pq.peek()) {
				pq.poll();
				pq.offer(arr[j]);
			}
		}

		return pq;
	}
	
	/** 扩展-寻找第k个最小值，不含重复的。
	 *  
	 * @param nums
	 * @param k
	 */
	public static void find(int[] nums, int k){
		// 关键代码2-1：重新Comparator建立最大堆优先队列
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for ( int i = 0 ; i < k ; i ++ )
        {
            if ( !priorityQueue.contains(nums[i]) ) priorityQueue.offer(nums[i]);
        }
        for ( int i = k ; i < nums.length  ; i ++ ){
        	// 关键代码2-2：利用队列contains方式去重
            if ( nums[i] < priorityQueue.peek() && !priorityQueue.contains(nums[i]) ){
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        System.out.println(priorityQueue.peek());
        while ( priorityQueue.peek() != null ){
            System.out.print(priorityQueue.poll()+"   ");
        }
    }

	public static void main(String[] args) {
		int[] arr = { 1,1, 4, 5, 2, 3, 7, 6, 9, 8 };
		PriorityQueue<Integer> pq = TopKSearch.getTopK(arr, 5);
		// 第K大的数
		System.out.println("第K大的数：" + pq.peek());
		// 前K大的数
		System.out.println(pq.toString());
		// 依次输出前K大的数
		while (pq.peek() != null) {
			System.out.println(pq.peek());
			pq.poll();
		}
		System.out.println("找不重复的前K个最小值：");
		find(arr, 5);
	}

}
