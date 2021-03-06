import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//							numbers10		numbers100		numbers1000		numbers1000Duplicates		numbersNearlyOrdered1000		numbersReverse1000		numbersSorted1000
//insertionSort				628000 ns		1043900 ns		8430300 ns		9912000 ns					3647700 ns						7186600 ns				912900 ns
//selectionSort				14100 ns		253500 ns		7360200 ns		6729800 ns					6011000 ns						6190000 ns				7696700 ns
//quickSort					26300 ns		227700 ns		5291900 ns		6913900 ns					5893300 ns						5470200 ns				4995400 ns
//mergeSortIterative		86800 ns		109000 ns		858600 ns		1123400 ns					1045100 ns						953200 ns				803200 ns
//mergeSortRecursive		13700 ns		78300 ns		2174500 ns		3145000 ns					3242900 ns						2107500 ns				2199300 ns



//a. Which of the sorting algorithms does the order of input have an impact on? Why?

//Answer: its insertionSort, because it has a huge time gap between 3647700ns and 9912000ns.

//b. Which algorithm has the biggest difference between the best and worst performance, based
//on the type of input, for the input of size 1000? Why?

//Answer: its insertionSort, the difference is 7802300.because It��s efficient for small data sets. 
//It typically outperforms other simple quadratic algorithms, such as selection sort or bubble sort.


//c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
//based on the input size? Please consider only input files with random order for this answer.

//Answer: its insertionSort, because it��s adaptive: it sorts data sets that are already substantially 
//sorted efficiently. The time complexity is O(nk) when each element is at most k places away from its sorted position.

//d. Did you observe any difference between iterative and recursive implementations of merge
//sort?

//Answer: The main difference is that recursive merge sorting uses recursive function calls, while 
//iterative merge sorting does not require recursion and instead uses loops.

//e. Which algorithm is the fastest for each of the 7 input files?
//Answer: mergeSortRecursive is the fastest for 10numbers and 100 numbers, for all others input, the fastest is mergeSortIterative.
@RunWith(JUnit4.class)
public class SortComparisonTest {

