package bit.app.board;

import java.io.IOException;
import java.util.*;

public class ListEx1 {
	private Scanner scanner = new Scanner(System.in);
	public void add() {
		BoardBean bean = new BoardBean();
		{//고유번호 받기
			int no = 0;
			boolean flag = false;
			while(!flag) {
				System.out.print("No :");
				no = insertInteger();
				if(no == -1) {
					continue;
				}
				
				flag = ListDao.getInst().noCheck(no);
				if(flag == false) {
					System.err.println("중복된 숫자입니다.");
					System.err.println("다시 입력해주십시오.");
					System.out.println();
				}
			}
			bean.setNo(no);
		}
		
//		System.out.print("Title :");
//		String title = scanner.next();
//		bean.setTitle(title);
//		System.out.print("Writer :");
//		String writer = scanner.next();
//		bean.setWriter(writer);
//		System.out.print("Contents :");
//		String contents = scanner.next();
//		bean.setContents(contents);
//		System.out.print("Password :");
//		String password = scanner.next();
//		bean.setPassword(password);
		Calendar c = Calendar.getInstance();
		String regdate = 
				String.valueOf(c.get(Calendar.YEAR)).concat(
						String.valueOf(c.get(Calendar.MONTH)+1)).concat(
								String.valueOf(c.get(Calendar.DATE)));
		bean.setRegdate(regdate);
		ListDao.getInst().insertList(bean);
		System.out.println(bean);
	}
	public void list() {
		ListDao.getInst().showList();
	}
	public void info() {
		BoardBean result = search();
		if(result != null) {
			System.out.println(result.toString());
		}
	}
	public void modify() {
		BoardBean result = search();
		if(result != null) {
			System.out.print("Title :");
			String title = scanner.next();
			result.setTitle(title);
			System.out.println(result.toString());
		}
	}
	public void delete() {
		BoardBean result = search();
		if(result != null) {
			if(ListDao.getInst().deleteBean(result)) {
				System.out.println("삭제완료");
			}
			else
				System.out.println("삭제실패");
		}
	}
	public void menu() {
		while (true) {
			System.out.println(
					"1.Add 2.List 3.Info 4.Modify "
					+ "5.Delete 6.Save 7.Open 8.Exit"
					);
			int index = insertInteger();
			if(index == -1)
				continue;
			
			switch (index) {
			case 1: {
				add();
				break;
			}
			case 2: {
				list();
				break;
			}
			case 3: {
				info();
				break;
			}
			case 4: {
				modify();
				break;
			}
			case 5: {
				delete();
				break;
			}
			case 6: {
				ListDao.getInst().saveData();
				break; 
			}
			case 7: {
				ListDao.getInst().loadData();
				break;
			}
			case 8: {
				System.out.println("Program Terminate");
				return;
			}
			default:
			}
		}
		
	}
	private BoardBean search() {
		BoardBean result = ListDao.getInst().searchBean(insertNo());
		
		if(result == null) {
			System.out.println("입력된 값의 Bean이 존재하지 않습니다.");
			System.out.println();
		}
		
		return result;
	}
	private int insertNo() {
		int no = 0;
		System.out.print("No :");
		no = insertInteger();
		
		return no;
	}
	private int insertInteger() {
		int value = -1;
		try {
			value = scanner.nextInt();
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.err.println("숫자가 아닌 값을 입력하셨습니다.");
			System.err.println("다시 입력해주십시오.");
			System.out.println();
			scanner.nextLine();
		}
		
		return value;
	}
	public static void main(String[] args) throws IOException {
		ListEx1 ex = new ListEx1();
		ex.menu();
	}
}
