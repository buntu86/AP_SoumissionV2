package ap.dev.soumission2.view.dialog;

import ap.dev.soumission2.MainApp;
import ap.dev.soumission2.data.CahierToStringConverter;
import ap.dev.soumission2.model.M_Cahier;
import ap.dev.soumission2.model.M_Position;
import ap.dev.soumission2.tools.Log;
import ap.dev.soumission2.tools.Toolbox;
import java.net.URL;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditPositionsController implements Initializable {
    
    private Stage stage;

    @FXML
    private TableView<M_Position> table;
    
    @FXML
    private TableColumn<M_Position, Float> num;
    @FXML
    private TableColumn<M_Position, Integer> var;
    @FXML
    private TableColumn<M_Position, String> desc;
    @FXML
    private TableColumn<M_Position, String> unite;
    @FXML
    private TableColumn<M_Position, Double> prix;
    
    @FXML
    private ChoiceBox<M_Cahier> choicebox;
    
    @FXML
    private VBox vbox;
    
    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_modifier;
    @FXML
    private Button btn_supprimer;
    
    @FXML
    private TextField tf_num;
    @FXML
    private TextField tf_var;
    @FXML
    private TextField tf_desc;
    @FXML
    private TextField tf_unite;
    @FXML
    private TextField tf_prix;
    
    private int index = 0;    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    List<M_Cahier> cahiers = MainApp.getCan().getListCahiers();
    choicebox.getItems().addAll(cahiers);
    choicebox.setConverter( new CahierToStringConverter());
    
    //Choicebox listener
    choicebox.getSelectionModel()
            .selectedItemProperty()
            .addListener( (ObservableValue<? extends M_Cahier> observable, M_Cahier oldValue, M_Cahier newValue) -> updateTable(newValue) );

    resetInterface();
    vbox.setDisable(true);
    
    //Listener if somethings is selected
    table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if(newSelection != null)
        {
            Log.msg(0, table.getSelectionModel().getSelectedItem().getNumPosition() + "");
            btn_modifier.setDisable(false);
            btn_supprimer.setDisable(false);
            btn_ajouter.setDisable(true);
            tf_num.setText(String.valueOf(obs.getValue().getNumPosition()));
            tf_var.setText(String.valueOf(obs.getValue().getVariante()));
            tf_desc.setText(obs.getValue().getDescription());
            tf_unite.setText(obs.getValue().getUnite());
            tf_prix.setText(String.valueOf(obs.getValue().getPrixUnitaire()));

            index = table.getSelectionModel().selectedIndexProperty().get();            
        }
        else
        {
            resetInterface();
        }
    });        
    }    
    
    public void updateTable(M_Cahier cahier){
        MainApp.getCan().save();

        table.setItems(cahier.getListPositions());
        num.setCellValueFactory(cellData -> cellData.getValue().numPositionProperty().asObject());
        var.setCellValueFactory(cellData -> cellData.getValue().varianteProperty().asObject());
        desc.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        unite.setCellValueFactory(cellData -> cellData.getValue().uniteProperty());
        prix.setCellValueFactory(cellData -> cellData.getValue().prixUnitaireProperty().asObject());
        vbox.setDisable(false);
    }
    
    @FXML
    public void add(){
        if(!tf_num.getText().trim().equals("")){
            choicebox
                .getSelectionModel()
                .getSelectedItem()
                .getListPositions()
                .add(new M_Position(Toolbox.getFloat(tf_num.getText().trim()), false, Toolbox.getInt(tf_var.getText().trim()), Toolbox.getDouble(tf_prix.getText().trim()), tf_desc.getText().trim(), tf_unite.getText().trim()));            
            MainApp.getCan().save();
            resetInterface();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur - numéro position obligatoire");
            alert.setHeaderText(null);
            alert.setContentText("Le numéro de la position est obligatoire.");
            alert.showAndWait();
        }
    }    
    
    @FXML
    public void update(){
        if(!tf_num.getText().trim().equals("")){
            choicebox
                .getSelectionModel()
                .getSelectedItem()
                .getListPositions()
                .set(index, new M_Position(Toolbox.getFloat(tf_num.getText().trim()), false, Toolbox.getInt(tf_var.getText().trim()), Toolbox.getDouble(tf_prix.getText().trim()), tf_desc.getText().trim(), tf_unite.getText().trim()));
            MainApp.getCan().save();
            
            resetInterface();
            
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur - numéro position obligatoire");
            alert.setHeaderText(null);
            alert.setContentText("Le numéro de la position est obligatoire.");
            alert.showAndWait();
        }
    }      

    @FXML
    public void delete(){
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression de la position");
        alert.setContentText(null);
        alert.setHeaderText("Etes-vous sûr de vouloir supprimer cette position (" + table.getSelectionModel().getSelectedItem().getNumPosition() + " " + table.getSelectionModel().getSelectedItem().getDescription() + ")?");
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == ButtonType.OK)
        {
            Log.msg(0, "delete");
            choicebox.getSelectionModel().getSelectedItem().getListPositions().remove(index);
            
            MainApp.getCan().save();
        }
        

    }    
    
    public void setStage(Stage editArticlesStage) {
        this.stage = editArticlesStage;

        //ESC touch listener
        stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> closeIfEscape(event));
        choicebox.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> closeIfEscape(event));
             
    }  
    
    private void closeIfEscape(KeyEvent event){      
        if (KeyCode.ESCAPE == event.getCode()) {
            if(table.getSelectionModel().getSelectedItem() != null)
                table.getSelectionModel().clearSelection();
            else
                stage.close();
        }       
   }
    
    @FXML
    public void close(){
        this.stage.close();
    }   

    private void resetInterface(){
        btn_modifier.setDisable(true);
        btn_supprimer.setDisable(true);
        btn_ajouter.setDisable(false);
        tf_num.clear();
        tf_var.clear();
        tf_desc.clear();
        tf_unite.clear();
        tf_prix.clear();
        index = 0;
        table.getSelectionModel().clearSelection();        
    }
    
}
