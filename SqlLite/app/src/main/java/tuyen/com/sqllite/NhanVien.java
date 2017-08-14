package tuyen.com.sqllite;

/**
 * Created by Administrator on 12/08/2017.
 */

public class NhanVien {
    public int ID;
    public String ten;
    public String sdt;
    public byte[] anh;

    public NhanVien(int ID, String ten, String sdt, byte[] anh) {
        this.ID = ID;
        this.ten = ten;
        this.sdt = sdt;
        this.anh = anh;
    }
}
