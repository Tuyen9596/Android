package tuyen.com.tab_host;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText soa,sob;
    Button btcong;
    ListView lvhistory;
    ArrayList<String> array;
    ArrayAdapter<String> adapter;
    TabHost tabhost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrol();
        addevent();
    }

    private void addevent() {
        btcong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void addcontrol() {
        tabhost= (TabHost) findViewById(R.id.tabHost);
        tabhost.setup();

        TabHost.TabSpec tab1=tabhost.newTabSpec("t1");
        tab1.setIndicator("Phep cong");
        tab1.setContent(R.id.tab3);
        TabHost.TabSpec tab2=tabhost.newTabSpec("t2");
        tab2.setIndicator("Hisory");
        tab2.setContent(R.id.tab2);
        tabhost.addTab(tab1);
        tabhost.addTab(tab2);


        soa= (EditText) findViewById(R.id.soa);
        sob= (EditText) findViewById(R.id.sob);
        btcong= (Button) findViewById(R.id.button);
        lvhistory= (ListView) findViewById(R.id.lvHistory);
    }
}
