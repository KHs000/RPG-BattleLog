

package rpg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Rabelo
 */
public class Player {
    private int HP;
    private int MANA;
    private int STR;
    private int AGI;
    private int DEX;
    private int CON;
    private int INT;
    private String Skill [];
    private String SkillCost [];
    private String Item [];
    private String ItemQuant [];
    private int Quant;
    private int InvQuant;
    private String Name;
    private File playerFile;
    
    public Player (String Name, int Quant, int InvQuant) {
        playerFile = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\Jogadores\\"
                + Name + ".txt");
        Skill = new String [Quant];
        SkillCost = new String [Quant];
        Item = new String [InvQuant];
        ItemQuant = new String [InvQuant];
        setQuant(Quant);
        setInvQuant(InvQuant);
    }

    public Player(int HP, int MANA, String [] Skill, String Name, int Quant) {
        this.HP = HP;
        this.MANA = MANA;
        this.Skill = Skill;
        this.Name = Name;
        Skill = new String [Quant];
        this.playerFile = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\Jogadores\\"
        + Name + ".txt");
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMANA() {
        return MANA;
    }

    public void setMANA(int MANA) {
        this.MANA = MANA;
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public int getAGI() {
        return AGI;
    }

    public void setAGI(int AGI) {
        this.AGI = AGI;
    }

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
    }

    public int getCON() {
        return CON;
    }

    public void setCON(int CON) {
        this.CON = CON;
    }

    public int getINT() {
        return INT;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public String getSkill(int i) {
        return Skill[i];
    }
    
    public void setSkill (String [] Skill) {
        this.Skill = Skill.clone();
    }

    public String getSkillCost(int i) {
        return SkillCost[i];
    }

    public void setSkillCost(String [] SkillCost) {
        this.SkillCost = SkillCost.clone();
    }

    public String getItem(int i) {
        return Item[i];
    }

    public void setItem(String[] Item) {
        this.Item = Item.clone();
    }

    public String getItemQuant(int i) {
        return ItemQuant[i];
    }

    public void setItemQuant(String[] ItemQuant) {
        this.ItemQuant = ItemQuant.clone();
    }

    public int getQuant() {
        return Quant;
    }

    public void setQuant(int Quant) {
        this.Quant = Quant;
    }

    public int getInvQuant() {
        return InvQuant;
    }

    public void setInvQuant(int InvQuant) {
        this.InvQuant = InvQuant;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public void Cria () throws IOException {
        if (playerFile.exists() == false) {
            playerFile.createNewFile();
        }
    }
    
    public void gravaFicha () throws IOException {
        if (playerFile.canWrite() == true) {
            try (BufferedWriter dado = new BufferedWriter (new FileWriter (playerFile))){
                dado.write("Nome:");
                dado.write(Name);
                dado.newLine();
                dado.write("HP:");
                String hp = String.valueOf(HP);
                dado.write(hp);
                dado.newLine();
                dado.write("MANA:");
                String mana = String.valueOf(MANA);
                dado.write(mana);
                dado.newLine();
                for (int i = 0 ; i <= Item.length - 1 ; i++) {
                    dado.write("Item:");
                    dado.write(Item[i]);
                    dado.newLine();
                    dado.write("Quant:");
                    dado.write(ItemQuant[i]);
                    dado.newLine();
                }
                for (int i = 0 ; i <= Skill.length - 1 ; i ++) {
                    dado.write("Skill:");
                    dado.write(Skill[i]);
                    dado.newLine();
                    dado.write("Cost:");
                    dado.write(SkillCost[i]);
                    dado.newLine();
                }
                dado.write("STR:");
                String str = String.valueOf(STR);
                dado.write(str);
                dado.newLine();
                dado.write("DEX:");
                String dex = String.valueOf(DEX);
                dado.write(dex);
                dado.newLine();
                dado.write("AGI:");
                String agi = String.valueOf(AGI);
                dado.write(agi);
                dado.newLine();
                dado.write("CON:");
                String con = String.valueOf(CON);
                dado.write(con);
                dado.newLine();
                dado.write("INT:");
                String intl = String.valueOf(INT);
                dado.write(intl);
                dado.newLine();
                dado.close();
            }
        }
    }
}
