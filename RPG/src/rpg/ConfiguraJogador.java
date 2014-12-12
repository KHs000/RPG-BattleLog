

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
    private JTextField CampoSkill;
    private JTextField CampoSkillCost;
    private JTextField CampoInventario;
    private JTextField CampoItemQuant;
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
        painel.add(CampoName, c);
        
        CampoHP = new JTextField (5);
        CampoHP.setEditable(true);
        CampoHP.setText("HP");
        CampoHP.setToolTipText("Digite o valor do HP do personagem");
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 1;
        painel.add(CampoHP, c);
        
        CampoMANA = new JTextField (5);
        CampoMANA.setEditable(true);
        CampoMANA.setText("MANA");
        CampoMANA.setToolTipText("Digite o valor da MANA do personagem");
        c.gridy = 1;
        c.gridx = 1;
        c.gridwidth = 1;
        painel.add(CampoMANA, c);
        
        CampoInventario = new JTextField (10);
        CampoInventario.setEditable(true);
        CampoInventario.setText("Inventário");
        CampoInventario.setToolTipText("Digite o nome do item");
        c.gridy = 2;
        c.gridx = 1;
        c.gridwidth = 2;
        painel.add(CampoInventario, c);
        
        CampoItemQuant = new JTextField (5);
        CampoItemQuant.setEditable(true);
        CampoItemQuant.setText("Quant");
        CampoItemQuant.setToolTipText("Digite a quantidade");
        c.gridy = 2;
        c.gridx = 4;
        c.gridwidth = 1;
        painel.add(CampoItemQuant, c);
        
        ImageIcon plus = new ImageIcon ("plus.jpg");
        NovoAdd = new JButton (plus);
        NovoAdd.setPreferredSize(new Dimension(10, 10));
        NovoAdd.setToolTipText("Adicionar novo campo de inventário");
        NovoAdd.addActionListener(onclick);
        c.gridy = 2;
        c.gridx = 5;
        c.anchor = GridBagConstraints.NORTH;
        painel.add(NovoAdd, c);
        ImageIcon minus = new ImageIcon ("minus.png");
        NovoSub = new JButton (minus);
        NovoSub.setPreferredSize(new Dimension(10, 10));
        NovoSub.setToolTipText("Remover último campo de inventário");
        NovoSub.addActionListener(onclick);
        c.gridy = 2;
        c.gridx = 5;
        c.anchor = GridBagConstraints.SOUTH;
        painel.add(NovoSub, c);
        
        CampoSkill = new JTextField (10);
        CampoSkill.setEditable(true);
        CampoSkill.setText("Skill");
        CampoSkill.setToolTipText("Digite o nome de uma skill");
        c.gridy = 2;
        c.gridx = 6;
        c.gridwidth = 2;
        painel.add(CampoSkill, c);
        
        CampoSkillCost = new JTextField (5);
        CampoSkillCost.setEditable(true);
        CampoSkillCost.setText("Skill Cost");
        CampoSkillCost.setToolTipText("Digite o custo de ativação da skill");
        c.gridy = 2;
        c.gridx = 8;
        c.gridwidth = 1;
        painel.add(CampoSkillCost, c);
        
        add = new JButton (plus);
        add.setPreferredSize(new Dimension(10, 10));
        add.setToolTipText("Adicionar novo campo skill");
        add.addActionListener(onclick);
        c.gridy = 2;
        c.gridx = 10;
        c.anchor = GridBagConstraints.NORTH;
        painel.add(add, c);
        sub = new JButton (minus);
        sub.setPreferredSize(new Dimension(10, 10));
        sub.setToolTipText("Remover último campo skill");
        sub.addActionListener(onclick);
        c.gridy = 2;
        c.gridx = 10;
        c.anchor = GridBagConstraints.SOUTH;
        painel.add(sub, c);
        
        CampoSTR = new JTextField (5);
        CampoSTR.setEditable(true);
        CampoSTR.setText("STR");
        CampoSTR.setToolTipText("Digite o valor da STR - MAX: 10");
        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 1;
        painel.add(CampoSTR, c);
        
        CampoDEX = new JTextField (5);
        CampoDEX.setEditable(true);
        CampoDEX.setText("DEX");
        CampoDEX.setToolTipText("Digite o valor da DEX - MAX: 3");
        c.gridy = 3;
        c.gridx = 0;
        c.gridwidth = 1;
        painel.add(CampoDEX, c);
        
        CampoAGI = new JTextField (5);
        CampoAGI.setEditable(true);
        CampoAGI.setText("AGI");
        CampoAGI.setToolTipText("Digite o valor da AGI - MAX: 3");
        c.gridy = 4;
        c.gridx = 0;
        c.gridwidth = 1;
        painel.add(CampoAGI, c);
        
        CampoINT = new JTextField (5);
        CampoINT.setEditable(true);
        CampoINT.setText("INT");
        CampoINT.setToolTipText("Digite o valor da INT");
        c.gridy = 5;
        c.gridx = 0;
        c.gridwidth = 1;
        painel.add(CampoINT, c);
        
        CampoCON = new JTextField (5);
        CampoCON.setEditable(true);
        CampoCON.setText("CON");
        CampoCON.setToolTipText("Digite o valor da CON");
        c.gridy = 6;
        c.gridx = 0;
        c.gridwidth = 1;
        painel.add(CampoCON, c);
        
        salvar = new JButton ("Salvar");
        salvar.addActionListener(onclick);
        c.gridy = 7;
        c.gridx = 0;
        c.gridwidth = 3;
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
        Skill[i] = CampoSkill.getText();
    }

    public String getSkillCost(int i) {
        return SkillCost[i];
    }

    public void setSkillCost(int i) {
        SkillCost[i] = CampoSkillCost.getText();
    }

    public String getInventario(int i) {
        return Inventario[i];
    }

    public void setInventario(int i) {
        Inventario[i] = CampoInventario.getText();
    }

    public String getItemQuant(int i) {
        return ItemQuant[i];
    }

    public void setItemQuant(int i) {
        ItemQuant[i] = CampoItemQuant.getText();
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
            if (event.getSource() == add) {
                Event onclick = new Event();
                ImageIcon plus = new ImageIcon ("plus.jpg");
                ImageIcon minus = new ImageIcon ("minus.png");
                GridBagConstraints c = new GridBagConstraints ();
                setLinha();
                
                setSkill(cont);
                setSkillCost(cont);
                cont++;
                
                CampoSkill = new JTextField(10);
                CampoSkill.setText("Skill");
                CampoSkill.setToolTipText("Digite o nome de uma skill");
                c.gridy = getLinha();
                c.gridx = 6;
                c.gridwidth = 2;
                painel.add(CampoSkill, c);
                
                CampoSkillCost = new JTextField (5);
                CampoSkillCost.setText("Skill Cost");
                CampoSkillCost.setToolTipText("Digite o valor de ativação da skill");
                c.gridy = getLinha();
                c.gridx = 8;
                c.gridwidth = 1;
                painel.add(CampoSkillCost, c);
                
                add = new JButton (plus);
                add.setPreferredSize(new Dimension(10, 10));
                add.setToolTipText("Adicionar novo campo skill e valida-lo");
                add.addActionListener(onclick);
                c.gridy = getLinha();
                c.gridx = 10;
                c.anchor = GridBagConstraints.NORTH;
                painel.add(add, c);
                sub = new JButton (minus);
                sub.setPreferredSize(new Dimension(10, 10));
                sub.setToolTipText("Remover último campo skill");
                sub.addActionListener(onclick);
                c.gridy = getLinha();
                c.gridx = 10;
                c.anchor = GridBagConstraints.SOUTH;
                painel.add(sub, c);
                
                painel.remove(salvar);
                if (getLinha() < 7 && getInvLinha() < 7) {
                    c.gridy = 7;
                }
                else {
                    setNovaLinha();
                    c.gridy = getNovaLinha();
                }
                c.gridx = 0;
                c.gridwidth = 3;
                painel.add(salvar, c);
                
                ConfiguraJogador.this.validate();
            }
            if (event.getSource() == sub) {
                painel.remove(CampoSkill);
                painel.remove(add);
                painel.remove(sub);
                painel.validate();
                
                Event onclick = new Event();
            }
            if (event.getSource() == NovoAdd) {
                Event onclick = new Event();
                ImageIcon plus = new ImageIcon ("plus.jpg");
                ImageIcon minus = new ImageIcon ("minus.png");
                GridBagConstraints c = new GridBagConstraints ();
                setInvLinha();
                
                setInventario(InvCont);
                setItemQuant(InvCont);
                InvCont++;
                
                CampoInventario = new JTextField(10);
                CampoInventario.setText("Inventário");
                CampoInventario.setToolTipText("Digite o nome do item");
                c.gridy = getInvLinha();
                c.gridx = 1;
                c.gridwidth = 2;
                painel.add(CampoInventario, c);
                
                CampoItemQuant = new JTextField (5);
                CampoItemQuant.setEditable(true);
                CampoItemQuant.setText("Quant");
                CampoItemQuant.setToolTipText("Digite a quantidade");
                c.gridy = getInvLinha();
                c.gridx = 4;
                c.gridwidth = 1;
                painel.add(CampoItemQuant, c);
                
                NovoAdd = new JButton (plus);
                NovoAdd.setPreferredSize(new Dimension(10, 10));
                NovoAdd.setToolTipText("Adicionar novo campo inventário e valida-lo");
                NovoAdd.addActionListener(onclick);
                c.gridy = getInvLinha();
                c.gridx = 5;
                c.anchor = GridBagConstraints.NORTH;
                painel.add(NovoAdd, c);
                NovoSub = new JButton (minus);
                NovoSub.setPreferredSize(new Dimension(10, 10));
                NovoSub.setToolTipText("Remover último campo inventário");
                NovoSub.addActionListener(onclick);
                c.gridy = getInvLinha();
                c.gridx = 5;
                c.anchor = GridBagConstraints.SOUTH;
                painel.add(NovoSub, c);
                
                painel.remove(salvar);
                if (getLinha() < 7 && getInvLinha() < 7) {
                    c.gridy = 7;
                }
                else {
                    setNovaLinha();
                    c.gridy = getNovaLinha();
                }
                c.gridx = 0;
                c.gridwidth = 3;
                painel.add(salvar, c);
                
                ConfiguraJogador.this.validate();
            }
        }
    }
}
