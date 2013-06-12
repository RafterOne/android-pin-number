package com.pixelmedia.androidpinnumber;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class PinNumberTextWatcher implements TextWatcher {
	
    private final EditText currentEditTextFieldId;
    private final EditText nextEditTextFieldId;
    private final EditText editTextFieldToChange;

	public PinNumberTextWatcher(EditText currentEditTextFieldId, EditText  nextEditTextFieldId, EditText editTextFieldToChange) { 
		this.currentEditTextFieldId = currentEditTextFieldId;
		this.nextEditTextFieldId = nextEditTextFieldId;
		this.editTextFieldToChange = editTextFieldToChange;
	}
	
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		this.currentEditTextFieldId.setTransformationMethod(PasswordTransformationMethod.getInstance());
	}
	
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		if (this.currentEditTextFieldId.getText().length() == 1) { 
			this.editTextFieldToChange.requestFocus();
			this.nextEditTextFieldId.requestFocus();
			if (this.currentEditTextFieldId.getId() == this.nextEditTextFieldId.getId()) {
				((InputMethodManager) this.currentEditTextFieldId.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
			    .hideSoftInputFromWindow(this.currentEditTextFieldId.getWindowToken(), 0);
			}
		}
	}
	
	public void afterTextChanged(Editable s) {
	
	}
}
