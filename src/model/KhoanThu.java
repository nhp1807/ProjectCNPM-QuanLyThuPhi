package model;

import java.util.Date;

public class KhoanThu {
    private String IDKhoanThu;
    private String TenKhoanThu;
    private String LoaiKhoanThu;
    private int GiaTri;
    private Date NgayBatDau;
    private Date NgayKetThuc;

    public KhoanThu() {

    }

    public KhoanThu(String IDKhoanThu, String tenKhoanThu, String loaiKhoanThu, int giaTri, Date ngayBatDau, Date ngayKetThuc) {
        this.IDKhoanThu = IDKhoanThu;
        TenKhoanThu = tenKhoanThu;
        LoaiKhoanThu = loaiKhoanThu;
        GiaTri = giaTri;
        NgayBatDau = ngayBatDau;
        NgayKetThuc = ngayKetThuc;
    }

    public String getIDKhoanThu() {
        return IDKhoanThu;
    }

    public void setIDKhoanThu(String IDKhoanThu) {
        this.IDKhoanThu = IDKhoanThu;
    }

    public String getTenKhoanThu() {
        return TenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        TenKhoanThu = tenKhoanThu;
    }

    public String getLoaiKhoanThu() {
        return LoaiKhoanThu;
    }

    public void setLoaiKhoanThu(String loaiKhoanThu) {
        LoaiKhoanThu = loaiKhoanThu;
    }

    public int getGiaTri() {
        return GiaTri;
    }

    public void setGiaTri(int giaTri) {
        GiaTri = giaTri;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        NgayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        NgayKetThuc = ngayKetThuc;
    }
}
