package model;

public class HoKhau {
    private String IDHoKhau;
    private String ChuHo;
    private String DiaChi;

    public HoKhau() {

    }

    public HoKhau(String IDHoKhau, String chuHo, String diaChi) {
        this.IDHoKhau = IDHoKhau;
        ChuHo = chuHo;
        DiaChi = diaChi;
    }

    public String getIDHoKhau() {
        return IDHoKhau;
    }

    public void setIDHoKhau(String IDHoKhau) {
        this.IDHoKhau = IDHoKhau;
    }

    public String getChuHo() {
        return ChuHo;
    }

    public void setChuHo(String chuHo) {
        ChuHo = chuHo;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }
}
