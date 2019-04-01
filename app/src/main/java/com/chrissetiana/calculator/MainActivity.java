package com.chrissetiana.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText n1;
    private EditText n2;
    private int num1;
    private int num2;
    private int total;
    private String c;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.edit_num1);
        n2 = findViewById(R.id.edit_num2);
        result = findViewById(R.id.text_result);
    }

    private void convert() {
        num1 = Integer.parseInt(n1.getText().toString().trim());
        num2 = Integer.parseInt(n2.getText().toString().trim());
    }

    public void onAdd(View view) {
        convert();
        total = num1 + num2;
        result.setText(Integer.toString(total));
        Log.d(LOG_TAG, "Performing addition: " + num1 + "+" + num2 + "=" + total);
    }

    public void onSubtract(View view) {
        convert();
        total = num1 - num2;
        result.setText(Integer.toString(total));
        Log.d(LOG_TAG, "Performing subtraction: " + num1 + "-" + num2 + "=" + total);
    }

    public void onMultiply(View view) {
        convert();
        total = num1 * num2;
        result.setText(Integer.toString(total));
        Log.d(LOG_TAG, "Performing multiplication: " + num1 + "*" + num2 + "=" + total);
    }

    public void onDivide(View view) {
        convert();

        if (num2 == 0) {
            Toast.makeText(this, "Second number cannot not be 0", Toast.LENGTH_SHORT).show();
            result.setText("INVALID");
        } else {
            total = num1 / num2;
            result.setText(Integer.toString(total));
        }
        Log.d(LOG_TAG, "Performing division: " + num1 + "/" + num2 + "=" + total);
    }
}
