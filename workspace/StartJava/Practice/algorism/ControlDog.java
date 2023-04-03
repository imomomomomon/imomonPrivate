package algorism;

import java.util.Arrays;

public class ControlDog {
	public static void main(String[] args) {
		ControlDog ex = new ControlDog();
		
		String []park = {"SOOOO","OXXOO","OOXOO", "XOOOX"};
		String []routes = {"N 2","S 2","W 1", "S 3", "E 3"};
		
		int []answer = ex.solution(park, routes);
		System.out.println(Arrays.toString(answer));
	}
	
	public int[] solution(String[] park, String[] routes) {
		
		int []answer = new int[2]; //pos x,y
		
		for(int i = 0; i <  park.length; i++){
			int search = park[i].indexOf('S');
			if(search != -1) {
				answer[0] = i;
				answer[1] = search;
				break;
			}
		}
		
		for (int i = 0; i < routes.length; i++) {
			
			char dir = routes[i].charAt(0);
			int mov = Integer.valueOf((routes[i].split(" ")[1]));
			
			switch (dir) {
			case 'N':
				if(answer[0]-mov < 0)
					break;
				checkObs(park,answer,0,-mov);
				break;
			case 'S':
				if(answer[0]+mov >= park.length)
					break;
				checkObs(park,answer,0,mov);
				break;
			case 'W':
				if(answer[1]-mov < 0)
					break;
				checkObs(park,answer,1,-mov);
				break;
			case 'E':
				if(answer[1]+mov >= park[answer[1]].length())
					break;
				checkObs(park,answer,1,mov);
				break;
			}
		}
		
		return answer;
	}
	
	public void checkObs(String[] park,int[] answer, int pos, int inc) {
		
		if(pos == 0) {
			for (int i = 0; i < inc; i++) {
				if ((answer[0]-1 > 0 && answer[0] + 1 < park.length)) {
					//if(park[i].charAt(answer[1]) == 'X')
				}
			}
		} else if (pos == 1) {
		}
	}
}
