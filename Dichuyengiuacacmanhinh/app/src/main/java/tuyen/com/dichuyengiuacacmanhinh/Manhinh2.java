package tuyen.com.dichuyengiuacacmanhinh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Manhinh2 extends AppCompatActivity {
EditText text2;
    Button bt;
TextView chuoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh2);
        text2=(EditText)findViewById(R.id.txt2);
        chuoi=(TextView)findViewById(R.id.textView);
        bt=(Button)findViewById(R.id.Back);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh1=new Intent(Manhinh2.this,MainActivity.class);
                startActivity(mh1);
            }
        });
        Bundle bd=getIntent().getExtras();
        if(bd!=null)
        {
            String name=bd.getString("hoten");
            chuoi.setText(name);
        }
    }
}
