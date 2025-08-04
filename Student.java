class Student {
	private String name;
	private int age;
	private double grade;

	public Student() {
		this.name = "";
		this.age = 0;
		this.grade = 0.0;
	}

	public Student(String name, int age, double grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public double getGrade() {
		return this.grade;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
}