

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
public class JanelaConfiguraJogador extends JFrame{
    private JButton player [];
    private String playername [] = {"Lestrade", "Tyrion", "Izuna"};
    private JButton voltar;
    public JanelaConfiguraJogador () {
        super ("Jogadores");
        
        setLayout (new GridLayout (4, 1));
        setVisible (true);
        player = new JButton [playername.length];
        voltar = new JButton("Voltar");
        for (int i = 0 ; i < player.length ; i++) {
            player[i] = new JButton (playername[i]);
            add(player[i]);
        }
        add(voltar);
        
        Event onclick = new Event ();
        for (int i = 0 ; i < player.length ; i++) {
            player[i].addActionListener(onclick);
        }
        voltar.addActionListener(onclick);
    }
    
    public void encerar () {
        this.dispose();
    }
    
    private class Event implements ActionListener{
      @Override
      public void actionPerformed( ActionEvent event ){
         if (event.getSource() == voltar) {
             encerar();
             
             JanelaConfiguracao open = new JanelaConfiguracao();
             open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             open.setSize(250, 250);
             open.setLocation(500, 30);
             open.setVisible(true);
         }
         if (event.getSource() == player[0]) {
             encerar();
             
             ConfiguraJogador playerLestrade = new ConfiguraJogador ();
             playerLestrade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             playerLestrade.setSize(600, 400);
             playerLestrade.setLocation(500, 30);
             playerLestrade.setVisible(true);
         }
         if (event.getSource() == player[1]) {
             encerar();
             
             ConfiguraJogador playerTyrion = new ConfiguraJogador ();
             playerTyrion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             playerTyrion.setSize(600, 400);
             playerTyrion.setLocation(500, 30);
             playerTyrion.setVisible(true);
         }
         if (event.getSource() == player[2]) {
             encerar();
             
             ConfiguraJogador playerIzuna = new ConfiguraJogador ();
             playerIzuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             playerIzuna.setSize(600, 400);
             playerIzuna.setLocation(500, 30);
             playerIzuna.setVisible(true);
         }
      }
   }
}
