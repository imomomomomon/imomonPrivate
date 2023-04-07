package bit.app.board;

import java.io.IOException;
import java.util.*;

public class BoardEX {
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
		System.out.print("Password :");
		String password = scanner.next();
		bean.setPassword(password);
		
		insertBeanValue(bean);
		ListDao.getInst().insertList(bean);
	}
	public void list() {
		ListDao.getInst().showList();
	}
	public void info() {
		BoardBean result = search();
		if(result != null) {
			System.out.println();
			System.out.println("No : " + result.getNo() 
							+ "/ Writer : " + result.getWriter());
			System.out.println("Pass : " + result.getPassword());
			System.out.println("Date : " + result.getRegdate());
			System.out.println("-Contents-");
			System.out.println(result.getContents());
			System.out.println();
		} else {
			System.err.println("찾으시는 값이 없습니다.");
		}
	}
	public void modify() {
		BoardBean result = checkPassword();
		if(result != null) {
			insertBeanValue(result);
		}
	}
	public void delete() {
		BoardBean result = checkPassword();
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
					+ "5.Delete 6.Save 7.Exit"
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
				if(ListDao.getInst().saveData())
					System.out.println("파일저장성공");
				else
					System.out.println("파일저장실패");
				break; 
			}
			case 7: {
				System.out.println("Program Terminate");
				return;
			}
			default:
				System.err.println("번호를 잘못 입력하셨습니다.");
			}
		}
		
	}
	private BoardBean search() {
		BoardBean result = ListDao.getInst().searchBean(insertNo());
		return result;
	}
	private int insertNo() {
		int no = 0;
		System.out.print	("No :");
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
	private BoardBean checkPassword() {
		BoardBean temp = search();
		if(temp == null) {
			System.err.println("찾으시는 값이 없습니다.");
			return null;
		}
		
		System.out.print("Password :");
		String password = scanner.next();
		if(password.equals(temp.getPassword())) {
			return temp;
		} else 			
			System.err.println("비밀번호가 틀렸습니다.");
		
		return null;
	}
	private void insertBeanValue(BoardBean bean) {
		System.out.print("Title :");
		String title = scanner.next();
		bean.setTitle(title);
		System.out.print("Writer :");
		String writer = scanner.next();
		bean.setWriter(writer);
		{
			System.out.println("Contents : 마지막 단어 [^]입력시 종료");
			String content = "";
			while(true) {
				content += scanner.next();
				if(content.charAt(content.length()-1) == '^')
					break;
				content += "\n";
			}
			bean.setContents(content);
		}
		Calendar c = Calendar.getInstance();
		String regdate = 
				String.valueOf(c.get(Calendar.YEAR)).concat(
						String.valueOf(c.get(Calendar.MONTH)+1)).concat(
								String.valueOf(c.get(Calendar.DATE)));
		bean.setRegdate(regdate);
	}
	public static void main(String[] args) throws IOException {
		BoardEX ex = new BoardEX();
		ListDao.getInst().loadData();
		ex.menu();
	}
}
