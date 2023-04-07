package bit.app.board;

import java.util.ArrayList;
import java.util.Iterator;

public class ListDao {
	private ListDao() {}
	private static ListDao inst = null;
	public static ListDao getInst() {
		if(inst == null)
			inst = new ListDao();
		return inst;
	}
	
	private final String path = "test.dat";
	private ArrayList<BoardBean> list = 
			new ArrayList<BoardBean>();
	
	public boolean noCheck(int value) {
		if (list.isEmpty()) return true;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo()==value)
				return false;
		}
		return true;
	}
	public void insertList(BoardBean bean) {
		list.add(bean);
	}
	
	public void showList() {
		if(list.isEmpty()) System.err.println("자료가 없습니다.");
		for (Iterator<BoardBean> iterator = list.iterator(); iterator.hasNext();) {
			BoardBean boardBean = (BoardBean) iterator.next();
			System.out.println("No: " + boardBean.getNo() 
			+ "/ title : "+ boardBean.getTitle()
			+ "/ date : "+ boardBean.getRegdate());
		}
	}
	
	public BoardBean searchBean(int no) {
		if(list.isEmpty()) return null;
		for (Iterator<BoardBean> iterator = list.iterator(); iterator.hasNext();) {
			BoardBean boardBean = (BoardBean) iterator.next();
			if(boardBean.getNo() == no)
				return boardBean;
		}
		return null;
	}
	
	public boolean deleteBean(int no) {
		BoardBean bean = searchBean(no);
		return list.remove(bean);
	}
	
	public boolean deleteBean(BoardBean bean) {
		return list.remove(bean);
	}
	
	public boolean saveData() {
		return FileManager.getInst().writeFile(list,path);
	}
	
	@SuppressWarnings("unchecked")
	public void loadData() {
		System.out.println("절대경로/"+ path +" 로드 중..");
		
		Object temp = FileManager.getInst().readFile(path);
		if(temp == null)
			System.err.println("파일이 존재하지 않습니다.");
		else {
			list = (ArrayList<BoardBean>)temp;
			System.out.println("파일로드성공");
		}
	}
}
