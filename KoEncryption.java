import java.util.*;
import java.io.*;
import java.nio.charset.*;
import java.lang.System.*;
import java.util.Random;




public class KoEncryption{

	static ArrayList<String> dictionary = new ArrayList<String>();
	static ArrayList<String> permutation_words = new ArrayList<String>();
	static ArrayList<Integer> permutation_nums = new ArrayList<Integer>();

	public KoEncryption(){

		//initialize variables

	}


	public static void main(String args[]) throws IOException{

		KoEncryption ko = new KoEncryption();


		ko.readDictionary(args[0]);
		permutation_nums = generatePermutation();
		permutation_words = permutateDictionary(permutation_nums);	

		//System.out.println(permutation_words);
		for(int i = 0; i < permutation_words.size(); i++){
			System.out.println(permutation_words.get(i));
		}
	}



	public void readDictionary(String filename) throws IOException{
		File input = new File(filename);
		Scanner fileScanner = new Scanner(input);

		while(fileScanner.hasNext()){
			dictionary.add(fileScanner.next());
		}
	}

	public static ArrayList<Integer> generatePermutation(){
		Random rand = new Random();	
		int size = dictionary.size();

		for(int i = 0; i < size; i++){
			int n = rand.nextInt(size-1) + 0;
			permutation_nums.add(n);
		}
		return permutation_nums;
	}

	public static ArrayList<String> permutateDictionary(ArrayList<Integer> perm_num){
		for(int i = 0; i < permutation_nums.size(); i++){
			int n = permutation_nums.get(i);
			permutation_words.add(dictionary.get(n));
		}		
		return permutation_words;
	}

	//convert the permutation_words into ascii values, and do something with that	

}
