package tuyen.com.sqllite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
final  String Database_name="Emlpoyer.sqlite";
    SQLiteDatabase database;
    private ListView listView;
    ArrayList<NhanVien> arrayList;
    AdapterNhanVien adapter;
    String DB_PATH_SUFFIX="/databases/";
    Button btadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        readData();
        processCopy();
        addEvent();
    }
    private void addEvent() {
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Add.class);
                startActivity(intent);
            }
        });
    }
    private void addControl() {
        listView= (ListView) findViewById(R.id.lv);
        arrayList=new ArrayList<>();
        adapter=new AdapterNhanVien(this,arrayList);
        listView.setAdapter(adapter);
        btadd= (Button) findViewById(R.id.btnadd);
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
    private void CopydulieuvaoDatabase()
    {
        try{
            InputStream inputStream=getAssets().open(Database_name);
            String outputfile=duongdanluutru();
            File f=new File(getApplicationInfo().dataDir+DB_PATH_SUFFIX);
            if(!f.exists())
            {
                f.mkdir();
            }
            OutputStream outputStream=new FileOutputStream(outputfile);
            byte[] buffer=new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }
        catch (Exception ex)
        {
            Log.e("Loi sao chep ",ex.toString());
        }
    }
    private  String duongdanluutru()
    {
        return getApplicationInfo().dataDir+DB_PATH_SUFFIX+Database_name;
    }
    private void processCopy() {
        //private app
         File dbFile = getDatabasePath(Database_name);
        if (!dbFile.exists())
        {
            try{
                CopydulieuvaoDatabase();
                Toast.makeText(this, "Copying sucess from Assets folder", Toast.LENGTH_LONG).show();
            }
            catch (Exception ex)
            {
                Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

    }
