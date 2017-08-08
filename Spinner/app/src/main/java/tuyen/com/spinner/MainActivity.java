package tuyen.com.spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import tuyen.com.spinner.tuyentnt.MyarrayAdapter;
import tuyen.com.spinner.tuyentnt.nhanvien;

public class MainActivity extends AppCompatActivity {
    TextView textnhap;
    Button bt;
    Spinner spinner;
    ListView listvieww;
    ArrayList<nhanvien> dsach;
    String ngaycongtac[] = {"Thu 2", "Thu 3", "Thu 4", "Thu 5", "Thu 6", "Thu 7", "Chu nhat"};
    MyarrayAdapter myadapter = null;
    Integer luachon = -1;
    String chuoi = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dsach = new ArrayList<nhanvien>();
        addControl();
        addEvent();
        myadapter = new MyarrayAdapter(MainActivity.this, R.layout.items_name, dsach);
        listvieww.setAdapter(myadapter);
    }

    private void addEvent() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chuoi = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,textnhap.getText()+ chuoi, Toast.LENGTH_SHORT).show();
                nhanvien a=new nhanvien();
                a.setHoten(textnhap.getText().toString());
                a.setNgaycongtac(chuoi.toString());
                dsach.add(a);
                myadapter.notifyDataSetChanged();

            }
        });
    }

    private void xulixacnhan() {

    }

    private void addControl() {
        textnhap = (TextView) findViewById(R.id.textname);
        spinner = (Spinner) findViewById(R.id.spinnerngay);
        bt = (Button) findViewById(R.id.button);
        listvieww = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ngaycongtac);
        //phải gọi lệnh này để hiển thị danh sách cho Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}