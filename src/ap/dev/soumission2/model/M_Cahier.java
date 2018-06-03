package ap.dev.soumission2.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class M_Cahier {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty num = new SimpleIntegerProperty();
    private final IntegerProperty annee = new SimpleIntegerProperty();    
    private final StringProperty titre = new SimpleStringProperty();    
    private ObservableList<M_Position> listPositions = FXCollections.observableArrayList();
    
    public M_Cahier(){
    }
    
    public M_Cahier(int id, int num, int annee, String titre){
        this.id.set(id);
        this.num.set(num);
        this.annee.set(annee);
        this.titre.set(titre);
    }
    
    @Override
    public String toString() {
        return getNum() + " - " + getTitre() + " (v" + getAnnee() + ")";
    }
    
    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public int getNum() {
        return num.get();
    }

    public void setNum(int value) {
        num.set(value);
    }

    public IntegerProperty numProperty() {
        return num;
    }

    public int getAnnee() {
        return annee.get();
    }

    public void setAnnee(int value) {
        annee.set(value);
    }

    public IntegerProperty anneeProperty() {
        return annee;
    }

    public String getTitre() {
        return titre.get();
    }

    public void setTitre(String value) {
        titre.set(value);
    }

    public StringProperty titreProperty() {
        return titre;
    }
    
    public ObservableList<M_Position> getListPositions(){
        return this.listPositions;
    }
    
    public void setListPositions(ObservableList<M_Position> list){
        this.listPositions = list; 
    }
}
