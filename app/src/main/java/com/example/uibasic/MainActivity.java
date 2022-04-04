package com.example.uibasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtHelloView;
    private EditText edtTxtName;
    private CheckBox checkBoxHarry, checkBoxMatrix, checkBoxJoker;
    private RadioGroup rgMaritalStatus;
    private ProgressBar progressBar, progressBarBelt;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHelloSay:
//                Toast.makeText(this, "Hello button Clicked", Toast.LENGTH_SHORT).show();
                txtHelloView.setText("Hello " + edtTxtName.getText().toString());
                break;
            case R.id.edtTxtName:
                Toast.makeText(this, "Attempting to type something", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }//onClick

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHelloTerminal = findViewById(R.id.btnHelloTerminal);
        btnHelloTerminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hello");
            }
        });//btnHelloTerminal

        Button btnHelloSay = findViewById(R.id.btnHelloSay);
        btnHelloSay.setOnClickListener(this);


        btnHelloSay.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Long Press", Toast.LENGTH_LONG).show();
                return true;
            }
        });//btnHelloSay


        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtName.setOnClickListener(this);
        txtHelloView = findViewById(R.id.txtHelloView);

        checkBoxHarry = findViewById(R.id.checkBoxHarry);
        checkBoxMatrix = findViewById(R.id.checkBoxMatrix);
        checkBoxJoker = findViewById(R.id.checkBoxJoker);

//        After tern on app then you'll see message
        if (checkBoxMatrix.isChecked()) {
            Toast.makeText(MainActivity.this, "You have watched Matrix", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "You need to watch Matrix", Toast.LENGTH_SHORT).show();
        }
        if (checkBoxJoker.isChecked()) {
            Toast.makeText(MainActivity.this, "You have watched Joker", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "You need to watch Joker", Toast.LENGTH_SHORT).show();
        }

//        When you clicked on checkbox
        checkBoxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You have watched Harry Potter", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "You need to watch Harry Potter", Toast.LENGTH_SHORT).show();
                }
            }
        });//checkBoxHarry

        rgMaritalStatus = findViewById(R.id.rgMaritalStatus);
        progressBar = findViewById(R.id.progressBar);
        progressBarBelt = findViewById(R.id.progressBarBelt);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10; i++) {
                    progressBarBelt.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });//thread
        thread.start();

        int checkButton = rgMaritalStatus.getCheckedRadioButtonId();
        switch (checkButton){
            case R.id.rbMarried:
                Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbSingle:
                Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbInRelation:
                Toast.makeText(MainActivity.this, "Relationship", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }//checkButton

        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this, "Married 2", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity.this, "Single 2", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbInRelation:
                        Toast.makeText(MainActivity.this, "Relationship 2", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }
        });//rgMaritalStatus



    }//onCreate

    public void onHelloBtnClicked(View view) {
        TextView txtWelcome = findViewById(R.id.textWelcome);
        txtWelcome.setText("Hello Again");
    }

}//Main