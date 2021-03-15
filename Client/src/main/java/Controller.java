import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView filesOnServerTable;

    @FXML
    VBox leftPanel, rightPanel;


    public void btnExitAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void copyBtnAction(ActionEvent actionEvent) { //кнопка копирования файла
        LeftPanelController leftPC = (LeftPanelController) leftPanel.getProperties().get("ctrl"); //из левой панели достали ссылку на контроллер левой панели
        LeftPanelController rightPC = (LeftPanelController) rightPanel.getProperties().get("ctrl");

        if (leftPC.getSelectedFilename() == null && rightPC.getSelectedFilename() == null) { //если ни в левой ни вправой панели файл не выбран
            Alert alert = new Alert(Alert.AlertType.ERROR, "Ни один файл не был выбран", ButtonType.OK);
            alert.showAndWait();
            return;
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Network.start();
        System.out.println("Network starter");
    }
} 