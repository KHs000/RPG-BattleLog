

package rpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Felipe Rabelo
 */
public class ConfiguraJogador extends JFrame{
    private final JTextField CampoName;
    private String Name;
    private final JTextField CampoHP;
    private String HP;
    private final JTextField CampoMANA;
    private String MANA;
    private final JTextField CampoSTR;
    private String STR;
    private final JTextField CampoAGI;
    private String AGI;
    private final JTextField CampoDEX;
    private String DEX;
    private final JTextField CampoINT;
    private String INT;
    private final JTextField CampoCON;
    private String CON;
    private JTextField [] CampoSkill;
    private JTextField [] CampoSkillCost;
    private JTextField [] CampoInventario;
    private JTextField [] CampoItemQuant;
    private int linha = 2;
    private int InvLinha = 2;
    private int NovaLinha = 7;
    private String Skill [];
    private String SkillCost [];
    private String Inventario [];
    private String ItemQuant [];
    private int Quant;
    private int QuantInv;
    private int cont = 0;
    private int InvCont = 0;
    private int linhaSkill = 2;
    private int linhaSkillCost = 2;
    private int linhaInv = 2;
    private int linhaInvQuant = 2;
    private final int STRMAX = 10;
    private final int DEXMAX = 3;
    private final int AGIMAX = 3;
    private JButton add;
    private JButton NovoAdd;
    private JButton sub;
    private JButton NovoSub;
    private final JButton salvar;
    private final JButton voltar;
    private final JPanel painel;
    
