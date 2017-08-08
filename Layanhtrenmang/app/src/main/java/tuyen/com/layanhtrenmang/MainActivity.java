package tuyen.com.layanhtrenmang;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
ImageView imd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imd=(ImageView)findViewById(R.id.imageView);
    runOnUiThread(new Runnable() {
    @Override
    public void run() {
        new Loadanhfrominternet().execute("https://goo.gl/2Hb5i1");
    }
});
        //endregion
}
    private class  Loadanhfrominternet extends AsyncTask<String,Integer,String> {
Bitmap bmap;
        @Override
        protected String doInBackground(String... params) {
            try {
                URL u=new URL(params[0]);
                Bitmap bmap= BitmapFactory.decodeStream(u.openConnection().getInputStream());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            imd.setImageBitmap(bmap);
            Toast.makeText(MainActivity.this, "Load xong", Toast.LENGTH_SHORT).show();
        }
    }

}
