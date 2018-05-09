package br.pro.hashi.ensino.desagil.morse;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import java.util.LinkedList;

public class Contatos_Send extends AppCompatActivity {
    String num;
    String msg;

    //para funcionar o botão back
    public void onBackPressed(){
        super.onBackPressed();
        openMessagesActivity();
        finish();
    }

    //função para ir para essa página
    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        finish();
    }

    //função para ir para essa página
    private void openMessagesActivity() {
        Intent intent = new Intent(this, MesagesActivity.class);
        startActivity(intent);

        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //pegando a mensagem da página anterior
        Intent intent = getIntent();
        msg = intent.getStringExtra("msg");

        //criamos botões para os números
        Button button1 = (Button) findViewById(R.id.button6);
        Button button2 = (Button) findViewById(R.id.button7);
        Button button3 = (Button) findViewById(R.id.button8);
        Button button4 = (Button) findViewById(R.id.button9);
        Button button5 = (Button) findViewById(R.id.button10);


        //Atividade dos botões - pegar número e enviar mensagem pré-estabelecida
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = "+5511983126006";

                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(num, null,msg , null, null);


                openMainActivity();


            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = "+5511972814040";
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(num, null, msg, null, null);
                openMainActivity();

            }

        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = "+5511986493002";
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(num, null, msg, null, null);
                openMainActivity();


            }

        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = "+5511983126006";
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(num, null, msg, null, null);
                openMainActivity();


            }

        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = "+5511983126006";
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(num, null, msg, null, null);
                openMainActivity();


            }

        });

    }

}



