package il.co.beeart.cerenresepies;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

class PhoneReceiver extends PhoneStateListener {
        Context context;

        public PhoneReceiver(Context context) {
            this.context = context;
        }

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);


            String stateString = "";
            switch (state) {
                case TelephonyManager.CALL_STATE_IDLE:
                    stateString = "idle";
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    stateString = "ringing";
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    stateString = "offhook";
                    break;
            }
            Toast.makeText(context, stateString + " "
                    + incomingNumber, Toast.LENGTH_SHORT).show();
        }

        //////////////////////////////////////////////////////////

    public class PhoneStateReceiver extends BroadcastReceiver {

        TelephonyManager telephonyManager;
        PhoneStateListener listener;
        boolean alreadyListening;

        @Override
        public void onReceive(Context context, Intent intent) {
            listener = new PhoneReceiver(context);
            telephonyManager = (TelephonyManager)context.getSystemService(
                    Context.TELEPHONY_SERVICE);
            if(!alreadyListening){
                telephonyManager.listen(listener,
                        PhoneStateListener.LISTEN_CALL_STATE);
                alreadyListening = true;
            }
        }
    }
    }
