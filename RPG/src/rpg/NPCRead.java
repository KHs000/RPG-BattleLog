

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
public class NPCRead {
    private File [] npcFichas;
    private File npcFicha;
    private File npcPasta;
    private String [] npcMob;
    
    public NPCRead () throws FileNotFoundException, IOException {
        npcPasta = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\NPCs");
        if (npcPasta.listFiles().length > 0) {
            npcFichas = new File [npcPasta.listFiles().length];
            npcFichas = npcPasta.listFiles();
            npcMob = new String[npcPasta.listFiles().length];int index = 0;
            String aux;
            for (File i : npcFichas) {
                if (i.canRead()) {
                    BufferedReader br = new BufferedReader(new FileReader(i));
                    while (br.ready()) {
                        aux = br.readLine();
                        if (aux.substring(0, 4).equals("Nome")) {npcMob[index] = aux.substring(5);index++;}
                    }
                }
            }
        }
    }
    
    public NPCRead (String name) {
        npcPasta = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\NPCs");
        if (npcPasta.listFiles().length > 0) {
            npcFichas = new File[npcPasta.listFiles().length];
            npcFichas = npcPasta.listFiles();
            for (File i : npcFichas) {
                if (i.getName().equals(name + ".txt")) {npcFicha = i;}
            }
        }
    }
    
    public String [] getNomeMob () {return npcMob;}
    
    public String getName () {
        String name = null;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Nome:")) {name = aux.substring(5);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return name;
    }
    
    public String getSTR () {
        String STR = null;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.substring(0, 4).equals("STR:")) {STR = aux.substring(4);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return STR;
    }
    
    public String getWIS () {
        String WIS = null;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.substring(0, 4).equals("WIS:")) {WIS = aux.substring(4);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return WIS;
    }
    
    public String getVIG () {
        String VIG = null;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.substring(0, 4).equals("VIG:")) {VIG = aux.substring(4);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return VIG;
    }
    
    public String getWIL () {
        String WIL = null;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.substring(0, 4).equals("WIL:")) {WIL = aux.substring(4);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return WIL;
    }
    
    public String getCON () {
        String CON = null;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.substring(0, 4).equals("CON:")) {CON = aux.substring(4);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return CON;
    }
    
    public String getINT () {
        String INT = null;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.substring(0, 4).equals("INT:")) {INT = aux.substring(4);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return INT;
    }
    
    public String getDEX () {
        String DEX = null;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.substring(0, 4).equals("DEX:")) {DEX = aux.substring(4);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return DEX;
    }
    
    public String getXPDrop () {
        String xpdrop = null;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("XP Drop:")) {xpdrop = aux.substring(8);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
       
        return xpdrop;
    }
    
    public String getLevel () {
        String level = null;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Level:")) {level = aux.substring(6);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
       
        return level;
    }
    
    public String getHP () {
        String hp = null;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.substring(0, 3).equals("HP:")) {hp = aux.substring(3);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
       
        return hp;
    }
    
    public String getMP () {
        String mp = null;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("MANA:")) {mp = aux.substring(5);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
       
        return mp;
    }
    
    public String [] getItem () {
        String [] item = new String [contInv()]; int index = 0;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Item:")) {item[index] = aux.substring(5);index++;}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return item;
    }
    
    public String [] getItemQuant () {
        String [] itemQuant = new String [contInv()]; int index = 0;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Quant:")) {itemQuant[index] = aux.substring(6);index++;}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return itemQuant;
    }
    
    public String [] getSkill () {
        String [] skill = new String [contSkill()]; int index = 0;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Skill:")) {skill[index] = aux.substring(6);index++;}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return skill;
    }
    
    public String [] getSkillCost () {
        String [] skillCost = new String [contSkill()]; int index = 0;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Cost:")) {skillCost[index] = aux.substring(5);index++;}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return skillCost;
    }
    
    public int contInv () {
        int cont = 0;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Item:")) {cont++;}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return cont;
    }
    
    public int contSkill () {
        int cont = 0;
        if (npcFicha.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (npcFicha))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Skill:")) {cont++;}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return cont;
    }
    
    public void Deleta () {npcFicha.deleteOnExit();}
}