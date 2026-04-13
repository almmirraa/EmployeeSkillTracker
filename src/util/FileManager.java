package util;

import model.Employee;
import model.Skill;
import model.SoftSkill;
import model.TechnicalSkill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static void saveToFile(List<Employee> employees, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Employee employee : employees) {
                writer.write("EMPLOYEE;" +
                        employee.getId() + ";" +
                        employee.getName() + ";" +
                        employee.getDepartment() + ";" +
                        employee.getPosition() + ";" +
                        employee.getEmail());
                writer.newLine();

                for (Skill skill : employee.getSkills()) {
                    if (skill instanceof TechnicalSkill technicalSkill) {
                        writer.write("TECHNICAL;" +
                                technicalSkill.getSkillId() + ";" +
                                technicalSkill.getSkillName() + ";" +
                                technicalSkill.getLevel() + ";" +
                                technicalSkill.getTechnologyCategory());
                    } else if (skill instanceof SoftSkill softSkill) {
                        writer.write("SOFT;" +
                                softSkill.getSkillId() + ";" +
                                softSkill.getSkillName() + ";" +
                                softSkill.getLevel() + ";" +
                                softSkill.getDescription());
                    }
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public static List<Employee> loadFromFile(String fileName) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Employee currentEmployee = null;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                if (parts[0].equals("EMPLOYEE")) {
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    String department = parts[3];
                    String position = parts[4];
                    String email = parts[5];

                    currentEmployee = new Employee(id, name, department, position, email);
                    employees.add(currentEmployee);

                } else if (parts[0].equals("TECHNICAL") && currentEmployee != null) {
                    int skillId = Integer.parseInt(parts[1]);
                    String skillName = parts[2];
                    int level = Integer.parseInt(parts[3]);
                    String category = parts[4];

                    currentEmployee.addSkill(new TechnicalSkill(skillId, skillName, level, category));

                } else if (parts[0].equals("SOFT") && currentEmployee != null) {
                    int skillId = Integer.parseInt(parts[1]);
                    String skillName = parts[2];
                    int level = Integer.parseInt(parts[3]);
                    String description = parts[4];

                    currentEmployee.addSkill(new SoftSkill(skillId, skillName, level, description));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with empty employee list.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }

        return employees;
    }

    public static void exportToCSV(List<Employee> employees, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("EmployeeId,Name,Department,Position,Email,SkillId,SkillName,Level,SkillType,ExtraInfo");
            writer.newLine();

            for (Employee employee : employees) {
                if (employee.getSkills().isEmpty()) {
                    writer.write(employee.getId() + "," +
                            employee.getName() + "," +
                            employee.getDepartment() + "," +
                            employee.getPosition() + "," +
                            employee.getEmail() + ",,,,,");
                    writer.newLine();
                } else {
                    for (Skill skill : employee.getSkills()) {
                        String extraInfo = "";

                        if (skill instanceof TechnicalSkill technicalSkill) {
                            extraInfo = technicalSkill.getTechnologyCategory();
                        } else if (skill instanceof SoftSkill softSkill) {
                            extraInfo = softSkill.getDescription();
                        }

                        writer.write(employee.getId() + "," +
                                employee.getName() + "," +
                                employee.getDepartment() + "," +
                                employee.getPosition() + "," +
                                employee.getEmail() + "," +
                                skill.getSkillId() + "," +
                                skill.getSkillName() + "," +
                                skill.getLevel() + "," +
                                skill.getSkillType() + "," +
                                extraInfo);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error exporting to CSV: " + e.getMessage());
        }
    }

    public static List<Employee> importFromCSV(String fileName) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",");

                int employeeId = Integer.parseInt(parts[0]);
                String name = parts[1];
                String department = parts[2];
                String position = parts[3];
                String email = parts[4];

                Employee employee = null;

                for (Employee existingEmployee : employees) {
                    if (existingEmployee.getId() == employeeId) {
                        employee = existingEmployee;
                        break;
                    }
                }

                if (employee == null) {
                    employee = new Employee(employeeId, name, department, position, email);
                    employees.add(employee);
                }

                if (parts.length > 5 && !parts[5].isEmpty()) {
                    int skillId = Integer.parseInt(parts[5]);
                    String skillName = parts[6];
                    int level = Integer.parseInt(parts[7]);
                    String skillType = parts[8];
                    String extraInfo = parts[9];

                    if (skillType.equals("Technical Skill")) {
                        employee.addSkill(new TechnicalSkill(skillId, skillName, level, extraInfo));
                    } else if (skillType.equals("Soft Skill")) {
                        employee.addSkill(new SoftSkill(skillId, skillName, level, extraInfo));
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error importing from CSV: " + e.getMessage());
        }

        return employees;
    }
}