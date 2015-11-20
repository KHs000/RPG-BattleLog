

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
public class ItenRead {
    private File [] itenList;
    private File iten;
    private File itenPasta;
    private String [] nomeIten;
    
    public ItenRead () throws FileNotFoundException, IOException {
        itenPasta = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\Itens");
        if (itenPasta.listFiles().length > 0) {
            itenList = new File [itenPasta.listFiles().length];
            itenList = itenPasta.listFiles();
            nomeIten = new String[itenPasta.listFiles().length];int index = 0;
            String aux;
            for (File i : itenList) {
                if (i.canRead()) {
                    BufferedReader br = new BufferedReader(new FileReader(i));
                    while (br.ready()) {
                        aux = br.readLine();
                        if (aux.substring(0, 4).equals("Nome")) {nomeIten[index] = aux.substring(5);index++;}
                    }
                }
            }
        }
    }
    
    public ItenRead (String name) {
        itenPasta = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\Itens");
        if (itenPasta.listFiles().length > 0) {
            itenList = new File[itenPasta.listFiles().length];
            itenList = itenPasta.listFiles();
            for (File i : itenList) {
                if (i.getName().equals(name + ".txt")) {iten = i;}
            }
        }
    }
    
    public String [] getNomeIten () {return nomeIten;}
    
    public String getName () {
        String name = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Nome:")) {name = aux.substring(5);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return name;
    }
    
    public String getType () {
        String type = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Type:")) {type = aux.substring(5);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return type;
    }
    
    public String getDescription () {
        String description = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Description:")) {description = aux.substring(12);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return description;
    }
    
    public String getSTR () {
        String STR = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
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
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
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
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
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
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
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
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
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
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
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
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.substring(0, 4).equals("DEX:")) {DEX = aux.substring(4);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return DEX;
    }
    
    public String getHP () {
        String hp = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Healing HP:")) {hp = aux.substring(11);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
       
        return hp;
    }
    
    public String getMP () {
        String mp = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Healing MANA:")) {mp = aux.substring(13);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
       
        return mp;
    }
    
    public String getArmor () {
        String arm = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Armor:")) {arm = aux.substring(6);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return arm;
    }
    
    public String getWeapon () {
        String weapon = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Damage:")) {weapon = aux.substring(7);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return weapon;
    }
    
    public String getResistenceFire () {
        String fire = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Resistence Fire:")) {fire = aux.substring(16);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return fire;
    }
    
    public String getResistenceWater () {
        String water = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Resistence Water:")) {water = aux.substring(17);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return water;
    }
    
    public String getResistenceEarth () {
        String earth = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Resistence Earth:")) {earth = aux.substring(17);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return earth;
    }
    
    public String getResistenceWind () {
        String wind = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Resistence Wind:")) {wind = aux.substring(16);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return wind;
    }
    
    public String getResistenceLight () {
        String light = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Resistence Light:")) {light = aux.substring(17);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return light;
    }
    
    public String getResistenceBlack () {
        String black = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Resistence Black:")) {black = aux.substring(17);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return black;
    }
    
    public String getElementNeutral () {
        String neutral = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Element Neutral:")) {neutral = aux.substring(16);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return neutral;
    }
    
    public String getElementFire () {
        String fire = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Element Fire:")) {fire = aux.substring(13);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return fire;
    }
    
    public String getElementWater () {
        String water = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Element Water:")) {water = aux.substring(14);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return water;
    }
    
    public String getElementEarth () {
        String earth = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Element Earth:")) {earth = aux.substring(14);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return earth;
    }
    
    public String getElementWind () {
        String wind = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Element Wind:")) {wind = aux.substring(13);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return wind;
    }
    
    public String getElementLight () {
        String light = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Element Light:")) {light = aux.substring(14);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return light;
    }
    
    public String getElementBlack () {
        String black = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Element Black:")) {black = aux.substring(14);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return black;
    }
    
    public String getSkill () {
        String skill = null;
        if (iten.canRead() == true) {
            try (BufferedReader br = new BufferedReader (new FileReader (iten))) {
                while (br.ready()) {
                    String aux = br.readLine();
                    if (aux.startsWith("Skill:")) {skill = aux.substring(6);}
                }
            }
            catch (IOException e) {e.getMessage();}
        }
        
        return skill;
    }
    
    public void Deleta () {iten.deleteOnExit();}
}
