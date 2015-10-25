

package rpg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Rabelo
 */
public class PlayerRead {
    private String HP;
    private String MANA;
    private String lvl; 
    private String xp;
    private String gold;
    private String classe;
    private String STR;
    private String WIS;
    private String VIG;
    private String WIL;
    private String CON;
    private String INT;
    private String DEX;
    private String [] Skill;
    private String [] SkillCost;
    private String [] Inv;
    private String [] InvQuant;
    private String Name;
    private int Quant = 0;
    private int QuantInv = 0;
    private int ContInv = 1;
    private int SkillCont = 1;
    private File playerFile;
    
    public PlayerRead (int jogador) {
        switch (jogador) {
            case 1:
                Name = "Lestrade";
                break;
            case 2:
                Name = "Tyrion";
                break;
            case 3:
                Name = "Izuna";
                break;
        }
        playerFile = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\Jogadores\\"
        + Name + ".txt");
    }
    
    public PlayerRead (String name) throws IOException {
        ConfiguracoesSalvas manip = new ConfiguracoesSalvas ();
        playerFile = new File (manip.SelecionaPath("Skyrim-Jogadores") + "\\" + name + ".txt");
    }
    
    public void Testa () throws FileNull {if (playerFile.exists() == false) throw new FileNull();}
    
    public String getHP () {return HP;}
    
    public void setHP () throws FileNotFoundException {
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("HP:")) {this.HP = aux.substring(3, aux.length());}
                }
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }
    
    public String getMANA () {return MANA;}
    
    public void setMANA () throws FileNotFoundException {
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("MANA:")) {this.MANA = aux.substring(5, aux.length());}
                }
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }
    
    public String getName () {return Name;}
    
    public void setName () throws IOException {
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile))) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("Nome:")) {this.Name = aux.substring(5, aux.length());}
                }
            }
        }
    }
    
    public String getLVL () {return lvl;}
    
    public void setLVL () throws IOException{
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile) )) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("Level:")) {this.lvl = aux.substring(6, aux.length());}
                }
            }
        }
    }
    
    public String getXP () {return xp;}
    
    public void setXP () throws IOException{
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile) )) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("XP:")) {this.xp = aux.substring(3, aux.length());}
                }
            }
        }
    }
    
    public String getGold () {return gold;}
    
    public void setGold () throws IOException{
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile) )) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("Gold:")) {this.gold = aux.substring(5, aux.length());}
                }
            }
        }
    }
    
    public String getClasse () {return classe;}
    
    public void setClasse () throws IOException {
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile) )) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("Class:")) {this.classe = aux.substring(6, aux.length());}
                }
            }
        }
    }
    
    public String getSTR () {return STR;}
    
    public void setSTR () throws IOException {
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile) )) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("STR:")) {this.STR = aux.substring(4, aux.length());}
                }
            }
        }
    }
    
    public String getWIS () {return WIS;}
    
    public void setWIS () throws IOException {
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile) )) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("WIS:")) {this.WIS = aux.substring(4, aux.length());}
                }
            }
        }
    }
    
    public String getVIG () {return VIG;}
    
    public void setVIG () throws IOException {
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile) )) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("VIG:")) {this.VIG = aux.substring(4, aux.length());}
                }
            }
        }
    }
    
    public String getWIL () {return WIL;}
    
    public void setWIL () throws IOException {
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile) )) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("WIL:")) {this.WIL = aux.substring(4, aux.length());}
                }
            }
        }
    }
    
    public String getCON () {return CON;}
    
    public void setCON () throws IOException {
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile) )) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("CON:")) {this.CON = aux.substring(4, aux.length());}
                }
            }
        }
    }
    
    public String getINT () {return INT;}
    
    public void setINT () throws IOException {
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile) )) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("INT:")) {this.INT = aux.substring(4, aux.length());}
                }
            }
        }
    }
    
    public String getDEX () {return DEX;}
    
    public void setDEX () throws IOException {
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile) )) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("DEX:")) {this.DEX = aux.substring(4, aux.length());}
                }
            }
        }
    }
    
    public void setQuant () throws IOException{
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader(playerFile))) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("Skill:")) {Quant++;}
                }
            }
        }
    }
    
    public int getQuant () {return Quant;}
    
    public void setQuantInv () {
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Item:")) {
                        QuantInv++;
                    }
                }
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }
    
    public int getQuantInv () {return QuantInv;}
    
    public void setInv () {
        Inv = new String [getQuantInv()];
        int c = 0;
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Item:")) {this.Inv[c] = aux.substring(5, aux.length());c++;}
                }
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }
    
    public String [] getInv () {return Inv;}
    
    public String getInv (int i) {return Inv[i];}
    
    public void setInvQuant () {
        InvQuant = new String [getQuantInv()];
        int c = 0;
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Quant:")) {this.InvQuant[c] = aux.substring(6, aux.length());c++;}
                }
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }
    
    public String [] getInvQuant () {return InvQuant;}
    
    public String getInvQuant (int i) {return InvQuant[i];}

    public String [] getSkill() {return Skill;}
    
    public String getSkill (int i) {return Skill[i];}
    
    public void setSkill () throws IOException{
        Skill = new String [getQuant()];
        int c = 0;
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader(playerFile))) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("Skill:")) {this.Skill[c] = aux.substring(6, aux.length());c++;}
                }
            }
        }
    }
    
    public String [] getSkillCost () {return SkillCost;}
    
    public String getSkillCost (int i) {return SkillCost[i];}
    
    public void setSkillCost () throws IOException{
        SkillCost = new String [getQuant()];
        int c = 0;
        if (playerFile.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (playerFile))) {
                String aux;
                while (br.ready()) {
                    aux = br.readLine();
                    if (aux.startsWith("Cost:")) {this.SkillCost[c] = aux.substring(5, aux.length());c++;}
                }
            }
        }
    }
}
