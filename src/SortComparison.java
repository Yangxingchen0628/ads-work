import java.util.ArrayList;
import java.util.*;
import java.util.Random;
import java.lang.Math.*; 
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static Double [] insertionSort (Double[] newlist){
		if(newlist.length<=1) {return newlist;}
		for(int j = 1; j < newlist.length; j++) {
			double key = newlist[j];
			int i = j-1;
			while(i >= 0 && newlist[i] > key) {
				newlist[i+1] = newlist[i];
				i--;
			}
			newlist[i+1] = key;
		}
		return newlist;

		//todo: implement the sort
	}//end insertionsort

	/**
	 * Sorts an array of doubles using Selection Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static Double [] selectionSort (Double a[]){
		if(a.length<=1) {return a;}
		for(int i = 0; i < a.length - 1; i++) {// first selection
			int k = i;
			for(int j = k + 1; j < a.length; j++){// get the smallest one
				if(a[j] < a[k]){ 
					k = j; //get the location
				}
			}
			//在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
			if(i != k){  //交换a[i]和a[k]
				Double temp = a[i];
				a[i] = a[k];
				a[k] = temp;
			}    
		}
		return a;
		//todo: implement the sort

	}//end selectionsort

	/**
	 * Sorts an array of doubles using Quick Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static Double [] quickSort (Double a[]){
		quickSort(a,0,a.length-1);
		return a;
		//todo: implement the sort

	}
	static void quickSort (Double arrays[],int start,int end) {
		if (start >= end)
		{
			return ;
		}
		int middleIndex = subQuickSortCore(arrays, start, end);
		quickSort(arrays, start, middleIndex - 1);
		quickSort(arrays, middleIndex + 1, end);
	}
	static int subQuickSortCore(Double[] arrays, int start, int end)
	{
		Double middleValue = arrays[start];
		while (start < end)
		{
			while (arrays[end] >= middleValue && start < end)
			{
				end--;
			}
			arrays[start] = arrays[end];
			while (arrays[start] <= middleValue && start < end)
			{
				start++;
			}
			arrays[end] = arrays[start];
		}
		arrays[start] = middleValue;
		return start;
	}
	//end quicksort

	/**
	 * Sorts an array of doubles using Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */

	static Double[] mergeSortIterative (Double a[]) {
		mergeSort(a,a.length);
		return a;
		//todo: implement the sort

	}//end mergesortIterative
	static void mergeSort(Double arr[], int n) 
	{ 


		int curr_size;  


		int left_start; 


		for (curr_size = 1; curr_size <= n-1;  
				curr_size = 2*curr_size) 
		{ 


			for (left_start = 0; left_start < n-1; 
					left_start += 2*curr_size) 
			{ 

				int mid = Math.min(left_start + curr_size - 1, n-1); 

				int right_end = Math.min(left_start  
						+ 2*curr_size - 1, n-1); 


				merge(arr, left_start, mid, right_end); 
			} 
		} 
	} 


	static void merge(Double arr[], int l, int m, int r) 
	{ 
		int i, j, k; 
		int n1 = m - l + 1; 
		int n2 = r - m; 


		Double L[] = new Double[n1]; 
		Double R[] = new Double[n2]; 


		for (i = 0; i < n1; i++) 
			L[i] = arr[l + i]; 
		for (j = 0; j < n2; j++) 
			R[j] = arr[m + 1+ j]; 


		i = 0; 
		j = 0; 
		k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i]; 
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 


		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 


		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 


	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */
	static Double[] mergeSortRecursive (Double a[]) {
		mergeSort(a,0,a.length-1);
		return a;
		//todo: implement the sort

	}
	static void merge2(Double []a,int left,int mid,int right){
		Double []tmp=new Double[a.length];
		int p1=left,p2=mid+1,k=left;

		while(p1<=mid && p2<=right){
			if(a[p1]<=a[p2])
				tmp[k++]=a[p1++];
			else
				tmp[k++]=a[p2++];
		}

		while(p1<=mid) tmp[k++]=a[p1++];
		while(p2<=right) tmp[k++]=a[p2++];


		for (int i = left; i <=right; i++) 
			a[i]=tmp[i];
	}

	static void mergeSort(Double [] a,int start,int end){
		if(start<end){
			int mid=(start+end)/2;
			mergeSort(a, start, mid);
			mergeSort(a, mid+1, end);
			merge2(a, start, mid, end);
		}
	}







	public static void main(String[] args) {
		List<Double> list = new ArrayList<Double>();
		try {
			File myObj = new File("C:\\Users\\DELL\\Dropbox\\ads\\week6\\numbers1000.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				list.add(Double.valueOf(data));
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		Double[] newlist = new Double[list.size()];
		list.toArray(newlist);
		Double[] list1 = newlist;
		Double[] list2 = newlist;
		Double[] list3 = newlist;
		Double[] list4 = newlist;
		Double[] list5 = newlist;
		long startTime;
		long endTime;
		long totalTime;
		startTime = System.nanoTime();
		newlist= insertionSort(list1);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("insertionSort "+totalTime);
		startTime = System.nanoTime();
		newlist= selectionSort(list2);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("selectionSort "+totalTime);
		startTime = System.nanoTime();
		newlist= quickSort(list3);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("quickSort "+totalTime);
		startTime = System.nanoTime();
		newlist= mergeSortIterative(list4);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("mergeSortIterative "+totalTime);
		startTime = System.nanoTime();
		newlist= mergeSortRecursive(list5);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("mergeSortRecursive "+totalTime);
		//System.out.println("排好序的数组：");
		//for (double e : newlist)
			//System.out.println(e+" ");
	}

	//todo: do experiments as per assignment instructions
}

//end class
