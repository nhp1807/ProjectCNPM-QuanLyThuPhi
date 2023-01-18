package model;

import java.util.Date;

public class NhanKhau {
    private String IDNhanKhau;
    private String IDHoKhau;
    private String HoTen;
    private String CCCD;
    private Date NgaySinh;
    private String QuanHeVoiChuHo;

    public NhanKhau() {

    }

    public NhanKhau(String IDNhanKhau, String IDHoKhau, String hoTen, String CCCD, Date ngaySinh, String quanHeVoiChuHo) {
        this.IDNhanKhau = IDNhanKhau;
        this.IDHoKhau = IDHoKhau;
        HoTen = hoTen;
        this.CCCD = CCCD;
        NgaySinh = ngaySinh;
        QuanHeVoiChuHo = quanHeVoiChuHo;
    }

    public String getIDNhanKhau() {
        return IDNhanKhau;
    }

    public void setIDNhanKhau(String IDNhanKhau) {
        this.IDNhanKhau = IDNhanKhau;
    }

    public String getIDHoKhau() {
        return IDHoKhau;
    }

    public void setIDHoKhau(String IDHoKhau) {
        this.IDHoKhau = IDHoKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getQuanHeVoiChuHo() {
        return QuanHeVoiChuHo;
    }

    public void setQuanHeVoiChuHo(String quanHeVoiChuHo) {
        QuanHeVoiChuHo = quanHeVoiChuHo;
    }
}
