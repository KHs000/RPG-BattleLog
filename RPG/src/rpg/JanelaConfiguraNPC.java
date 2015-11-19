

package rpg;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaConfiguraNPC extends JFrame{
    private JButton criar;
    private JButton modificar;
    private JButton excluir;
    private JButton voltar;
    
    public JanelaConfiguraNPC () {
        super("NPCs");
        
        setLayout(new GridLayout(4, 1));
        setVisible(true);
        criar = new JButton ("Criar novo NPCs");
        modificar = new JButton ("Editar NPCs");
        excluir = new JButton ("Excluir NPCs");
        voltar = new JButton ("Voltar");
        
        Event onclick = new Event();
        
        criar.addActionListener(onclick);
        modificar.addActionListener(onclick);
        excluir.addActionListener(onclick);
        voltar.addActionListener(onclick);
        
        add(criar);
        add(modificar);
        add(excluir);
        add(voltar);
    }
    
    public void encerrar () {this.dispose();}
    
    private class Event implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == criar) {
                encerrar();
                
                JanelaConfiguraFichaNPC obj = new JanelaConfiguraFichaNPC ();
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                obj.setLocation(500, 30);
                obj.setVisible(true);
            }
            if (e.getSource() == modificar) {
                encerrar();
                
                try {
                    JanelaEditarNPC obj = new JanelaEditarNPC ();
                    
                    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    obj.setLocation(500, 30);
                    obj.setSize(400, 400);
                    obj.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(JanelaConfiguraNPC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == excluir) {
                encerrar();
                
                try {
                    JanelaDeletarNPC obj = new JanelaDeletarNPC ();
                    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    obj.setLocation(500, 30);
                    obj.setSize(400, 400);
                    obj.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(JanelaConfiguraMob.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == voltar) {
                encerrar();
                
                JanelaConfiguracao config = new JanelaConfiguracao ();
                config.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                config.setSize(250, 500);
                config.setLocation(500, 3);
                config.setVisible(true);
            }
        }
        
    }
}
