package control;

import database.database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Predicate;

public class controllerDashBoard implements Initializable {
    @FXML
    private Button dangxuat_btn;

    @FXML
    private TextField dongPhi_idHoKhauTxt;

    @FXML
    private Button dongphi_btn;

    @FXML
    private AnchorPane dongphi_form;

    @FXML
    private TableColumn<HoKhau, String> dongphi_idHoKhau_col;

    @FXML
    private TableColumn<DongPhi, String> dongphi_idKhoanThu_col;

    @FXML
    private TextField dongphi_idKhoanThuTxt;

    @FXML
    private DatePicker dongphi_ngayDongTxt;

    @FXML
    private TableColumn<DongPhi, String> dongphi_ngayDong_col;

    @FXML
    private TextField dongphi_searchTxt;

    @FXML
    private Button dongphi_sua_btn;

    @FXML
    private TableView<DongPhi> dongphi_table;

    @FXML
    private TextField dongphi_tenNguoiNopTxt;

    @FXML
    private TableColumn<DongPhi, String> dongphi_tenNguoiNop_col;

    @FXML
    private Button dongphi_them_btn;

    @FXML
    private Button dongphi_xoa_btn;

    @FXML
    private Button exit_bt;

    @FXML
    private Button hokhau_btn;

    @FXML
    private TableColumn<HoKhau, String> hokhau_chuHo_col;

    @FXML
    private TableColumn<HoKhau, String> hokhau_diaChi_col;

    @FXML
    private AnchorPane hokhau_form;

    @FXML
    private TableColumn<HoKhau, String> hokhau_idHoKhau_col;

    @FXML
    private TableView<HoKhau> hokhau_table;

    @FXML
    private Button khoanThu_chinhSuaBt;

    @FXML
    private TextField khoanThu_giaTriTxt;

    @FXML
    private TextField khoanThu_idKhoanThuTxt;

    @FXML
    private ComboBox<?> khoanThu_loaiKhoanThuTxt;

    @FXML
    private TextField khoanThu_searchTxt;

    @FXML
    private TextField khoanThu_tenKhoanThuTxt;

    @FXML
    private Button khoanThu_themBtn;

    @FXML
    private Button khoanThu_xoaBtn;

    @FXML
    private Button khoanthu_btn;

    @FXML
    private AnchorPane khoanthu_form;

    @FXML
    private TableColumn<KhoanThu, String> khoanthu_giaTri_col;

    @FXML
    private TableColumn<KhoanThu, String> khoanthu_idKhoanThu_col;

    @FXML
    private TableColumn<KhoanThu, String> khoanthu_loaiKhoanThu_col;

    @FXML
    private DatePicker khoanthu_ngayBatDauTxt;

    @FXML
    private TableColumn<KhoanThu, String> khoanthu_ngayBatDau_col;

    @FXML
    private DatePicker khoanthu_ngayKetThucTxt;

    @FXML
    private TableColumn<KhoanThu, String> khoanthu_ngayKetThuc_col;

    @FXML
    private TableView<KhoanThu> khoanthu_table;

    @FXML
    private TableColumn<KhoanThu, String> khoanthu_tenKhoanThu_col;

    @FXML
    private Button minus_btn;

    @FXML
    private TextField nhanKhau_searchTxt;

    @FXML
    private TextField nhanKhau_searchTxt1;

    @FXML
    private Button nhankhau_btn;

    @FXML
    private TableColumn<NhanKhau, String> nhankhau_canCuoc_col;

    @FXML
    private AnchorPane nhankhau_form;

    @FXML
    private TableColumn<NhanKhau, String> nhankhau_hoTen_col;

    @FXML
    private TableColumn<NhanKhau, String> nhankhau_idHoKhau_col;

    @FXML
    private TableColumn<NhanKhau, String> nhankhau_idNhanKhau_col;

    @FXML
    private TableColumn<NhanKhau, String> nhankhau_namSinh_col;

    @FXML
    private TableColumn<NhanKhau, String> nhankhau_quanHe_col;

    @FXML
    private TableView<NhanKhau> nhankhau_table;

    @FXML
    private TableColumn<QuaTang, String> quatang_baoGom_col;

    @FXML
    private Button quatang_btn;

    @FXML
    private TableColumn<QuaTang, String> quatang_diaDiem_col;

    @FXML
    private TableColumn<QuaTang, String> quatang_dieuKien_col;

    @FXML
    private AnchorPane quatang_form;

    @FXML
    private TableColumn<QuaTang, String> quatang_giaTri_col;

    @FXML
    private TableColumn<QuaTang, String> quatang_idQuaTang_col;

    @FXML
    private TableColumn<QuaTang, String> quatang_ngayBatDau_col;

    @FXML
    private TableColumn<QuaTang, String> quatang_ngayKetThuc_col;

    @FXML
    private TextField quatang_searchTxt;

    @FXML
    private TableColumn<QuaTang, String> quatang_suKien_col;

    @FXML
    private TableView<QuaTang> quatang_table;

    @FXML
    private TextField tangqua_baoGomTxt;

    @FXML
    private TextField tangqua_diaDiemTxt;

    @FXML
    private TextField tangqua_dieuKienTxt;

    @FXML
    private TextField tangqua_giaTriTxt;

    @FXML
    private TextField tangqua_idQuaTangTxt;

    @FXML
    private DatePicker tangqua_ngayBatDauTxt;

