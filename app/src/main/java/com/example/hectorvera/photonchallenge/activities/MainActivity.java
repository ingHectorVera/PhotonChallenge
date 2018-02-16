package com.example.hectorvera.photonchallenge.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hectorvera.photonchallenge.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioButton rdBtnTest1, rdBtnTest2, rdBtnTest3, rdBtnOtherTest;
    private TextView txtOutput;
    private EditText eTxtInput;
    private Button btnRunTest;
    private String txtTest = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
    }


    private void setUI() {
        rdBtnTest1 = (RadioButton) findViewById(R.id.rdBtnTest1);
        rdBtnTest2 = (RadioButton) findViewById(R.id.rdBtnTest2);
        rdBtnTest3 = (RadioButton) findViewById(R.id.rdBtnTest3);
        rdBtnOtherTest = (RadioButton) findViewById(R.id.rdBtnOtherTest);
        txtOutput = (TextView) findViewById(R.id.txtOutput);
        eTxtInput = (EditText) findViewById(R.id.eTxtInput);
        btnRunTest = (Button) findViewById(R.id.btnRunTest);

        rdBtnTest1.setOnClickListener(this);
        rdBtnTest2.setOnClickListener(this);
        rdBtnTest3.setOnClickListener(this);
        rdBtnOtherTest.setOnClickListener(this);
        btnRunTest.setOnClickListener(this);

        eTxtInput.setEnabled(false);
        btnRunTest.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        txtTest = null;
        switch (v.getId()) {
            case R.id.rdBtnTest1:
                if(rdBtnTest1.isChecked()) {
                    txtTest = rdBtnTest1.getText().toString();
                    eTxtInput.setEnabled(false);
                    btnRunTest.setEnabled(true);
                }
                break;
            case R.id.rdBtnTest2:
                if(rdBtnTest2.isChecked()) {
                    txtTest = rdBtnTest2.getText().toString();
                    eTxtInput.setEnabled(false);
                    btnRunTest.setEnabled(true);
                }
                break;
            case R.id.rdBtnTest3:
                if(rdBtnTest3.isChecked()) {
                    txtTest = rdBtnTest3.getText().toString();
                    eTxtInput.setEnabled(false);
                    btnRunTest.setEnabled(true);
                }
                break;
            case R.id.rdBtnOtherTest:
                if(rdBtnOtherTest.isChecked()) {
                    txtTest = rdBtnOtherTest.getText().toString();
                    eTxtInput.setEnabled(true);
                    btnRunTest.setEnabled(true);
                }
                break;
            case R.id.btnRunTest:
                txtTest = eTxtInput.getText().toString();
                txtOutput.setText(txtTest);
                Toast.makeText(getApplicationContext(), txtTest, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
