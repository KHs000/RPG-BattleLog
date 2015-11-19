

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
public class JanelaDeletarNPC extends JFrame{
    private final File pastaNPC;
    private File [] fichaNPC;
    private final JButton voltar;
    private JButton [] npc;
    private final JPanel areaConteudo;
    private String [] nomeNPC;
    
    public JanelaDeletarNPC () throws IOException {
        super ("Excluir NPC");
        
        setLayout(new BorderLayout());
        setVisible(true);
        voltar = new JButton ("Voltar");
        areaConteudo = new JPanel();
        areaConteudo.setLayout(new FlowLayout());
        JScrollPane jsp = new JScrollPane(areaConteudo);
        add(jsp, BorderLayout.CENTER);
        add(voltar, BorderLayout.SOUTH);
        
        Event e = new Event ();
        
        pastaNPC = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\NPCs");
        if (pastaNPC.listFiles().length > 0) {
            npc = new JButton [pastaNPC.listFiles().length];
            fichaNPC = new File[pastaNPC.listFiles().length];
            fichaNPC = pastaNPC.listFiles();int index = 0;
            NPCRead ficha = new NPCRead();
            nomeNPC = ficha.getNomeMob();
            for (int i = 0 ; i < npc.length ; i++) {
                npc[i] = new JButton(nomeNPC[index]);
                npc[i].setName(nomeNPC[index]);
                areaConteudo.add(npc[i]);
                ActionListener event = (ActionEvent e1) -> {
                    String name1 = new Button().getName((JButton) e1.getSource());
                    
                    NPCRead npc1 = new NPCRead(name1);
                    npc1.Deleta();
                    encerrar();
                    
                    JanelaConfiguraNPC open = new JanelaConfiguraNPC ();
                    open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    open.setSize(400, 400);
                    open.setLocation(450, 30);
                    open.setVisible(true);
                };
                npc[i].addActionListener(event);
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
                
                JanelaConfiguraNPC open = new JanelaConfiguraNPC ();
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
