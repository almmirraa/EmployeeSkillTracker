package service;

import model.Employee;
import model.Skill;
import model.SoftSkill;
import model.TechnicalSkill;
import util.FileManager;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee.getDetails());
        }
    }

    public void viewEmployeesWithSkills() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee.getDetails());

            if (employee.getSkills().isEmpty()) {
                System.out.println("  No skills added.");
            } else {
                for (Skill skill : employee.getSkills()) {
                    System.out.println("  - " + skill.getDetails());
                }
            }

            System.out.println();
        }
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void updateEmployee(int id, String name, String department, String position, String email) {
        Employee employee = findEmployeeById(id);

        if (employee != null) {
            employee.setName(name);
            employee.setDepartment(department);
            employee.setPosition(position);
            employee.setEmail(email);
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void deleteEmployee(int id) {
        Employee employee = findEmployeeById(id);

        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void addSkillToEmployee(int employeeId, Skill skill) {
        Employee employee = findEmployeeById(employeeId);

        if (employee != null) {
            employee.addSkill(skill);
            System.out.println("Skill added successfully!");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void updateSkill(int employeeId, int skillId, int newLevel) {
        Employee employee = findEmployeeById(employeeId);

        if (employee != null) {
            Skill skill = employee.findSkillById(skillId);

            if (skill != null) {
                skill.setLevel(newLevel);
                System.out.println("Skill updated successfully!");
            } else {
                System.out.println("Skill not found.");
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void deleteSkill(int employeeId, int skillId) {
        Employee employee = findEmployeeById(employeeId);

        if (employee != null) {
            boolean removed = employee.removeSkillById(skillId);

            if (removed) {
                System.out.println("Skill deleted successfully!");
            } else {
                System.out.println("Skill not found.");
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void saveToFile() {
        FileManager.saveToFile(employees, "data.txt");
        System.out.println("Data saved successfully!");
    }

    public void loadFromFile() {
        employees = FileManager.loadFromFile("data.txt");
        System.out.println("Data loaded successfully!");
    }
}
