package tuyen.com.dichuyengiuacacmanhinh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button goto2;
EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goto2=(Button)findViewById(R.id.btgoto2);
        text=(EditText)findViewById(R.id.text1);
        goto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh2=new Intent(MainActivity.this,Manhinh2.class);
                mh2.putExtra("hoten",text.getText().toString());
                startActivity(mh2);
            }
        });

    }
}
