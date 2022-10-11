module textAnalyzerGUI {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires org.jsoup;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
