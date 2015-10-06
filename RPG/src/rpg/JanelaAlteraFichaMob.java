

package rpg;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaAlteraFichaMob extends JFrame{
    private JButton voltar;
    private JButton salvar;
    private JPanel areaConteudo;
    private JPanel inv;
    private JPanel hab;
    private JLabel [] label = new JLabel[12];
    private JTextField [] textField = new JTextField[12];
    private JTextField [] item; private JTextField [] itemQuant;
    private JTextField [] skill; private JTextField [] skillCost;
    private String [] labelNome = {"Nome:", "STR:", "WIS:", "VIG:", "WIL:", "CON:", "INT:", "DEX:", "XP Drop:", 
        "Nível:", "HP:", "MP:"};
    
    public JanelaAlteraFichaMob (String name) {
        super (name);
        
        setLayout(new BorderLayout());
        setVisible(true);
        voltar = new JButton ("Voltar");
        salvar = new JButton ("Salvar");
        areaConteudo = new JPanel ();
        areaConteudo.setLayout(new GridBagLayout());
        inv = new JPanel ();
        inv.setLayout(new GridBagLayout());
        hab = new JPanel ();
        hab.setLayout(new GridBagLayout());
        JScrollPane jsp = new JScrollPane (areaConteudo);
        JScrollPane jspInv = new JScrollPane (inv);
        JScrollPane jspHab = new JScrollPane (hab);
        add(voltar, BorderLayout.SOUTH);
        add(jsp, BorderLayout.CENTER);
        
        Event onclick = new Event();
        
        MobReader mob = new MobReader (name);
        GridBagConstraints c = new GridBagConstraints ();
        c.insets = new Insets (2, 2, 2, 2);
        
        for (int i = 0 ; i < label.length ; i++) {label[i] = new JLabel(labelNome[i]);}
        
        c.gridy = 0; c.gridx = 0;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(label[0], c);
        c.gridy = 0; c.gridx = 1;
        c.gridwidth = 4; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        textField[0] = new JTextField (mob.getName(), 40);
        areaConteudo.add(textField[0], c);
        
        c.gridy = 0; c.gridx = 5;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(label[9], c);
        c.gridy = 0; c.gridx = 6;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        textField[9] = new JTextField (mob.getLevel(), 10);
        areaConteudo.add(textField[9], c);
        
        c.gridy = 0; c.gridx = 7;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(label[10], c);
        c.gridy = 0; c.gridx = 8;
        c.gridwidth = 3; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        textField[10] = new JTextField (mob.getHP(), 30);
        areaConteudo.add(textField[10], c);
        
        c.gridy = 1; c.gridx = 0;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(label[1], c);
        c.gridy = 1; c.gridx = 1;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        textField[1] = new JTextField (mob.getSTR(), 10);
        areaConteudo.add(textField[1], c);
        
        c.gridy = 1; c.gridx = 2;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(label[8], c);
        c.gridy = 1; c.gridx = 3;
        c.gridwidth = 3; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        textField[8] = new JTextField (mob.getXPDrop(), 30);
        areaConteudo.add(textField[8], c);
        
        c.gridy = 1; c.gridx = 7;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(label[11], c);
        c.gridy = 1; c.gridx = 8;
        c.gridwidth = 3; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        textField[11] = new JTextField (mob.getMP(), 30);
        areaConteudo.add(textField[11], c);
        
        c.gridy = 2; c.gridx = 0;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(label[2], c);
        c.gridy = 2; c.gridx = 1;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        textField[2] = new JTextField (mob.getWIS(), 10);
        areaConteudo.add(textField[2], c);
        
        
        c.gridy = 3; c.gridx = 0;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(label[3], c);
        c.gridy = 3; c.gridx = 1;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        textField[3] = new JTextField (mob.getVIG(), 10);
        areaConteudo.add(textField[3], c);
        
        c.gridy = 4; c.gridx = 0;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(label[4], c);
        c.gridy = 4; c.gridx = 1;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        textField[4] = new JTextField (mob.getWIL(), 10);
        areaConteudo.add(textField[4], c);
        
        c.gridy = 5; c.gridx = 0;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(label[5], c);
        c.gridy = 5; c.gridx = 1;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        textField[5] = new JTextField (mob.getCON(), 10);
        areaConteudo.add(textField[5], c);
        
        c.gridy = 6; c.gridx = 0;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(label[6], c);
        c.gridy = 6; c.gridx = 1;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        textField[6] = new JTextField (mob.getINT(), 10);
        areaConteudo.add(textField[6], c);
        
        c.gridy = 7; c.gridx = 0;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(label[7], c);
        c.gridy = 7; c.gridx = 1;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        textField[7] = new JTextField (mob.getDEX(), 10);
        areaConteudo.add(textField[7], c);
        
        c.gridy = 2; c.gridx = 2;
        c.gridwidth = 4; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        c.gridheight = 12;
        areaConteudo.add(jspHab, c);
        
        c.gridy = 2; c.gridx = 6;
        c.gridwidth = 4; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        c.gridheight = 12;
        areaConteudo.add(jspInv, c);
        
        c.gridy = 14; c.gridx = 4;
        c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
        areaConteudo.add(salvar, c);
        
        item = new JTextField [mob.contInv()];
        itemQuant = new JTextField [mob.contInv()];
        String [] itemName = mob.getItem(); String [] itemQuantNum = mob.getItemQuant();
        for (int i = 0 ; i < item.length ; i++) {
            c.gridy = i; c.gridx = 0;
            c.gridwidth = 2; c.fill = GridBagConstraints.HORIZONTAL;
            c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
            item[i] = new JTextField (itemName[i], 20);
            inv.add(item[i], c);
            c.gridy = i; c.gridx = 3;
            c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
            c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
            itemQuant[i] = new JTextField (itemQuantNum[i], 10);
            inv.add(itemQuant[i], c);
        }
        
        skill = new JTextField [mob.contSkill()];
        skillCost = new JTextField [mob.contSkill()];
        String [] skillName = mob.getSkill(); String [] skillCostNum = mob.getSkillCost();
        for (int i = 0 ; i < skill.length ; i++) {
            c.gridy = i; c.gridx = 0;
            c.gridwidth = 2; c.fill = GridBagConstraints.HORIZONTAL;
            c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
            skill[i] = new JTextField (skillName[i], 20);
            hab.add(skill[i], c);
            c.gridy = i; c.gridx = 3;
            c.gridwidth = 1; c.fill = GridBagConstraints.HORIZONTAL;
            c.anchor = GridBagConstraints.NORTH; c.weighty = 1;
            skillCost[i] = new JTextField (skillCostNum[i], 10);
            hab.add(skillCost[i], c);
        }
        
        voltar.addActionListener(onclick);
        salvar.addActionListener(onclick);
    }
    
    private void encerrar () {
        this.dispose();
    }
    
    private class Event implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent event) {
            if (event.getSource() == voltar) {
                encerrar();
            }
            if (event.getSource() == salvar) {
                try {
                    Mob mob = new Mob();
                    
                    mob.setName(textField[0].getText());
                    mob.setLevel(Integer.parseInt(textField[9].getText()));
                    mob.setHP(Integer.parseInt(textField[10].getText()));
                    mob.setMANA(Integer.parseInt(textField[11].getText()));
                    mob.setExpDrop(Integer.parseInt(textField[8].getText()));
                    mob.setSTR(Integer.parseInt(textField[1].getText()));
                    mob.setWIS(Integer.parseInt(textField[2].getText()));
                    mob.setVIG(Integer.parseInt(textField[3].getText()));
                    mob.setWIL(Integer.parseInt(textField[4].getText()));
                    mob.setCON(Integer.parseInt(textField[5].getText()));
                    mob.setINT(Integer.parseInt(textField[6].getText()));
                    mob.setDEX(Integer.parseInt(textField[7].getText()));
                    String [] itens = new String [item.length]; String [] itensQuant = new String [item.length];
                    for (int i = 0 ; i < itens.length ; i++) {
                        itens[i] = item[i].getText();
                        itensQuant[i] = itemQuant[i].getText();
                    }
                    mob.setItem(itens);mob.setItemQuant(itensQuant);
                    String [] skills = new String [skill.length]; String [] skillsCost = new String [skill.length];
                    for (int i = 0 ; i < skill.length ; i++) {
                        skills[i] = skill[i].getText();
                        skillsCost[i] = skillCost[i].getText();
                    }
                    mob.setSkill(skills);mob.setSkillCost(skillsCost);
                    
                    mob.gravaFicha();
                } catch (IOException ex) {
                    Logger.getLogger(JanelaAlteraFichaMob.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
