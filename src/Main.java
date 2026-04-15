import service.EmployeeManager;
import model.*;
import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeManager manager = new EmployeeManager();

    public static void main(String[] args) {

        while (true) {
            printMenu();
            int choice = getIntInput("Choose: ");

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> manager.viewEmployees();
                case 3 -> updateEmployee();
                case 4 -> deleteEmployee();
                case 5 -> addSkill();
                case 6 -> manager.viewEmployeesWithSkills();
                case 7 -> updateSkill();
                case 8 -> deleteSkill();
                case 9 -> manager.saveToFile();
                case 10 -> manager.loadFromFile();
                case 11 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Employee Skill Tracker ---");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Add Skill");
        System.out.println("6. View Employees with Skills");
        System.out.println("7. Update Skill");
        System.out.println("8. Delete Skill");
        System.out.println("9. Save to File");
        System.out.println("10. Load from File");
        System.out.println("11. Exit");
    }

    private static void addEmployee() {
        int id = getIntInput("Enter ID: ");
        String name = getStringInput("Enter Name: ");
        String dept = getStringInput("Enter Department: ");
        String pos = getStringInput("Enter Position: ");
        String email = getStringInput("Enter Email: ");

        manager.addEmployee(new Employee(id, name, dept, pos, email));
    }

    private static void updateEmployee() {
        int id = getIntInput("Enter Employee ID to update: ");
        String name = getStringInput("New Name: ");
        String dept = getStringInput("New Department: ");
        String pos = getStringInput("New Position: ");
        String email = getStringInput("New Email: ");

        manager.updateEmployee(id, name, dept, pos, email);
    }

    private static void deleteEmployee() {
        int id = getIntInput("Enter Employee ID to delete: ");
        manager.deleteEmployee(id);
    }

    private static void addSkill() {
        int empId = getIntInput("Enter Employee ID: ");
        int skillId = getIntInput("Enter Skill ID: ");
        String name = getStringInput("Enter Skill Name: ");
        int level = getIntInput("Enter Level (1-10): ");

        System.out.println("1. Technical Skill");
        System.out.println("2. Soft Skill");
        int type = getIntInput("Choose type: ");

        Skill skill;

        if (type == 1) {
            String category = getStringInput("Enter Category: ");
            skill = new TechnicalSkill(skillId, name, level, category);
        } else {
            String desc = getStringInput("Enter Description: ");
            skill = new SoftSkill(skillId, name, level, desc);
        }

        manager.addSkillToEmployee(empId, skill);
    }

    private static void updateSkill() {
        int empId = getIntInput("Enter Employee ID: ");
        int skillId = getIntInput("Enter Skill ID to update: ");
        int newLevel = getIntInput("Enter new level: ");

        manager.updateSkill(empId, skillId, newLevel);
    }

    private static void deleteSkill() {
        int empId = getIntInput("Enter Employee ID: ");
        int skillId = getIntInput("Enter Skill ID to delete: ");

        manager.deleteSkill(empId, skillId);
    }

    private static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static String getStringInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}