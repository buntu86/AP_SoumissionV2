package ap.dev.soumission2.view.dialog;

import ap.dev.soumission2.MainApp;
import ap.dev.soumission2.model.M_Cahier;
import ap.dev.soumission2.model.M_Position;
import ap.dev.soumission2.tools.Log;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class EditPositionsController implements Initializable {
    
    private Stage stage;

    @FXML
    private TableView<M_Position> table;
    
    @FXML
    private TableColumn<M_Position, Integer> num;
    
    @FXML
    private ChoiceBox<M_Cahier> choicebox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choicebox.setItems(MainApp.getCan().getListCahiers());
        choicebox.getSelectionModel()
                .selectedItemProperty()
                .addListener( (ObservableValue<? extends M_Cahier> observable, M_Cahier oldValue, M_Cahier newValue) -> updateChoiceBox(newValue) );
    }    
    
    public void updateChoiceBox(M_Cahier cahier){
        
        //cahier.getListPositions().add(new M_Position(0, true, 0, 0, "desc", "unite"));
        
        table.setItems(cahier.getListPositions());
        num.setCellValueFactory(cellData -> cellData.getValue().numPositionProperty().asObject());            
        
     
    }
    
    public void setStage(Stage editArticlesStage) {
        this.stage = editArticlesStage;

        //ESC touch listener
        stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (KeyCode.ESCAPE == event.getCode()) {
                stage.close();
            }
        });
        choicebox.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (KeyCode.ESCAPE == event.getCode()) {
                stage.close();
            }
        });
    }  
    
    @FXML
    public void close(){
        this.stage.close();
    }       
    
}
