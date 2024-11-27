module Calculator {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires exp4j;
	
	opens application to javafx.graphics, javafx.fxml;
	exports source;
	opens source to javafx.fxml;
}
