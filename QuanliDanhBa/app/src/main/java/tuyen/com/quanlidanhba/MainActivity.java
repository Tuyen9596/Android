package tuyen.com.quanlidanhba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import tuyen.com.quanlidanhba.model.DanhBa;
import tuyen.com.quanlidanhba.model.DataAdapter;
import tuyen.com.quanlidanhba.model.Database;

public class MainActivity extends AppCompatActivity {
    ListView lvdanhba;
    ArrayList<DanhBa> list;
    ArrayAdapter adaptertest;
    DataAdapter adapter;
    SQLiteDatabase database;
    final  String Database_Name="Danhba.sqlite";
    String DATA_PATH_SUFIX="/databases/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database= Database.initDatabase(this,Database_Name);
        Cursor cursor=database.rawQuery("Select * from DanhBa",null);
        cursor.moveToNext();
        Toast.makeText(this, cursor.getString(0).toString(), Toast.LENGTH_SHORT).show();
       // showAllContactonList();
       // addCotrol();
    }

    private void addCotrol() {
        lvdanhba= (ListView) findViewById(R.id.lvdanba);
        list=new ArrayList<>();
        adaptertest=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,list);
        lvdanhba.setAdapter(adapter);
    }

    private void showAllContactonList() {
        //B1:Mở cơ sỏ dl
        database= openOrCreateDatabase(Database_Name,MODE_PRIVATE,null);
        Cursor cursor=database.rawQuery("Select * from DanhBa",null);
       list.clear();
       for(int i=0;i<cursor.getCount();i++)
        {
            cursor.moveToNext();
            String name=cursor.getString(0);
            String sdt=cursor.getString(1);
            String gio=cursor.getString(2);
            list.add(new DanhBa(name,sdt,gio));
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }
}
