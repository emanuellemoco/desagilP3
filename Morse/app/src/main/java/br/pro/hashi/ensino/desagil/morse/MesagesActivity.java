package br.pro.hashi.ensino.desagil.morse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MesagesActivity extends AppCompatActivity {
    String msg;

    //para funcionar o botão de voltar
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        openMainActivity();
        finish();
    }


    //função para ir para essa página
    private void openContatos_Send(String msg) {
        // Exemplo de código para abrir uma activity. Especificamente, a SendActivity.
        Intent intent = new Intent(this, Contatos_Send.class);
        intent.putExtra("msg",msg);
        startActivity(intent);
        finish();
    }

    //função para ir para essa página
    private void openMainActivity() {
        // Exemplo de código para abrir uma activity. Especificamente, a SendActivity.
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("msg",msg);
        startActivity(intent);
        finish();
    }

    //função para ir para essa página
    private void openMorseActivity() {
        // Exemplo de código para abrir uma activity. Especificamente, a SendActivity.
        Intent intent = new Intent(this, MorseActivity.class);
        intent.putExtra("msg", msg);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        //criamos botões para as mensagens e o código morse
        Button button1 = (Button) findViewById(R.id.button6);
        Button button2 = (Button) findViewById(R.id.button7);
        Button button3 = (Button) findViewById(R.id.button8);
        Button button4 = (Button) findViewById(R.id.button9);
        Button button5 = (Button) findViewById(R.id.button10);
        Button button6 = (Button) findViewById(R.id.button11);

        //Atividade do botão morse - ir para a página que escreve o código morse
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = "";
                openMorseActivity();

            }

        });

        //Atividade dos botões - definir mensagem e ir para a página de contatos
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = "Estou com fome";
                openContatos_Send(msg);

            }

        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = "Estou com sede";
                openContatos_Send(msg);

            }

        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = "Por favor venha até aqui";
                openContatos_Send(msg);

            }

        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = "Preciso ir ao banheiro";
                openContatos_Send(msg);

            }

        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = "Ajuda urgente";
                openContatos_Send(msg);

            }

        });

    }

}
