package com.pixelmedia.androidpinnumber;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

public class PinNumberDeleteKeyListener implements OnKeyListener  {

    
    private final EditText pin_box;
    
    public PinNumberDeleteKeyListener(EditText pinBox) {
        this.pin_box = pinBox;          
    }
    
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
        //Log.i("INFO", keyCode);

        
            if(keyCode == KeyEvent.KEYCODE_DEL){  
                //this is for backspace
                Log.i("INFO", "delete key hit"); //you should see this log in ddms after you hit delete key
            
        
                //This is the filter to make sure it only fires once
                if (event.getAction()!=KeyEvent.ACTION_DOWN)
                    return true;
        
                EditTextPinNumber pinbox = (EditTextPinNumber) v;
            
                Integer textlength = pinbox.getText().length();
                if (textlength < 1) { 
                    this.pin_box.requestFocus();
                    this.pin_box.setText("");
                }
            
            }
    
    return false;
    }
}
