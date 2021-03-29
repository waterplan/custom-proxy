package com.alorithm.newcode;

public class QuickSort01 {
	
	public static void quickSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return ;
		}
		
		quickSort(arr,0, arr.length -1);
	}

	private static void quickSort(int[] arr, int i, int j) {
		if(i< j) {
			int p = partition(arr,i,j);
			
			quickSort(arr,i, p -1);
			quickSort(arr, p +1, j);
		}
	}

	
	private static int partition(int[] arr, int l, int r) {
		int pviot = arr[r];
		int i = l;
		for (int j = l; j < r; j++) {
			if(arr[j] < pviot) {
				if(j == i) {
					++i;
				}
				else {
					int tmp = arr[j];
					arr[j] = arr[i];
					arr[i++] = tmp;
				}
			}
		}
		int tmp = arr[r];
		arr[r] =arr[i];
		arr[i] = tmp;
		return i;
	}

	public static void main(String[] args) {
		int[] arr= {4,6,7,4,6,9,3,1};
		quickSort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
