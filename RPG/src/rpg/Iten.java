

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
public class Iten {
    private File itenFile;
    private String Name;
    private String description;
    private int HP;
    private int MANA;
    private int STR;
    private int WIS;
    private int VIG;
    private int WIL;
    private int CON;
    private int INT;
    private int DEX;
    private int dam;
    private int arm;
    private int [] type = new int [4];
    private int [] resistence = new int [6];
    private String [] resistenceLabel = {"Fire", "Water", "Earth", "Wind", "Light", "Black"};
    private int [] element = new int [7];
    private String [] elementLabel = {"Neutral", "Fire", "Water", "Earth", "Wind", "Light", "Black"};
    private String Skill;
    private String local;
    private final JFileChooser path = new JFileChooser();
    
    public Iten () throws IOException {
        ConfiguracoesSalvas obj = new ConfiguracoesSalvas ();
        if (obj.Exists() && obj.checaPath("Skyrim-Itens")) {local = obj.SelecionaPath("Skyrim-Itens");}
        else {
            path.setCurrentDirectory(new java.io.File("."));
            path.setDialogTitle("Selecione a pasta");
            path.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            path.setAcceptAllFileFilterUsed(false);
            if (path.showOpenDialog(path) == JFileChooser.APPROVE_OPTION) {
                local = path.getSelectedFile().toString() + "\\";
                obj.SalvaConfiguracoes(local, "Skyrim-Itens");
            }
            else {local = null;}
        }
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getDam() {
        return dam;
    }

    public void setDam(int dam) {
        this.dam = dam;
    }

    public int getArm() {
        return arm;
    }

    public void setArm(int arm) {
        this.arm = arm;
    }

    public int[] getType() {
        return type;
    }

    public void setType(int[] type) {
        this.type = type;
    }

    public int[] getResistence() {
        return resistence;
    }

    public void setResistence(int[] resistence) {
        this.resistence = resistence;
    }

    public int[] getElement() {
        return element;
    }

    public void setElement(int[] element) {
        this.element = element;
    }

    public String getSkill() {
        return Skill;
    }

    public void setSkill(String Skill) {
        this.Skill = Skill;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    public void Cria () throws IOException {
        if (itenFile.exists() == false) {
            itenFile.createNewFile();
        }
    }
    
    public void gravaItem () throws IOException {
        itenFile = new File (local + Name + ".txt");
        try (BufferedWriter dado = new BufferedWriter (new FileWriter (itenFile))) {
            dado.write("Nome:");
            dado.write(Name);
            dado.newLine();
            dado.write("Type:");
            String Type = null;
            for (int i = 0 ; i < type.length ; i++) {
                if (type[i] != 0) {Type = String.valueOf(i);}
            }
            dado.write(Type);
            dado.newLine();
            dado.write("Description:");
            dado.write(description);
            dado.newLine();
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
            dado.write("Healing HP:");
            String hp = String.valueOf(HP);
            dado.write(hp);
            dado.newLine();
            dado.write("Healing MANA:");
            String mana = String.valueOf(MANA);
            dado.write(mana);
            dado.newLine();
            dado.write("Armor:");
            String armor = String.valueOf(arm);
            dado.write(armor);
            dado.newLine();
            dado.write("Damage:");
            String damage = String.valueOf(dam);
            dado.write(damage);
            dado.newLine();
            for (int i = 0 ; i < resistence.length ; i++) {
                dado.write(resistenceLabel[i] + ":");
                String res = String.valueOf(resistence[i]);
                dado.write(res);
                dado.newLine();
            }
            for (int i = 0 ; i < elementLabel.length ; i++) {
                dado.write(elementLabel[i] + ":");
                String ele = String.valueOf(element[i]);
                dado.write(ele);
                dado.newLine();
            }
            dado.write("Skill:");
            dado.write(Skill);
            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
        }
    }
}
