
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class Controller {

    @FXML
    private TableView filesOnServerTable;

    @FXML
    private VBox leftPanel, rightPanel;

    public void btnExitAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void copyBtnAction (ActionEvent actionEvent){ //копирования файла
        LeftPanelController leftPC = (LeftPanelController) leftPanel.getProperties().get("ctrl");
        LeftPanelController rightPC = (LeftPanelController) rightPanel.getProperties().get("ctrl");

        if (leftPC.getSelectedFilename() == null && rightPC.getSelectedFilename() == null){ //если ни в левой ни вправой панели файл не выбран
            Alert alert = new Alert(Alert.AlertType.ERROR, "Ни один файл не был выбран", ButtonType.OK);
            alert.showAndWait();
            return;
        }
    }

}
