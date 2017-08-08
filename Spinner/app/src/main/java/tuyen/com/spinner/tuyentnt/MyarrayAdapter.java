package tuyen.com.spinner.tuyentnt;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tuyen.com.spinner.R;

/**
 * Created by Administrator on 8/1/2017.
 */

public class MyarrayAdapter extends BaseAdapter {
    Activity activity;
    ArrayList<nhanvien> arrayList;
    int layoutId;
public MyarrayAdapter(Activity activity,int layoutId, ArrayList<nhanvien> arrayList)
{
    this.activity=activity;
    this.arrayList=arrayList;
    this.layoutId=layoutId;
}
    @Override
    public int getCount() {
        return 0;
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
        LayoutInflater inflater=activity.getLayoutInflater();
        convertView=inflater.inflate(layoutId,null);
        TextView txtdisplay=(TextView) convertView.findViewById(R.id.tv_name);
        TextView txtdisplay2=(TextView) convertView.findViewById(R.id.tv2_name);
        final nhanvien emp=arrayList.get(position);
        //đưa thông tin lên TextView
        //emp.toString() sẽ trả về Id và Name
        txtdisplay.setText(emp.toString());
        txtdisplay2.setText(emp.toString());
        return null;
    }
}
