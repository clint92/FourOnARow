import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    GridPane gp;

    @Override
    public void start(Stage primaryStage) throws Exception {

        showBoard();
    }

    public void showBoard() {
        try {
            // Load seatsOverview for Small theater
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Board.fxml"));
            BorderPane board = loader.load();

            // new Stage with new scene
            Stage Stage = new Stage();
            Scene scene = new Scene(board, 600, 400);
            Stage.setScene(scene);
            Stage.setTitle("Connect 420");

            Image img = new Image("index.png");
            ImageView imgView = new ImageView(img);

            Button AddCellButton = new Button("Add Grids");

            gp = new GridPane();
            gp.setGridLinesVisible(true);
            gp.setAlignment(Pos.CENTER);
            board.setBottom(gp);
            board.setTop(AddCellButton);

            int columns = 3;
            int rows = 3;
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    Circle cb = new Circle(25);
                    cb.setFill(Color.RED);
                    gp.add(cb, i, j);
                }
            }
            Stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
