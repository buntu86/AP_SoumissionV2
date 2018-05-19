package ap.dev.soumission2.model;

import ap.dev.soumission2.data.Can_Xml;
import ap.dev.soumission2.tools.Log;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CAN")
public class M_CAN {

    private ObservableList<M_Cahier> listCahiers = FXCollections.observableArrayList();
    
    public M_CAN() {
        Log.msg(0, "ini CAN");
    }

    /*public M_Cahier getCahierByNumYear(int num, int year) {
        M_Cahier cahier = null;
        
        cahier = listCahiers
                .stream()
                .filter(x -> x.getNum() == num)
                .filter(x -> x.getAnnee() == year)
                .findFirst()
                .get();
        
        return cahier;
    }*/

    @XmlElement(name = "Cahiers")
    public ObservableList<M_Cahier> getListCahiers(){
        return this.listCahiers;
    }

    public void update() {
        Log.msg(0, "load CAN");
        Can_Xml.load();
    }
    
    public void save(){
        Log.msg(0, "save CAN");
        Can_Xml.save();
    }

    @Override
    public String toString() {
        return "M_CAN{" + " listCahiers=" + listCahiers + '}';
    }
    
    public void sorted(){
        Collections.sort(this.getListCahiers(), (M_Cahier cahier1, M_Cahier cahier2) -> String.valueOf(cahier1.getNum()).compareTo(String.valueOf(cahier2.getNum())));            
    }
}
