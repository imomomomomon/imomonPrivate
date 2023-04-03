package bit.app.io;

import java.io.Serializable;

public class Member implements Serializable {
	private String id;
	private transient String name;
	private double height;
	
	public Member() {
		super();
	}

	public Member(String id, String name, double height) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", height=" + height + "]";
	}
	
	
}
