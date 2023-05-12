module DiscosDonPepe {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires java.logging;
	requires java.rmi;
	requires javafx.base;

	opens controllers to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
	exports application;
	exports model;
}
