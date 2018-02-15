/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acr.component;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author salam
 */
public class CDateField extends CTextField {

    public CDateField() {
        setCharacter_limit(10);
        this.setForeground(Color.MAGENTA);
        setText(getCurrentDate("DD-MM-YYYY"));
        addFocusListener(new FocusAdapter() {

            public void focusLost(FocusEvent fe) {
                validateDate();
            }
        });
    }

    /**get current date in the specified format. You can get the date in these
     *forms: 1. DD-MM-YY   2. DD-MM-YYYY   3. YYYY-MM-DD    4. SQL
     */
    private String getCurrentDate(String format) {

        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);

        String strDay = Integer.toString(day);
        String strMonth = Integer.toString(month);
        String strYear = Integer.toString(year);

        if (strDay.length() == 1) {
            strDay = "0" + strDay;
        }

        if (strMonth.length() == 1) {
            strMonth = "0" + strMonth;
        }

        String date = "";

        if (format.compareToIgnoreCase("DD-MM-YYYY") == 0) {
            date = strDay + "-" + strMonth + "-" + strYear;
        } else if (format.compareToIgnoreCase("YYYY-MM-DD") == 0) {
            date = strYear + "-" + strMonth + "-" + strDay;
        } else if (format.compareToIgnoreCase("DDMMYYYY") == 0) {
            date = strDay + strMonth + strYear;
        } else if (format.compareTo("SQL") == 0) {
            date = strYear + "-" + strMonth + "-" + strDay;
        } else;

        return date;
    }

    private void validateDate() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            sdf.parse(getText());
            this.setForeground(Color.MAGENTA);
        } catch (ParseException pe) {
            System.out.println("=Parser Exception");
            this.setForeground(Color.red);
        } catch (IllegalArgumentException iae) {
            System.out.println("=Illegal Argument Exception");
            this.setForeground(Color.red);
        } catch (Exception e) {
            System.out.println("=General Exception");
            this.setForeground(Color.red);
        }
    }

    public String getSQLDate() {

        String date = getText();
        if (date == null || date.compareToIgnoreCase("") == 0
                || date.compareToIgnoreCase("invalid") == 0){
            ;
        }
        else {
            String[] token = date.split("-");
            date = token[2] + "-" + token[1] + "-" + token[0];
        }

        return date;
    }

    public void setNormalDate(String SQLDate){
        SimpleDateFormat inFmt = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outFmt = new SimpleDateFormat("dd-MM-yyyy");
        String out = "";
        try{
            out = outFmt.format(inFmt.parse(SQLDate));
        }catch(Exception e){
            out = "";
        }
        setText(out);
    }


    public Date getDate(){
        String [] toke = getText().split("-");
        int dd = 0;
        int mm = 0;
        int yy = 0;

        if(toke != null){
            try
            {
                dd = Integer.parseInt(toke[0]);
                mm = Integer.parseInt(toke[1]);
                yy = Integer.parseInt(toke[2]);

            }catch(Exception e){
                
            }
            
        }

        Calendar cal = Calendar.getInstance();
        cal.set(yy,mm,dd);
        Date d = cal.getTime();
        
        return d;
    }


    public Calendar getCalendar(){
        String [] toke = getText().split("-");
        int dd = 0;
        int mm = 0;
        int yy = 0;

        if(toke != null){
            try
            {
                dd = Integer.parseInt(toke[0]);
                mm = Integer.parseInt(toke[1]);
                yy = Integer.parseInt(toke[2]);

            }catch(Exception e){

            }

        }

        Calendar cal = Calendar.getInstance();
        cal.set(yy,mm,dd);


        return cal;
    }
}
