package com.example.lily.ejercicio01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName;
    private CheckBox chkPolite;
    private Button btnSaludar;
    private EditText txtSurname;
    private Button btnReset;
    TextView lblMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        txtName = findViewById(R.id.txtName);
        txtSurname = findViewById(R.id.txtSurname);
        chkPolite = findViewById(R.id.chkPolite);
        btnSaludar = findViewById(R.id.btnSaludar);
        btnReset = findViewById(R.id.btnReset);
        lblMessage = findViewById(R.id.lblSaludo);

        btnSaludar.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        int id2 = v.getId();
        if (id == R.id.btnSaludar) {
            saludar();
        }
        if (id2 == R.id.btnReset) {
            reset();
        }
    }

    private void reset() {
        lblMessage.setText("");
        txtName.setText("");
        txtSurname.setText("");
    }

    private void saludar() {
        String message = getString(R.string.main_impolite, (" " + txtName.getText().toString()), (" " + txtSurname.getText().toString()));

        if (chkPolite.isChecked()) {
            message = getString(R.string.main_polite, (" " + txtName.getText().toString()), (" " + txtSurname.getText().toString()));
        }

        lblMessage.setText(message);
    }
}
