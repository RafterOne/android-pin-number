android-pin-number
==================

Android Library that provides iOS style pin number functionality

## How to use: 

 * Import the library into your project
 * Replace your EditText's with ```com.pixelmedia.androidpinnumber.EditTextPinNumber```

```xml
<com.pixelmedia.androidpinnumber.EditTextPinNumber
    android:id="@+id/pinBox1"
    style="@style/edit_field_device_code" >
    
    <requestFocus />
</com.pixelmedia.androidpinnumber.EditTextPinNumber>
<com.pixelmedia.androidpinnumber.EditTextPinNumber 
    android:id="@+id/pinBox2"
    style="@style/edit_field_device_code" />
<com.pixelmedia.androidpinnumber.EditTextPinNumber 
    android:id="@+id/pinBox3"
    style="@style/edit_field_device_code" />
<com.pixelmedia.androidpinnumber.EditTextPinNumber 
    android:id="@+id/pinBox4"
    style="@style/edit_field_device_code" /> 
```



 * When defining your pin boxes, add the custom TextChangedListener and onKeyListener
 
```java
pinBox1 = (EditText) findViewById(R.id.pinBox1);
pinBox2 = (EditText) findViewById(R.id.pinBox2);
pinBox3 = (EditText) findViewById(R.id.pinBox3);
pinBox4 = (EditText) findViewById(R.id.pinBox4);

pinBox1.addTextChangedListener(new PinNumberTextWatcher(pinBox1, pinBox2, pinBox2));
pinBox2.addTextChangedListener(new PinNumberTextWatcher(pinBox2, pinBox3, pinBox1));
pinBox3.addTextChangedListener(new PinNumberTextWatcher(pinBox3, pinBox4, pinBox2));
pinBox4.addTextChangedListener(new PinNumberTextWatcher(pinBox4, pinBox4, pinBox3));


pinBox2.setOnKeyListener(new PinNumberDeleteKeyListener(pinBox1));
pinBox3.setOnKeyListener(new PinNumberDeleteKeyListener(pinBox2));
pinBox4.setOnKeyListener(new PinNumberDeleteKeyListener(pinBox3));
```

 * And make sure you've imported those 

```java
import com.pixelmedia.androidpinnumber.PinNumberTextWatcher;
import com.pixelmedia.androidpinnumber.PinNumberDeleteKeyListener;
```


