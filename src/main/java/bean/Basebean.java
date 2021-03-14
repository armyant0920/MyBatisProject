package bean;

public class Basebean {
	
	int id;
	String name;
	String name2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Basebean [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", name2=");
		builder.append(name2);
		builder.append("]");
		return builder.toString();
	}
	
	

}
