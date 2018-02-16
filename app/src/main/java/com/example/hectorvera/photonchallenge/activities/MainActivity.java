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

import com.example.hectorvera.photonchallenge.Library;
import com.example.hectorvera.photonchallenge.R;
import com.example.hectorvera.photonchallenge.model.PathSeeker;
import com.example.hectorvera.photonchallenge.model.Utils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioButton rdBtnTest1, rdBtnTest2, rdBtnTest3, rdBtnOtherTest;
    private TextView txtOutput;
    private EditText eTxtInput;
    private Button btnRunTest;
    //private String txtTest = null;
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
        String txtTest = null;
        switch (v.getId()) {
            case R.id.rdBtnTest1:
                if(rdBtnTest1.isChecked()) {
                    eTxtInput.setEnabled(false);
                    btnRunTest.setEnabled(false);
                    eTxtInput.setText(Utils.printIntArray(Library.TEST_1));
                }
                break;
            case R.id.rdBtnTest2:
                if(rdBtnTest2.isChecked()) {
                    eTxtInput.setEnabled(false);
                    btnRunTest.setEnabled(false);
                    eTxtInput.setText(Utils.printIntArray(Library.TEST_2));
                }
                break;
            case R.id.rdBtnTest3:
                if(rdBtnTest3.isChecked()) {
                    eTxtInput.setEnabled(false);
                    btnRunTest.setEnabled(false);
                    eTxtInput.setText(Utils.printIntArray(Library.TEST_3));
                }
                break;
            case R.id.rdBtnOtherTest:
                if(rdBtnOtherTest.isChecked()) {
                    eTxtInput.setText("");
                    eTxtInput.setEnabled(true);
                    btnRunTest.setEnabled(true);
                }
                break;
            case R.id.btnRunTest:
                txtTest = eTxtInput.getText().toString();
                //txtOutput.setText(PathSeeker.seekPath(Utils.convertStringToIntArray(txtTest)));
                txtOutput.setText("OnDevelop");
                break;
        }
    }
}
