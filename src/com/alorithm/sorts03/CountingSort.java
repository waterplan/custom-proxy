package com.alorithm.sorts03;

public class CountingSort {

	public static void countingSort(int[] a, int n) {
		if(n <= 1) return;
		//查找数组中数据的范围
		int max = a[0];
		for (int i = 1; i < n; ++i) {
			if(max < a[i]) {
				max = a[i];
			}
		}
		//申请一个计数数组c，下标大小[0,max]
		int[] c = new int[max +1];
		//计数每个元素的个数，放入c中
		for (int i = 0; i < n; ++i) {
			c[a[i]]++;
		}
		
		//依次累加
		for(int i = 1; i< max+1; ++i) {
			c[i] = c[i-1] + c[i];
		}
		
		//临时数组r，存储排序之后的结果
		int[] r = new int[n];
		
		//计算排序的关键步骤了
		for (int i = n -1; i >= 0; --i) {
			int index = c[a[i]]-1;
			r[index] = a[i];
			c[a[i]]--;
		}
		
		for (int i = 0; i < n; ++i) {
			a[i] = r[i];
		}
	}
	
}
