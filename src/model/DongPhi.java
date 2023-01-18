package model;

import java.sql.Date;

public class DongPhi {
    private String IDKhoanThu;
    private String IDHoKhau;
    private String NguoiDong;
    private Date NgayNop;

    public DongPhi(String IDKhoanThu, String IDHoKhau, String nguoiDong, Date ngayNop) {
        this.IDKhoanThu = IDKhoanThu;
        this.IDHoKhau = IDHoKhau;
        NguoiDong = nguoiDong;
        NgayNop = ngayNop;
    }

    public DongPhi() {
    }

    public String getIDKhoanThu() {
        return IDKhoanThu;
    }

    public void setIDKhoanThu(String IDKhoanThu) {
        this.IDKhoanThu = IDKhoanThu;
    }

    public String getIDHoKhau() {
        return IDHoKhau;
    }

    public void setIDHoKhau(String IDHoKhau) {
        this.IDHoKhau = IDHoKhau;
    }

    public String getNguoiDong() {
        return NguoiDong;
    }

    public void setNguoiDong(String nguoiDong) {
        NguoiDong = nguoiDong;
    }

    public Date getNgayNop() {
        return NgayNop;
    }

    public void setNgayNop(Date ngayNop) {
        NgayNop = ngayNop;
    }
}
