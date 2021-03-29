package com.alorithm.sorts03;
/**
 * 桶排序
 * @author zplan
 *
 */
public class BucketSort {
	
	
	

	/**
	 * 桶排序
	 * @param arr
	 * @param bucketSize
	 */
	public static void bucketSort(int[] arr, int bucketSize) {
		if(arr.length <2) {
			return;
		}
		
		//数组最小值
		int minValue = arr[0];
		//数组最大值
		int maxValue = arr[1];
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < minValue) {
				minValue = arr[i];
			}else if( arr[i] > maxValue) {
				maxValue = arr[i];
			}
		}
		
		//桶数量
		int bucketCount = (maxValue - minValue) /bucketSize +1;
		int[][] buckets = new int[bucketCount][bucketSize];
		int[] indexArr = new int[bucketCount];
		
		for (int i = 0; i < arr.length; i++) {
			int bucketIndex = (arr[i] - minValue) / bucketSize;
			if(indexArr[bucketIndex] == buckets[bucketIndex].length) {
				ensureCapacity(buckets, bucketIndex);
			}
			buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
		}
		
		//对每一个桶进行排序，这里使用了快速排序
		int k = 0;
		for (int i = 0; i < buckets.length; i++) {
			if(indexArr[i] == 0) {
				continue;
			}
			quickSortC(buckets[i],0, indexArr[i]-1);
			for (int j = 0; j < indexArr[i]; j++) {
				arr[k++] = buckets[i][j];
			}
		}
		
		
	}
	
	/**
	 * 快速排序递归函数
	 * @param arr
	 * @param p
	 * @param r
	 */
	private static void quickSortC(int[] arr, int p, int r) {
		if(p >= r) {
			return;
		}
		int q = partition(arr,p,r);
		quickSortC(arr, p, q-1);
		quickSortC(arr, q+1, r);

		
	}
	
	/**
	 * 分区函数
	 * @param arr
	 * @param p
	 * @param r
	 * @return
	 */
	private static int partition(int[] arr, int p, int r) {
		int pivot = arr[r];
		int i = p;
		for(int j = p; j<r; j++) {
			if(arr[j] <= pivot) {
				swap(arr, i++,j);
			}
		}
		swap(arr,i,r);
		return i;
	}


	private static void swap(int[] arr, int i, int r) {
		if(i == r) {
			return;
		}
		int tmp = arr[i];
		arr[i] = arr[r];
		arr[r] = tmp;
	}

	/**
	 * 数组扩容
	 * @param buckets
	 * @param bucketIndex
	 */
	private static void ensureCapacity(int[][] buckets, int bucketIndex) {
		int[] tempArr = buckets[bucketIndex];
		int[] newArr = new int[tempArr.length * 2];
		for (int i = 0; i < tempArr.length; i++) {
			newArr[i] = tempArr[i];
		}
		buckets[bucketIndex] = newArr;
	}
	
	
}
