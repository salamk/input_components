/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acr.component;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

/**
 *
 * @author salam
 */
public class CTextField extends JTextField {

    public int character_limit = 100;

    public CTextField() {
        super();
        setDocument(new JTextFieldLimit(character_limit));
        addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent fe){
                selectAll();
            }
        });
    }

    /**
     * Get the value of character_limit
     *
     * @return the value of character_limit
     */
    public int getCharacter_limit() {
        return character_limit;
    }

    /**
     * Set the value of character_limit
     *
     * @param character_limit new value of character_limit
     */
    public void setCharacter_limit(int character_limit) {
        this.character_limit = character_limit;
        setDocument(new JTextFieldLimit(character_limit));
    }

}
