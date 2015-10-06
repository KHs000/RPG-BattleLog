

package rpg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Rabelo
 */
public class Mob {
    private File mobFile;
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
    private int expDrop;
    private String Name;
    private String Skill [];
    private String SkillCost [];
    private String Item [];
    private String ItemQuant [];
    private String local;
    private final JFileChooser path;
    
    public Mob () throws IOException {
        ConfiguracoesSalvas obj = new ConfiguracoesSalvas ();
        path = new JFileChooser();
        if (obj.Exists() && obj.checaPath("Skyrim-Mobs")) {local = obj.SelecionaPath("Skyrim-Mobs");}
        else {
            path.setCurrentDirectory(new java.io.File("."));
            path.setDialogTitle("Selecione a pasta");
            path.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            path.setAcceptAllFileFilterUsed(false);
            if (path.showOpenDialog(path) == JFileChooser.APPROVE_OPTION) {
                local = path.getSelectedFile().toString() + "\\";
                obj.SalvaConfiguracoes(local, "Skyrim-Mobs");
            }
            else {local = null;}
        }
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExpDrop() {
        return expDrop;
    }

    public void setExpDrop(int expDrop) {
        this.expDrop = expDrop;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSkill(int i) {
        return Skill[i];
    }

    public void setSkill(String[] Skill) {
        this.Skill = Skill;
    }

    public String getSkillCost(int i) {
        return SkillCost[i];
    }

    public void setSkillCost(String[] SkillCost) {
        this.SkillCost = SkillCost;
    }

    public String getItem(int i) {
        return Item[i];
    }

    public void setItem(String[] Item) {
        this.Item = Item;
    }

    public String getItemQuant(int i) {
        return ItemQuant[i];
    }

    public void setItemQuant(String[] ItemQuant) {
        this.ItemQuant = ItemQuant;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    public void Cria () throws IOException {
        if (mobFile.exists() == false) {
            mobFile.createNewFile();
        }
    }
    
    public void gravaFicha () throws IOException {
        mobFile = new File (local + Name + ".txt");
        if (true) {
            try (BufferedWriter dado = new BufferedWriter (new FileWriter (mobFile))){
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
                String lvl = String.valueOf(level);
                dado.write("Level:");dado.write(lvl);dado.newLine();
                String xp = String.valueOf(expDrop);
                dado.write("XP Drop:");dado.write(xp);dado.newLine();
                String str = String.valueOf(STR);
                dado.write("STR:");dado.write(str);dado.newLine();
                String wis = String.valueOf(WIS);
                dado.write("WIS:");dado.write(wis);dado.newLine();
                String vig = String.valueOf(VIG);
                dado.write("VIG:");dado.write(vig);dado.newLine();
                String wil = String.valueOf(WIL);
                dado.write("WIL:");dado.write(wil);dado.newLine();
                String con = String.valueOf(CON);
                dado.write("CON:");dado.write(con);dado.newLine();
                String Int = String.valueOf(INT);
                dado.write("INT:");dado.write(Int);dado.newLine();
                String dex = String.valueOf(DEX);
                dado.write("DEX:");dado.write(dex);dado.newLine();
                for (int i = 0 ; i < Item.length ; i++) {
                    dado.write("Item:");dado.write(Item[i]);dado.newLine();
                    dado.write("Quant:");dado.write(ItemQuant[i]);dado.newLine();
                }
                for (int i = 0 ; i < Skill.length ; i++) {
                    dado.write("Skill:");dado.write(Skill[i]);dado.newLine();
                    dado.write("Cost:");dado.write(SkillCost[i]);dado.newLine();
                }
                JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
            }
        }
    }
}
