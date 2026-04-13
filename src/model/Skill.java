package model;

import interfaces.Displayable;

public class Skill implements Displayable {
    private int skillId;
    private String skillName;
    private int level;

    public Skill() {
    }

    public Skill(int skillId, String skillName, int level) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.level = level;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSkillType() {
        return "General Skill";
    }

    @Override
    public String getDetails() {
        return "Skill ID: " + skillId +
                ", Name: " + skillName +
                ", Level: " + level +
                ", Type: " + getSkillType();
    }
}