    public ConfiguraJogador () {
        super ("Configuração - Jogador");
        
        Quant = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantas skills"
                + " o jogador possui?"));
        QuantInv = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantos itens"
                + " o jogador tem no invéntario?"));
                
        setLayout (new BorderLayout());
        setVisible (true);
        painel = new JPanel();
        voltar = new JButton ("Voltar");
        
        add(painel, BorderLayout.CENTER);
        add(voltar, BorderLayout.SOUTH);
        
        painel.setBackground(Color.BLACK);
        painel.setLayout(new GridBagLayout());
        
        Event onclick = new Event ();
        voltar.addActionListener(onclick);
        
        GridBagConstraints c = new GridBagConstraints ();
        c.insets = new Insets (2, 2, 2, 2);
        
        CampoName = new JTextField (11);
        CampoName.setEditable(true);
        CampoName.setText("Nome");
        CampoName.setToolTipText("Digite o nome do personagem");
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        painel.add(CampoName, c);
        
        CampoHP = new JTextField (5);
        CampoHP.setEditable(true);
        CampoHP.setText("HP");
        CampoHP.setToolTipText("Digite o valor do HP do personagem");
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        painel.add(CampoHP, c);
        
        CampoMANA = new JTextField (5);
        CampoMANA.setEditable(true);
        CampoMANA.setText("MANA");
        CampoMANA.setToolTipText("Digite o valor da MANA do personagem");
        c.gridy = 1;
        c.gridx = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        painel.add(CampoMANA, c);
        
        CampoInventario = new JTextField[QuantInv];
        for (int i = 0 ; i < CampoInventario.length ; i++) {
            CampoInventario[i] = new JTextField(15);
            CampoInventario[i].setEditable(true);
            CampoInventario[i].setText("Item");
            CampoInventario[i].setToolTipText("Digite o nome do item");
            c.gridy = linhaInv;
            c.gridx = 1;
            c.gridwidth = 2;
            c.fill = GridBagConstraints.HORIZONTAL;
            painel.add(CampoInventario[i], c);
            linhaInv++;
        }
        
        CampoItemQuant = new JTextField[QuantInv];
        for (int i = 0 ; i < CampoItemQuant.length ; i++) {
            CampoItemQuant[i] = new JTextField(5);
            CampoItemQuant[i].setEditable(true);
            CampoItemQuant[i].setText("Quant");
            CampoItemQuant[i].setToolTipText("Digite a quantidade do item no inventário");
            c.gridy = linhaInvQuant;
            c.gridx = 3;
            c.gridwidth = 1;
            c.fill = GridBagConstraints.HORIZONTAL;
            painel.add(CampoItemQuant[i], c);
            linhaInvQuant++;
        }
        
        CampoSkill = new JTextField[Quant];
        for (int i = 0 ; i < CampoSkill.length ; i++) {
            CampoSkill[i] = new JTextField(15);
            CampoSkill[i].setEditable(true);
            CampoSkill[i].setText("Skill");
            CampoSkill[i].setToolTipText("Digite o nome da skill");
            c.gridy = linhaSkill;
            c.gridx = 4;
            c.gridwidth = 2;
            c.fill = GridBagConstraints.HORIZONTAL;
            painel.add(CampoSkill[i], c);
            linhaSkill++;
        }
        
        CampoSkillCost = new JTextField[Quant];
        for (int i = 0 ; i < CampoSkillCost.length ; i++) {
            CampoSkillCost[i] = new JTextField(5);
            CampoSkillCost[i].setEditable(true);
            CampoSkillCost[i].setText("Cost");
            CampoSkillCost[i].setToolTipText("Digite o valor de ativação da skill");
            c.gridy = linhaSkillCost;
            c.gridx = 6;
            c.gridwidth = 1;
            c.fill = GridBagConstraints.HORIZONTAL;
            painel.add(CampoSkillCost[i], c);
            linhaSkillCost++;
        }
        
        CampoSTR = new JTextField (5);
        CampoSTR.setEditable(true);
        CampoSTR.setText("STR");
        CampoSTR.setToolTipText("Digite o valor da STR - MAX: 10");
        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        painel.add(CampoSTR, c);
        
        CampoDEX = new JTextField (5);
        CampoDEX.setEditable(true);
        CampoDEX.setText("DEX");
        CampoDEX.setToolTipText("Digite o valor da DEX - MAX: 3");
        c.gridy = 3;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        painel.add(CampoDEX, c);
        
        CampoAGI = new JTextField (5);
        CampoAGI.setEditable(true);
        CampoAGI.setText("AGI");
        CampoAGI.setToolTipText("Digite o valor da AGI - MAX: 3");
        c.gridy = 4;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        painel.add(CampoAGI, c);
        
        CampoINT = new JTextField (5);
        CampoINT.setEditable(true);
        CampoINT.setText("INT");
        CampoINT.setToolTipText("Digite o valor da INT");
        c.gridy = 5;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        painel.add(CampoINT, c);
        
        CampoCON = new JTextField (5);
        CampoCON.setEditable(true);
        CampoCON.setText("CON");
        CampoCON.setToolTipText("Digite o valor da CON");
        c.gridy = 6;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        painel.add(CampoCON, c);
        
        salvar = new JButton ("Salvar");
        salvar.addActionListener(onclick);
        c.gridy = 7;
        c.gridx = 0;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        painel.add(salvar, c);
        
        Skill = new String [Quant];
        SkillCost = new String [Quant];
        Inventario = new String [QuantInv];
        ItemQuant = new String [QuantInv];
    }
    
    @Override
    public String getName () {
        return Name;
    }
    
    public void setName () {
        Name = CampoName.getText();
    }
    
    public String getHP () {
        return HP;
    }
    
    public void setHP () {
        HP = CampoHP.getText();
    }
    
    public String getMANA () {
        return MANA;
    }
    
    public void setMANA () {
        MANA = CampoMANA.getText();
    }

    public String getSTR() {
        return STR;
    }

    public void setSTR() {
        STR = CampoSTR.getText();
    }

    public String getAGI() {
        return AGI;
    }

    public void setAGI() {
        AGI = CampoAGI.getText();
    }

    public String getDEX() {
        return DEX;
    }

    public void setDEX() {
        DEX = CampoDEX.getText();
    }

    public String getINT() {
        return INT;
    }

    public void setINT() {
        INT = CampoINT.getText();
    }

    public String getCON() {
        return CON;
    }

    public void setCON() {
        CON = CampoCON.getText();
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha() {
        linha = linha + 1;
    }

    public int getInvLinha() {
        return InvLinha;
    }

    public void setInvLinha() {
        InvLinha = InvLinha + 1;
    }
    
    public int getNovaLinha () {
        return NovaLinha;
    }
    
    public void setNovaLinha () {
        NovaLinha = NovaLinha + 1;
    }
    
    public String getSkill (int i) {
        return Skill[i];
    }
    
    public void setSkill (int i) {
        Skill[i] = CampoSkill[i].getText();
    }

    public String getSkillCost(int i) {
        return SkillCost[i];
    }

    public void setSkillCost(int i) {
        SkillCost[i] = CampoSkillCost[i].getText();
    }

    public String getInventario(int i) {
        return Inventario[i];
    }

    public void setInventario(int i) {
        Inventario[i] = CampoInventario[i].getText();
    }

    public String getItemQuant(int i) {
        return ItemQuant[i];
    }

    public void setItemQuant(int i) {
        ItemQuant[i] = CampoItemQuant[i].getText();
    }
    
    public int getQuant () {
        return Quant;
    }
    
    public int getQuantInv () {
        return QuantInv;
    }
    
    public void encerrar () {
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja voltar ?"
                + "\nDados não salvos serão perdidos", "ATENÇÂO ", JOptionPane.YES_NO_OPTION ) == 0) {
            this.dispose();
            JanelaConfiguracao config = new JanelaConfiguracao ();
            config.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            config.setSize(250, 250);
            config.setLocation(500, 3);
            config.setVisible(true);
        }
    }
    
    private class Event implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent event ) {
            if (event.getSource() == voltar) {
                encerrar();
            }
            if (event.getSource() == salvar) {
                setName();
                setHP();
                setMANA();
                setSTR();
                setAGI();
                setDEX();
                setCON();
                setINT();
                for (int i = 0 ; i < CampoSkill.length ; i++) {
                    setSkill(i);
                    setSkillCost(i);
                }
                for (int i = 0 ; i < CampoInventario.length ; i++) {
                    setInventario(i);
                    setItemQuant(i);
                }
                Player Ficha = new Player (getName(), getQuant(), getQuantInv());
                try {
                    Ficha.Cria();
                }
                catch (IOException e) {
                    e.getMessage();
                }
                
                Ficha.setHP(Integer.valueOf(getHP()));
                Ficha.setMANA(Integer.valueOf(getMANA()));
                Ficha.setName(getName());
                Ficha.setItem(Inventario);
                Ficha.setItemQuant(ItemQuant);
                Ficha.setSkill(Skill);
                Ficha.setSkillCost(SkillCost);
                Ficha.setSTR(Integer.valueOf(getSTR()));
                Ficha.setDEX(Integer.valueOf(getDEX()));
                Ficha.setAGI(Integer.valueOf(getDEX()));
                Ficha.setCON(Integer.valueOf(getCON()));
                Ficha.setINT(Integer.valueOf(getINT()));
                
                try {
                    Ficha.gravaFicha();
                    JOptionPane.showMessageDialog(null, "Informações gravadas com sucesso", 
                            "Aviso", WIDTH);
                }
                catch (IOException e) {
                    e.getMessage();
                }
            }
        }
    }
}
