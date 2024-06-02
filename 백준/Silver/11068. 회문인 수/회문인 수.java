import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static int[] convertBase(int x, int B) {
		int len = 0, copyX = x;
		while(copyX>0) {
			copyX /= B;
			len++;
		}
		//가장 최대값을 이진법으로 변환한 자릿수가 가장 길이가 긴 진법변환일 것이다 
		int[] digit = new int[len];
		len=0;
		while(x>0) {
			digit[len++] = x % B;
			x /=B;
		}
		return digit;
	}
	public static boolean isPalindrome(int[] digit) {
		for(int i=0; i<digit.length /2; i++) {
			if(digit[i] != digit[digit.length-i-1]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int x = sc.nextInt();
			boolean ans = false;
			for(int i=2; i<=64; i++) {
				int[] digit = convertBase(x,i);
				if(isPalindrome(digit)) {
					ans = true;
					break;
				}
			}
			System.out.println(ans ? "1" : "0");
		}
	}
	
	public static int findCase(long num) {
		for(int B=2; B<=64; B++) {
			String numStr = Long.toString(num, B);
			if(isValid(numStr)) {
				return 1;
			}
		}
		return 0;
	}
	
	public static boolean isValid(String str) {
		int left = 0;
		int right = str.length()-1;
		while(left<right) {
			if(str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
 
}