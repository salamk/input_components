/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acr.component;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author salam
 */
public class CNICField extends CIntegerField {

    public CNICField() {
        setCharacter_limit(13);
        this.setForeground(Color.blue);
        addFocusListener(new FocusAdapter() {

            public void focusLost(FocusEvent fe) {
                checkNIC();
            }
        });
    }

    private void checkNIC() {
        String str = getText();
        if (str.compareToIgnoreCase("") == 0 || str == null
                || str.compareToIgnoreCase("invalid.....") == 0) {
            setText("");
        }
        if (str.length() > 13) {
            this.setForeground(Color.red);
        } else if (str.length() < 11) {
            this.setForeground(Color.red);
        } else if (str.length() > 11 && str.length() < 13) {
            this.setForeground(Color.red);
        } else {
            this.setForeground(Color.blue);
        }
    }
}
