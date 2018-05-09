package br.pro.hashi.ensino.desagil.morse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Dictionary extends AppCompatActivity {
    String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
    Translator translate = new Translator();
    //para funcionar o botão back
    String msg;

    public void onBackPressed(){
        super.onBackPressed();

        Intent intent = new Intent(this, MorseActivity.class);
        intent.putExtra("msg", msg);

        openMorseActivity();
        finish();
    }

    //função para voltar para o morse
    private void openMorseActivity() {
        Intent intent = new Intent(this, MorseActivity.class);
        intent.putExtra("msg", msg);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //pegando a mensagem da página anterior
        Intent intent = getIntent();
        msg = intent.getStringExtra("msg");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dict);

        final TextView dictionaryABC = findViewById(R.id.dictFromABC);
        final TextView dictionaryMorse = findViewById(R.id.dictFromMorse);
        String dict1 = "";
        String dict2 = "";

        for (int i=0; i < alphabet.length() ;i++){
            Character character = alphabet.charAt(i);
            dict1 += character + " " + translate.charToMorse(character) + "       ";
        }

        for (int i=0; i<translate.getCodes().size(); i++){
            String string = translate.getCodes().get(i).toString();
            dict2 += string + " " + translate.morseToChar(string) + "       ";
        }
        dictionaryABC.setText(dict1);
        dictionaryMorse.setText(dict2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMorseActivity();
            }
        });
    }
}
