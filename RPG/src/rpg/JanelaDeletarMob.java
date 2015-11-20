

package rpg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaDeletarMob extends JFrame{
    private final File pastaMob;
    private File [] fichaMob;
    private final JButton voltar;
    private JButton [] mob;
    private final JPanel areaConteudo;
    private String [] nomeMob;
    
    public JanelaDeletarMob () throws IOException {
        super ("Excluir Mob");
        
        setLayout(new BorderLayout());
        setVisible(true);
        voltar = new JButton ("Voltar");
        areaConteudo = new JPanel();
        areaConteudo.setLayout(new FlowLayout());
        JScrollPane jsp = new JScrollPane(areaConteudo);
        add(jsp, BorderLayout.CENTER);
        add(voltar, BorderLayout.SOUTH);
        
        Event e = new Event ();
        
        pastaMob = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\Mobs");
        if (pastaMob.listFiles().length > 0) {
            mob = new JButton [pastaMob.listFiles().length];
            fichaMob = new File[pastaMob.listFiles().length];
            fichaMob = pastaMob.listFiles();int index = 0;
            MobRead ficha = new MobRead();
            nomeMob = ficha.getNomeMob();
            for (int i = 0 ; i < mob.length ; i++) {
                mob[i] = new JButton(nomeMob[index]);
                mob[i].setName(nomeMob[index]);
                areaConteudo.add(mob[i]);
                ActionListener event = (ActionEvent e1) -> {
                    String name1 = new Button().getName((JButton) e1.getSource());
                    
                    MobRead mob1 = new MobRead(name1);
                    mob1.Deleta();
                };
                mob[i].addActionListener(event);
                index++;
            }
        } 
        
        voltar.addActionListener(e);
    }
    
    public final void encerrar () {
        this.dispose();
    }
    
    private class Event implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            if (e.getSource() == voltar) {
                encerrar();
                
                JanelaConfiguraMob open = new JanelaConfiguraMob ();
                open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                open.setSize(400, 400);
                open.setLocation(450, 30);
                open.setVisible(true);
            }
        }
    }
    
    private class Button {
        public String getName (JButton b) {
            return b.getName();
        }
    }
}
