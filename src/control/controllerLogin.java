package control;

import database.database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class controllerLogin {

    @FXML
    private Button btnAbout;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnContact;

    @FXML
    private Button btnInfo;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnMinus;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private AnchorPane loginView;

    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;


    @FXML
    void accessAbout(ActionEvent event) {

    }

    @FXML
    void accessContact(ActionEvent event) {

    }

    @FXML
    void accessInfo(ActionEvent event) {

    }

    @FXML
    void closeLogin(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    void minusLogin(ActionEvent event) {
        Stage stage = (Stage) loginView.getScene().getWindow();
        stage.setIconified(true);
    }

    private double y = 0;
    private double x = 0;

    @FXML
    void dangNhap() {

        String sql = "select * from nguoidung where username=? and password=?";

        connection = database.connectDb();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, txtUsername.getText());
            preparedStatement.setString(2, txtPassword.getText());
            resultSet = preparedStatement.executeQuery();

            Alert alert;

            if (txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                if (resultSet.next()) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully login!");
                    alert.showAndWait();

                    btnLogin.getScene().getWindow().hide();

                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/view/dashboard1.fxml"));
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
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong username or password!");
                    txtUsername.clear();
                    txtPassword.clear();
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
