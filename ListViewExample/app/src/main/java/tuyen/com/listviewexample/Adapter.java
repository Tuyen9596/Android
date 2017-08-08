package tuyen.com.listviewexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 7/29/2017.
 */

public class Adapter extends BaseAdapter{
    String[] item;
    private  Activity activity;
    public Adapter(Activity activity, String[] item)
    {
        this.activity=activity;
        this.item=item;
    }
    @Override
    public int getCount() {
        return item.length;
    }

    @Override
    public Object getItem(int position) {
        return item[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        convertView=layoutInflater.inflate(R.layout.item_name,null);
        TextView textView= (TextView) convertView.findViewById(R.id.textview1);
        textView.setText(item[position]);
        return convertView;
    }
}
