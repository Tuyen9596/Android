package tuyen.com.quanlidanhba.model;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import tuyen.com.quanlidanhba.R;

/**
 * Created by Administrator on 19/08/2017.
 */

public class DataAdapter extends BaseAdapter {
    Activity context;
ArrayList<DanhBa> list;

    public DataAdapter(Activity context, ArrayList<DanhBa> list) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.item_danhba,null);
        TextView chusdt= (TextView) view.findViewById(R.id.txttensdt);
        final TextView sdt= (TextView) view.findViewById(R.id.txtsdt);
        TextView gio= (TextView) view.findViewById(R.id.txtgio);
        Button goidien= (Button) view.findViewById(R.id.btngoidien);
        DanhBa one=list.get(position);
        chusdt.setText(one.name.toString());
        sdt.setText(one.sdt.toString());
        gio.setText(one.gio.toString());
        goidien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + sdt.getText().toString());
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(uri);
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                context.startActivity(intent);
            }
        });
        return view;
    }
}
