package com.example.apptask1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {
    EditText ETNam, ETApe, ETDni, ETCui, ETEma;
    Button BTReg, BTCan, BTLim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FF06AC9C"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle("Formulario Lab 02");

        ETNam = (EditText) findViewById(R.id.EditTextName);
        ETApe = (EditText) findViewById(R.id.EditTextApe);
        ETDni = (EditText) findViewById(R.id.EditTextDni);
        ETCui = (EditText) findViewById(R.id.EditTextCui);
        ETEma = (EditText) findViewById(R.id.EditTextEmail);

        BTReg = (Button) findViewById(R.id.buttonReg);
        BTCan = (Button) findViewById(R.id.buttonCancel);
        BTLim = (Button) findViewById(R.id.buttonLimpiar);

        BTReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registrar();
            }
        });
        BTCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Close();
            }
        });
        BTLim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clean();
            }
        });
    }

    public void Registrar(){
        String nam = ETNam.getText().toString();
        String ape = ETApe.getText().toString();
        String dni = ETDni.getText().toString();
        String cui = ETCui.getText().toString();
        String ema = ETEma.getText().toString();

        if(!nam.equals("") && !ape.equals("") && !dni.equals("") && !cui.equals("") && !ema.equals("")){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FormularioActivity.this);
            alertDialogBuilder.setTitle("Registro");
            alertDialogBuilder.setMessage("Se registro a:\n"+nam+" "+ape+"\nDNI: "+dni+"\nCUI: "+cui+"\nEmail: "+ema);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(getApplicationContext(),"Datos registrados",Toast.LENGTH_SHORT).show();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Debe llenar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }

    public void  Close(){
        Intent intent = new Intent(FormularioActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void Clean(){
        ETNam.setText("");
        ETApe.setText("");
        ETDni.setText("");
        ETCui.setText("");
        ETEma.setText("");
    }
}