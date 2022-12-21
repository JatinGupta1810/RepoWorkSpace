
import java.util.HashMap;
import java.util.Map;

public class Launch {

	public static void main(String[] args) {

		// 1
		String str1 = "Java Programming";
		System.out.println("**************************************************");
		removeDuplicates(str1);

		// 2
		System.out.println("**************************************************");
		printDuplicates(str1);

		// 3
		String str2 = "1221";
		System.out.println("**************************************************");
		System.out.println("Is it a palindrome: " + isPalindrome(str2));

		// 4
		String str3 = "Java$#Programming*12";
		System.out.println("**************************************************");
		counts(str3);

		// 5
		String str4 = "swalrl ";
		String str5 = "lsrasw";
		System.out.println("**************************************************");
		System.out.println("Is it an anagram: " + isAnagram(str4, str5));

		// 6
		String str6 = "The quick brown fox jumps over the lazy dog";
		System.out.println("**************************************************");
		System.out.println("Is it a panagram: " + isPanagram(str6));

		// 7
		String str7 = "Java";
		System.out.println("**************************************************");
		System.out.println("Is string contains unique characters: " + unique(str7));

		// 8
		String str8 = "Java";
		System.out.println("**************************************************");
		maximumOccurringCharacter(str8);
	}

//	WAP to remove Duplicates from a String.(Take any String str with duplicates character)
	public static void removeDuplicates(String str) {

		if (str == null) {
			System.out.println("str is already null");
			return;
		}

		Map<Character, Integer> map = new HashMap<>();

		String newString = "";
		for (int i = 0; i < str.length(); i++) {

			if (!map.containsKey(str.charAt(i))) {
				newString += str.charAt(i);
				map.put(str.charAt(i), 1);
			}
		}
		System.out.println("String with no duplicates: " + newString);

	}

//	WAP to print Duplicates characters from the String.
	public static void printDuplicates(String str) {

		if (str == null) {
			System.out.println("str is already null");
			return;
		}

		Map<Character, Integer> map = new HashMap<>();

		String newString = "";
		for (int i = 0; i < str.length(); i++) {

			if (map.containsKey(str.charAt(i)))
				newString += str.charAt(i);
			else
				map.put(str.charAt(i), 1);
		}
		System.out.println("String with duplicates: " + newString);

	}

//	WAP to check if “2552” is palindrome or not.
	public static Boolean isPalindrome(String str) {

		String reverseString = "";

		for (int i = str.length() - 1; i >= 0; i--)
			reverseString += str.charAt(i);

		if (reverseString.equals(str))
			return true;
		else
			return false;
	}

//	WAP to count the number of consonants, vowels, special characters in a String.
	public static void counts(String str) {

		String vowels = "";
		String consonants = "";
		String specialCharacters = "";
		String vowel = "aeiou";

		for (int i = 0; i < str.length(); i++) {

			int value = str.charAt(i);

			if (('a' <= value && value <= 'z') || ('A' <= value && value <= 'Z')) {

				if (vowel.contains(String.valueOf(str.charAt(i)))) {
					vowels += str.charAt(i);
				} else
					consonants += str.charAt(i);

			} else
				specialCharacters += str.charAt(i);
		}

		// System.out.println(vowels + ", " + consonants + ", " + specialCharacters);

		System.out.println("Total Vowels: " + vowels.length() + ", Total consonants: " + consonants.length()
				+ ", Total SpecialCharacters: " + specialCharacters.length());
	}

//	WAP to implement Anagram Checking least inbuilt methods being used.
	public static Boolean isAnagram(String str1, String str2) {

		if (str1.length() != str2.length())
			return false;

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {

			if (!map.containsKey(str1.charAt(i)))
				map.put(str1.charAt(i), 1);
			else
				map.put(str1.charAt(i), (map.get(str1.charAt(i)) + 1));
		}

		for (int i = 0; i < str2.length(); i++) {

			if (map.containsKey(str2.charAt(i))) {

				if (map.get(str2.charAt(i)) == 1)
					map.remove(str2.charAt(i));
				else
					map.put(str2.charAt(i), (map.get(str2.charAt(i)) - 1));
			} else
				return false;
		}

		return true;
	}

//	WAP to implement Pangram Checking with least inbuilt methods being used.
	public static Boolean isPanagram(String str) {

		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			int value = str.charAt(i);
			if (65 <= value && value <= 90)
				newStr += (char) (value + 32);
			else if (97 <= value && value <= 122)
				newStr += str.charAt(i);
		}

		boolean[] arr = new boolean[26];
		for (int i = 0; i < newStr.length(); i++) {

			int value = newStr.charAt(i) - 97;
			if (!arr[value])
				arr[value] = true;
		}

		// checking
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i])
				return false;
		}
		return true;
	}

//	WAP to find if String contains all unique characters.
	public static Boolean unique(String str) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			if (map.containsKey(str.charAt(i)))
				return false;
			else
				map.put(str.charAt(i), 1);
		}
		return true;
	}

//	WAP to find the maximum occurring character in a String.
	public static void maximumOccurringCharacter(String str) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			if (map.containsKey(str.charAt(i)))
				map.put(str.charAt(i), (map.get(str.charAt(i)) + 1));
			else
				map.put(str.charAt(i), 1);
		}

		int count = 0;
		char c = ' ';
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {

			if (entry.getValue() > count) {
				count = entry.getValue();
				c = entry.getKey();
			}
		}
		System.out.println("Maximum occurring character is: '" + c + "', occurred " + count + " times.");

	}
}