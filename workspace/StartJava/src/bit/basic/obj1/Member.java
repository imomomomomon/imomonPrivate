package bit.basic.obj1;
/*
 * (alt + shift + s) + o
 * (alt + shift + s) + r getter,setter
 * (alt + shift + s) + s toString
 * (alt + shift + s) + v Override
 */

public class Member {
	public static void main(String[] args) {
		System.out.println(new MemberInfo(
				"이도경","imomon93","imomon93@gmail.com",0
				).toString());
	}
}

class MemberInfo {
	private String name;
	private String id;
	private String email;
	private int countValue;
	
	public MemberInfo() {
		super();
	}

	public MemberInfo(String name, String id, String email, int countValue) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.countValue = countValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCountValue() {
		return countValue;
	}

	public void setCountValue(int countValue) {
		this.countValue = countValue;
	}

	@Override
	public String toString() {
		return "MemberInfo [name=" + name + ", id=" + id + ", email=" + email + ", countValue=" + countValue + "]";
	}
	
}
