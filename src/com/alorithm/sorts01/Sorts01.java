package com.alorithm.sorts01;

/**
 * 冒泡排序，插入排序，选择排序
 * @author zplan
 *
 */
public class Sorts01 {
	
	//冒泡排序，a是数组
	public static void bubbleSort(int [] a) {
		if(a == null || a.length <=1) return;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n -1; j++) {
				if(a[j] > a[j+1]) {
					int tmpt = a[j];
					a[j] = a[j+1];
					a[j+1] =tmpt;
					
				}
			}
		}
	}
	/**
	 * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
	 * @param a
	 * 
	 */
	public static void bubbleSort2(int [] a) {
		if(a == null || a.length <=1) return;
		int n = a.length;
		//最后异常交换的位置
		int lastExchange = 0;
		//无序数据的边界，每次只需要比较到这里即可退出
		int sortBorder = n -1;
		for (int i = 0; i < n; i++) {
			//提前退出标志位
			boolean flag = false;
			for (int j = 0; j < sortBorder; j++) {
				if(a[j] > a[j+1]){
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					flag = true;
					lastExchange =j;
				}
			}
			sortBorder = lastExchange;
			if(!flag) break;
		}
	}
	
	
	//插入排序
	//6  -4  0  -11  -2  3 
	//-4  6  0  -11  -2  3 
	//0 -4  6  6  -11  -2  3 
//	-11 -4  -2 	0  3  6 
	public static void insertionSort(int[] a) {
		if(a == null || a.length <=1) return;
		
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int value = a[i];
			int j = i -1;
			//查找要插入的位置并移动数据
			for (;  j >=0; --j) {
				if(a[j] > value) {
					a[j+1] = a[j];
				}else {
					System.out.println(j);
					break;
				}
			}
			a[j + 1] = value;
		}
	}
	
	public static void selectionSort(int[] a) {
		if(a == null || a.length <=1) return;
		
		int n = a.length;
		for (int i = 0; i < n -1; ++i) {
			int minIndex = i;
			for (int j = i+1; j < n; ++j) {
				if(a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			
			int tmp = a[i];
			a[i] = a[ minIndex];
			a[minIndex] = tmp;
		}
	}
	
	public static void main(String[] args) {
		
		int[] a = LogartihmicUtil.generateRandomArray(9, 14);
		LogartihmicUtil.printArray(a);
		int[] b = LogartihmicUtil.copyArray(a);
//		bubbleSort(a);
//		bubbleSort2(b);
//		insertionSort(a);
		selectionSort(a);
		LogartihmicUtil.printArray(a);
//		LogartihmicUtil.printArray(b);

	}
	
	

}