    @FXML
    private DatePicker tangqua_ngayKetThucTxt;

    @FXML
    private TextField tangqua_suKienTxt;

    @FXML
    private ComboBox<?> dongphi_tennguoidong;
    @FXML
    private ComboBox<?> dongphi_idhokhau;

    @FXML
    private ComboBox<?> dongphi_idkhoanthu;

    @FXML
    private Button tangqua_sua_btn;

    @FXML
    private Button tangqua_them_btn;

    @FXML
    private Button tangqua_xoa_btn;

    @FXML
    private Label tongQuan_tongHoKhauTxt;

    @FXML
    private Label tongQuan_tongNhanKhauTxt;

    @FXML
    private Label tongQuan_tongKhoanThuTxt;

    @FXML
    private Button tongquan_btn;

    @FXML
    private Button khoanThu_don_btn;

    @FXML
    private TextField hoKhau_searchTxt;

    @FXML
    private TableColumn<DongPhi, String> dongphi_soTien_col;

    @FXML
    private AnchorPane tongquan_form;

    @FXML
    private TextField dongPhi_soTienTxt;

    @FXML
    private Label tongQuan_tongQuaTxt;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;

    /*------------------------NHAN KHAU--------------------------*/
    private ObservableList<NhanKhau> danhSachNhanKhau;

