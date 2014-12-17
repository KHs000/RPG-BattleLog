

package rpg;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JanelaConfiguracao extends JFrame {
    private JButton Opcao [];
    private String OpcaoTexto [] = {"Jogadores", "Mobs", "NPCs", "Voltar"};

    public JanelaConfiguracao() {
        super ("Configurações");
        
        setLayout (new GridLayout (4, 1));
        setVisible (true);
        Opcao = new JButton [OpcaoTexto.length];
        for (int i = 0 ; i < Opcao.length ; i++) {
            Opcao[i] = new JButton (OpcaoTexto[i]);
            add(Opcao[i]);
        }
        
        Event onclick = new Event ();
        for (int i = 0 ; i < Opcao.length ; i++) {
            Opcao[i].addActionListener(onclick);
        }
    }
    
    public void encerar () {
        this.dispose();
    }
    
    private class Event implements ActionListener {
      @Override
      public void actionPerformed( ActionEvent event ){
         if (event.getSource() == Opcao[3]) {
             encerar();
             
             Janela open = new Janela();
             open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             open.setSize(250, 250);
             open.setLocation(500, 30);
             open.setVisible(true);
         }
         if (event.getSource() == Opcao[0]) {
             encerar();
             
             JanelaConfiguraJogador configJogador = new JanelaConfiguraJogador ();
             configJogador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             configJogador.setSize(400, 400);
             configJogador.setLocation(450, 30);
             configJogador.setVisible(true);
         }
         if (event.getSource() == Opcao[1]) {
             encerar();
             
             JanelaTemporaria open = new JanelaTemporaria ();
             open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             open.setSize(250, 250);
             open.setLocation(500, 30);
             open.setVisible(true);
         }
         if (event.getSource() == Opcao[2]) {
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
