import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class run extends Application {
    private double x = 0 ;
    private double y = 0;
    public void start(Stage stage) throws Exception {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        Scene home = new Scene(homeRoot);

        stage.setScene(home);
        stage.centerOnScreen();

        homeRoot.setOnMousePressed((MouseEvent event) ->{
            x = event.getSceneX();
            y = event.getSceneY();
        });

        homeRoot.setOnMouseDragged((MouseEvent event) ->{
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image("/image/citizen_icon.png"));
        stage.show();

        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