    public ObservableList<NhanKhau> layDanhSachNhanKhau() {
        String sql = "SELECT * FROM nhankhau";
        ObservableList<NhanKhau> danhSachNhanKhau = FXCollections.observableArrayList();
        connection = database.connectDb();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            NhanKhau nhanKhauData;

            while (resultSet.next()) {
                nhanKhauData = new NhanKhau(resultSet.getString("IDNhanKhau"),
                        resultSet.getString("IDHoKhau"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("CCCD"),
                        resultSet.getDate("NgaySinh"),
                        resultSet.getString("QuanHeVoiChuHo"));
                danhSachNhanKhau.add(nhanKhauData);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return danhSachNhanKhau;
    }

    public void hienThiDanhSachNhanKhau() {
        danhSachNhanKhau = layDanhSachNhanKhau();

        nhankhau_idNhanKhau_col.setCellValueFactory(new PropertyValueFactory<>("IDNhanKhau"));
        nhankhau_idHoKhau_col.setCellValueFactory(new PropertyValueFactory<>("IDHoKhau"));
        nhankhau_hoTen_col.setCellValueFactory(new PropertyValueFactory<>("HoTen"));
        nhankhau_canCuoc_col.setCellValueFactory(new PropertyValueFactory<>("CCCD"));
        nhankhau_namSinh_col.setCellValueFactory(new PropertyValueFactory<>("NgaySinh"));
        nhankhau_quanHe_col.setCellValueFactory(new PropertyValueFactory<>("QuanHeVoiChuHo"));

        nhankhau_table.setItems(danhSachNhanKhau);
        timKiemNhanKhau();
    }

    //Tim kiem nhan khau
    @FXML
    void timKiemNhanKhau() {
        FilteredList<NhanKhau> nhanKhauFilteredList = new FilteredList<>(danhSachNhanKhau, b -> true);
        nhanKhau_searchTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            nhanKhauFilteredList.setPredicate(NhanKhau -> {
                if (newValue == null || newValue.isEmpty() || newValue.isBlank()) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (NhanKhau.getIDNhanKhau().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (NhanKhau.getIDHoKhau().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (NhanKhau.getHoTen().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (NhanKhau.getCCCD().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (NhanKhau.getNgaySinh().toString().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (NhanKhau.getQuanHeVoiChuHo().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else return false;
            });
        });

        SortedList<NhanKhau> nhanKhauSortedList = new SortedList<>(nhanKhauFilteredList);
        nhanKhauSortedList.comparatorProperty().bind(nhankhau_table.comparatorProperty());

        nhankhau_table.setItems(nhanKhauSortedList);
    }

    /*-----------------------------KHOAN THU-------------------------------*/

    private ObservableList<KhoanThu> danhSachKhoanThu;
    private String[] loaiKhoanThuList = {"Bắt buộc", "Ủng hộ"};

    public void loaiKhoanThu() {
        List<String> loaikhoanthu = new ArrayList<>();

        for (String loaiKT : loaiKhoanThuList) {
            loaikhoanthu.add(loaiKT);
        }

        ObservableList observableList = FXCollections.observableArrayList(loaikhoanthu);
        khoanThu_loaiKhoanThuTxt.setItems(observableList);
    }

    public ObservableList<KhoanThu> layDanhSachKhoanThu() {
        String sql = "SELECT * FROM khoanthu";
        ObservableList<KhoanThu> khoanThuData = FXCollections.observableArrayList();
        connection = database.connectDb();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            KhoanThu khoanThu;

            while (resultSet.next()) {
                khoanThu = new KhoanThu(resultSet.getString("IDKhoanThu"),
                        resultSet.getString("TenKhoanThu"),
                        resultSet.getString("LoaiKhoanThu"),
                        resultSet.getInt("GiaTri"),
                        resultSet.getDate("NgayBatDau"),
                        resultSet.getDate("NgayKetThuc"));

                khoanThuData.add(khoanThu);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return khoanThuData;
    }

    public void hienThiDanhSachKhoanThu() {
        danhSachKhoanThu = layDanhSachKhoanThu();

        khoanthu_idKhoanThu_col.setCellValueFactory(new PropertyValueFactory<>("IDKhoanThu"));
        khoanthu_tenKhoanThu_col.setCellValueFactory(new PropertyValueFactory<>("TenKhoanThu"));
        khoanthu_loaiKhoanThu_col.setCellValueFactory(new PropertyValueFactory<>("LoaiKhoanThu"));
        khoanthu_giaTri_col.setCellValueFactory(new PropertyValueFactory<>("GiaTri"));
        khoanthu_ngayBatDau_col.setCellValueFactory(new PropertyValueFactory<>("NgayBatDau"));
        khoanthu_ngayKetThuc_col.setCellValueFactory(new PropertyValueFactory<>("NgayKetThuc"));

        khoanthu_table.setItems(danhSachKhoanThu);
        timKiemKhoanThu();
    }

    public void chonKhoanThu() {
        KhoanThu khoanThu = khoanthu_table.getSelectionModel().getSelectedItem();
        int num = khoanthu_table.getSelectionModel().getSelectedIndex();

        if ((num - 1 < -1)) {
            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("System Message");
            alert.setHeaderText(null);
            alert.setContentText("Chưa có khoản thu được lựa chọn");
            alert.showAndWait();
            return;
        }

        khoanThu_idKhoanThuTxt.setText(khoanThu.getIDKhoanThu());
        khoanThu_tenKhoanThuTxt.setText(khoanThu.getTenKhoanThu());
        khoanThu_giaTriTxt.setText(String.valueOf(khoanThu.getGiaTri()));
        khoanthu_ngayBatDauTxt.setValue(LocalDate.parse(String.valueOf(khoanThu.getNgayBatDau())));
        khoanthu_ngayKetThucTxt.setValue(LocalDate.parse(String.valueOf(khoanThu.getNgayKetThuc())));
    }

    public void themKhoanThu() {
        String sql = "INSERT INTO `khoanthu`(`IDKhoanThu`, `TenKhoanThu`, `LoaiKhoanThu`, `GiaTri`, `NgayBatDau`, `NgayKetThuc`) VALUES (?,?,?,?,?,?)";
        connection = database.connectDb();

        try {
            Alert alert;
            if (khoanThu_idKhoanThuTxt.getText().isEmpty()
                    || khoanThu_tenKhoanThuTxt.getText().isEmpty()
                    || khoanThu_giaTriTxt.getText().isEmpty()
                    || khoanThu_loaiKhoanThuTxt.getSelectionModel().getSelectedItem() == null
                    || khoanthu_ngayBatDauTxt.getValue() == null
                    || khoanthu_ngayKetThucTxt.getValue() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                if(khoanThu_giaTriTxt.getText().matches("^(0|[1-9][0-9]*)$")) {
                    //Kiem IDKhoanThu
                    String checkIdKhoanThu = "SELECT IDKhoanThu FROM khoanthu WHERE IDKhoanThu = '" + khoanThu_idKhoanThuTxt.getText() + "'";
                    statement = connection.createStatement();
                    resultSet = preparedStatement.executeQuery(checkIdKhoanThu);

                    if (resultSet.next()) {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("ID Khoản thu" + khoanThu_idKhoanThuTxt.getText() + "đã tồn tại!");
                        alert.showAndWait();
                    } else {
                        preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, khoanThu_idKhoanThuTxt.getText());
                        preparedStatement.setString(2, khoanThu_tenKhoanThuTxt.getText());
                        preparedStatement.setString(3, (String) khoanThu_loaiKhoanThuTxt.getSelectionModel().getSelectedItem());
                        preparedStatement.setString(4, khoanThu_giaTriTxt.getText());
                        preparedStatement.setString(5, String.valueOf(khoanthu_ngayBatDauTxt.getValue()));
                        preparedStatement.setString(6, String.valueOf(khoanthu_ngayKetThucTxt.getValue()));

                        preparedStatement.executeUpdate();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Thêm thành công!");
                        alert.showAndWait();

                        hienThiDanhSachKhoanThu();
                        donKhoanThu();
                    }
                }else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("please enter the correct format of 'Giá trị'");
                    alert.showAndWait();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void capNhatKhoanThu() {
        String capNhat = "UPDATE khoanthu SET "
                + "TenKhoanThu = '" + khoanThu_tenKhoanThuTxt.getText()
                + "', LoaiKhoanThu = '" + khoanThu_loaiKhoanThuTxt.getSelectionModel().getSelectedItem()
                + "', GiaTri = '" + khoanThu_giaTriTxt.getText()
                + "', NgayBatDau = '" + khoanthu_ngayBatDauTxt.getValue()
                + "', NgayKetThuc = '" + khoanthu_ngayKetThucTxt.getValue()
                + "' WHERE IDKhoanThu = '"
                + khoanThu_idKhoanThuTxt.getText() + "'";

        connection = database.connectDb();

        try {
            Alert alert;
            if (khoanThu_idKhoanThuTxt.getText().isEmpty()
                    || khoanThu_tenKhoanThuTxt.getText().isEmpty()
                    || khoanThu_giaTriTxt.getText().isEmpty()
                    || khoanThu_loaiKhoanThuTxt.getSelectionModel().getSelectedItem() == null
                    || khoanthu_ngayBatDauTxt.getValue() == null
                    || khoanthu_ngayKetThucTxt.getValue() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                if(khoanThu_giaTriTxt.getText().matches("^(0|[1-9][0-9]*)$")) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Bạn có muốn UPDATE khoản thu #" +
                            khoanThu_idKhoanThuTxt.getText() + "?");
                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get().equals(ButtonType.OK)) {
                        statement = connection.createStatement();
                        statement.executeUpdate(capNhat);

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Updated!");
                        alert.showAndWait();

                        hienThiDanhSachKhoanThu();
                        donKhoanThu();
                    } else {
                        return;
                    }
                }else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("please enter the correct format of 'Giá trị'");
                    alert.showAndWait();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void xoaKhoanThu() {
        String xoaKT = "DELETE FROM khoanthu WHERE IDKhoanThu = '"
                + khoanThu_idKhoanThuTxt.getText() + "'";
        connection = database.connectDb();

        try {
            Alert alert;
            if (khoanThu_idKhoanThuTxt.getText().isEmpty()
                    || khoanThu_tenKhoanThuTxt.getText().isEmpty()
                    || khoanThu_giaTriTxt.getText().isEmpty()
                    || khoanthu_ngayBatDauTxt.getValue() == null
                    || khoanthu_ngayKetThucTxt.getValue() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn có muốn DELETE khoản thu #" +
                        khoanThu_idKhoanThuTxt.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connection.createStatement();
                    statement.executeUpdate(xoaKT);

                    String checkId = "SELECT IDKhoanThu FROM khoanthu "
                            + "WHERE IDKhoanThu = '" + khoanThu_idKhoanThuTxt.getText() + "'";
                    preparedStatement = connection.prepareStatement(checkId);
                    resultSet = preparedStatement.executeQuery();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    hienThiDanhSachKhoanThu();
                    donKhoanThu();
                } else {
                    return;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void timKiemKhoanThu() {
        FilteredList<KhoanThu> khoanThuFilteredList = new FilteredList<>(danhSachKhoanThu, b -> true);
        khoanThu_searchTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            khoanThuFilteredList.setPredicate(KhoanThu -> {
                if (newValue == null || newValue.isEmpty() || newValue.isBlank()) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (KhoanThu.getIDKhoanThu().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (KhoanThu.getTenKhoanThu().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (KhoanThu.getLoaiKhoanThu().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (KhoanThu.getNgayBatDau().toString().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (KhoanThu.getNgayKetThuc().toString().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (((Integer) KhoanThu.getGiaTri()).toString().indexOf(searchKeyword) != -1) {
                    return true;
                } else return false;
            });
        });

        SortedList<KhoanThu> khoanThuSortedList = new SortedList<>(khoanThuFilteredList);
        khoanThuSortedList.comparatorProperty().bind(khoanthu_table.comparatorProperty());

        khoanthu_table.setItems(khoanThuSortedList);
    }

    public void donKhoanThu() {
        khoanThu_idKhoanThuTxt.setText("");
        khoanThu_loaiKhoanThuTxt.getSelectionModel().clearSelection();
        khoanThu_giaTriTxt.setText("");
        khoanthu_ngayBatDauTxt.setValue(null);
        khoanthu_ngayKetThucTxt.setValue(null);
        khoanThu_tenKhoanThuTxt.setText("");
    }

    /*--------------------------------Hộ khẩu-------------------------------*/
    public ObservableList<HoKhau> layDanhSachHoKhau() {
        String sql = "select * from hokhau";
        ObservableList<HoKhau> dsHoKhau = FXCollections.observableArrayList();
        connection = database.connectDb();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            HoKhau hoKhau;

            while (resultSet.next()) {
                hoKhau = new HoKhau(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                dsHoKhau.add(hoKhau);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsHoKhau;
    }

    private ObservableList<HoKhau> dsHoKhau;

    public void hienThiDanhSachHoKhau() {
        dsHoKhau = layDanhSachHoKhau();

        hokhau_idHoKhau_col.setCellValueFactory(new PropertyValueFactory<>("IDHoKhau"));
        hokhau_chuHo_col.setCellValueFactory(new PropertyValueFactory<>("ChuHo"));
        hokhau_diaChi_col.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));

        hokhau_table.setItems(dsHoKhau);
        timKiemHoKhau();
    }

    @FXML
    void timKiemHoKhau() {
        FilteredList<HoKhau> hoKhauFilteredList = new FilteredList<>(dsHoKhau, b -> true);
        hoKhau_searchTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            hoKhauFilteredList.setPredicate(HoKhau -> {
                if (newValue == null || newValue.isEmpty() || newValue.isBlank()) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (HoKhau.getIDHoKhau().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (HoKhau.getChuHo().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (HoKhau.getDiaChi().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else return false;
            });
        });

        SortedList<HoKhau> hoKhauSortedList = new SortedList<>(hoKhauFilteredList);
        hoKhauSortedList.comparatorProperty().bind(hokhau_table.comparatorProperty());

        hokhau_table.setItems(hoKhauSortedList);
    }

    /*----------------------Quà tặng-----------------------------*/

    public ObservableList<QuaTang> layDanhSachQuaTang() {
        String sql = "select * from quatang";
        ObservableList<QuaTang> dsQuaTang = FXCollections.observableArrayList();

        connection = database.connectDb();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            QuaTang quaTang;

            while (resultSet.next()) {
                quaTang = new QuaTang(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6),
                        resultSet.getDate(7), resultSet.getDate(8));

                dsQuaTang.add(quaTang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsQuaTang;
    }

    ObservableList<QuaTang> dsQuaTang;

    public void hienThiDanhSachQuaTang() {
        dsQuaTang = layDanhSachQuaTang();

        quatang_idQuaTang_col.setCellValueFactory(new PropertyValueFactory<>("IDQuaTang"));
        quatang_suKien_col.setCellValueFactory(new PropertyValueFactory<>("SuKien"));
        quatang_baoGom_col.setCellValueFactory(new PropertyValueFactory<>("BaoGom"));
        quatang_dieuKien_col.setCellValueFactory(new PropertyValueFactory<>("DieuKien"));
        quatang_giaTri_col.setCellValueFactory(new PropertyValueFactory<>("GiaTri"));
        quatang_diaDiem_col.setCellValueFactory(new PropertyValueFactory<>("DiaDiemNhanQua"));
        quatang_ngayBatDau_col.setCellValueFactory(new PropertyValueFactory<>("NgayBatDau"));
        quatang_ngayKetThuc_col.setCellValueFactory(new PropertyValueFactory<>("NgayKetThuc"));

        quatang_table.setItems(dsQuaTang);
    }

    public void themQuaTang() {
        String sql = "insert into quatang values(?,?,?,?,?,?,?,?)";

        connection = database.connectDb();

        try {
            if (tangqua_idQuaTangTxt.getText().isEmpty() || tangqua_suKienTxt.getText().isEmpty() || tangqua_baoGomTxt.getText().isEmpty() ||
                    tangqua_giaTriTxt.getText().isEmpty() || tangqua_dieuKienTxt.getText().isEmpty() || tangqua_diaDiemTxt.getText().isEmpty() ||
                    tangqua_ngayBatDauTxt.getEditor().getText().isEmpty() || tangqua_ngayKetThucTxt.getEditor().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập đủ thông tin");
                alert.showAndWait();
            } else {
                if(tangqua_giaTriTxt.getText().matches("^(0|[1-9][0-9]*)$")) {
                    String checkData = "select IDQuaTang from quatang where IDQuaTang='" + tangqua_idQuaTangTxt.getText() + "'";

                    statement = connection.createStatement();
                    resultSet = statement.executeQuery(checkData);

                    if (resultSet.next()) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error message");
                        alert.setHeaderText(null);
                        alert.setContentText("Quà tặng đã tồn tại");
                        alert.showAndWait();
                    } else {
                        preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, tangqua_idQuaTangTxt.getText());
                        preparedStatement.setString(2, tangqua_suKienTxt.getText());
                        preparedStatement.setString(3, tangqua_baoGomTxt.getText());
                        preparedStatement.setString(4, tangqua_dieuKienTxt.getText());
                        preparedStatement.setString(5, String.valueOf(tangqua_giaTriTxt.getText()));
                        preparedStatement.setString(6, tangqua_diaDiemTxt.getText());
                        Date date1 = Date.from(tangqua_ngayBatDauTxt.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                        java.sql.Date nbdsql = new java.sql.Date(date1.getTime());
                        preparedStatement.setString(7, String.valueOf(nbdsql));
                        Date date2 = Date.from(tangqua_ngayKetThucTxt.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                        java.sql.Date nktsql = new java.sql.Date(date2.getTime());
                        preparedStatement.setString(8, String.valueOf(nktsql));

                        preparedStatement.executeUpdate();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information message");
                        alert.setHeaderText(null);
                        alert.setContentText("Thêm quà tặng thành công");
                        alert.showAndWait();

                        hienThiDanhSachQuaTang();
                        resetThongTinQuaTang();
                    }
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter the correct format of 'Giá trị'");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void suaQuaTang() {
        String capNhat = "UPDATE quatang SET "
                + "SuKien = '" + tangqua_suKienTxt.getText()
                + "', BaoGom = '" + tangqua_baoGomTxt.getText()
                + "', DieuKien = '" + tangqua_dieuKienTxt.getText()
                + "', GiaTri = '" + tangqua_giaTriTxt.getText()
                + "', DiaDiemNhanQua = '" + tangqua_diaDiemTxt.getText()
                + "', NgayBatDau = '" + tangqua_ngayBatDauTxt.getValue()
                + "', NgayKetThuc = '" + tangqua_ngayBatDauTxt.getValue()
                + "' WHERE IDQuaTang = '"
                + tangqua_idQuaTangTxt.getText() + "'";
        connection = database.connectDb();

        try {
            Alert alert;
            if (tangqua_idQuaTangTxt.getText().isEmpty()
                    || tangqua_baoGomTxt.getText().isEmpty()
                    || tangqua_dieuKienTxt.getText().isEmpty()
                    || tangqua_giaTriTxt.getText().isEmpty()
                    || tangqua_diaDiemTxt.getText().isEmpty()
                    || tangqua_ngayBatDauTxt.getValue() == null
                    || tangqua_ngayBatDauTxt.getValue() == null) {
            } else {
                if(tangqua_giaTriTxt.getText().matches("^(0|[1-9][0-9]*)$")) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Bạn có muốn UPDATE quà tặng #" +
                            tangqua_idQuaTangTxt.getText() + "?");
                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get().equals(ButtonType.OK)) {
                        statement = connection.createStatement();
                        statement.executeUpdate(capNhat);

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Updated!");
                        alert.showAndWait();

                        hienThiDanhSachQuaTang();
                        resetThongTinQuaTang();
                    } else {
                        return;
                    }
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter the correct format of 'Giá trị'");
                    alert.showAndWait();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void xoaQuaTang() {
        QuaTang thongTinQuaTang = quatang_table.getSelectionModel().getSelectedItem();
        int row = quatang_table.getSelectionModel().getFocusedIndex();

        if ((row - 1) < -1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("Chọn quà tặng cần xoá");
            alert.show();
        } else {
            String sql = "delete from quatang where IDQuaTang='" + tangqua_idQuaTangTxt.getText() + "'";
            try {
                statement = connection.createStatement();
                statement.executeUpdate(sql);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information message");
                alert.setHeaderText(null);
                alert.setContentText("Xoá thành công");
                alert.show();
                resetThongTinQuaTang();
                hienThiDanhSachQuaTang();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void hienThiThongTinQuaTangDangChon() {
        QuaTang thongTinQuaTang = quatang_table.getSelectionModel().getSelectedItem();
        int row = quatang_table.getSelectionModel().getSelectedIndex();

        if ((row - 1) < -1) {
            return;
        }

        tangqua_idQuaTangTxt.setText(thongTinQuaTang.getIDQuaTang());
        tangqua_suKienTxt.setText(thongTinQuaTang.getSuKien());
        tangqua_baoGomTxt.setText(thongTinQuaTang.getBaoGom());
        tangqua_giaTriTxt.setText(String.valueOf(thongTinQuaTang.getGiaTri()));
        tangqua_dieuKienTxt.setText(thongTinQuaTang.getDieuKien());
        tangqua_diaDiemTxt.setText(thongTinQuaTang.getDiaDiemNhanQua());
        tangqua_ngayBatDauTxt.setValue(LocalDate.parse(String.valueOf(thongTinQuaTang.getNgayBatDau())));
        tangqua_ngayKetThucTxt.setValue(LocalDate.parse(String.valueOf(thongTinQuaTang.getNgayKetThuc())));
    }

    public void resetThongTinQuaTang() {
        tangqua_idQuaTangTxt.setText("");
        tangqua_suKienTxt.setText("");
        tangqua_baoGomTxt.setText("");
        tangqua_dieuKienTxt.setText("");
        tangqua_giaTriTxt.setText("");
        tangqua_ngayBatDauTxt.setValue(null);
        tangqua_ngayKetThucTxt.setValue(null);
        tangqua_diaDiemTxt.setText("");
    }

    @FXML
    void timKiemQuaTang() {
        FilteredList<QuaTang> quaTangFilteredList = new FilteredList<>(dsQuaTang, b -> true);
        quatang_searchTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            quaTangFilteredList.setPredicate(QuaTang -> {
                if (newValue == null || newValue.isEmpty() || newValue.isBlank()) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (QuaTang.getIDQuaTang().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (QuaTang.getSuKien().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (QuaTang.getBaoGom().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (QuaTang.getNgayBatDau().toString().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (QuaTang.getNgayKetThuc().toString().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (((Integer) QuaTang.getGiaTri()).toString().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (QuaTang.getDiaDiemNhanQua().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (QuaTang.getDieuKien().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else return false;
            });
        });

        SortedList<QuaTang> quaTangSortedList = new SortedList<>(quaTangFilteredList);
        quaTangSortedList.comparatorProperty().bind(quatang_table.comparatorProperty());

        quatang_table.setItems(quaTangSortedList);
    }
    /*----------------------------------ĐÓNG PHÍ----------------------------------*/

    public void chonIDHoKhau() {
        String sql = "SELECT * FROM hokhau";

        connection = database.connectDb();

        try {
            ObservableList dsIDHoKhau = FXCollections.observableArrayList();

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                dsIDHoKhau.add(resultSet.getString(1));
            }

            dongphi_idhokhau.setItems(dsIDHoKhau);
            chonNguoiDong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chonNguoiDong() {
        String sql = "SELECT * FROM nhankhau WHERE IDHoKhau = '" + dongphi_idhokhau.getSelectionModel().getSelectedItem() + "'";
//        String sql = "SELECT * FROM nhankhau";
//        String sql = "SELECT * FROM nhankhau WHERE IDHoKhau = 'HK01'";
        connection = database.connectDb();

        try {
            ObservableList dsNguoiDong = FXCollections.observableArrayList();

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                dsNguoiDong.add(resultSet.getString(3));
            }

            dongphi_tennguoidong.setItems(dsNguoiDong);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ObservableList<DongPhi> danhSachDongPhi;

    public ObservableList<DongPhi> layDanhSachDongPhi() {
        String sql = "select * from danhsachdongphi";
        ObservableList<DongPhi> dsDongPhi = FXCollections.observableArrayList();

        connection = database.connectDb();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            DongPhi dongPhi;

            while (resultSet.next()) {
                dongPhi = new DongPhi(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4));
                dsDongPhi.add(dongPhi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsDongPhi;
    }

    public void hienThiDanhSachDongPhi() {
        danhSachDongPhi = layDanhSachDongPhi();

        dongphi_idKhoanThu_col.setCellValueFactory(new PropertyValueFactory<>("IDKhoanThu"));
        dongphi_idHoKhau_col.setCellValueFactory(new PropertyValueFactory<>("IDHoKhau"));
        dongphi_tenNguoiNop_col.setCellValueFactory(new PropertyValueFactory<>("NguoiDong"));
        dongphi_ngayDong_col.setCellValueFactory(new PropertyValueFactory<>("NgayNop"));

        dongphi_table.setItems(danhSachDongPhi);
    }

    public void chonDongPhi() {
        DongPhi dongPhi = dongphi_table.getSelectionModel().getSelectedItem();
        int num = dongphi_table.getSelectionModel().getSelectedIndex();

        if ((num - 1 < -1)) {
            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("System Message");
            alert.setHeaderText(null);
            alert.setContentText("Chưa có dữ liệu được lựa chọn");
            alert.showAndWait();
            return;
        }
        dongphi_idKhoanThuTxt.setText(dongPhi.getIDKhoanThu());
        dongphi_ngayDongTxt.setValue(LocalDate.parse(String.valueOf(dongPhi.getNgayNop())));
    }

    public void donDongPhi() {
        dongphi_idKhoanThuTxt.setText("");
        dongphi_idhokhau.setItems(null);
        dongphi_tennguoidong.setItems(null);
        dongphi_ngayDongTxt.setValue(null);
    }

    public void themDongPhi() {
        String sql = "INSERT INTO `danhsachdongphi`(`IDKhoanThu`, `IDHoKhau`, `NguoiDong`, `NgayNop`) VALUES (?,?,?,?)";
        connection = database.connectDb();

        try {
            Alert alert;
            if (dongphi_idKhoanThuTxt.getText().isEmpty()
                    || dongphi_idhokhau.getValue() == null
                    || dongphi_ngayDongTxt.getValue() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                //Kiem IDKhoanThu & IDHoKhau
                String checkIdKhoanThu = "SELECT IDKhoanThu, IDHoKhau FROM danhsachdongphi WHERE IDKhoanThu = '" + dongphi_idKhoanThuTxt.getText()
                        + "' AND IDHoKhau = '" + dongphi_idhokhau.getSelectionModel().getSelectedItem() + "'";
                statement = connection.createStatement();
                resultSet = preparedStatement.executeQuery(checkIdKhoanThu);

                if (resultSet.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("ID Khoản thu " + dongphi_idKhoanThuTxt.getText() + " của hộ khẩu " + dongphi_idhokhau.getSelectionModel().getSelectedItem() + " đã tồn tại!");
                    alert.showAndWait();
                } else {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, dongphi_idKhoanThuTxt.getText());
                    preparedStatement.setString(2, String.valueOf(dongphi_idhokhau.getSelectionModel().getSelectedItem()));
                    preparedStatement.setString(3, String.valueOf(dongphi_tennguoidong.getSelectionModel().getSelectedItem()));
                    preparedStatement.setString(4, String.valueOf(dongphi_ngayDongTxt.getValue()));

                    preparedStatement.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Thêm thành công!");
                    alert.showAndWait();

                    hienThiDanhSachDongPhi();
                    donDongPhi();

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void capNhapDongPhi() {
        String capNhat = "UPDATE danhsachdongphi SET "
                + "NguoiDong = '" + dongphi_tennguoidong.getSelectionModel().getSelectedItem()
                + "', NgayNop = '" + dongphi_ngayDongTxt.getValue()
                + "' WHERE IDKhoanThu = '"
                + dongphi_idKhoanThuTxt.getText() + "' AND"
                + " IDHoKhau = '" + dongphi_idhokhau.getSelectionModel().getSelectedItem() + "'";

        connection = database.connectDb();

        try {
            Alert alert;
            if (dongphi_idKhoanThuTxt.getText().isEmpty()
                    || dongphi_idhokhau.getValue() == null
                    || dongphi_ngayDongTxt.getValue() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn có muốn UPDATE dữ liệu không ?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connection.createStatement();
                    statement.executeUpdate(capNhat);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    hienThiDanhSachDongPhi();
                    donDongPhi();
                } else {
                    return;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void xoaDongPhi() {
        String xoaDP = "DELETE FROM danhsachdongphi WHERE IDKhoanThu = '"
                + dongphi_idKhoanThuTxt.getText() + "'";
//                + "AND IDHoKhau = '" + dongphi_idhokhau.getSelectionModel().getSelectedItem() + "'";
        connection = database.connectDb();

        try {
            Alert alert;
            if (dongphi_idKhoanThuTxt.getText().isEmpty()
                    || dongphi_ngayDongTxt.getValue() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn có muốn DELETE ?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connection.createStatement();
                    statement.executeUpdate(xoaDP);
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    hienThiDanhSachDongPhi();
                    donDongPhi();
                } else {
                    return;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void timKiemDongPhi() {
        FilteredList<DongPhi> dongPhiFilteredList = new FilteredList<>(danhSachDongPhi, b -> true);
        dongphi_searchTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            dongPhiFilteredList.setPredicate(DongPhi -> {
                if (newValue == null || newValue.isEmpty() || newValue.isBlank()) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (DongPhi.getIDKhoanThu().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (DongPhi.getIDHoKhau().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (DongPhi.getNguoiDong().toLowerCase().indexOf(searchKeyword) != -1) {
                    return true;
                } else if (DongPhi.getNgayNop().toString().indexOf(searchKeyword) != -1) {
                    return true;
                } else return false;
            });
        });

        SortedList<DongPhi> dongPhiSortedList = new SortedList<>(dongPhiFilteredList);
        dongPhiSortedList.comparatorProperty().bind(dongphi_table.comparatorProperty());

        dongphi_table.setItems(dongPhiSortedList);
    }

    /*-----------------------------------TỔNG QUAN---------------------------------*/
    public void hienThiTongHoKhau() {
        String sql = "SELECT COUNT(IDHoKhau) FROM hokhau";

        connection = database.connectDb();

        int countIDHoKhau = 0;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                countIDHoKhau = resultSet.getInt("COUNT(IDHoKhau)");
            }

            tongQuan_tongHoKhauTxt.setText(String.valueOf(countIDHoKhau));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hienThiTongNhanKhau() {
        String sql = "SELECT COUNT(IDNhanKhau) FROM nhankhau";

        connection = database.connectDb();

        int countIDNhanKhau = 0;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                countIDNhanKhau = resultSet.getInt("COUNT(IDNhanKhau)");
            }

            tongQuan_tongNhanKhauTxt.setText(String.valueOf(countIDNhanKhau));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hienThiTongKhoanThu() {
        String sql = "SELECT COUNT(IDKhoanThu) FROM khoanthu";

        connection = database.connectDb();

        int countIDKhoanThu = 0;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                countIDKhoanThu = resultSet.getInt("COUNT(IDKhoanThu)");
            }

            tongQuan_tongKhoanThuTxt.setText(String.valueOf(countIDKhoanThu));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hienThiTongSoQua() {
        String sql = "SELECT COUNT(IDQuaTang) FROM quatang";

        connection = database.connectDb();

        int countIDQuaTang = 0;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                countIDQuaTang = resultSet.getInt("COUNT(IDQuaTang)");
            }

            tongQuan_tongQuaTxt.setText(String.valueOf(countIDQuaTang));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchWindow(ActionEvent event) {
        if (event.getSource() == tongquan_btn) {
            tongquan_form.setVisible(true);
            nhankhau_form.setVisible(false);
            hokhau_form.setVisible(false);
            khoanthu_form.setVisible(false);
            quatang_form.setVisible(false);
            dongphi_form.setVisible(false);

            hienThiTongHoKhau();
            hienThiTongKhoanThu();
            hienThiTongNhanKhau();
            hienThiTongSoQua();
        } else if (event.getSource() == nhankhau_btn) {
            tongquan_form.setVisible(false);
            nhankhau_form.setVisible(true);
            hokhau_form.setVisible(false);
            khoanthu_form.setVisible(false);
            quatang_form.setVisible(false);
            dongphi_form.setVisible(false);

            hienThiDanhSachNhanKhau();
            timKiemNhanKhau();
        } else if (event.getSource() == hokhau_btn) {
            tongquan_form.setVisible(false);
            nhankhau_form.setVisible(false);
            hokhau_form.setVisible(true);
            khoanthu_form.setVisible(false);
            quatang_form.setVisible(false);
            dongphi_form.setVisible(false);

            hienThiDanhSachHoKhau();
            timKiemHoKhau();
        } else if (event.getSource() == khoanthu_btn) {
            tongquan_form.setVisible(false);
            nhankhau_form.setVisible(false);
            hokhau_form.setVisible(false);
            khoanthu_form.setVisible(true);
            quatang_form.setVisible(false);
            dongphi_form.setVisible(false);

            hienThiDanhSachKhoanThu();
            loaiKhoanThu();
            timKiemKhoanThu();
        } else if (event.getSource() == quatang_btn) {
            tongquan_form.setVisible(false);
            nhankhau_form.setVisible(false);
            hokhau_form.setVisible(false);
            khoanthu_form.setVisible(false);
            quatang_form.setVisible(true);
            dongphi_form.setVisible(false);

            hienThiDanhSachQuaTang();
            timKiemQuaTang();
        } else if (event.getSource() == dongphi_btn) {
            tongquan_form.setVisible(false);
            nhankhau_form.setVisible(false);
            hokhau_form.setVisible(false);
            khoanthu_form.setVisible(false);
            quatang_form.setVisible(false);
            dongphi_form.setVisible(true);

            hienThiDanhSachDongPhi();
            timKiemDongPhi();
            chonIDHoKhau();
            chonNguoiDong();
        }
    }

    public void minusWindow() {
        Stage stage = (Stage) minus_btn.getScene().getWindow();
        stage.setIconified(true);
    }

    private double y = 0;
    private double x = 0;

    public void dangXuat() {
        dangxuat_btn.getScene().getWindow().hide();

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        root.setOnMousePressed((MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/image/citizen_icon.png"));
        stage.show();
    }

    @FXML
    public void exit_ui(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hienThiTongHoKhau();
        hienThiTongKhoanThu();
        hienThiTongNhanKhau();
        hienThiTongSoQua();

        hienThiDanhSachHoKhau();
        hienThiDanhSachNhanKhau();
        hienThiDanhSachKhoanThu();
        hienThiDanhSachQuaTang();
        hienThiDanhSachDongPhi();

        timKiemNhanKhau();
        timKiemHoKhau();
        timKiemKhoanThu();
        timKiemQuaTang();
        loaiKhoanThu();
        timKiemDongPhi();
        chonIDHoKhau();
        chonNguoiDong();
    }
}
