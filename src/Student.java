
public class Student {
	private String name;
	private String lifestyleType;
	
	public Student(String name, String lifestyleType) {
		this.name = name;
		this.lifestyleType = lifestyleType;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLifestyleType() {
		return lifestyleType;
	}
	
	public String toString() {
		return name + " (" + lifestyleType + ")";
	}
}
