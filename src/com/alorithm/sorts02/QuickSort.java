package com.alorithm.sorts02;

import com.alorithm.sorts01.LogartihmicUtil;

public class QuickSort {
	
	public static void main(String[] args) {
//		int[] array = LogartihmicUtil.generateRandomArray(20, 20);
		int[] array = {2,10,54,1,9,7,5,3,8};
		LogartihmicUtil.printArray(array);

		quickSort(array, array.length);
		
		LogartihmicUtil.printArray(array);
	}
	
	//快速排序，a是数组，n表示数组的大小
	public static void quickSort(int[] a, int n) {
		quickSortInternally(a, 0, n-1);
	}

	private static void quickSortInternally(int[] a, int p, int r) {
		if(p >= r) return;
		
		int q = partition(a,p,r);//获取分区点
		quickSortInternally(a, p, q-1);
		quickSortInternally(a, q+1, r);
		
	}

	private static int partition(int[] a, int p, int r) {
		int pivot = a[r];
		int i = p;
		for (int j = p; j < r; ++j) {
			if(a[j] <pivot) {
				if(i == j) {
					++i;
				}else {
					int tmp = a[i];
					a[i++] = a[j];
					a[j] = tmp;
				}
			}
		}
		int tmp = a[i];
		a[i] = a[r];
		a[r] = tmp;
		System.out.println("i = "+i);
		return i;
	}

}
