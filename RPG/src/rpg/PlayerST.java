

package rpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Felipe Rabelo
 */
public class PlayerST {
    private File playerFile;
    private int STR; //Atributo força
    private int DEX; //Atributo dextreza
    private int CON; //Atributo constituição
    private int INT; //Atributo inteligência
    private int WIS; //Atributo sabedoria(wisdom) 
    private int CHA; //Atributo carisma
    private int Vit; //Valor do HP
    private int Def; //Valor da defesa, armadura
    private int BAtk; //Valor do dano do jogador
    private int Init; //Valor da iniciativa do jogador
    private int For; //Marcador de resistência física
    private int Ref; //Marcador de reflexo
    private int Wil; //Marcador de sabedoria
    private int Mel; //Dano de ataque melee
    private int Ran; //Dano de ataque ranged
    private Object [][] Weapon = new Object [9][2];
    private Object [][] Armor = new Object [9][1];
    private ArrayList Item; //Lista de itens
    private ArrayList Skill; //Lista de skills ou proficiência
    private ArrayList Hab; //Lista efetiva de skills ou habilidades
    private String [] Dados = new String [13]; //Informações da ficha
    private String [] DadosLabel = {"Name:", "Player:", "Class:", "Species:", 
        "Character Lvl:", "Class Lvl:", "Age:", "Gender:", "Height:", "Weight:", 
        "Eyes:", "Hair:", "Skin:"};
    
    public PlayerST () {
        playerFile  = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Star Wars\\Jogadores\\"
                + "tempName.txt");
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
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

    public int getWIS() {
        return WIS;
    }

    public void setWIS(int WIS) {
        this.WIS = WIS;
    }

    public int getCHA() {
        return CHA;
    }

    public void setCHA(int CHA) {
        this.CHA = CHA;
    }

    public int getVit() {
        return Vit;
    }

    public void setVit(int Vit) {
        this.Vit = Vit;
    }

    public int getDef() {
        return Def;
    }

    public void setDef(int Def) {
        this.Def = Def;
    }

    public int getBAtk() {
        return BAtk;
    }

    public void setBAtk(int BAtk) {
        this.BAtk = BAtk;
    }

    public int getInit() {
        return Init;
    }

    public void setInit(int Init) {
        this.Init = Init;
    }

    public int getFor() {
        return For;
    }

    public void setFor(int For) {
        this.For = For;
    }

    public int getRef() {
        return Ref;
    }

    public void setRef(int Ref) {
        this.Ref = Ref;
    }

    public int getWil() {
        return Wil;
    }

    public void setWil(int Wil) {
        this.Wil = Wil;
    }

    public int getMel() {
        return Mel;
    }

    public void setMel(int Mel) {
        this.Mel = Mel;
    }

    public int getRan() {
        return Ran;
    }

    public void setRan(int Ran) {
        this.Ran = Ran;
    }

    public Object[][] getWeapon() {
        return Weapon;
    }

    public void setWeapon(Object[][] Weapon) {
        this.Weapon = Weapon;
    }

    public Object[][] getArmor() {
        return Armor;
    }

    public void setArmor(Object[][] Armor) {
        this.Armor = Armor;
    }

    public ArrayList getItem() {
        return Item;
    }

    public void setItem(ArrayList Item) {
        this.Item = Item;
    }

    public ArrayList getSkill() {
        return Skill;
    }

    public void setSkill(ArrayList Skill) {
        this.Skill = Skill;
    }

    public ArrayList getHab() {
        return Hab;
    }

    public void setHab(ArrayList Hab) {
        this.Hab = Hab;
    }

    public String[] getDados() {
        return Dados;
    }

    public void setDados(String[] Dados) {
        this.Dados = Dados;
    }
    
    public void GeraHP () {
        switch (Dados[2]) {
            case "Nobre":
                Vit += 18;
            case "Vigarista":
                Vit += 18;
            case "Explorador":
                Vit += 24;
            case "Soldado":
                Vit += 30;
            case "Force User":
                Vit += 30;
        }
        
    }
    
    public void Cria () throws IOException{
        if (!playerFile.exists()) {
            playerFile.createNewFile();
        }
    }
    
    public void gravaFicha () throws IOException {
        if (playerFile.canWrite()) {
            try (BufferedWriter dado = new BufferedWriter (new FileWriter (playerFile))) {
                for (int i = 0 ; i < Dados.length ; i++) {
                    dado.write(DadosLabel[i]);
                    dado.write(Dados[i]);
                    dado.newLine();
                }
                File FName = new File (Dados[0] + ".txt");
                playerFile.renameTo(FName);
                FName.delete();
                dado.write("STR:");dado.write(STR);dado.newLine();
                dado.write("DEX:");dado.write(DEX);dado.newLine();
                dado.write("CON:");dado.write(CON);dado.newLine();
                dado.write("INT:");dado.write(INT);dado.newLine();
                dado.write("WIS:");dado.write(WIS);dado.newLine();
                dado.write("CHA:");dado.write(CHA);dado.newLine();
            }
        }
    }
}
