

package rpg;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Rabelo
 */

public class Janela extends JFrame {
    private JButton iniciar;
    private JButton configurar;
    private JButton fechar;
    public Janela() {
        
        super ("Simulador de RPG");
        
        setLayout (new GridLayout (3, 1));
        setVisible (true);
        iniciar = new JButton("Iniciar");
        configurar  = new JButton("Configurações");
        fechar = new JButton("Fechar");
        
        add(iniciar);
        add(configurar);
        add(fechar);
        
        Event onclick = new Event ();
        iniciar.addActionListener(onclick);
        configurar.addActionListener(onclick);
        fechar.addActionListener(onclick);
    }
    
    public void newJanelaIniciar () {
        
    }
    
    public void fechar (){  
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja encerrar o programa?", "ATENÇÂO ", JOptionPane.YES_NO_OPTION ) == 0){  
            this.dispose();  
        }  
    }
    
    public void encerar () {
        this.dispose();
    }
    
   private class Event implements ActionListener{
      @Override
      public void actionPerformed( ActionEvent event ){
         if (event.getSource() == fechar) {
             fechar();
         }
         if (event.getSource() == iniciar) {
             encerar();
             
             JanelaJogo init = new JanelaJogo();
             init.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
             init.setSize(250, 250);
             init.setLocation(500, 30);
             init.setVisible( true );
         }
         if (event.getSource() == configurar) {
             encerar();
             
             JanelaConfiguracao config = new JanelaConfiguracao ();
             config.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             config.setSize(250, 500);
             config.setLocation(500, 3);
             config.setVisible(true);
         }
      }
   }
}
