package tuyen.com.gamelabai;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button button;
    TextView text;
    static int dem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.imagelabai);
        button=(Button)findViewById(R.id.bt);
        text=(TextView)findViewById(R.id.txt1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> mang=new ArrayList<Integer>();
                mang.add(R.drawable.c1);
                mang.add(R.drawable.c2);
                mang.add(R.drawable.c3);
                mang.add(R.drawable.c4);
                mang.add(R.drawable.c5);
                Random r=new Random();
                int giatri=r.nextInt(4);

                img.setImageResource(mang.get(giatri));
            }
        });
        dem=0;
        new CountDownTimer(10000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                text.setText("Giay thu "+(dem+1));
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this,"Xong roi",Toast.LENGTH_SHORT);

            }
        }.start();

    }
}
