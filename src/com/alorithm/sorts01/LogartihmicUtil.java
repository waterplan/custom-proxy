package com.alorithm.sorts01;

public class LogartihmicUtil {
	
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
			
		}
		return arr;
	}
	
	public static int [] copyArray(int[] arr) {
		if(arr == null) {
			return arr;
		}
		int []res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if((arr1 == null && arr2 != null) ||(arr1 != null && arr2 == null)) {
			return false;
		}
		if(arr1 == null && arr2 == null) {
			return true;
		}
		if(arr1.length != arr2.length) {
			return false;
		}
		
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void printArray(int[] arr) {
		if(arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+ " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int n = 1;
		System.out.println("++n："+ (++n));
		int i = 1;
		System.out.println("i++："+ (i++));
		System.out.println(i);

	}

}
