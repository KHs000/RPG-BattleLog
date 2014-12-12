

package rpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaLestrade extends JFrame{
    private final JTextField Name;
    private final JTextField CampoName;
    private final JTextField HP;
    private final JTextField CampoHP;
    private final JTextField MANA;
    private final JTextField CampoMANA;
    private final JTextField CampoSkill;
    //private final JTextField CampoInv;
    private JTextField SkillNome;
    //private JTextField ItemNome;
    private String [] Skill;
    //private String [] Item;
    //private String [] ItemQuant;
    private final JButton Voltar;
    private final JPanel Ficha;
    private int SkillLinha = 2;
    public JanelaLestrade () {
        super ("Lestrade");
        
        setLayout (new BorderLayout());
        setVisible(true);
        Ficha = new JPanel ();
        Voltar = new JButton("Voltar");
        
        PlayerRead player = new PlayerRead (1);
        try {
            player.Testa();
            player.setHP();
            player.setMANA();
            player.setQuant();
            player.setSkill();
        }
        catch (Exception e) {
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
        Ficha.add(CampoName, c);
        Name = new JTextField(11);
        Name.setEditable(false);
        Name.setText(player.getName());
        c.gridy = 0;
        c.gridx = 1;
        c.gridwidth = 2;
        Ficha.add(Name, c);
        
        CampoHP = new JTextField (4);
        CampoHP.setText("HP:");
        CampoHP.setBackground(Color.GRAY);
        CampoHP.setForeground(Color.WHITE);
        CampoHP.setEditable(false);
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 1;
        Ficha.add(CampoHP, c);
        HP = new JTextField (6);
        HP.setEditable(false);
        HP.setText(player.getHP());
        c.gridy = 1;
        c.gridx = 1;
        Ficha.add(HP, c);
        Skill = player.getSkill();
        CampoMANA = new JTextField(4);
        CampoMANA.setText("MANA:");
        CampoMANA.setBackground(Color.GRAY);
        CampoMANA.setForeground(Color.WHITE);
        CampoMANA.setEditable(false);
        c.gridy = 1;
        c.gridx = 2;
        c.gridwidth = 1;
        Ficha.add(CampoMANA, c);
        MANA = new JTextField (6);
        MANA.setEditable(false);
        MANA.setText(player.getMANA());
        c.gridy = 1;
        c.gridx = 3;
        c.gridwidth = 1;
        Ficha.add(MANA, c);
        
        CampoSkill = new JTextField (4);
        CampoSkill.setText("Skills:");
        CampoSkill.setBackground(Color.GRAY);
        CampoSkill.setForeground(Color.WHITE);
        CampoSkill.setEditable(false);
        c.gridy = 2;
        c.gridx = 4;
        c.gridwidth = 1;
        Ficha.add(CampoSkill, c);
        setSkill(player.getSkill());
        for (int i = 0 ; i < player.getQuant() ; i ++) {
            SkillNome = new JTextField (10);
            SkillNome.setEditable(false);
            JOptionPane.showMessageDialog(null, Skill[0]);
            c.gridy = SkillLinha;
            c.gridx = 5;
            c.gridwidth = 1;
            Ficha.add(SkillNome, c);
            setSkillLinha();
        }
    }

    public int getSkillLinha() {
        return SkillLinha;
    }

    public void setSkillLinha() {
        SkillLinha++;
    }
    
    public String getSkill (int i) {
        return Skill[i];
    }
    
    public void setSkill (String [] Skill) {
        this.Skill = Skill;
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
