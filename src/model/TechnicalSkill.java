package model;

public class TechnicalSkill extends Skill {
    private String technologyCategory;

    public TechnicalSkill() {
    }

    public TechnicalSkill(int skillId, String skillName, int level, String technologyCategory) {
        super(skillId, skillName, level);
        this.technologyCategory = technologyCategory;
    }

    public String getTechnologyCategory() {
        return technologyCategory;
    }

    public void setTechnologyCategory(String technologyCategory) {
        this.technologyCategory = technologyCategory;
    }

    @Override
    public String getSkillType() {
        return "Technical Skill";
    }

    @Override
    public String getDetails() {
        return "Skill ID: " + getSkillId() +
                ", Name: " + getSkillName() +
                ", Level: " + getLevel() +
                ", Type: " + getSkillType() +
                ", Category: " + technologyCategory;
    }
}
