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
		for (Iterator<BoardBean> iterator = list.iterator(); iterator.hasNext();) {
			BoardBean boardBean = (BoardBean) iterator.next();
			System.out.println(boardBean.toString());
		}
	}
	
	public BoardBean searchBean(int no) {
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
	
	public void saveData() {
		FileManager.getInst().writeFile(list);
	}
	
	@SuppressWarnings("unchecked")
	public void loadData() {
		list = (ArrayList<BoardBean>)FileManager.getInst().readFile();
	}
}
