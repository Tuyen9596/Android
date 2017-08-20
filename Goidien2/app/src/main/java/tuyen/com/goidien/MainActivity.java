package tuyen.com.goidien;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lvdanhsach;
    final  String DATABASE_NAME="Danhba.sqlite";
    SQLiteDatabase database;
    ArrayList<DanhBa> list;
    DataAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCOntrols();
        readData();
    }

    private void addCOntrols() {
        lvdanhsach= (ListView) findViewById(R.id.lvdanhsach);
        list=new ArrayList<>();
        adapter=new DataAdapter(this,list);
        lvdanhsach.setAdapter(adapter);

    }
    private  void readData()
    {
        database=Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("select * from DanhBa",null);
        cursor.moveToNext();
        Toast.makeText(this, cursor.getString(0).toString(), Toast.LENGTH_SHORT).show();
        list.clear();
        for(int i=0;i<cursor.getCount();i++)
        {
            cursor.moveToPosition(i);
            String name=cursor.getString(0);
            String sdt=cursor.getString(1);
            String gio=cursor.getString(2);
            list.add(new DanhBa(name,sdt,gio));
        }
        adapter.notifyDataSetChanged();

    }
}
