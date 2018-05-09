package br.pro.hashi.ensino.desagil.morse;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class MorseActivity extends AppCompatActivity {

    String msg = "";
    String morse = "";
    Character translatedChar;
    Translator translate = new Translator();
    long initialTime;
    long endTime;

    public void onBackPressed() {
        super.onBackPressed();
        openMessagesActivity();
        finish();
    }

    private void openContatos_Send(String msg) {
        // Exemplo de código para abrir uma activity. Especificamente, a SendActivity.
        Intent intent = new Intent(this, Contatos_Send.class);
        intent.putExtra("msg", msg);
        startActivity(intent);
        finish();
    }

    private void openDictionary() {
        // Exemplo de código para abrir uma activity. Especificamente, a SendActivity.
        Intent intent = new Intent(this, Dictionary.class);
        intent.putExtra("msg", msg);
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

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //pegando a mensagem da página anterior
        Intent intent = getIntent();
        msg = intent.getStringExtra("msg");

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
                System.out.println("Mandei a mensagem" + msg);
                openContatos_Send(msg);
            }

        });

        final Handler handler = new Handler();

        final long update_msg = 500; //Em milissegundos

        Runnable periodicUpdate = new Runnable() {
            @Override
            public void run() {
                endTime = System.currentTimeMillis();
                if (morse.length() > 5) {
                    msg += " ";
                    morse = "";
                } else if (endTime - initialTime > 1000 && morse.length() != 0) {
                    translatedChar = translate.morseToChar(morse);
                    if (translatedChar == null) {
                        msg += " ";
                    } else {
                        msg += translatedChar;
                    }
                    System.out.println(msg);
                    morse = "";
                }
                text.setText(msg);
                textMorse.setText(morse);
                handler.postDelayed(this, update_msg);
            }
        };

        handler.postDelayed(periodicUpdate, update_msg);


        button2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    initialTime = System.currentTimeMillis();
                    System.out.println("Down");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    endTime = System.currentTimeMillis();
                    System.out.println("UP");
                    if (endTime - initialTime > 350) {
                        morse += "-";
                    } else {
                        morse += ".";
                    }
                    initialTime = System.currentTimeMillis();
                    textMorse.setText(morse);

                }
                return true;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDictionary();
            }
        });
    }
}
