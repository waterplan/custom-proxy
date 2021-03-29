package com.alorithm.sorts02;

public class KthSmallest {
	
	public static void main(String[] args) {
		int arr[] = new int[]{2,2,5,9,4,3,10};
		int kthSmallest = kthSmallest(arr, arr.length);
		System.out.println(kthSmallest);
		print(arr);
		
	}
	
	public static void print(int[] arr) {
		if(arr == null) {
			System.out.println();
		}
		String str = "[";
		for (int i = 0; i < arr.length; i++) {
			str+=" "+arr[i];
			if(i < arr.length-1) {
				str+=",";
			}
		}
		System.out.println(str+"]");
	}
	
	public static int kthSmallest(int[] arr, int k) {
		if(arr == null || arr.length < k) {
			return -1;
		}
		int partition = partition(arr,0,arr.length -1);
		while(partition + 1 != k) {
			if(partition + 1 <k) {
				partition = partition(arr, partition + 1, arr.length-1);
			} else {
				partition = partition(arr, 0, partition -1);
			}
		}
		return arr[partition];
	}

	/**
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	private static int partition(int[] arr, int p, int r) {
		int pivot = arr[r];
		int i = p;
		
		for (int j = p; j < r; j++) {
			//这里要是<=,不然会出现死循环，比如查询数组[1,1,2]的第二小的元素
			if(arr[i] <= pivot) {
				swap(arr,i++,j);
			}
		}
		swap(arr, i, r);
		return i;
	}

	private static void swap(int[] arr, int i, int j) {
		if(i == j) {
			return;
		}
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}

}
