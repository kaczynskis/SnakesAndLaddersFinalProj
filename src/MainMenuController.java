import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class MainMenuController implements Initializable{
	@FXML private Button newGameButton;
	public void loadNext() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
			Parent root;
			root = loader.load();
			Scene scene = new 
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		newGameButton.setOnAction((event -> {
			loadNext();
		}));
		
	}

}
