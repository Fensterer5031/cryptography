import java.util.Scanner;
import java.util.Random;

public class ClassicalCryptography {
	/*
	 * CSI 426 HomeWork 1
	 * Aaron Fensterer
	 */

	public static void main(String[] args) {
		
		System.out.println("Please enter plaintext to encrypt: ");
		
		 // plainText is the message to encrypt
		 
		Scanner scan = new Scanner(System.in);
		String plainText = scan.nextLine();
		scan.close();
		
		
		// remove whitespace, change to lower case and display the original message
		plainText = plainText.replaceAll("\\s", "").toLowerCase();
		System.out.println("Your message to encrypt is: " + plainText);
		
		//the string that will hold the ciphertext as operations are continuously performed on it
		String cipherText = "";
		
		//to go through the user's message, the string is converted to a char array
		//so that we can work on each letter independently
		char[] plainTextArray = plainText.toCharArray();
		
		
		//this loop goes through each character of the plaintext and shifts each
		//letter by the same amount
		for(char originalCharacter : plainTextArray) {
			
			//we cast the character to an integer so we can use math to perform the shift
			int asciiValue = (int) originalCharacter;
			
			//this println shows what the original character's ascii value is (in decimal)
			System.out.print(originalCharacter + "("+asciiValue+")");
			//asciiValue mod 26 will keep us in the range of letters and wrap indices
			asciiValue = (asciiValue%26) + 97;
			// output will be in the range 97 to 122 (asciis values a-z)
			
			//newChar is the new letter of each character from the original user input
			char newChar = (char)asciiValue;
			
			//this output allows you to see what the new ascii value is compared to the original
			System.out.print("= " + newChar +"("+asciiValue+")\n");
			//System.out.println();
			
			//creating the ciphertext string as we go along
			cipherText += Character.toString(newChar);
			
		}
		
		//now we wish to take the current ciphertext string and convert it 
		//to a character array and then convert that array to a 2 dimensional array
		char[] initialCipherTextArray  = cipherText.toCharArray();
		char [][] cipher2dArray = new char[10][10];
		//System.out.println(initialCipherArray.length);
		
		//int k will allow linear progression through initialciphertextarray
		//as we add values to the 2 dimensional cipher text array in this for loop
		int k=0;
		for(int i = 0; i < 10; i++){
			//System.out.println();
			for (int j = 0; j < 10; j++) {
				
				if(k < cipherText.length()) {
				cipher2dArray[i][j] = initialCipherTextArray[k];
				//System.out.print(cipher2dArray[i][j]+ " ");
				}
				//now we append randomly generated letters to fill out the rest of the array.  
				//These will later be threaded throughout the ciphertext to stifle 
				//cryptanayltic attacks such as natural letter frequency.
				
				else {
					Random randomletter = new Random();
					char c = (char) (randomletter.nextInt(26) + 'a'); 
					cipher2dArray[i][j] = c;
					cipherText += Character.toString(c);
					//System.out.print(cipher2dArray[i][j] + " ");
				}
				k++;
				
			}
		}
		
		System.out.println("\n\nAfter substitution, encrypted message is currently:\n" + cipherText + "\n");
		
		 //creating transposed array from plaintext(no substitution)
		char plainText2dArray[][] = new char [10][10];
		int p = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(p < plainText.length()) {
				plainText2dArray[i][j] = plainTextArray[p];
				}
				else {
					Random randomletter = new Random();
					char c = (char) (randomletter.nextInt(26) + 'a');
					plainText2dArray[i][j] = c;
					plainText += Character.toString(c);
				}
				p++;
			}
		}
		
		//this for loop performs the transposition on the plaintext
		//and stores it in transposedArray
		int m =0;
		char[][] transposedArray = new char[10][10];
		for(int columns = 9; columns >= 0; columns--) {
			int n = 0;
			for(int rows = 0; rows < 10; rows++) {
				transposedArray[rows][columns] = plainText2dArray[m][n];
				n++;
			}
			m++;
		}
		
		//plaintext is output as a 10x10 array with randomized letters to fill any unused postitions
		//ciphertext is reset and then updated with the cipher generated by transposition
		cipherText = "";
		System.out.println("Plaintext array is: ");
		for(int i = 0; i < 10; i++) {
			System.out.println();
			for(int j =0; j < 10; j++) {
				cipherText += transposedArray[i][j];
				System.out.print(plainText2dArray[i][j] + " ");
			}
		}
		System.out.println("\n\nYour plaintext after transposition(no substitution):\n" + cipherText);
		
		//the 2dcipherarray is then copied by inverting the rows and columns, the ordering is also changed
		char productCipherArray [][] = new char [10][10];
		System.out.print("\n\nThe product array is: ");
		int x =0;
		for(int columns = 9; columns >= 0; columns--) {
			int n = 0;
			for(int rows = 0; rows < 10; rows++) {
				productCipherArray[rows][columns] = cipher2dArray[x][n];
				n++;
			}
			x++;
		}
		//printing the new array with permuted rows
		//and updating our ciphertext by using the transposed array
		cipherText = "";
		for(int i = 0; i < 10; i++){
			System.out.println();
			for (int j = 0; j < 10; j++) {
				System.out.print(productCipherArray[i][j] + " ");
				cipherText += productCipherArray[i][j];
			}
		}
		
		
		System.out.println();
		System.out.println("\nYour encrypted message after transposition with random letter generator(product) is:\n\n" + cipherText);
		System.out.print("\nYour original message was:\n\n ");
		System.out.println(plainText); 
		//transposition1[0][0]= 'a';
		//System.out.println(transposition1[0][0]);
		
		
		}
		
	}

