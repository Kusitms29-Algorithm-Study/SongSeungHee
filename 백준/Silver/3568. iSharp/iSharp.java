import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine().replace(",", "").replace(";", "");
		String[] str = origin.split(" ");
		for(int i=1; i<str.length; i++) {
			System.out.println(str[0] + reverse(str[i]) + ";");
		}
		
		
		
	}	
	static String reverse(String str) {
		char[] origin = str.toCharArray();
		String result = "";
		for(int i=str.length()-1; i>=0; i--) {
			if(origin[i] != ']') {
				if(origin[i] == '*' || origin[i] == '&') {
					result += origin[i];
				} else {
					//알파벳의 경우 역순으로 해서는 안된
					//끝에서 알파벳 시작하는 부분을 발견함 
					result += " ";
					for(int j=0; j<=i; j++) {
						result += origin[j];
					}
					break;
				}
			} else {
				// ]을 만났다 
				result += "[]";
				i--;
			}
		}
		return result;
	}

}