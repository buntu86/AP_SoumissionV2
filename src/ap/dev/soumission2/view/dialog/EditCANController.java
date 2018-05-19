package ap.dev.soumission2.view.dialog;

import ap.dev.soumission2.MainApp;
import ap.dev.soumission2.model.M_Cahier;
import ap.dev.soumission2.tools.Log;
import ap.dev.soumission2.tools.Toolbox;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class EditCANController implements Initializable{

    private Stage stage;
    
    @FXML
    private TableView<M_Cahier> table;
    
    @FXML
    private TableColumn<M_Cahier, Integer> num;
    
    @FXML
    private TableColumn<M_Cahier, Integer> annee;

    @FXML
    private TableColumn<M_Cahier, String> titre;    

    @FXML
    private TextField tf_num;

    @FXML
    private TextField tf_annee;
    
    @FXML
    private TextField tf_titre;
    
    @FXML
    private Button btn_ajouter;

    @FXML
    private Button btn_modifier;
    
    @FXML
    private Button btn_supprimer;
    
    private int index = 0;    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        table.setItems(MainApp.getCan().getListCahiers());
        num.setCellValueFactory(cellData -> cellData.getValue().numProperty().asObject());
        annee.setCellValueFactory(cellData -> cellData.getValue().anneeProperty().asObject());
        titre.setCellValueFactory(cellData -> cellData.getValue().titreProperty());

        btn_modifier.setDisable(true);
        btn_supprimer.setDisable(true);

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null)
            {
                Log.msg(0, table.getSelectionModel().getSelectedItem().getNum() + "");
                btn_modifier.setDisable(false);
                btn_supprimer.setDisable(false);
                btn_ajouter.setDisable(true);
                tf_num.setText(String.valueOf(obs.getValue().getNum()));
                tf_annee.setText(String.valueOf(obs.getValue().getAnnee()));
                tf_titre.setText(obs.getValue().getTitre());
                index = table.getSelectionModel().selectedIndexProperty().get();
            }
            else
            {
                btn_modifier.setDisable(true);
                btn_supprimer.setDisable(true);
                btn_ajouter.setDisable(false);
                tf_num.clear();
                tf_annee.clear();
                tf_titre.clear();
                index = 0;
            }
        });        
    }

    public void setStage(Stage editListStage) {
        this.stage = editListStage;

        //ESC touch listener
        stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (KeyCode.ESCAPE == event.getCode()) {
                if(table.getSelectionModel().getSelectedItem() != null)
                    table.getSelectionModel().clearSelection();
                else
                    stage.close();
            }
        });
    }
    
    @FXML
    public void close(){
        this.stage.close();
    }    
    
    @FXML
    public void update(){
        Log.msg(0, "update");
        MainApp.getCan().getListCahiers().set(index, new M_Cahier(0, Toolbox.getInt(tf_num.getText()), Toolbox.getInt(tf_annee.getText()), tf_titre.getText()));
        MainApp.getCan().sorted();
        MainApp.getCan().save();
        btn_modifier.setDisable(true);
        btn_supprimer.setDisable(true);
        btn_ajouter.setDisable(false);
        tf_num.clear();
        tf_annee.clear();
        tf_titre.clear();
        index = 0;
        table.getSelectionModel().clearSelection();
    }
    
    @FXML
    public void delete(){
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression du cahier");
        alert.setContentText(null);
        alert.setHeaderText("Etes-vous sûr de vouloir supprimer ce cahier et \ntoutes les positions qu'il contient?");
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == ButtonType.OK)
        {
            Log.msg(0, "delete");
            MainApp.getCan().getListCahiers().remove(index);
            MainApp.getCan().save();
        }
        
        btn_modifier.setDisable(true);
        btn_supprimer.setDisable(true);
        btn_ajouter.setDisable(false);
        tf_num.clear();
        tf_annee.clear();
        tf_titre.clear();
        index = 0;   
        table.getSelectionModel().clearSelection();
    }
    
    @FXML
    public void add(){
        if(!tf_num.getText().trim().equals(""))
        {
            M_Cahier newCahier = new M_Cahier(0, Toolbox.getInt(tf_num.getText()), Toolbox.getInt(tf_annee.getText()), tf_titre.getText());
            MainApp.getCan().getListCahiers().add(newCahier);
            MainApp.getCan().sorted();
            MainApp.getCan().save();
            tf_num.clear();
            tf_annee.clear();
            tf_titre.clear();  
            table.getSelectionModel().clearSelection();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur - numéro cahier obligatoire");
            alert.setHeaderText(null);
            alert.setContentText("Le numéro du cahier est obligatoire.");
            alert.showAndWait();
        }
    }
}    
   