package tuyen.com.helloword;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static tuyen.com.helloword.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    TextView txtten;
    Button btsubmit;
    ImageView imag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        txtten=(TextView) findViewById(R.id.txtname);
        Toast.makeText(MainActivity.this,"Hello people",Toast.LENGTH_SHORT).show();
       btsubmit=(Button) findViewById(R.id.btxacnhan);
        imag=(ImageView)findViewById(R.id.imagelbl);
        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtten.setText("Co cai cc ý");
                imag.setImageResource(R.drawable.hangkhong);
            }
        });


    }
}
