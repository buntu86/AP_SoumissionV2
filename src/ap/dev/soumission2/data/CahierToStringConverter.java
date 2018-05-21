package ap.dev.soumission2.data;

import ap.dev.soumission2.model.M_Cahier;
import java.util.HashMap;
import java.util.Map;
import javafx.util.StringConverter;

public class CahierToStringConverter extends StringConverter<M_Cahier> {

   private Map<String, M_Cahier> cahierMap = new HashMap<>();

   @Override
   public String toString(M_Cahier cahier) {
       
       return cahier.getNum() + " - " + cahier.getTitre() + "/v" + cahier.getAnnee();
   }

   @Override
   public M_Cahier fromString(String name) {
       return cahierMap.get(name);
   }
}