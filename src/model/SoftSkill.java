package model;

public class SoftSkill extends Skill {
    private String description;

    public SoftSkill() {
    }

    public SoftSkill(int skillId, String skillName, int level, String description) {
        super(skillId, skillName, level);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getSkillType() {
        return "Soft Skill";
    }

    @Override
    public String getDetails() {
        return "Skill ID: " + getSkillId() +
                ", Name: " + getSkillName() +
                ", Level: " + getLevel() +
                ", Type: " + getSkillType() +
                ", Description: " + description;
    }
}
