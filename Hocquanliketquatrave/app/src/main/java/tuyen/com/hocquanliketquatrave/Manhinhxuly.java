package tuyen.com.hocquanliketquatrave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Manhinhxuly extends AppCompatActivity {
TextView txtnhap;
    Button bt;
    Intent intent;
    int a,b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhxuly);
        addControl();
        addEvent();
    }

    private void addEvent() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min=Math.min(a,b);
                int uscln=1;
                for(int i=min;i>=1;i--)
                {
                    if(a%i==0 && b%i==0) {
                        uscln = i;
                        break;
                    }
                }
                //gui ket qua ve man hinh chinh bang intent cu
                intent.putExtra("USCLN",uscln);
                //Danh dau ket qua tra ve
                setResult(33,intent);
                //Dong  man hinh nay lai de man hinh main tro thanh ForeGroudLifeTime
                finish();
            }
        });
    }


    private void addControl() {
        txtnhap= (TextView) findViewById(R.id.txtnhap);
        bt= (Button) findViewById(R.id.btUSCLN);
        //Lay du lieu intent ra
        intent=getIntent();
        a=intent.getIntExtra("a",-1);
        b=intent.getIntExtra("b",-1);
        txtnhap.setText("a="+a+" ;b="+b);

    }
}
