package ap.dev.soumission2.data;

import ap.dev.soumission2.MainApp;
import ap.dev.soumission2.model.M_CAN;
import ap.dev.soumission2.model.M_Cahier;
import ap.dev.soumission2.tools.AppConfig;
import ap.dev.soumission2.tools.Log;
import java.io.File;
import java.util.Collections;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Can_Xml {
    private static String pathCAN = "";
    private static Properties prop = new Properties();    
    
    public static void load() {
        Log.msg(0, "load");
        
        ObservableList<M_Cahier> list = FXCollections.observableArrayList();        
        /*
        list.add(new M_Cahier(0, 0, 0, "titre10"));
        list.add(new M_Cahier(0, 0, 0, "titre2"));
        list.add(new M_Cahier(0, 0, 0, "titre3"));
        list.add(new M_Cahier(0, 0, 0, "titre4"));*/
        
        //Log.msg(0, AppConfig.getCanXmlFile().getPath());*/

	 try {
            File file = AppConfig.getCanXmlFile();
            JAXBContext jaxbContext = JAXBContext.newInstance(M_CAN.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            M_CAN can = (M_CAN) jaxbUnmarshaller.unmarshal(file);
            can.sorted();
            MainApp.setCan(can);
            
            //System.out.println(customer);

	  } catch (JAXBException e) {
		e.printStackTrace();
	  }      
    }

    public static void save() {
        Log.msg(0, "save");
        try {
            File file = AppConfig.getCanXmlFile();
            JAXBContext jaxbContext = JAXBContext.newInstance(M_CAN.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(MainApp.getCan(), file);

        } catch (JAXBException e) {
          e.printStackTrace();
        }        
    }
    


/*

        try {
            prop.load(new FileInputStream(resourceStr));
            pathListCan = prop.getProperty("pathListCan");
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur - fichier paramètres");
            alert.setHeaderText(null);
            alert.setContentText("Le fichier de configuration " + resourceStr + " n'a pas pu être chargé.");
            alert.showAndWait();
            System.exit(1);
        }
        
        File f = new File(pathListCan);
        if(!f.exists())
        {
            File file = new File(pathListCan);
            try {
                file.createNewFile();
                CanList_Xml.iniListCanToXML();
                Log.msg(0, "Création du fichier " + pathListCan);
            } catch (IOException ex) {
                Log.msg(1, "Impossible de créer le fichier " + pathListCan);
            }
        }
        
        return pathListCan;
    }    
    */


}
