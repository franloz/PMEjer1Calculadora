package com.example.pmejer1calculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button buttonmultiplicar;
    private Button buttonsumar;         //me creo los objetos de la interfaz
    private Button buttonrestar;
    private Button buttondividir;
    private TextView textView1;
    private TextView textView2;
    private EditText editTextNumber2;
    private EditText editTextNumber1;
    private EditText editTextNumber3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//crea lo grafico
        editTextNumber1=(EditText) findViewById(R.id.editTextNumber1);// los asocio con los objetos de la interfaz
        editTextNumber2=(EditText) findViewById(R.id.editTextNumber2);
        editTextNumber3=(EditText) findViewById(R.id.editTextNumber3);

        textView1= (TextView) findViewById(R.id.textView1);
        textView2= (TextView) findViewById(R.id.textView2);

        buttonmultiplicar= (Button)findViewById(R.id.buttonmultiplicar);
        buttondividir= (Button)findViewById(R.id.buttondividir);
        buttonrestar= (Button)findViewById(R.id.buttonrestar);
        buttonsumar= (Button)findViewById(R.id.buttonsumar);

        buttonsumar.setOnClickListener(new View.OnClickListener() {//pongo los objetos a la escucha
            @Override
            public void onClick(View view) {
                if(editTextNumber1.getText().toString().isEmpty()||editTextNumber2.getText().toString().isEmpty()){
                    editTextNumber3.setText("introduzca numeros");
                }
                else{
                    double numero1,numero2,numero3;
                    numero1=Double.parseDouble(editTextNumber1.getText().toString());
                    numero2=Double.parseDouble(editTextNumber2.getText().toString());
                    numero3=numero1+numero2;
                    String num3 = String.valueOf(numero3);
                    editTextNumber3.setText(num3);

                    Toast.makeText(getApplicationContext(),"Suma",Toast.LENGTH_LONG).show();
                }



            }
        });

        buttonrestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextNumber1.getText().toString().isEmpty()||editTextNumber2.getText().toString().isEmpty()){
                    editTextNumber3.setText("introduzca numeros");
                }
                else {
                    double numero1, numero2, numero3;
                    numero1 = Double.parseDouble(editTextNumber1.getText().toString());
                    numero2 = Double.parseDouble(editTextNumber2.getText().toString());
                    numero3 = numero1 - numero2;
                    String num3 = String.valueOf(numero3);
                    editTextNumber3.setText(num3);

                    AlertDialog alertDialog = createAlertDialog("Resta", "Ha restado");//me creo el objeto alertdialog,
                    // y llamo al metodo createalertdialog con dos parametros
                    alertDialog.show();
                }


            }
        });
        buttondividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextNumber1.getText().toString().isEmpty()||editTextNumber2.getText().toString().isEmpty()){
                    editTextNumber3.setText("introduzca numeros");
                }
                else {
                    double numero1, numero2, numero3;
                    numero1 = Double.parseDouble(editTextNumber1.getText().toString());
                    numero2 = Double.parseDouble(editTextNumber2.getText().toString());
                    numero3 = numero1 / numero2;
                    String num3 = String.valueOf(numero3);
                    editTextNumber3.setText(num3);
                    //snackbar
                    Snackbar.make(view,"Ha dividido",Snackbar.LENGTH_LONG).show();

                }


            }
        });
        buttonmultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextNumber1.getText().toString().isEmpty()||editTextNumber2.getText().toString().isEmpty()){
                    editTextNumber3.setText("introduzca numeros");
                }
                else {
                    double numero1, numero2, numero3;
                    numero1 = Double.parseDouble(editTextNumber1.getText().toString());
                    numero2 = Double.parseDouble(editTextNumber2.getText().toString());
                    numero3 = numero1 * numero2;
                    String num3 = String.valueOf(numero3);
                    editTextNumber3.setText(num3);
                }


            }
        });

    }

    public AlertDialog createAlertDialog(String titulo, String mensaje){//devuelve un alertdialog
        //Creamos un 'builder' o constructor que nos ayude a configurar el cuadro de dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        //Este objeto builder nos permitirá añadir todas las configuraciones que se necesiten
        //  antes de crear el alert. En este ejemplo se añade el mensaje y el titulo del alert
        builder.setMessage(mensaje).setTitle(titulo);

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {//si pulsa si
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, " SIII", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {//si pulsa no
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "NOOOOO", Toast.LENGTH_SHORT).show();
            }
        });
        // Una vez hemos añadido todas las configuraciones creamos el alertDialog. En este
        //  caso, devolvemos el objeto creado.
        return builder.create();
    }
}