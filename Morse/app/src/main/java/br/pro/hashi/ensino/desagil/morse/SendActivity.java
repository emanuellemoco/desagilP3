package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

public class SendActivity extends AppCompatActivity {

    public SendActivity(LinkedList<String> infos) {
        String message = infos.get(0);
        String number = infos.get(1);

        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(number, null, message, null, null);

        if (infos.size() > 2) {
            for (int i = 2; i <= infos.size() - 1; i++) {
                number = infos.get(i);
                SmsManager manager1 = SmsManager.getDefault();
                manager1.sendTextMessage(number, null, message, null, null);
            }
        }
    }
}