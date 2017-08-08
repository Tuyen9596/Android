package tuyen.com.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] items={"Tuyen","Vinh"};
        listview= (ListView) findViewById(R.id.listview1);
        Adapter adapter=new Adapter(this,items);
        listview.setAdapter(adapter);
    }
}
