package tuyen.com.goidiennhantin;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtphone, txttinnhan;
    Button btquayso, btgoiuon, btnhantin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        Xylyquayso();
        btgoiuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + txtphone.getText().toString());
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(uri);
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });
        Xylytinnhan();
    }

    private void Xylytinnhan() {
        btnhantin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager sms = SmsManager.getDefault();
                Intent msgSent = new Intent("ACTION_MSG_SENT");
                final PendingIntent pendingMsgSent =
                        PendingIntent.getBroadcast(MainActivity.this, 0, msgSent, 0);
                registerReceiver(new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        int result = getResultCode();
                        String msg="Send OK";
                        if (result != Activity.RESULT_OK) {
                            msg="Send failed";
                        }
                        Toast.makeText(MainActivity.this, msg,
                                Toast.LENGTH_LONG).show();
                    }
                }, new IntentFilter("ACTION_MSG_SENT"));
                //Gọi hàm gửi tin nhắn đi
                sms.sendTextMessage(txtphone.getText().toString(), null, txttinnhan.getText()+"",
                        pendingMsgSent, null);
                //finish();

            }
        });
    }

    private void Xylyquayso() {
        btquayso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("tel:"+txtphone.getText().toString());
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }

    private void addControl()
    {
        txtphone= (EditText) findViewById(R.id.txtphone);
        txttinnhan= (EditText) findViewById(R.id.txttinnhan);
        btquayso= (Button) findViewById(R.id.btquayso);
        btgoiuon= (Button) findViewById(R.id.btgoiluon);
        btnhantin= (Button) findViewById(R.id.btnhantin);
    }
}
