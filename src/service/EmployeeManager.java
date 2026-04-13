package service;

import model.Employee;
import model.Skill;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public boolean isEmpty() {
        return employees.isEmpty();
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> searchEmployeeByName(String name) {
        List<Employee> foundEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getName().toLowerCase().contains(name.toLowerCase())) {
                foundEmployees.add(employee);
            }
        }

        return foundEmployees;
    }

    public boolean updateEmployee(int id, String name, String department, String position, String email) {
        Employee employee = findEmployeeById(id);

        if (employee != null) {
            employee.setName(name);
            employee.setDepartment(department);
            employee.setPosition(position);
            employee.setEmail(email);
            return true;
        }

        return false;
    }

    public boolean deleteEmployee(int id) {
        Employee employee = findEmployeeById(id);

        if (employee != null) {
            employees.remove(employee);
            return true;
        }

        return false;
    }

    public boolean addSkillToEmployee(int employeeId, Skill skill) {
        Employee employee = findEmployeeById(employeeId);

        if (employee != null) {
            employee.addSkill(skill);
            return true;
        }

        return false;
    }

    public boolean removeSkillFromEmployee(int employeeId, int skillId) {
        Employee employee = findEmployeeById(employeeId);

        if (employee != null) {
            return employee.removeSkillById(skillId);
        }

        return false;
    }

    public boolean updateSkillForEmployee(int employeeId, int skillId, String newSkillName, int newLevel) {
        Employee employee = findEmployeeById(employeeId);

        if (employee != null) {
            Skill skill = employee.findSkillById(skillId);

            if (skill != null) {
                skill.setSkillName(newSkillName);
                skill.setLevel(newLevel);
                return true;
            }
        }

        return false;
    }

    public void showAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee.getDetails());
        }
    }

    public void showEmployeesWithSkills() {
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
}
