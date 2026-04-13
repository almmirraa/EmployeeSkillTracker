import model.*;
import service.EmployeeManager;
import util.FileManager;
import util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeManager manager = new EmployeeManager();

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> manager.showAllEmployees();
                case 3 -> updateEmployee();
                case 4 -> deleteEmployee();
                case 5 -> addSkill();
                case 6 -> manager.showEmployeesWithSkills();
                case 7 -> FileManager.saveToFile(manager.getAllEmployees(), "data.txt");
                case 8 -> {
                    List<Employee> loaded = FileManager.loadFromFile("data.txt");
                    for (Employee e : loaded) {
                        manager.addEmployee(e);
                    }
                }
                case 9 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option");
            }

        } while (choice != 9);
    }

    private static void printMenu() {
        System.out.println("\n--- Employee Skill Tracker ---");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Add Skill");
        System.out.println("6. View Employees with Skills");
        System.out.println("7. Save to File");
        System.out.println("8. Load from File");
        System.out.println("9. Exit");
        System.out.print("Choose: ");
    }

    private static void addEmployee() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Department: ");
        String dep = scanner.nextLine();

        System.out.print("Position: ");
        String pos = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (!InputValidator.isValidEmail(email)) {
            System.out.println("Invalid email!");
            return;
        }

        manager.addEmployee(new Employee(id, name, dep, pos, email));
    }

    private static void updateEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New Name: ");
        String name = scanner.nextLine();

        System.out.print("Department: ");
        String dep = scanner.nextLine();

        System.out.print("Position: ");
        String pos = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (manager.updateEmployee(id, name, dep, pos, email)) {
            System.out.println("Updated!");
        } else {
            System.out.println("Employee not found");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        if (manager.deleteEmployee(id)) {
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found");
        }
    }

    private static void addSkill() {
        System.out.print("Employee ID: ");
        int empId = scanner.nextInt();

        System.out.print("Skill ID: ");
        int skillId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Skill Name: ");
        String name = scanner.nextLine();

        System.out.print("Level (1-10): ");
        int level = scanner.nextInt();
        scanner.nextLine();

        System.out.print("1 - Technical, 2 - Soft: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        Skill skill;

        if (type == 1) {
            System.out.print("Category: ");
            String cat = scanner.nextLine();
            skill = new TechnicalSkill(skillId, name, level, cat);
        } else {
            System.out.print("Description: ");
            String desc = scanner.nextLine();
            skill = new SoftSkill(skillId, name, level, desc);
        }

        if (manager.addSkillToEmployee(empId, skill)) {
            System.out.println("Skill added!");
        } else {
            System.out.println("Employee not found");
        }
    }
}
