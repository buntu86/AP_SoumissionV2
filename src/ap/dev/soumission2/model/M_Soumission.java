package ap.dev.soumission2.model;

import ap.dev.soumission2.data.Soumission_Xml;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.annotation.XmlElement;

public class M_Soumission {    
    private final StringProperty nomMandat = new SimpleStringProperty();    
    private final StringProperty numMandat = new SimpleStringProperty();
    private ObservableList<M_SeriePrixQuantite> listeSeriePrixQuantite = FXCollections.observableArrayList();
    
    public M_Soumission(){
        
    }

    @XmlElement(name = "Soumissions")
    public ObservableList<M_SeriePrixQuantite> getListSeriePrixQuantite(){
        return this.listeSeriePrixQuantite;
    }
    
    public void update(){
        Soumission_Xml.load();
    }

    public void save(){
        Soumission_Xml.save();
    }

    @Override
    public String toString() {
        return "M_SOUMISSION{" + " listSeriePrixQuantie=" + listeSeriePrixQuantite + '}';
    }  
    
    public String getNumMandat(){
        return numMandat.get();
    }
    
    public void setNumMandat(String value){
        numMandat.set(value);
    }

    public StringProperty numMandatProperty() {
        return numMandat;
    }    

    public String getNomMandat() {
        return nomMandat.get();
    }

    public void setNomMandat(String value) {
        nomMandat.set(value);
    }

    public StringProperty nomMandatProperty() {
        return nomMandat;
    }
}

