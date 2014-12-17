

package rpg;

import javax.swing.JFrame;

/**
 *
 * @author Felipe Rabelo
 */
public class RPG {

    public static void main(String[] args) {
        Janela opcao = new Janela ();
        opcao.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        opcao.setSize(250, 250);
        opcao.setLocation(500, 30);
        opcao.setVisible( true );
    }
    
}
