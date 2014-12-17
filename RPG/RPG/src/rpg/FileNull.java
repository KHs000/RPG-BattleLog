

package rpg;

import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Rabelo
 */
public class FileNull extends Exception {

    public FileNull() {
        JOptionPane.showMessageDialog(null, "Arquivo inexistente");
    }

    public FileNull(String msg) {
        super(msg);
    }
}
