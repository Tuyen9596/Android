package tuyen.com.gridview;

        import android.os.Bundle;
        import android.app.Activity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.GridView;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.AdapterView.OnItemClickListener;

        import Grid.MyAdapter;

public class MainActivity extends Activity
        implements OnItemClickListener
{
    TextView tvMsg;
    GridView gv;
    TextView tvSoloMsg;
    //mảng lưu danh sách các id hình ảnh có sẵn
    Integer[]mThumbIds;
    //Adapter cho GridView
    MyAdapter adapter=null;
    //Vì không tạo thêm 1 Activity nên lấy luôn 2 Id ở bên solo_picture.xml
    ImageView ivSoloPicture;
    Button btnBack;
    //Lưu Bundle backup cho MainActivity
    Bundle myBackupBundle;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Lưu savedInstanceState trước vào myBackupBundle
        myBackupBundle=savedInstanceState;
        setContentView(R.layout.activity_main);
        tvMsg=(TextView) findViewById(R.id.tvMsg);
        //gán mảng các Id hình ảnh cho mThumbIds
        mThumbIds=new Integer[]{R.drawable.h1,R.drawable.h2,
                R.drawable.h3,R.drawable.h4,
                R.drawable.h5,R.drawable.h6,
                R.drawable.h1,R.drawable.h2};
        gv=(GridView) findViewById(R.id.gridView1);
        //thiết lập Datasource cho Adapter
        adapter=new MyAdapter(this, mThumbIds);
        //gán Adapter vào Gridview
        gv.setAdapter(adapter);
        //thiết lập sự kiện để mở từng hình ảnh chitiết
        gv.setOnItemClickListener(this);
    }
    public void onItemClick(AdapterView<?> arg0,
                            View arg1, int arg2, long arg3) {
        //gọi hàm xem hình ảnh chi tiết tại ví trí thứ arg2
        showdetail(arg2);
    }
    public void showdetail(int posistion)
    {
        //Không mở Activity mới mà chỉ thiết lập lại Layout
        setContentView(R.layout.items_grid);
        //Vừa gọi hàm trên thì màn hình sẽ thay đổi qua cái mới
        //ta lấy các control trong layout mới này
        tvSoloMsg=(TextView) findViewById(R.id.tvSoloMsg);
        tvSoloMsg.setText("Hinh Thu "+posistion);
        ivSoloPicture=(ImageView) findViewById(R.id.imgSolo);
        //thiết lập hình ảnh đang chọn lên ImageView mới
        ivSoloPicture.setImageResource(mThumbIds[posistion]);
        btnBack=(Button) findViewById(R.id.btnBack);
        //Thiết lập sự kiện click Back để phục hồi lại MainActivity
        //bằng cách gọi lại onCreate(myBackupBundle);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                onCreate(myBackupBundle);
            }
        });
    }
}