package tuyen.com.sqllite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Update extends AppCompatActivity {
    final String Database_name = "Emlpoyer.sqlite";
    final int REquest_Take_Photo = 123;
    final int Request_Choose_Photo = 321;
    Button btChonhinh, btchuphinh, btluuhinh, btHuy;
    TextView editname, editsdt;
    ImageView imgHinhDaiDien;
     int id=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        addontrol();
        initUI();
        addEvent();
    }

    private void initUI() {

            Intent intent = getIntent();
            id = intent.getIntExtra("ID", -1);
            SQLiteDatabase database = Datatbase.initDatabase(this, Database_name);
            Cursor cursor = database.rawQuery("SELECT * FROM NhanVien WHERE ID = ?",new String[]{id+""});
            cursor.moveToFirst();
            String ten = cursor.getString(1);
            String sdt = cursor.getString(2);
            byte[] anh = cursor.getBlob(3);
            Bitmap bitmap = BitmapFactory.decodeByteArray(anh, 0, anh.length);
            imgHinhDaiDien.setImageBitmap(bitmap);
            editname.setText(ten);
            editsdt.setText(sdt);

    }

    private void addEvent() {
        btChonhinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoTo();
            }
        });
        btchuphinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoTo();
            }
        });
        btluuhinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        btHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancle();
            }
        });
    }

    private void addontrol() {
        btChonhinh = (Button) findViewById(R.id.btnChonHinh);
        btchuphinh = (Button) findViewById(R.id.btnChupHinh);
        btluuhinh = (Button) findViewById(R.id.btnLuu);
        btHuy = (Button) findViewById(R.id.btnHuy);
        editname = (TextView) findViewById(R.id.edtTen);
        editsdt = (TextView) findViewById(R.id.edtSdt);
        imgHinhDaiDien = (ImageView) findViewById(R.id.imgHinhDaiDien1);
    }

    private void takePhoTo() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REquest_Take_Photo);
    }

    private void choosePhoTo() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, Request_Choose_Photo);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (requestCode == Request_Choose_Photo) {
                try {
                    Uri imaUri = data.getData();
                    InputStream is = getContentResolver().openInputStream(imaUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    imgHinhDaiDien.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (requestCode == REquest_Take_Photo) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imgHinhDaiDien.setImageBitmap(bitmap);
            }
        }
    }
    private  void update()
    {
    byte[] anh=ImageView_To_Byte(imgHinhDaiDien);
        ContentValues contentvalue=new ContentValues();
        contentvalue.put("Ten",editname.getText().toString());
        contentvalue.put("SDT",editsdt.getText().toString());
        contentvalue.put("Anh",anh);
        SQLiteDatabase sqlitedatabase=Datatbase.initDatabase(this,Database_name);
        sqlitedatabase.update("NhanVien",contentvalue,"ID=?",new String[]{id+""});
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private void cancle()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
    public byte[] ImageView_To_Byte(ImageView imgv){

        BitmapDrawable drawable = (BitmapDrawable) imgv.getDrawable();
        Bitmap bmp = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}
