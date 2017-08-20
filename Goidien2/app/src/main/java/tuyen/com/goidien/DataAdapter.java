package tuyen.com.goidien;

import android.Manifest;
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

/**
 * Created by Administrator on 20/08/2017.
 */

public class DataAdapter extends BaseAdapter {
    Context context;
    ArrayList<DanhBa> list;

    public DataAdapter(Context activity, ArrayList<DanhBa> list) {
        this.context = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.items_danhba,null);
        TextView name= (TextView) view.findViewById(R.id.txtname);
        final TextView sdt= (TextView) view.findViewById(R.id.txtsdt);
        TextView gio= (TextView) view.findViewById(R.id.txtgio);
        Button btgoidien= (Button) view.findViewById(R.id.btngoidien);
        DanhBa a=list.get(position);
        name.setText(a.name.toString());
        sdt.setText(a.sdt.toString());
        gio.setText(a.gio.toString());
        btgoidien.setOnClickListener(new View.OnClickListener() {
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
