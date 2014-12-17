

package rpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaTyrion extends JFrame{
    private JTextField Name;
    private JTextField CampoName;
    private JTextField HP;
    private JTextField CampoHP;
    private JTextField MANA;
    private JTextField CampoMANA;
    private JTextField STR;
    private JTextField CampoSTR;
    private JTextField AGI;
    private JTextField CampoAGI;
    private JTextField DEX;
    private JTextField CampoDEX;
    private JTextField INT;
    private JTextField CampoINT;
    private JTextField CON;
    private JTextField CampoCON;
    private JTextField [] CampoSkill;
    private JTextField [] CampoSkillCost;
    private JTextField [] CampoInv;
    private JTextField [] CampoInvQuant;
    private JTextField SkillNome;
    private JTextField ItemNome;
    private JButton Voltar;
    private JPanel Ficha;
    private int linhaSkill = 3;
    private int linhaInv = 3;
    public JanelaTyrion () {
        super ("Tyrion");
        
        setLayout (new BorderLayout());
        setVisible(true);
        Ficha = new JPanel ();
        Voltar = new JButton("Voltar");
        
        PlayerRead player = new PlayerRead (2);
        try {
            player.Testa();
            player.setHP();
            player.setMANA();
            player.setSTR();
            player.setDEX();
            player.setAGI();
            player.setINT();
            player.setCON();
            player.setQuant();
            player.setQuantInv();
            player.setInv();
            player.setInvQuant();
        } catch (Exception e) {
            e.getMessage();
            }
        
        add(Ficha, BorderLayout.CENTER);
        add(Voltar, BorderLayout.SOUTH);
        
        Ficha.setBackground(Color.BLACK);
        Ficha.setLayout(new GridBagLayout());
        
        Event onclick = new Event ();
        Voltar.addActionListener(onclick);
        
        GridBagConstraints c = new GridBagConstraints ();
        c.insets = new Insets (2, 2, 2, 2);
        
        CampoName = new JTextField (4);
        CampoName.setText("Nome:");
        CampoName.setBackground(Color.GRAY);
        CampoName.setForeground(Color.WHITE);
        CampoName.setEditable(false);
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(CampoName, c);
        Name = new JTextField(11);
        Name.setEditable(false);
        Name.setText(player.getName());
        c.gridy = 0;
        c.gridx = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(Name, c);
        
        CampoHP = new JTextField (4);
        CampoHP.setText("HP:");
        CampoHP.setBackground(Color.GRAY);
        CampoHP.setForeground(Color.WHITE);
        CampoHP.setEditable(false);
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(CampoHP, c);
        HP = new JTextField (6);
        HP.setEditable(false);
        HP.setText(player.getHP());
        c.gridy = 1;
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(HP, c);
        
        CampoMANA = new JTextField(4);
        CampoMANA.setText("MANA:");
        CampoMANA.setBackground(Color.GRAY);
        CampoMANA.setForeground(Color.WHITE);
        CampoMANA.setEditable(false);
        c.gridy = 1;
        c.gridx = 2;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(CampoMANA, c);
        MANA = new JTextField (6);
        MANA.setEditable(false);
        MANA.setText(player.getMANA());
        c.gridy = 1;
        c.gridx = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(MANA, c);
        
        CampoSTR = new JTextField (4);
        CampoSTR.setText("STR:");
        CampoSTR.setBackground(Color.GRAY);
        CampoSTR.setForeground(Color.WHITE);
        CampoSTR.setEditable(false);
        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(CampoSTR, c);
        STR = new JTextField (3);
        STR.setText(player.getSTR());
        STR.setEditable(false);
        c.gridy = 2;
        c.gridx = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(STR, c);
        
        CampoDEX = new JTextField (4);
        CampoDEX.setText("DEX:");
        CampoDEX.setBackground(Color.GRAY);
        CampoDEX.setForeground(Color.WHITE);
        CampoDEX.setEditable(false);
        c.gridy = 3;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(CampoDEX, c);
        DEX = new JTextField (3);
        DEX.setText(player.getDEX());
        DEX.setEditable(false);
        c.gridy = 3;
        c.gridx = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(DEX, c);
        
        CampoAGI = new JTextField (4);
        CampoAGI.setText("AGI:");
        CampoAGI.setBackground(Color.GRAY);
        CampoAGI.setForeground(Color.WHITE);
        CampoAGI.setEditable(false);
        c.gridy = 4;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(CampoAGI, c);
        AGI = new JTextField (3);
        AGI.setText(player.getAGI());
        AGI.setEditable(false);
        c.gridy = 4;
        c.gridx = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(AGI, c);
        
        CampoINT = new JTextField (4);
        CampoINT.setText("INT:");
        CampoINT.setBackground(Color.GRAY);
        CampoINT.setForeground(Color.WHITE);
        CampoINT.setEditable(false);
        c.gridy = 5;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(CampoINT, c);
        INT = new JTextField (3);
        INT.setText(player.getINT());
        INT.setEditable(false);
        c.gridy = 5;
        c.gridx = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(INT, c);
        
        CampoCON = new JTextField (4);
        CampoCON.setText("CON:");
        CampoCON.setBackground(Color.GRAY);
        CampoCON.setForeground(Color.WHITE);
        CampoCON.setEditable(false);
        c.gridy = 6;
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(CampoCON, c);
        CON = new JTextField (3);
        CON.setText(player.getCON());
        CON.setEditable(false);
        c.gridy = 6;
        c.gridx = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(CON, c);
        
        ItemNome = new JTextField (5);
        ItemNome.setText("Inventário");
        ItemNome.setBackground(Color.GRAY);
        ItemNome.setForeground(Color.WHITE);
        ItemNome.setEditable(false);
        c.gridy = 2;
        c.gridx = 2;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(ItemNome, c);
        CampoInv = new JTextField [player.getQuantInv()];
        CampoInvQuant = new JTextField [player.getQuantInv()];
        player.setInvQuant();
        for (int i = 0 ; i < CampoInv.length ; i++) {
            CampoInv[i] = new JTextField (15);
            CampoInv[i].setText(player.getInv(i));
            CampoInv[i].setEditable(false);
            c.gridy = linhaInv;
            c.gridx = 2;
            c.gridwidth = 2;
            c.fill = GridBagConstraints.HORIZONTAL;
            Ficha.add(CampoInv[i], c);
            CampoInvQuant[i] = new JTextField (3);
            CampoInvQuant[i].setText(player.getInvQuant(i));
            CampoInvQuant[i].setToolTipText("Quantidade no inventário");
            CampoInvQuant[i].setEditable(false);
            c.gridy = linhaInv;
            c.gridx = 4;
            c.gridwidth = 1;
            c.fill = GridBagConstraints.HORIZONTAL;
            Ficha.add(CampoInvQuant[i], c);
            linhaInv++;
        }
        
        SkillNome = new JTextField(5);
        SkillNome.setText("Skill");
        SkillNome.setBackground(Color.GRAY);
        SkillNome.setForeground(Color.WHITE);
        SkillNome.setEditable(false);
        c.gridy = 2;
        c.gridx = 5;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        Ficha.add(SkillNome, c);
        CampoSkill = new JTextField[player.getQuant()];
        player.setSkill();
        CampoSkillCost = new JTextField[player.getQuant()];
        player.setSkillCost();
        for (int i = 0 ; i < CampoSkill.length ; i++) {
            CampoSkill[i] = new JTextField(15);
            CampoSkill[i].setText(player.getSkill(i));
            CampoSkill[i].setEditable(false);
            c.gridy = linhaSkill;
            c.gridx = 5;
            c.gridwidth = 2;
            c.fill = GridBagConstraints.HORIZONTAL;
            Ficha.add(CampoSkill[i], c);
            CampoSkillCost[i] = new JTextField (3);
            CampoSkillCost[i].setText(player.getSkillCost(i));
            CampoSkillCost[i].setToolTipText("Custo de ativação da skill");
            CampoSkillCost[i].setEditable(false);
            c.gridy = linhaSkill;
            c.gridx = 7;
            c.gridwidth = 1;
            c.fill = GridBagConstraints.HORIZONTAL;
            Ficha.add(CampoSkillCost[i], c);
            linhaSkill++;
        }
    }
    
    public void encerar () {
        this.dispose();
    }
    
    private class Event implements ActionListener{
      @Override
      public void actionPerformed( ActionEvent event ){
          if (event.getSource() == Voltar) {
              encerar();
              
             JanelaIniciar init = new JanelaIniciar();
             init.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
             init.setSize(250, 250);
             init.setLocation(500, 30);
             init.setVisible( true );
          }
      }
   }
}
