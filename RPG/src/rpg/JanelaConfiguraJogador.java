

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
             open.setSize(250, 500);
             open.setLocation(500, 30);
             open.setVisible(true);
         }
         if (event.getSource() == player[0]) {
             encerar();
             
             JanelaConfiguraFicha obj = new JanelaConfiguraFicha ();
             obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             obj.setLocation(500, 30);
             obj.setVisible(true);
         }
         if (event.getSource() == player[1]) {
             encerar();
             
             JanelaConfiguraFicha obj = new JanelaConfiguraFicha ();
             obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             obj.setLocation(500, 30);
             obj.setVisible(true);
         }
         if (event.getSource() == player[2]) {
             encerar();
             
             JanelaConfiguraFicha obj = new JanelaConfiguraFicha ();
             obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             obj.setLocation(500, 30);
             obj.setVisible(true);
         }
      }
   }
}
