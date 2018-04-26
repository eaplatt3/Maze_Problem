import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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
	Image Ming;

	@Override
	public void start(Stage stage) throws Exception {

		//Image Imports
		Ming = new Image("maze.png");
		ImageView imgViewM = new ImageView(Ming);
		Image Ding = new Image("droid.jpg");
		ImageView imgViewD = new ImageView(Ding);


		spn1 = new StackPane(imgViewM);
		spn2 = new StackPane(imgViewD);


		//Starting Location for Droid
		spn2.setLayoutX(15);
		spn2.setLayoutY(258);

		//this.readPixelColor(Ming);
		
		Group g = new Group(spn1, spn2);
		Scene sn = new Scene(g, 607, 421);
		
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
		int x;

		pr = Ming.getPixelReader();

		for(y = 0; y < height; y++) {

			for(x = 0; x < width; x++) {
				color = pr.getColor(x, y);

				System.out.println("Color y: " + y + " " + color + " Color x: " + x + " " + color);

			}

		}


	}

	private boolean readPixelColor2(Image Ming, double x,double y) {

		pr = Ming.getPixelReader();
				color = pr.getColor((int)x, (int)y);
				System.out.println("Color y: " + y + " " + color + " Color x: " + x + " " + color);
				return (color.getBlue() == 0.1);
	}


	//Key Press Method moves Droid around Maze
	public void processKeyPress(KeyEvent event) {
				
		switch (event.getCode()) {

		case UP:
			if(!readPixelColor2(Ming, spn2.getLayoutX(), spn2.getLayoutY()))spn2.setLayoutY(spn2.getLayoutY() - MOVE);
			readPixelColor2(Ming, spn2.getLayoutX(), spn2.getLayoutY());	
				
				break;
		case DOWN:
			if(!readPixelColor2(Ming, spn2.getLayoutX(), spn2.getLayoutY()))spn2.setLayoutY(spn2.getLayoutY() + MOVE);
			readPixelColor2(Ming, spn2.getLayoutX(), spn2.getLayoutY());
			break;
		case RIGHT:
			if(!readPixelColor2(Ming, spn2.getLayoutX(), spn2.getLayoutY()))spn2.setLayoutX(spn2.getLayoutX() + MOVE);
			readPixelColor2(Ming, spn2.getLayoutX(), spn2.getLayoutY());
			break;
		case LEFT:
			if(!readPixelColor2(Ming, spn2.getLayoutX(), spn2.getLayoutY()))spn2.setLayoutX(spn2.getLayoutX() - MOVE);
			readPixelColor2(Ming, spn2.getLayoutX(), spn2.getLayoutY());
			break;
		default:
			break;

		}		

	}


	public static void main(String[] args) {
		launch(args);
	}

}
