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
import android.widget.ImageButton;

public class MorseActivity extends AppCompatActivity {

    String msg;

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
        setContentView(R.layout.activity_morse);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button1 = (Button) findViewById(R.id.buttonSend);
        ImageButton button2 = (ImageButton) findViewById(R.id.buttonMorse);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openContatos_Send(msg);


            }

        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = "";


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
