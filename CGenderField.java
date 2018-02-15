/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package acr.component;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author salam
 */
public class CGenderField extends CTextField{
    public CGenderField(){
        super();
        setCharacter_limit(6);
        setText("MALE");
        addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if(c == 'M' || c == 'm'){
                    ke.consume();
                    setText("MALE");
                }else if(c == 'F' || c=='f'){
                    ke.consume();
                    setText("FEMALE");
                }else{
                    ke.consume();
                }
                
            }
        });

        addFocusListener(new FocusAdapter(){
            public void focusLost(FocusEvent fe){
                checkInput();
            }
        });
    }

    private void checkInput(){
        if(getText().compareToIgnoreCase("male")==0){
            setText(getText().toUpperCase());
        }else if(getText().compareToIgnoreCase("female")==0){
            setText(getText().toUpperCase());
        }else{
            setText("invalid");
        }
    }

}
