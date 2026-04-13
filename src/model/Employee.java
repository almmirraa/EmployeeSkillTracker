package model;

import interfaces.Displayable;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Person implements Displayable {
    private String department;
    private String position;
    private String email;
    private List<Skill> skills;

    public Employee() {
        this.skills = new ArrayList<>();
    }

    public Employee(int id, String name, String department, String position, String email) {
        super(id, name);
        this.department = department;
        this.position = position;
        this.email = email;
        this.skills = new ArrayList<>();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public Skill findSkillById(int skillId) {
        for (Skill skill : skills) {
            if (skill.getSkillId() == skillId) {
                return skill;
            }
        }
        return null;
    }

    public boolean removeSkillById(int skillId) {
        Skill skill = findSkillById(skillId);
        if (skill != null) {
            skills.remove(skill);
            return true;
        }
        return false;
    }

    @Override
    public String getDetails() {
        return "Employee ID: " + getId() +
                ", Name: " + getName() +
                ", Department: " + department +
                ", Position: " + position +
                ", Email: " + email +
                ", Skills Count: " + skills.size();
    }

    @Override
    public String toString() {
        return getDetails();
    }
}