

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
public class JanelaConfiguraMob extends JFrame{
    private JButton criar;
    private JButton modificar;
    private JButton excluir;
    private JButton voltar;
    
    public JanelaConfiguraMob () {
        super("Mobs");
        
        setLayout(new GridLayout(4, 1));
        setVisible(true);
        criar = new JButton ("Criar novo Mob");
        modificar = new JButton ("Editar Mob");
        excluir = new JButton ("Excluir Mob");
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
        public void actionPerformed (ActionEvent event) {
            if (event.getSource() == criar) {
                encerrar();
                
                JanelaConfiguraFichaMob obj = new JanelaConfiguraFichaMob ();
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                obj.setLocation(500, 30);
                obj.setVisible(true);
            }
            if (event.getSource() == modificar) {
                encerrar();
                
                try {
                    JanelaEditarMob obj = new JanelaEditarMob();
                    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    obj.setLocation(500, 30);
                    obj.setSize(400, 400);
                    obj.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(JanelaConfiguraMob.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            if (event.getSource() == excluir) {
                encerrar();
                
                try {
                    JanelaDeletarMob obj = new JanelaDeletarMob ();
                    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    obj.setLocation(500, 30);
                    obj.setSize(400, 400);
                    obj.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(JanelaConfiguraMob.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (event.getSource() == voltar) {
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
