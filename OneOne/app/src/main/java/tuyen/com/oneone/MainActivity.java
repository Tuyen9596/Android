package tuyen.com.oneone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txt1,txt2,txt3;
    Button bttinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1= (TextView) findViewById(R.id.editText);
        txt2= (TextView) findViewById(R.id.editText2);
        txt3= (TextView) findViewById(R.id.textView1);
        bttinh= (Button) findViewById(R.id.button);
        bttinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(txt1.getText().toString());
                int b=Integer.parseInt(txt2.getText().toString());
                txt3.setText("Ket qua :"+(a+b));
            }
        });
    }
}
