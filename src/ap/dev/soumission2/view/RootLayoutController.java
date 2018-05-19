package ap.dev.soumission2.view;

import ap.dev.soumission2.MainApp;
import ap.dev.soumission2.view.dialog.EditCANController;
import ap.dev.soumission2.view.dialog.EditPositionsController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RootLayoutController {

    public RootLayoutController() {
    }
    
    @FXML
    private void exit(){ 
        System.exit(0);
    }
    
    @FXML
    private void dialog_EditCAN(){
        try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("/ap/dev/soumission2/view/dialog/EditCAN.fxml"));
                AnchorPane anchorPane = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Edition des cahiers CAN");
                stage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(anchorPane);
                stage.setScene(scene);
                EditCANController controller = loader.getController();
                controller.setStage(stage);

                stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }      
    }   
    @FXML
    private void dialog_EditPositions(){
        try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("/ap/dev/soumission2/view/dialog/EditPositions.fxml"));
                AnchorPane anchorPane = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Edition des positions");
                stage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(anchorPane);
                stage.setScene(scene);
                EditPositionsController controller = loader.getController();
                controller.setStage(stage);

                stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }      
    }    
}
