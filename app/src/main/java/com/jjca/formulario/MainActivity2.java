package com.jjca.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button insbtn = (Button) findViewById(R.id.insbtn);
        insbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String form1, form2, form3, form4;
                EditText et1, et2, et3, et4;

                et1 =(EditText) findViewById(R.id.formname);
                et2 =(EditText) findViewById(R.id.formemail);
                et3 =(EditText) findViewById(R.id.formphone);
                et4 =(EditText) findViewById(R.id.formdate);

                form1 = et1.getText().toString();
                form2 = et2.getText().toString();
                form3 = et3.getText().toString();
                form4 = et4.getText().toString();

                RadioButton rb1 = (RadioButton) findViewById(R.id.rb1);
                RadioButton rb2 = (RadioButton) findViewById(R.id.rb2);

                if(form1.trim().equals("") || form2.trim().equals("") || form3.trim().equals("")
                    || form4.trim().equals(""))
                {
                    FailMessage();

                }
                else{
                    if(!form1.trim().matches(".*[a-z A-Z].*") || !form2.trim().matches(".*@.*") ||
                            !form3.trim().matches(".*[0-9].*") || !form4.trim().matches(".*/.*"))
                    {
                        FailMessage();
                    }
                    else{
                        if (rb1.isChecked() || rb2.isChecked()) {
                            Intent intent2 = new Intent(MainActivity2.this, MainActivity3.class);
                            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent2);
                        }
                        else{
                            FailMessage();
                        }

                    }
                }
                }
        });


    }

        public void FailMessage ()
        {
            Toast mensaje = Toast.makeText(this, "Hay valores no válidos en el formulario", Toast.LENGTH_LONG);
            mensaje.show();

        }

        public void onRadioButtonClicked(View view)
        {
            boolean revisar = ((RadioButton) view).isChecked();
            String form5;
            switch(view.getId()){
                case R.id.rb1:
                    if(revisar)
                        form5="Masculino";
                    break;
                case R.id.rb2:
                    if(revisar)
                        form5="Femenino";
                    break;
            }
        }
    }
