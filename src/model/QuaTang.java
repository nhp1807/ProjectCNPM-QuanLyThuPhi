package model;

import java.util.Date;

public class QuaTang {
    private String IDQuaTang;
    private String SuKien;
    private String BaoGom;
    private String DieuKien;
    private int GiaTri;
    private String DiaDiemNhanQua;
    private Date NgayBatDau;
    private Date NgayKetThuc;

    public QuaTang() {

    }

    public QuaTang(String IDQuaTang, String suKien, String baoGom, String dieuKien, int giaTri, String diaDiemNhanQua, Date ngayBatDau, Date ngayKetThuc) {
        this.IDQuaTang = IDQuaTang;
        SuKien = suKien;
        BaoGom = baoGom;
        DieuKien = dieuKien;
        GiaTri = giaTri;
        DiaDiemNhanQua = diaDiemNhanQua;
        NgayBatDau = ngayBatDau;
        NgayKetThuc = ngayKetThuc;
    }

    public String getIDQuaTang() {
        return IDQuaTang;
    }

    public void setIDQuaTang(String IDQuaTang) {
        this.IDQuaTang = IDQuaTang;
    }

    public String getSuKien() {
        return SuKien;
    }

    public void setSuKien(String suKien) {
        SuKien = suKien;
    }

    public String getBaoGom() {
        return BaoGom;
    }

    public void setBaoGom(String baoGom) {
        BaoGom = baoGom;
    }

    public String getDieuKien() {
        return DieuKien;
    }

    public void setDieuKien(String dieuKien) {
        DieuKien = dieuKien;
    }

    public int getGiaTri() {
        return GiaTri;
    }

    public void setGiaTri(int giaTri) {
        GiaTri = giaTri;
    }

    public String getDiaDiemNhanQua() {
        return DiaDiemNhanQua;
    }

    public void setDiaDiemNhanQua(String diaDiemNhanQua) {
        DiaDiemNhanQua = diaDiemNhanQua;
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
