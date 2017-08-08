package tuyen.com.hocquanliketquatrave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText a,b;
    Button bt;
    TextView txtketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();


    }

    private void addEvent() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Manhinhxuly.class);
                //gui 2 gia tri a,b qua man hinh ben kia
               intent.putExtra("a",Integer.parseInt(a.getText().toString()));
                intent.putExtra("b",Integer.parseInt(b.getText().toString()));
                //khoi dong intent gui di voi ma code 99
                startActivityForResult(intent,99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==99 && resultCode==33)
        {
            txtketqua.setText(""+data.getIntExtra("USCLN",1));
        }
    }

    private void addControl() {
        a= (EditText) findViewById(R.id.a);
        b= (EditText) findViewById(R.id.b);
        bt= (Button) findViewById(R.id.button);
        txtketqua= (TextView) findViewById(R.id.txtketqua);
    }
}
