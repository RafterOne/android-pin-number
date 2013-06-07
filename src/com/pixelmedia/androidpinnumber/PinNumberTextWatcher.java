package com.pixelmedia.androidpinnumber;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;

public class PinNumberTextWatcher implements TextWatcher {
    private EditText currentEditTextFieldId;
    private EditText nextEditTextFieldId;
    private EditText editTextFieldToChange;

	public PinNumberTextWatcher(EditText currentEditTextFieldId, EditText  nextEditTextFieldId, EditText editTextFieldToChange) { 
		this.currentEditTextFieldId = currentEditTextFieldId;
		this.nextEditTextFieldId = nextEditTextFieldId;
		this.editTextFieldToChange = editTextFieldToChange;
	}
	
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		currentEditTextFieldId.setTransformationMethod(PasswordTransformationMethod.getInstance());
	}
	
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		Integer textlength1 = currentEditTextFieldId.getText().length();
		if (textlength1 >= 1) { 
			editTextFieldToChange.requestFocus();
			nextEditTextFieldId.requestFocus();
		}
	}
	
	public void afterTextChanged(Editable s) {
	
	}
}
