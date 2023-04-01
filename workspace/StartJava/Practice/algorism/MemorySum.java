package algorism;

import java.util.Arrays;
import java.util.HashMap;

public class MemorySum {
	public static void main(String[] args) {
		MemorySum ex = new MemorySum();
		
		{
			String[] name = {"may", "kein", "kain", "radi"};
			int[] yearning = {5, 10, 1, 3};
			String[][] photo = {{"may", "kein", "kain", "radi"},
								{"may", "kein", "brin", "deny"}, 
								{"kon", "kain", "may", "coni"}};
			
			int []result = ex.solution2(name, yearning, photo);
			System.out.println(Arrays.toString(result));
		}
	}
	
	//Array만으로 해결
	public int[] solution(String[] name, int[] yearning, String[][] photo)
	{
		int [][]cnt = new int[photo.length][];
		
		for (int i = 0; i < photo.length; i++) {
			cnt[i] = new int[name.length];
			for (int j = 0; j < photo[i].length; j++) {
				for (int k = 0; k < name.length; k++) {
					if(photo[i][j].equals(name[k])) {
						cnt[i][k] += yearning[k];
						break;
					}
				}
			}
		}
		
		int []sol = new int[photo.length];
		
		for (int i = 0; i < cnt.length; i++) {
			for (int j = 0; j < cnt[i].length; j++) {
				sol[i] += cnt[i][j];
			}
		}
		
		return sol;
	}
	
	//해쉬맵 사용
	public int[] solution2(String[] name, int[] yearning, String[][] photo)
	{
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(int i = 0; i < name.length; i++)
			hm.put(name[i], yearning[i]);
		
		int []answer = new int[photo.length];
		
		for(int i = 0; i < photo.length; i++) {
			for(int j = 0; j < photo[i].length; j++) {
				if(hm.containsKey(photo[i][j])) {
					answer[i] += hm.get(photo[i][j]);
				} 
			}
		}
		
		
		return answer;
	}
}
