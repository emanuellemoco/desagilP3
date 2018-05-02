package br.pro.hashi.ensino.desagil.morse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MorseActivity extends AppCompatActivity {

    String msg = "";
    String morse = "";
    Translator translate = new Translator();
    long initialTime;
    long endTime;

    public void onBackPressed(){
        super.onBackPressed();
        openMessagesActivity();
        finish();
    }

    private void openContatos_Send(String msg) {
        // Exemplo de código para abrir uma activity. Especificamente, a SendActivity.
        Intent intent = new Intent(this, Contatos_Send.class);
        intent.putExtra("msg",msg);
        startActivity(intent);
        finish();
    }

    private void openMessagesActivity() {
        // Exemplo de código para abrir uma activity. Especificamente, a SendActivity.
        Intent intent = new Intent(this, MesagesActivity.class);
        startActivity(intent);

        // Depois de abrir a Contatos_Send, não há porque manter a MainActivity aberta.
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialTime = System.currentTimeMillis();
        setContentView(R.layout.activity_morse);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button1 = (Button) findViewById(R.id.buttonSend);
        Button button2 = (Button) findViewById(R.id.buttonMorse);

        final TextView text = (TextView) findViewById(R.id.textView);
        final TextView textMorse = (TextView) findViewById(R.id.textViewMorse);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openContatos_Send(msg);


            }

        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endTime = System.currentTimeMillis();

                if (endTime - initialTime > 4000){
                    //Add o texto em msm
                    //Se tiver mais de 5 caracteres é um espaço
                    if (morse.length() > 5){
                        msg += " ";
                    }

                    else {
                        msg += translate.morseToChar(morse);
                    }

                    morse = "";
                    initialTime = System.currentTimeMillis();
                    text.setText(msg);
                }

                morse += ".";
                textMorse.setText(morse);

                initialTime = System.currentTimeMillis();
            }
        });

        button2.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View view) {
                endTime = System.currentTimeMillis();

                if (endTime - initialTime > 4000){
                    //Add o texto em msm
                    //Se tiver mais de 5 caracteres é um espaço
                    if (morse.length() > 5){
                        msg += " ";
                    }

                    else {
                        msg += translate.morseToChar(morse);
                    }

                    morse = "";
                    initialTime = System.currentTimeMillis();
                    text.setText(msg);
                }

                morse += "-";
                textMorse.setText(morse);

                initialTime = System.currentTimeMillis();
                return true;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Dicionário de morse aqui", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
