

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
    private String Name;
    private int Quant = 0;
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
                    if (aux.substring(0, 6).equals("Skill:")) {
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

    public String [] getSkill() {
        return Skill;
    }
    
    public void setSkill () {
        Skill = new String [getQuant()];
        if (playerFile.canRead() == true) {
            try (FileReader r = new FileReader(playerFile)) {
                BufferedReader br = new BufferedReader(r);
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Quant:")) {
                        br.skip(6);
                        this.Skill[0] = br.readLine();
                    }
                    if (aux.startsWith("Skill:")) {
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
}
