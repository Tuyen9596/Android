package tuyen.com.spinner.tuyentnt;

/**
 * Created by Administrator on 7/31/2017.
 */

public class nhanvien {
    public nhanvien(String hoten, String ngaycongtac) {
        this.hoten = hoten;
        this.ngaycongtac = ngaycongtac;
    }

    String hoten;
    String ngaycongtac;
    public String getHoten() {
        return hoten;
    }

    public nhanvien() {
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setNgaycongtac(String ngaycongtac) {
        this.ngaycongtac = ngaycongtac;
    }

    public String getNgaycongtac() {
        return ngaycongtac;
    }

    @Override
    public String toString() {
        return hoten+"\t"+ngaycongtac;
    }
}
