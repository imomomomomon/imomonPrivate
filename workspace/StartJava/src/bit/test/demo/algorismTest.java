package bit.test.demo;

public class algorismTest {
	public static void main(String[] args) {

		Test a = new Test();
		String[] str = {".#...", "..#..", "...#."};
		
		a.Conversion(str);
		a.Print();
	}
}

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        return answer;
    }
}

class Test {
    int[][] arrWallPaper = new int[51][51];
    int iHeight = 0;
    int iWide = 0;
    
    public void Print() {
    	for(int i =0; i < iHeight; i++) {
    		for (int j = 0; j < iWide; j++) {
				System.out.printf("%2d",arrWallPaper[i][j]);
			}
    		System.out.println();
    	}
    }
    public void Conversion(String[] wallpaper) {
    	
    	iHeight = wallpaper.length;
    	iWide = wallpaper[0].length();
    	
    	int min_Height = -1;
    	int min_Wide = -1;
    	int max_Height = 0;
    	int max_Wide = 0;
    	
        for(int i = 0; i < wallpaper.length; i++) {
        	for (int j = 0; j < wallpaper[i].length(); j++) {
        		if(wallpaper[i].charAt(j) == '#') {
        			arrWallPaper[i][j] = 1;
        			
        			if(min_Wide == -1 && min_Height == -1) {
        				min_Wide = j;
        				min_Height = i;
        			}
        			if(j < min_Wide) min_Wide = j;
        			if(i < min_Height) min_Height = i;
        			if(j > max_Wide) max_Wide = j;
        			if(i > max_Height) max_Height = i;
        		}
			}
        }
        
        System.out.println(min_Height+"/"+min_Wide);
        System.out.println(max_Height+"/"+max_Wide);
    }
}

class Solution2 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        return answer;
    }
    
    public void Check(int[] answers) {
//        int[][] person = new int[3][answers.]
    }
}
