import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class run extends Application {
    public void start(Stage stage) throws Exception {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        Scene home = new Scene(homeRoot);

        stage.setScene(home);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image("/image/citizen_icon.png"));
        stage.show();

        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
