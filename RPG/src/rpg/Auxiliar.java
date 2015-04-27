

package rpg;

/**
 *
 * @author Felipe Rabelo
 */
public class Auxiliar {
    private static String [] item;
    private static String [] itemQuant;
    private static String [] skill;
    private static String [] skillCost;

    public Auxiliar() {}

    public String[] getItem() {
        return item;
    }
    
    public String getItem(int i) {
        return item[i];
    }

    public void setItem(String[] item) {
        Auxiliar.item = item;
    }

    public String[] getItemQuant() {
        return itemQuant;
    }
    
    public String getItemQuant(int i) {
        return itemQuant[i];
    }

    public void setItemQuant(String[] itemQuant) {
        Auxiliar.itemQuant = itemQuant;
    }

    public String[] getSkill() {
        return skill;
    }

    public void setSkill(String[] skill) {
        Auxiliar.skill = skill;
    }

    public String[] getSkillCost() {
        return skillCost;
    }

    public void setSkillCost(String[] skillCost) {
        Auxiliar.skillCost = skillCost;
    }
}
