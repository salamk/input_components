/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acr.component;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author salam
 */
public class CAlphaField extends CTextField {

    public CAlphaField() {
        super();
        addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                    ke.consume(); // prevent event propagation
                }
            }
        });
    }
}
