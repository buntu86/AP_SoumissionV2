package ap.dev.soumission2.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class M_SeriePrixQuantite {

    private final StringProperty nomEntreprise = new SimpleStringProperty();
    private final StringProperty titre = new SimpleStringProperty();   
    private final IntegerProperty date = new SimpleIntegerProperty();
    //private ObservableList<M_Cahier> listCahiers = FXCollections.observableArrayList();    
    
    public String getNomEntreprise() {
        return nomEntreprise.get();
    }

    public void setNomEntreprise(String value) {
        nomEntreprise.set(value);
    }

    public StringProperty nomEntrepriseProperty() {
        return nomEntreprise;
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

    public int getDate() {
        return date.get();
    }

    public void setDate(int value) {
        date.set(value);
    }

    public IntegerProperty dateProperty() {
        return date;
    }
}
