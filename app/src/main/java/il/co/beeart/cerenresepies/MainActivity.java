package il.co.beeart.cerenresepies;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    TelephonyManager manager;

    private Button btnGoToMain;
    Button btnMail, btnCall;
    private PhoneStateListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGoToMain = findViewById(R.id.btnGoToStart);
        btnCall = findViewById(R.id.btnCallUs);
        btnMail = findViewById(R.id.btnUsMail);


        btnGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainMenu.class));
            }
        });
    }


    public void btnCall(View view) {

        String phoneNumber = "0527374888";
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel: "+phoneNumber));
        startActivity(intent);
        listener = new PhoneReceiver(this);
        manager = (TelephonyManager)getSystemService(
                Context.TELEPHONY_SERVICE);
    }

    public void btnMail(View view) {
        String mailAddress = "ceren.kush@gmail.com";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, mailAddress);
        intent.putExtra(Intent.EXTRA_SUBJECT, "היי, אשמח לקבל ממך מתכון!");
        intent.setType("Message");
    }
}