	@Test
	public void insertionSortTest() {
		Double[] arr = {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63,
				3669.57,4917.36,9100.94,2652.57,8931.88,2203.51,6317.98,5710.77,3321.58,1044.55,5029.31,
				5673.94,8541.65,401.409,1080.22,6393.96,131.11,7201.84,1018.14,4829.45,2543.55,6766.97,
				8967.82,7598.96,7202.92,9076.23,9286.11,3776.63,8997.56,7788.8,3242.55,1942.31,9955.53,
				1612.96,7080.34,5015.19,9363.01,7163.23,1051.9,2092.05,5593.97,7054.32,782.337,5105.3,1961.97,
				2742.11,6386.02,4482.08,398.718,4672.51,777.565,381.004,1600.44,3978.32,6888.98,};    
		Double[] tmp = arr;
		Arrays.sort(arr);
		tmp = SortComparison.insertionSort(tmp);
		assertArrayEquals("insertionSort",arr,tmp);
		Double[] arr2 = {};
		tmp = arr2;
		Arrays.sort(arr2);
		tmp = SortComparison.mergeSortRecursive(tmp);
		assertArrayEquals("mergeSortRecursive",arr2,tmp);
	}
	@Test
	public void selectionSortTest() {
		Double[] arr = {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63,
				3669.57,4917.36,9100.94,2652.57,8931.88,2203.51,6317.98,5710.77,3321.58,1044.55,5029.31,
				5673.94,8541.65,401.409,1080.22,6393.96,131.11,7201.84,1018.14,4829.45,2543.55,6766.97,
				8967.82,7598.96,7202.92,9076.23,9286.11,3776.63,8997.56,7788.8,3242.55,1942.31,9955.53,
				1612.96,7080.34,5015.19,9363.01,7163.23,1051.9,2092.05,5593.97,7054.32,782.337,5105.3,1961.97,
				2742.11,6386.02,4482.08,398.718,4672.51,777.565,381.004,1600.44,3978.32,6888.98,};   
		Double[] tmp = arr;
		Arrays.sort(arr);
		tmp = SortComparison.selectionSort(tmp);
		assertArrayEquals("selectionSort",arr,tmp);
		Double[] arr2 = {};
		tmp = arr2;
		Arrays.sort(arr2);
		tmp = SortComparison.mergeSortRecursive(tmp);
		assertArrayEquals("mergeSortRecursive",arr2,tmp);
	}
	@Test
	public void quickSortTest() {
		Double[] arr = {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63,
				3669.57,4917.36,9100.94,2652.57,8931.88,2203.51,6317.98,5710.77,3321.58,1044.55,5029.31,
				5673.94,8541.65,401.409,1080.22,6393.96,131.11,7201.84,1018.14,4829.45,2543.55,6766.97,
				8967.82,7598.96,7202.92,9076.23,9286.11,3776.63,8997.56,7788.8,3242.55,1942.31,9955.53,
				1612.96,7080.34,5015.19,9363.01,7163.23,1051.9,2092.05,5593.97,7054.32,782.337,5105.3,1961.97,
				2742.11,6386.02,4482.08,398.718,4672.51,777.565,381.004,1600.44,3978.32,6888.98,};  
		Double[] tmp = arr;
		Arrays.sort(arr); 
		tmp = SortComparison.quickSort(tmp);
		assertArrayEquals("quickSort",arr,tmp);
		Double[] arr2 = {};
		tmp = arr2;
		Arrays.sort(arr2);
		tmp = SortComparison.mergeSortRecursive(tmp);
		assertArrayEquals("mergeSortRecursive",arr2,tmp);
	}
	@Test
	public void mergeSortIterativeTest() {
		Double[] arr = {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63,
				3669.57,4917.36,9100.94,2652.57,8931.88,2203.51,6317.98,5710.77,3321.58,1044.55,5029.31,
				5673.94,8541.65,401.409,1080.22,6393.96,131.11,7201.84,1018.14,4829.45,2543.55,6766.97,
				8967.82,7598.96,7202.92,9076.23,9286.11,3776.63,8997.56,7788.8,3242.55,1942.31,9955.53,
				1612.96,7080.34,5015.19,9363.01,7163.23,1051.9,2092.05,5593.97,7054.32,782.337,5105.3,1961.97,
				2742.11,6386.02,4482.08,398.718,4672.51,777.565,381.004,1600.44,3978.32,6888.98,};  
		Double[] tmp = arr;
		Arrays.sort(arr); 
		tmp = SortComparison.mergeSortIterative(tmp);
		assertArrayEquals("mergeSortIterative",arr,tmp);
		Double[] arr2 = {};
		tmp = arr2;
		Arrays.sort(arr2);
		tmp = SortComparison.mergeSortRecursive(tmp);
		assertArrayEquals("mergeSortRecursive",arr2,tmp);
	}
	@Test
	public void mergeSortRecursiveTest() {
		Double[] arr = {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63,
				3669.57,4917.36,9100.94,2652.57,8931.88,2203.51,6317.98,5710.77,3321.58,1044.55,5029.31,
				5673.94,8541.65,401.409,1080.22,6393.96,131.11,7201.84,1018.14,4829.45,2543.55,6766.97,
				8967.82,7598.96,7202.92,9076.23,9286.11,3776.63,8997.56,7788.8,3242.55,1942.31,9955.53,
				1612.96,7080.34,5015.19,9363.01,7163.23,1051.9,2092.05,5593.97,7054.32,782.337,5105.3,1961.97,
				2742.11,6386.02,4482.08,398.718,4672.51,777.565,381.004,1600.44,3978.32,6888.98,};  
		Double[] tmp = arr;
		Arrays.sort(arr); 
		tmp = SortComparison.mergeSortRecursive(tmp);
		assertArrayEquals("mergeSortRecursive",arr,tmp);
		Double[] arr2 = {};
		tmp = arr2;
		Arrays.sort(arr2);
		tmp = SortComparison.mergeSortRecursive(tmp);
		assertArrayEquals("mergeSortRecursive",arr2,tmp);
	}
//	public static void main(String[] args) {
//		List<Double> list = new ArrayList<Double>();
//		try {
//			File myObj = new File("C:\\Users\\DELL\\Dropbox\\ads\\week6\\numbersSorted1000.txt");
//			Scanner myReader = new Scanner(myObj);
//			while (myReader.hasNextLine()) {
//				String data = myReader.nextLine();
//				list.add(Double.valueOf(data));
//			}
//			myReader.close();
//
//		} catch (FileNotFoundException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}
//		Double[] newlist = new Double[list.size()];
//		list.toArray(newlist);
//		Double[] list1 = newlist;
//		Double[] list2 = newlist;
//		Double[] list3 = newlist;
//		Double[] list4 = newlist;
//		Double[] list5 = newlist;
//		long startTime;
//		long endTime;
//		long totalTime;
//		startTime = System.nanoTime();
//		newlist= SortComparison.insertionSort(list1);
//		endTime   = System.nanoTime();
//		totalTime = endTime - startTime;
//		System.out.println("insertionSort "+totalTime);
//		startTime = System.nanoTime();
//		newlist= SortComparison.selectionSort(list2);
//		endTime   = System.nanoTime();
//		totalTime = endTime - startTime;
//		System.out.println("selectionSort "+totalTime);
//		startTime = System.nanoTime();
//		newlist= SortComparison.quickSort(list3);
//		endTime   = System.nanoTime();
//		totalTime = endTime - startTime;
//		System.out.println("quickSort "+totalTime);
//		startTime = System.nanoTime();
//		newlist= SortComparison.mergeSortIterative(list4);
//		endTime   = System.nanoTime();
//		totalTime = endTime - startTime;
//		System.out.println("mergeSortIterative "+totalTime);
//		startTime = System.nanoTime();
//		newlist= SortComparison.mergeSortRecursive(list5);
//		endTime   = System.nanoTime();
//		totalTime = endTime - startTime;
//		System.out.println("mergeSortRecursive "+totalTime);
//
//		
//	}
}
