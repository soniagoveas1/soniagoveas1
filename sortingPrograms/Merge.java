import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Merge{
	public static void main(String[] args) throws FileNotFoundException{
		if(args.length != 3){
			System.err.println("Expected 3 arguments, but got " + args.length);
			System.exit(0);
		}
		File f1 = null;
		File f2 = null;
		File f3 = null;
		try{
			f1 = new File(args[0]);
			f2 = new File(args[1]);
			f3 = new File(args[2]);
		} catch(Exception exception){
			System.err.println("ERROR! No file path could be detected!");
		}
		Scanner input1 = new Scanner(f1);
		Scanner input2 = new Scanner(f2);
		Scanner input3 = new Scanner(f3);
		ArrayList<Integer> numbersFile1 = new ArrayList<>();
		ArrayList<Integer> numbersFile2 = new ArrayList<>();
		ArrayList<Integer> numbersFile3 = new ArrayList<>();
		
		while(input1.hasNextInt()){
			int temp = input1.nextInt();
			numbersFile1.add(temp);
		}
		input1.close();
		while(input2.hasNextInt()){
			int temp = input2.nextInt();
			numbersFile2.add(temp);
		}
		input2.close();
		while(input3.hasNextInt()){
			int temp = input3.nextInt();
			numbersFile3.add(temp);
		}
		input3.close();
		mergeSort(numbersFile1, numbersFile2, numbersFile3);
	}
	static void mergeSort(ArrayList<Integer> f1, ArrayList<Integer> f2, ArrayList<Integer> f3){
		ArrayList<Integer> nums = new ArrayList<>();
		nums.addAll(f1);
		nums.addAll(f2);
		nums.addAll(f3);
		
		for(int i = 0; i < nums.size(); i++){
			for(int j = 0; j < nums.size() - 1 - i; j++){
				if(nums.get(j) > nums.get(j + 1)){
					nums.set(j, nums.get(j + 1));
					nums.set(j + 1, nums.get(j));
				}
			}
		}
		System.out.println(nums);
	}
}