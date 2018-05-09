package br.pro.hashi.ensino.desagil.morse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Dictionary extends AppCompatActivity {
    String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
    Translator translate = new Translator();
    //para funcionar o botão back

    public void onBackPressed(){
        super.onBackPressed();
        openMessagesActivity();
        finish();
    }

    //função para ir para essa página
    private void openMessagesActivity() {
        Intent intent = new Intent(this, MorseActivity.class);
        startActivity(intent);

        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }
}
