package ap.dev.soumission2.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class M_Position {

    private final FloatProperty numPosition = new SimpleFloatProperty(); 
    private final BooleanProperty positionR = new SimpleBooleanProperty();    
    private final IntegerProperty variante = new SimpleIntegerProperty();    
    private final FloatProperty prixUnitaire = new SimpleFloatProperty();
    private final StringProperty description = new SimpleStringProperty();    
    private final StringProperty unite = new SimpleStringProperty();
    
    public M_Position(float numPosition, boolean positionR, int variante, float prixUnitaire, String description, String unite){
        this.numPosition.set(numPosition);
        this.positionR.set(positionR);
        this.variante.set(variante);
        this.prixUnitaire.set(prixUnitaire);
        this.description.set(description);
        this.unite.set(unite);
    }

    public M_Position() {
    }

    public float getNumPosition() {
        return numPosition.get();
    }

    public void setNumPosition(float value) {
        numPosition.set(value);
    }

    public FloatProperty numPositionProperty() {
        return numPosition;
    }

    public boolean isPositionR() {
        return positionR.get();
    }

    public void setPositionR(boolean value) {
        positionR.set(value);
    }

    public BooleanProperty positionRProperty() {
        return positionR;
    }


    public int getVariante() {
        return variante.get();
    }

    public void setVariante(int value) {
        variante.set(value);
    }

    public IntegerProperty varianteProperty() {
        return variante;
    }


    public String getDescription() {
        return description.get();
    }

    public void setDescription(String value) {
        description.set(value);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public String getUnite() {
        return unite.get();
    }

    public void setUnite(String value) {
        unite.set(value);
    }

    public StringProperty uniteProperty() {
        return unite;
    }

    public float getPrixUnitaire() {
        return prixUnitaire.get();
    }

    public void setPrixUnitaire(float value) {
        prixUnitaire.set(value);
    }

    public FloatProperty prixUnitaireProperty() {
        return prixUnitaire;
    }   

    @Override
    public String toString() {
        return "POS{" + "num=" + getNumPosition() + ", description=" + getDescription() + '}';
    }

}
