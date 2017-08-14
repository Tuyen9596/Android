package tuyen.com.sqllite;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
final  String Database_name="Emlpoyer.sqlite";
    SQLiteDatabase database;
    private ListView listView;
    ArrayList<NhanVien> arrayList;
    AdapterNhanVien adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        readData();
    }
    private void addControl() {
    listView= (ListView) findViewById(R.id.lv);
        arrayList=new ArrayList<>();
        adapter=new AdapterNhanVien(this,arrayList);
        listView.setAdapter(adapter);
    }
    public void readData()
    {
        database=Datatbase.initDatabase(this,Database_name);
        Cursor cursor=database.rawQuery("select * from NhanVien",null);
        arrayList.clear();

        for(int i=0;i<cursor.getCount();i++)
        {
            cursor.moveToPosition(i);
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String sdt=cursor.getString(2);
            byte[] anh=cursor.getBlob(3);
            arrayList.add(new NhanVien(id,name,sdt,anh));
        }
        adapter.notifyDataSetChanged();
    }
}
