package com.pixelmedia.androidpinnumber;

import java.util.ArrayList;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;

public class EditTextPinNumber extends EditText {

    private ArrayList<TextWatcher> mListeners = null;
    
    public EditTextPinNumber(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public EditTextPinNumber(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextPinNumber(Context context) {
        super(context);
    }

    @Override
    public void addTextChangedListener(TextWatcher watcher)
    {       
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<TextWatcher>();
        }
        this.mListeners.add(watcher);

        super.addTextChangedListener(watcher);
    }

    @Override
    public void removeTextChangedListener(TextWatcher watcher)
    {       
        if (null == this.mListeners) return;
        final int i = this.mListeners.indexOf(watcher);
        if (i >= 0) {
            this.mListeners.remove(i);
        }
        super.removeTextChangedListener(watcher);
    }

    public void clearTextChangedListeners()
    {
        if (null == this.mListeners) return;
        
        for (TextWatcher watcher : this.mListeners) {
            super.removeTextChangedListener(watcher);
        }
        this.mListeners.clear();
        this.mListeners = null;
    }
    
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return new PinNumberInputConnection(super.onCreateInputConnection(outAttrs),
                true);
    }

    private class PinNumberInputConnection extends InputConnectionWrapper {

        public PinNumberInputConnection(InputConnection target, boolean mutable) {
            super(target, mutable);
        }

        public boolean sendCustomKeyEvent(KeyEvent event) {
            if (event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getKeyCode() == KeyEvent.KEYCODE_DEL) {
                // Un-comment if you wish to cancel the backspace:
                // return false;
            }
            return super.sendKeyEvent(event);
        }
        
        
        @Override
        public boolean deleteSurroundingText(int beforeLength, int afterLength) {       
            // magic: in latest Android, deleteSurroundingText(1, 0) will be called for backspace
            if (beforeLength == 1 && afterLength == 0) {
                // backspace
                return sendCustomKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL))
                    && sendCustomKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL));
            }

            return super.deleteSurroundingText(beforeLength, afterLength);
        }

    }
}
