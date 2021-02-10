import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class creates a Triangle in a GUI, the points of the triangle are
 * inputed by the user. The user must click "Create" to make the triangle once
 * all the points are entered. The user can also click "End" to close the
 * program.
 * 
 * @author Carter Clark
 *
 */
public class TriangleGUI extends Application {

	private Button createButton = new Button("Create");
	private Button endButton = new Button("End");

	private TextField xPoint1 = new TextField();
	private TextField xPoint2 = new TextField();
	private TextField xPoint3 = new TextField();
	private TextField yPoint1 = new TextField();
	private TextField yPoint2 = new TextField();
	private TextField yPoint3 = new TextField();

	private Text point1Text = new Text("Point 1");
	private Text point2Text = new Text("Point 2");
	private Text point3Text = new Text("Point 3");
	private Text xText = new Text("X");
	private Text yText = new Text("Y");

	private Canvas canvas = new Canvas(400, 400);

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane pane = new GridPane();
		pane.add(canvas, 0, 0);

		GridPane buttonPane = new GridPane();
		buttonPane.add(createButton, 0, 4);
		buttonPane.add(endButton, 1, 4);

		// x TextFields
		buttonPane.add(xText, 1, 0);
		buttonPane.add(xPoint1, 1, 1);
		buttonPane.add(xPoint2, 1, 2);
		buttonPane.add(xPoint3, 1, 3);

		// y TextFields
		buttonPane.add(yText, 2, 0);
		buttonPane.add(yPoint1, 2, 1);
		buttonPane.add(yPoint2, 2, 2);
		buttonPane.add(yPoint3, 2, 3);

		// text for labeling the points
		buttonPane.add(point1Text, 0, 1);
		buttonPane.add(point2Text, 0, 2);
		buttonPane.add(point3Text, 0, 3);

		// adds the buttonPane to pane
		pane.add(buttonPane, 0, 1);
		Scene scene = new Scene(pane);

		primaryStage.setTitle("Assignment2");
		primaryStage.setScene(scene);

		createButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// making points using method getPointFromTextField()
				Point point1 = new Point(Integer.parseInt(xPoint1.getText()), Integer.parseInt(yPoint1.getText()));
				Point point2 = new Point(Integer.parseInt(xPoint2.getText()), Integer.parseInt(yPoint2.getText()));
				Point point3 = new Point(Integer.parseInt(xPoint3.getText()), Integer.parseInt(yPoint3.getText()));

				// making and adding lines
				GraphicsContext gc = canvas.getGraphicsContext2D();
				gc.strokeLine(point1.getX(), point1.getY(), point2.getX(), point2.getY());
				gc.strokeLine(point2.getX(), point2.getY(), point3.getX(), point3.getY());
				gc.strokeLine(point3.getX(), point3.getY(), point1.getX(), point1.getY());

			}

		});

		endButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.exit(0);
			}
		});

		primaryStage.show();

	}

	/**
	 * main() launches the GUI
	 * 
	 * @param args, the arguments to run the program
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

//	/**
//	 * This method takes two objects of type TextField and returns a Point from
//	 * integers that are parsed from the TextFields
//	 * @param xPoint, a TextField that represents the x coordinate of the point
//	 * @param yPoint, a TextField that represents the y coordinate of the point
//	 * @return the point with the inputed x and y coordinates
//	 */
//	public Point getPointFromTextField(TextField xPoint, TextField yPoint) {
//        Point point = new Point(Integer.parseInt(xPoint.getText()), Integer.parseInt(yPoint.getText()));
//        
//        return point;
//	}

}

//add(node, columnNumber, rowNumber)
