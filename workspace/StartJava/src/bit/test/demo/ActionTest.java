package bit.test.demo;

import java.util.Scanner;

/*
 * 식당이라는 클래스안에서 식사를 하기 위해서
 * 로컬변수는 정해진 시간 식권 -> 점심 저녁 따로 끊어야함.
 * 인스턴스변수는 회원제 식권 -> 회원으로만 등록해야 나오는 식권
 * 스태틱변수는 선물받은 식권? -> 식당을 이용하는 누구나 가능
 * 
 */

public class ActionTest {
	public static void main(String[] args) {
		//Calculation Days
		{
			DayCalculation d1 = new DayCalculation();
			d1.inputData();
		}
		
	}

	private static void ActionFor(char cChar, int iStarNum) {
		for(int i = 0; i < iStarNum; i++)
			PrintCharPlus(cChar,i);
	}
	private static void PrintCharPlus(char cChar, int iCount) {
		String charPlus = "";
		for(int i = 0; i < iCount + 1; i++)
			charPlus += cChar;
		
		System.out.println(charPlus);
	}
}

class DayCalculation{

	private String[] strDays = { "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"};
	private int iYear = 0;
	private int iMonth = 0;
	private int iDay = 0;
	
	public void inputData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("연도를 입력해주세요");
		iYear = sc.nextInt();
		System.out.println("월수를 입력해주세요");
		iMonth = sc.nextInt();
		System.out.println("일수를 입력해주세요");
		iDay = sc.nextInt();
	
		printDay();
	}
	
	private void printDay(){
		int result = calculation(1993,7,7);
		System.out.println(
				iYear + "년 " + iMonth + "월 " + iDay + "일의 요일은 "
				+ strDays[result != 0 ? result-1 : strDays.length - 1 ]);
	}
	private int calculation(int iyear, int imonth, int iday){
		int days_year = ((iyear-1) * 365) + calculLeapmoon(iyear-1);
		int days_month = calculMonthToDay(iyear, imonth);
		
		int result = days_year + days_month + iday;
		return result % 7;
	}
	private int calculLeapmoon(int iyear){
		return ((iyear / 4) - (iyear / 100) + (iyear / 400));
	}
	private boolean checkLeapmoon(int iyear){
		return iyear % 4 == 0 && iyear % 100 !=0 || iyear % 400==0;
	}
	private int calculMonthToDay(int iyear, int imonth) {
		int result = 0;
		
		for(int i = 1; i < imonth; i++){
			switch (i) {
			case 2:
				if(checkLeapmoon(iyear))
					result += 29;
				else
					result += 28;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				result += 30; break;
			default:
				result += 31;
			}
		}
		
		return result;
	}
}
