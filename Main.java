public class Main {
	static Scanner s = new Scanner(System.in);
	static ArrayList<Student> studentData = new ArrayList<>();

	public static void main(String[] args) {
		boolean isUsing = true;

		do {
			System.out.println("------------------------------" +
							   "\nStudent Record System:" +
							   "\n1.) Add Student" +
							   "\n2.) View Student" +
							   "\n3.) Update Student" +
							   "\n4.) Delete Student" +
							   "\n5.) Exit" +
							   "\n------------------------------");

			System.out.print("Select: ");
			String input = s.nextLine();
			if(!isInteger(input)){
			    System.out.println("Invalid Input! Try Again.");
			    continue;
			}
			
			int choice = Integer.parseInt(input);

			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				viewStudent();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				deleteStudent();
				break;
			case 5:
				isUsing = false;
				break;
			default:
				System.out.println("Invalid Input! Try Again");
			}
		} while (isUsing);
	}

	public static void addStudent() {
		String input = null;
		String studName = null;
		int studAge = -1;
		double studGrade = -1;

		while (true) {
			if (studName == null) {
				System.out.print("Enter Student Name: ");
				studName = s.nextLine();
			}

			if (studAge == -1) {
				System.out.print("Enter Student Age: ");
				input = s.nextLine();
				if (!isInteger(input)) {
					System.out.println("Invalid Input! Try Again.");
					continue;
				}
				studAge = Integer.parseInt(input);
			}

			if (studGrade == -1) {
				System.out.print("Enter Student Grade: ");
				input = s.nextLine();
				if (!isDouble(input)) {
					System.out.println("Invalid Input! Try Again.");
					continue;
				}
				studGrade = Integer.parseInt(input);
				if (studGrade < 0 || studGrade > 100) {
					System.out.println("Your Grade is either too low or too high. Try Again.");
					studGrade = -1;
					continue;
				}
			}

			break;
		}

		Student newStud = new Student(studName, studAge, studGrade);
		studentData.add(newStud);

		System.out.println("Student Info Added");

	}

	public static void viewStudent() {
		if (!isEmpty()) {
			viewStudentList();
		} else {
			System.out.println("Student Data is Empty.");
		}
	}

	public static void updateStudent() {
		if (!isEmpty()) {
			do {
				viewStudentList();
				System.out.print("Select a Student No. to Update: ");
				int choice = s.nextInt();
				s.nextLine();

				if (choice <= studentData.size() && choice > 0) {
					Student prevStud = studentData.get(choice - 1);
					String input = null;
					String newName = null;
					int newAge = -1;
					double newGrade = -1;

					while (true) {
						if (newName == null) {
							System.out.print("Enter Student Name: ");
							newName = s.nextLine();
						}

						if (newAge == -1) {
							System.out.print("Enter Student Age: ");
							input = s.nextLine();
							if (!isInteger(input)) {
								System.out.println("Invalid Input! Try Again.");
								continue;
							}
							newAge = Integer.parseInt(input);
						}

						if (newGrade == -1) {
							System.out.print("Enter Student Grade: ");
							input = s.nextLine();
							if (!isDouble(input)) {
								System.out.println("Invalid Input! Try Again.");
								continue;
							}
							newGrade = Integer.parseInt(input);
							if (newGrade < 0 || newGrade > 100) {
								System.out.println("Your Grade is either too low or too high. Try Again.");
								newGrade = -1;
								continue;
							}
							break;
						}
					}

					prevStud.setName(newName);
					prevStud.setAge(newAge);
					prevStud.setGrade(newGrade);
					System.out.println("Student Info Updated");
					break;
				} else if (choice == 0) {
					break;
				} else {
					System.out.println("Invalid Input! Try Again");
				}
			} while (true);
		} else {
			System.out.println("Student Data is Empty.");
		}
	}

	public static void deleteStudent() {
		if (!isEmpty()) {
			do {
				viewStudentList();
				System.out.print("Select a Student No. to Delete: ");
				String input = s.nextLine();

				if (!isInteger(input)) {
					System.out.println("Invalid Input! Try Again.");
					continue;
				}

				int choice = Integer.parseInt(input);

				if (choice <= studentData.size() && choice > 0) {
					studentData.remove(choice - 1);
					System.out.println("Student Info Deleted");
					break;
				} else if (choice == 0) {
					break;
				} else {
					System.out.println("Invalid Input! Try Again");
				}
			} while (true);
		} else {
			System.out.println("Student Data is Empty.");
		}
	}

	public static void viewStudentList() {
		System.out.println("------------------------------");
		System.out.printf("%-5s %-15s %-5s %-5s \n", "No.", "Student", "Age", "Grade");
		for (int i = 0; i < studentData.size(); i++) {
			String studName = studentData.get(i).getName();
			int studAge = studentData.get(i).getAge();
			double studGrade = studentData.get(i).getGrade();
			System.out.printf("%-5d %-15s %-5d %-5.2f \n", i + 1, studName, studAge, studGrade);
		}
		System.out.println("------------------------------");
	}

	public static boolean isEmpty() {
		return studentData.size() == 0;
	}

	public static boolean isInteger(String text) {
		int result;
		try {
			result = Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isDouble(String text) {
		double result;
		try {
			result = Double.parseDouble(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}