package com.alorithm.sorts03;

/**
 * 基数排序
 * @author zplan
 *
 */
public class RadixSort {
	
	public static void radixSort(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		//从个位开始，对数组arr按指数进行排序
		for(int exp = 1; max /exp > 0 ; exp*=10) {
			countingSort(arr, exp);
		}
	}

	private static void countingSort(int[] arr, int exp) {
		if(arr.length <= 1) {
			return;
		}
		
		//计算每个元素的个数
		int[] c = new int[10];
		for(int i = 0; i < arr.length; i++) {
			c[(arr[i] / exp) % 10]++;
		}
		
		//计算排序后的位置
		for(int i = 1; i< c.length; i++) {
			c[i] += c[i-1];
		}
		
		//临时数组r，存储排序之后的结果
		int[] r = new int[arr.length];
		for (int i = arr.length; i >= 0; i--) {
			r[c[(arr[i] / exp) % 10] -1 ] = arr[i];
			c[(arr[i] / exp) % 10] --;
		}
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r[i];
		}
	}
	
	public static void main(String[] args) {
	int i =	2 << 4;
	
	int f =	-2 >>> 1;
	System.out.println(i);
	System.out.println(f);
	}

}
