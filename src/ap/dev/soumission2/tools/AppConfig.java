package ap.dev.soumission2.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javafx.scene.control.Alert;

public class AppConfig {
    private static Properties prop = new Properties();
    private static String resourceStr = "resources/config.properties";
    private static String pathCAN;
    
    public static File getCanXmlFile() {        
        try {
            //Get pathCAN
            prop.load(new FileInputStream(resourceStr));
            pathCAN = prop.getProperty("pathCAN");
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur - fichier paramètres");
            alert.setHeaderText(null);
            alert.setContentText("Le fichier de configuration " + resourceStr + " n'a pas pu être chargé.");
            alert.showAndWait();
            System.exit(1);
        }
        Log.msg(0, pathCAN);
        
        //If empty create
        if(pathCAN.trim().isEmpty())
            pathCAN = "ap-soumission_CAN.xml";
        
        File f = new File(pathCAN);
        
        //If not exist create
        if(!f.exists())
        {
            File file = new File(pathCAN);
            try {
                file.createNewFile();
                f = file;
                Log.msg(0, "Création du fichier " + pathCAN);
                
                //Save pathCAN
                prop.setProperty("pathCAN", pathCAN);
                try {
                    prop.store(new FileOutputStream(resourceStr), pathCAN);
                }catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur - fichier de config");
                    alert.setHeaderText(null);
                    alert.setContentText("Le fichier de configuration " + resourceStr + " n'a pas pu être chargé.");
                    alert.showAndWait();
                }                
            } catch (IOException ex) {
                Log.msg(1, "Impossible de créer le fichier " + pathCAN);
            }
        }
        
        return f;
    }
}
