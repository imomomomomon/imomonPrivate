package bit.basic.obj1;

import java.time.LocalDate;

public class ObjectEx3 {
	public static void main(String[] args) {
		String []member = {
				"이도경#910110-1010671#051)134-1678",
				"고양이#980510-1010672#02)234-2678",
				"이영재#930910-2010673#031)334-3678",
				"김석삼#031210-3010674#052)434-4678",
				"김재용#080710-4010675#061)534-5678"
				};
		ObjectEx3 obj = new ObjectEx3();
		
		DataInfo []data = new DataInfo[member.length];
		{
			for (int i = 0; i < data.length; i++) {
				data[i] = new DataInfo(member[i]);
			}
			obj.sorting_selection(data, 1);
			//출력
			for (int i = 0; i < data.length; i++) {
				data[i].Print();
			}
		}
		
		
		System.out.println("평균나이 :" + obj.averageAge(data));
		System.out.println(obj.Getsurnames(data));
	}
	
	public void sorting_selection(DataInfo []data,int order) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i+1; j < data.length; j++) {
				if(order == 0) { //내림차순
					if(data[i].getBirth().getOld()
							< 
							data[j].getBirth().getOld()) {
						swap(data,i,j);
					}
				} else {
					if(data[i].getBirth().getOld() 
							> 
						data[j].getBirth().getOld()) { //오름차순
						swap(data,i,j);
					}
				}
			}
		}
	}
	
	public void swap(DataInfo []data,int front, int back)
	{
		DataInfo temp = null;
		temp = data[front];
		data[front] = data[back];
		data[back] = temp;
	}
	
	public int averageAge(DataInfo[] arrdata) {
		int sum = 0;
		for(int i = 0; i < arrdata.length; i++)
			sum += arrdata[i].getBirth().getOld();
		
		return sum / arrdata.length;
	}
	
	public String Getsurnames(DataInfo[] arrdata) {
		char []surnames = new char[arrdata.length];
		{//중복값 제외 배열 생성
			int cnt = 0;
			for(int i = 0; i < arrdata.length; i++) {
					char chTemp = arrdata[i].getName().charAt(0);
					for (int j = 0; j < arrdata.length; j++) {
						if(surnames[j] == chTemp) 
							break;
						if(surnames[j] == 0) {
							surnames[cnt] = chTemp;
							cnt++;
							break;
						}
					}
			}
		}		
		int []surnamesCnt = new int[arrdata.length];
		{
			{//배열 2개 비교로 각 원소마다 중복원소 체크
				int max = 0;
				for (int i = 0; i < surnames.length; i++) {
					for (int j = 0; j < surnames.length; j++) {
						if(arrdata[i].getName().charAt(0) == surnames[j]) {
							surnamesCnt[j]++;
							if(surnamesCnt[j] > max) max = surnamesCnt[j];
							break;
						}
					}
				}
			}
		}
		String result = "";
		{//출력
			for (int i = 0; i < surnames.length; i++) {
				if(surnames[i] == 0) break;
				result += surnames[i] + ":" + Integer.toString(surnamesCnt[i]) + " ";
					
			}
		}
		
		return result;
	}
}

//이름,나이,생일,지역,띠,나이평균,나이별로 정렬,성씨별 인원수
class DataInfo {
	private String name ="";
	private String oriNum="";
	private String number="";
	private String addr="";
	private Birth birth=null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Birth getBirth() {
		return birth;
	}
	public void setBirth(Birth birth) {
		this.birth = birth;
	}

	public DataInfo(String info) {
		int cnt = 0;
		for(int i = 0; i < info.length(); i++)
		{
			if(info.charAt(i) == '#') {
				cnt++;
				i++;
			}
			switch (cnt) {
			case 0:
				this.name += info.charAt(i);
				break;
			case 1:
				this.oriNum += info.charAt(i);
				break;
			case 2:
				this.number += info.charAt(i);
				break;
			default:
				break;
			}
		}
		
		insertAddr();
		insertBirth();
	}

	public void Print() {
		System.out.println(
				"이름:"+ name +
				" 나이:"+ birth.getOld() +
				" 생일:"+ birth.getBirth_year() + "년 "
					+ birth.getBirth_month() + "월 "
					+ birth.getBirth_day() + "일" +
				" 띠:" + birth.getDdi() +
				" 지역:"+ addr
		);
	}
	
	private void insertAddr() {
		String strTemp = "";
		int	value = 0;
		for(int i = 0; i < this.number.length(); i++) {
			char chTemp = this.number.charAt(i);
			if(chTemp == '0') {
				i++;
				chTemp = this.number.charAt(i);
			}
			if(chTemp == ')' )
				break;
			strTemp += chTemp;
		}
		value = Integer.valueOf(strTemp);
		
		switch (value) {
		case 2:
			this.addr = "서울";
			break;
		case 31:
			this.addr = "인천";
			break;
		case 51:
			this.addr = "부산";
			break;
		case 52:
			this.addr = "울산";
			break;
		default:
			this.addr = null;
			break;
		}
	}
	
	private void insertBirth() {
		birth = new Birth(oriNum);
	}
	
}

class Birth {
	private int birth_year = 0;
	private int birth_month = 0;
	private int birth_day = 0;
	private int old = 0;
	private String ddi = "";
	
	private final static int limitBirthNum = 6;
	private final static int currentYear = LocalDate.now().getYear();
	
	public Birth(int birth_year, int birth_month, int birth_day) {
		this.birth_year = birth_year;
		this.birth_month = birth_month;
		this.birth_day = birth_day;
	}
	
	public Birth(String oriNum) {
		
		int temp = Integer.valueOf(oriNum.substring(0, limitBirthNum));
		{//생년월일
			birth_day = temp % 100;
			birth_month = (temp % 10000) - birth_day;
			birth_year = temp - (birth_day + birth_month);
			
			birth_month = birth_month / 100;
			birth_year = birth_year / 10000;
			
			int millennium = 
					Character.getNumericValue(oriNum.charAt(7));
			if(millennium == 1 || millennium == 2)
				birth_year += 1900;
			else
				birth_year += 2000;
		}
		
		old = currentYear - birth_year + 1;
		
		{//띠
			String []ddiData = {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
			ddi = ddiData[birth_year%12];
		}
	}
	
	public int getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}

	public int getBirth_month() {
		return birth_month;
	}

	public void setBirth_month(int birth_month) {
		this.birth_month = birth_month;
	}

	public int getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(int birth_day) {
		this.birth_day = birth_day;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	@Override
	public String toString() {
		return "Birth [birth_year=" + birth_year + ", birth_month=" + birth_month + ", birth_day=" + birth_day + "]";
	}
}