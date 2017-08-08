package tuyen.com.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listv=(ListView)findViewById(R.id.listview);
        final ArrayList<String> mang=new ArrayList();
        mang.add("Lap trinh android");
        mang.add("Lap trinh IOS");
        mang.add("Lap trinh PHP");
        mang.add("Lap trinh ASP.NET");
        mang.add("Lap trinh HTML");
        mang.add("Lap trinh WINDOW");
        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, mang);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, mang.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
