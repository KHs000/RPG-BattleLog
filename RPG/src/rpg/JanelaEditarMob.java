

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
public class JanelaEditarMob extends JFrame{
    private File pastaMob;
    private File [] fichaMob;
    private JButton voltar;
    private JButton [] mob;
    private JPanel areaConteudo;
    private String [] nomeMob;
    
    public JanelaEditarMob () throws IOException {
        super ("Editar Mob");
        
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
            MobReader ficha = new MobReader();
            nomeMob = ficha.getNomeMob();
            for (int i = 0 ; i < mob.length ; i++) {
                mob[i] = new JButton(nomeMob[index]);
                mob[i].setName(nomeMob[index]);
                areaConteudo.add(mob[i]);
                ActionListener event = new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = new Button().getName((JButton)e.getSource());
                        JanelaAlteraFichaMob obj = new JanelaAlteraFichaMob(name);
                        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        obj.setLocation(500, 30);
                        obj.setSize(400, 400);
                        obj.setVisible(true);
                    }
                };
                mob[i].addActionListener(event);
                index++;
            }
        } 
        
        voltar.addActionListener(e);
    }
    
    public void encerrar () {
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
