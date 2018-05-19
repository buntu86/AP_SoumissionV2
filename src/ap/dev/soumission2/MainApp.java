package ap.dev.soumission2;

import ap.dev.soumission2.data.Can_Xml;
import ap.dev.soumission2.model.M_CAN;
import ap.dev.soumission2.tools.Log;
import ap.dev.soumission2.view.RootLayoutController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    
    private final static Logger LOGGER = Logger.getLogger(MainApp.class.getName());
    
    private static M_CAN can = new M_CAN();
    
    @Override
    public void start(Stage primaryStage) {  
    
        /*Logger.getLogger("").setLevel(Level.INFO);
        Logger.getLogger("").getHandlers()[0].setLevel(Level.INFO);*/
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/ap/dev/soumission2/view/RootLayout.fxml"));
            BorderPane rootLayout = loader.load();
            RootLayoutController controller = loader.getController();
            Scene scene = new Scene(rootLayout);
            
            primaryStage.setTitle("AP - Soumission");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            LOGGER.severe("Error RootLayout.fxml | " + e.getMessage());
        }                

        Can_Xml.load();
        
       /*LOGGER.severe("severe");
       LOGGER.info("info");
       LOGGER.warning("warning");
       LOGGER.fine("fine");
       LOGGER.setLevel(Level.ALL);
       LOGGER.warning(LOGGER.getLevel().getName());
       LOGGER.fine("fine2");*/

       
        //Log.msg(0, can.toString());
        //Can_Xml.save();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static M_CAN getCan(){
        return can;
    }
    
    public static void setCan(M_CAN canNew){
        can = canNew;
    }
}
