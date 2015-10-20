

package rpg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaFichaJogador extends JFrame {
    private File [] jogadorLista;
    private final File jogadorPasta;
    private JButton jogadorTemp;
    private JButton [] jogador;
    private JButton voltar;
    private final String local;
    private String [] jogadorNome;
    private final JFileChooser path = new JFileChooser();
    
    public JanelaFichaJogador () throws IOException {
        super ("Jogadores");
        
        ConfiguracoesSalvas temp = new ConfiguracoesSalvas ();
        if (temp.Exists() && temp.checaPath("Skyrim-Jogadores")) {local = temp.SelecionaPath("Skyrim-Jogadores");}
        else {
            path.setCurrentDirectory(new java.io.File("."));
            path.setDialogTitle("Selecione a pasta");
            path.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            path.setAcceptAllFileFilterUsed(false);
            if (path.showOpenDialog(path) == JFileChooser.APPROVE_OPTION) {
                local = path.getSelectedFile().toString() + "\\";
                temp.SalvaConfiguracoes(local, "Skyrim-Jogadores");
            }
            else {local = null;}
        }
        
        jogadorPasta = new File (local);
        if (jogadorPasta.listFiles().length > 0) {
            jogadorLista = new File [jogadorPasta.listFiles().length];
            jogadorLista = jogadorPasta.listFiles();
            jogadorNome = new String[jogadorPasta.listFiles().length];int index = 0;
            String aux;
            for (File i : jogadorLista) {
                if (i.canRead()) {
                    BufferedReader br = new BufferedReader(new FileReader(i));
                    while (br.ready()) {
                        aux = br.readLine();
                        if (aux.substring(0, 4).equals("Nome")) {jogadorNome[index] = aux.substring(5);index++;}
                    }
                }
            }
            Event e = new Event ();
            
            jogador = new JButton [jogadorNome.length];
            for (int i = 0 ; i < jogador.length ; i++) {
                jogador[i] = new JButton (jogadorNome[i]);
                add(jogador[i]);
                jogador[i].addActionListener(e);
                JOptionPane.showMessageDialog(null, i);
            }
        }
        else {JOptionPane.showMessageDialog(null, "Não há jogadores");}
        
        add(voltar);
        voltar.addActionListener(new Event());
    }
    
    public void encerar () {
        this.dispose();
    }
    
    private class Event implements ActionListener{
      @Override
      public void actionPerformed( ActionEvent event ){
         if (event.getSource() == voltar) {
             encerar();
             
            JanelaFicha open = new JanelaFicha();
             open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             open.setSize(250, 250);
             open.setLocation(500, 30);
             open.setVisible(true);
         }
         if (event.getSource() == jogador) {
             for (JButton jogador1 : jogador) {
                 if (event.getSource() == jogador1) {
                     JOptionPane.showMessageDialog(null, jogador1.getName());
                 }
             }
         }
      }
   }
}
