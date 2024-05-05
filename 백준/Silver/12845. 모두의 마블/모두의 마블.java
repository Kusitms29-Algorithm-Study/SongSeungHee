import java.io.*;
import java.util.*;

public class Main {
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> card = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			card.add(Integer.parseInt(st.nextToken()));
		}
		int result = 0;
		while(true) {
			Collections.sort(card, Collections.reverseOrder());
			
			if(card.get(0) > card.get(1)) {
				int v = card.get(0);
				result += card.get(0) + card.get(1);
				card.remove(1);
			} else {
				int lv = card.get(1);
				result += card.get(0) + card.get(1);
				card.remove(0);
			}
			if(card.size() == 1) break;
		}
		
		System.out.println(result);
	}
 
}
 