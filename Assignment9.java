// Assignment #: ASU CSE205 Assignment #9
//         Name: Alan Griffieth
//    StudentID: 1212575453
//      Lecture: MWF 9:40 - 10:30 a.m.
//  Description: this program reads in a sequence of numbers from standard
//  input until 0 is read and stores the numbers in an array, it then
//  compute the largest number, the count of even numbers (includes both postive and negative),
//  the number of -1 inside the array, and also compute the sum of numbers at
//  odd indexes (i.e. 0, 2, 4, ...), using recursion.
//prasad lalsare//
import java.util.*;
import java.io.*;
public class Assignment9
{
	/******************************************************************************
	 ***Complete the main() method. See above program description for details.
	 ******************************************************************************/
	public static void main (String[] args) throws IOException
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>(); //need an ArrayList since we don't know size

		Scanner scan = new Scanner(System.in);
		int number;
			while((number = scan.nextInt()) != 0) {
				numbers.add(number);
			}
		
		int[] numbers2;
		numbers2 = new int[numbers.size()];
		for (int i = 0; i < numbers.size(); i ++) {//converts ArrayList into an array
			numbers2[i] = numbers.get(i);
		}

		System.out.print("The largest number is " + findMax(numbers2, 0, numbers.size() - 1) + "\n");
		System.out.print("The total number of even integers is " + countEven(numbers2, 0, numbers.size() - 1) + "\n");
		System.out.print("The total number of -1 is " + countNegativeOne(numbers2, numbers.size()) + "\n");
		System.out.print("The sum of numbers at odd indexes is " + computeSumAtOddIndexes(numbers2, numbers.size()) + "\n");
		}

		/*************************************************************************************
		 ***(1)Complete the method. The method finds the largest number in the partial array
		 ***range from startIndex to endIndex
		 *************************************************************************************/
		public static int findMax(int[ ] numbers, int startIndex, int endIndex)
		{
			if(endIndex - startIndex == 0) { //we are at index 0
				return numbers[endIndex];
			}

			else  {
				return Math.max(findMax(numbers, startIndex, endIndex - 1), numbers[endIndex]); //return max between number at end of 
																			//array and the max of an array without the last element
			}

		}

		/**************************************************************************************
		 ***(2)Complete the method. The method counts the number of even integers in the partial
		 ***arrya range from startIndex to endIndex
		 *************************************************************************************/
		public static int countEven(int[ ] numbers, int startIndex, int endIndex)
		{
			if(endIndex - startIndex == 0) {
				if(numbers[startIndex]%2 == 0) {
					return 1;
				}

				else {
					return 0;
				}

			}

			else {
				int midIndex = (startIndex + endIndex)/2; //divides the array in half
				int leftEven = countEven(numbers, startIndex, midIndex); //number of even numbers in left half
				int rightEven = countEven(numbers, midIndex + 1, endIndex); //number of even numbers in right half

				return leftEven + rightEven;

			}

		}

		/*************************************************************************************
		 ***(3)Complete the method. The method counts the number of -1 inside an array with
		 ***   "count" numbers, index ranges from 0 to count-1
		 *************************************************************************************/
		public static int countNegativeOne(int[ ] numbers, int count)
		{
			if(count == 1) { //we are at index 0
				if(numbers[0] == -1) {
					return 1;
				}
				
				else {
					return 0;
				}
			}
			
			else {
				if(numbers[count - 1] == -1) {
					return 1 + countNegativeOne(numbers, count - 1); //if number at this is -1, add 1 to total
				}
				
				else {
					return countNegativeOne(numbers, count - 1);
				}
			}
		}

		/**************************************************************************************
		 ***(4)Complete the method. The method computes the sum of numbers at index 1, 3, 5, ...
		 ***  inside a partial array with "count" numbers inside, index ranges from 0 to count-1
		 ***************************************************************************************/
		public static int computeSumAtOddIndexes(int[ ] numbers, int count)
		{
			if(count == 1) { //we are at index 0
				return 0;
			}
			
			else {
				if((count-1)%2 == 0) { //we are at an even index
					return computeSumAtOddIndexes(numbers, count - 1);
				}
				
				else { //we are at an odd index
					return numbers[count - 1] + computeSumAtOddIndexes(numbers, count - 1);
				}
			}
		}


	}// end of class Assignment9
