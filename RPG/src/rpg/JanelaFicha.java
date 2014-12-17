

package rpg;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaFicha extends JFrame{
    private JButton jogadores;
    private JButton npc;
    private JButton mob;
    private JButton voltar;
    
    public JanelaFicha () {
        super("Fichas");
        
        setLayout(new GridLayout(4, 1));
        setVisible(true);
        jogadores = new JButton ("Jogadores");
        npc = new JButton ("NPCs");
        mob = new JButton ("MOBs");
        voltar = new JButton ("Voltar");
        add(jogadores);
        add(npc);
        add(mob);
        add(voltar);
        
        JanelaFicha.Event onclick = new JanelaFicha.Event ();
        jogadores.addActionListener(onclick);
        npc.addActionListener(onclick);
        mob.addActionListener(onclick);
        voltar.addActionListener(onclick);
    }
    
    public void encerar () {
        this.dispose();
    }
    
    private class Event implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == voltar) {
            encerar();
             
            JanelaIniciar open = new JanelaIniciar();
            open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            open.setSize(250, 250);
            open.setLocation(500, 30);
            open.setVisible(true);
            }
            if (event.getSource() == jogadores) {
                encerar();
                
                JanelaFichaJogador open = new JanelaFichaJogador ();
                open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                open.setSize(250, 250);
                open.setLocation(500, 30);
                open.setVisible(true);
            }
            if (event.getSource() == npc) {
                encerar();
                
                JanelaTemporaria open = new JanelaTemporaria ();
                open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                open.setSize(250, 250);
                open.setLocation(500, 30);
                open.setVisible(true);
            }
            if (event.getSource() == mob) {
                encerar();
                
                JanelaTemporaria open = new JanelaTemporaria ();
                open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                open.setSize(250, 250);
                open.setLocation(500, 30);
                open.setVisible(true);
            }
        }
        
    }
}
