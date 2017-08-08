package tuyen.com.recyclerview_va_viewholder_trong_android_studio;

/**
 * Created by Administrator on 7/29/2017.
 */

public class Person {
    private String name;
    private boolean gioitinh;

    public Person(String name, boolean gioitinh) {
        this.name = name;
        this.gioitinh = gioitinh;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getName() {
        return name;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }
}
