

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
    
    public void Testa () throws FileNull {
        if (playerFile.exists() == false)
            throw new FileNull();
    }
    
    public String getHP () {
        return HP;
    }
    
    public void setHP () throws FileNotFoundException {
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.substring(0, 5).equals("Nome:")) {
                        br.skip(3);
                        this.HP = br.readLine();
                    }
                }
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }
    
    public String getMANA () {
        return MANA;
    }
    
    public void setMANA () throws FileNotFoundException {
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.substring(0, 3).equals("HP:")) {
                        br.skip(5);
                        this.MANA = br.readLine();
                    }
                }
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }
    
    public String getName () {
        return Name;
    }
    
    public void setQuant () {
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Skill:")) {
                        Quant++;
                    }
                }
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }
    
    public int getQuant () {
        return Quant;
    }
    
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
    
    public int getQuantInv () {
        return QuantInv;
    }
    
    public void setInv () {
        Inv = new String [getQuantInv()];
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("MANA:")) {
                        br.skip(5);
                        this.Inv[0] = br.readLine();
                    }
                    if (aux.startsWith("Quant:")) {
                        br.skip(5);
                        Inv[ContInv] = br.readLine();
                        this.ContInv++;
                    }
                }
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }
    
    public String [] getInv () {
        return Inv;
    }
    
    public String getInv (int i) {
        return Inv[i];
    }
    
    public void setInvQuant () {
        InvQuant = new String [getQuantInv()];
        int c = 0;
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Item:")) {
                        br.skip(6);
                        this.InvQuant[c] = br.readLine();
                        c++;
                    }
                }
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }
    
    public String [] getInvQuant () {
        return InvQuant;
    }
    
    public String getInvQuant (int i) {
        return InvQuant[i];
    }

    public String [] getSkill() {
        return Skill;
    }
    
    public String getSkill (int i) {
        return Skill[i];
    }
    
    public void setSkill () {
        Skill = new String [getQuant() + 1];
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Quant:")) {
                        br.skip(6);
                        this.Skill[0] = br.readLine();
                    }
                    if (aux.startsWith("Cost:")) {
                        br.skip(6);
                        this.Skill[SkillCont] = br.readLine();
                        SkillCont++;
                    }
                }
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }
    
    public String [] getSkillCost () {
        return SkillCost;
    }
    
    public String getSkillCost (int i) {
        return SkillCost[i];
    }
    
    public void setSkillCost () {
        SkillCont = 0;
        SkillCost = new String [getQuant()];
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Skill:")) {
                        br.skip(5);
                        this.SkillCost[SkillCont] = br.readLine();
                        SkillCont++;
                    }
                }
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }
}
