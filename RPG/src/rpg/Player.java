

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
    private int WIS;
    private int VIG;
    private int WIL;
    private int CON;
    private int INT;
    private int DEX;
    private int level;
    private int exp;
    private int gold;
    private String classe;
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
    
    public Player () {
        playerFile  = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\Jogadores\\"
                + "tempName.txt");
    }

    public Player(int HP, int MANA, int STR, int WIS, int VIG, int WIL, int CON,
            int INT, int DEX, int level, int exp, int gold, String classe,
            String Name) {
        this.HP = HP;
        this.MANA = MANA;
        this.STR = STR;
        this.WIS = WIS;
        this.VIG = VIG;
        this.WIL = WIL;
        this.CON = CON;
        this.INT = INT;
        this.DEX = DEX;
        this.level = level;
        this.exp = exp;
        this.gold = gold;
        this.classe = classe;
        this.Name = Name;
        
        playerFile  = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\Jogadores\\"
                + Name + ".txt");
    }

    public Player(String[] Item, String[] ItemQuant) {
        this.Item = Item;
        this.ItemQuant = ItemQuant;
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

    public int getWIS() {
        return WIS;
    }

    public void setWIS(int WIS) {
        this.WIS = WIS;
    }

    public int getVIG() {
        return VIG;
    }

    public void setVIG(int VIG) {
        this.VIG = VIG;
    }

    public int getWIL() {
        return WIL;
    }

    public void setWIL(int WIL) {
        this.WIL = WIL;
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

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
    
    public void Cria () throws IOException {
        if (playerFile.exists() == false) {
            playerFile.createNewFile();
        }
    }
    
    public void adicionaExp (int exp) {
        this.exp = this.exp + exp;

        if (checaLvlUp(this.exp)) {
            setLevel (level + 1);
        }
    }
    
    public boolean checaLvlUp (int exp) {
        boolean newLevel = false;
        int ExpNewLevel = (level + 1) * 10;
        
        if (this.exp + exp >= ExpNewLevel) {
            newLevel = true;
        }
        
        return newLevel;
    }
    
    public void gravaFicha () throws IOException {
        if (playerFile.canWrite()) {
            try (BufferedWriter dado = new BufferedWriter (new FileWriter (playerFile))){
                JOptionPane.showMessageDialog(null, "Cheguei");
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
                dado.write("Level:");dado.write(level);dado.newLine();
                dado.write("XP:");dado.write(exp);dado.newLine();
                dado.write("STR:");dado.write(STR);dado.newLine();
                dado.write("WIS:");dado.write(WIS);dado.newLine();
                dado.write("VIG:");dado.write(VIG);dado.newLine();
                dado.write("WIL:");dado.write(WIL);dado.newLine();
                dado.write("CON:");dado.write(CON);dado.newLine();
                dado.write("INT:");dado.write(INT);dado.newLine();
                dado.write("DEX:");dado.write(DEX);dado.newLine();
                dado.write("Gold:");dado.write(gold);dado.newLine();
                dado.write("Class:");dado.write(classe);dado.newLine();
                JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
            }
        }
    }
    
    public void gravaInventario () throws IOException {
        if (playerFile.canWrite()) {
            try (BufferedWriter dado = new BufferedWriter (new FileWriter (playerFile))) {
                for (int i = 0 ; i <= Item.length - 1 ; i++) {
                    dado.write("Item:");
                    dado.write(Item[i]);
                    dado.newLine();
                    dado.write("Quant:");
                    dado.write(ItemQuant[i]);
                    dado.newLine();
                }
            }
        }
    }
    
    public void gravaSkills () throws IOException {
        if (playerFile.canWrite()) {
            try (BufferedWriter dado = new BufferedWriter (new FileWriter (playerFile))) {
                for (int i = 0 ; i <= Item.length - 1 ; i++) {
                    dado.write("Skill:");
                    dado.write(Skill[i]);
                    dado.newLine();
                    dado.write("Cost:");
                    dado.write(SkillCost[i]);
                    dado.newLine();
                }
            }
        }
    }
}
