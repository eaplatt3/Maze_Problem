import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MazeTest extends Application {

	public final static int MOVE = 10;
	public final static int FADE = 8;
	private StackPane spn2;
	private StackPane spn1;
	private PixelReader pr;
	private Color color;


	@Override
	public void start(Stage stage) throws Exception {

		//Image Imports
		Image Ming = new Image("maze.png");
		ImageView imgViewM = new ImageView(Ming);
		Image Ding = new Image("droid.jpg");
		ImageView imgViewD = new ImageView(Ding);


		spn1 = new StackPane(imgViewM);
		spn2 = new StackPane(imgViewD);


		//Starting Location for Droid
		spn2.setLayoutX(15);
		spn2.setLayoutY(258);

		Group g = new Group(spn1, spn2);

		Scene sn = new Scene(g, 607, 421);


		this.readPixelColor(Ming);

		if(color != Color.WHITE) {

			sn.setOnKeyPressed(this::processKeyPress);

		}

		stage.setScene(sn);
		stage.setResizable(false);
		stage.setTitle("Maze Game");
		stage.show();


	}

	//Reads in the Color of each pixel per X and Y value then Prints them 
	private void readPixelColor(Image Ming) {

		int width = (int)Ming.getWidth();
		int height = (int)Ming.getHeight();
		int y;
		int x = 0;

		pr = Ming.getPixelReader();

		for(y = 0; y < height; y++) {

			for(x = 0; x < width; x++) {
				color = pr.getColor(x, y);

				System.out.println("Color y: " + y + " " + color + " Color x: " + x + " " + color);

			}

		}


	}



	//Key Press Method
	public void processKeyPress(KeyEvent event) {
				
		switch (event.getCode()) {

		case UP:
			spn2.setLayoutY(spn2.getLayoutY() - MOVE);
			break;
		case DOWN:
			spn2.setLayoutY(spn2.getLayoutY() + MOVE);
			break;
		case RIGHT:
			spn2.setLayoutX(spn2.getLayoutX() + MOVE);
			break;
		case LEFT:
			spn2.setLayoutX(spn2.getLayoutX() - MOVE);
			break;
		default:
			break;

		}		

	}


	public static void main(String[] args) {
		launch(args);
	}

}
