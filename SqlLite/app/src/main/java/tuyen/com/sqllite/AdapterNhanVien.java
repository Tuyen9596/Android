package tuyen.com.sqllite;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 12/08/2017.
 */

public class AdapterNhanVien extends BaseAdapter {
    final Activity context;
    ArrayList<NhanVien> list;

    public AdapterNhanVien(Activity context, ArrayList<NhanVien> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listview_row, null);
        ImageView img = (ImageView) row.findViewById(R.id.imganh);
        TextView ID = (TextView) row.findViewById(R.id.txtid);
        TextView name = (TextView) row.findViewById(R.id.txtname);
        TextView sdt = (TextView) row.findViewById(R.id.txtsdt);
        Button update = (Button) row.findViewById(R.id.btsua);
        Button xoa = (Button) row.findViewById(R.id.btxoa);
        final NhanVien nhanVien = list.get(position);
        ID.setText(nhanVien.ID + "");
        name.setText(nhanVien.ten);
        sdt.setText(nhanVien.sdt);
        Bitmap hinhanh = BitmapFactory.decodeByteArray(nhanVien.anh, 0, nhanVien.anh.length);
        img.setImageBitmap(hinhanh);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Update.class);
                intent.putExtra("ID", nhanVien.ID);
                context.startActivity(intent);
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setTitle("Xac nhận xóa");
                builder.setMessage("Bạn co chắc chắn xóa??");
                builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        delete(nhanVien.ID);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }

        });
        return row;
    }

    private void delete(int idNhanVien) {
        SQLiteDatabase database = Datatbase.initDatabase(context,"Emlpoyer.sqlite");
        database.delete("NhanVien","ID=?",new String[]{idNhanVien+""});
        Cursor cursor=database.rawQuery("select * from NhanVien",null);
        while (cursor.moveToNext())
        {
            int id=cursor.getInt(0);
            String ten=cursor.getString(1);
            String sdt=cursor.getString(2);
            byte[] anh=cursor.getBlob(3);
            list.clear();
            list.add(new NhanVien(id,ten,sdt,anh));
        }
notifyDataSetChanged();
    }
}
