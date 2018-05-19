package ap.dev.soumission2;

import ap.dev.soumission2.data.Can_Xml;
import ap.dev.soumission2.model.M_CAN;
import ap.dev.soumission2.tools.Log;
import ap.dev.soumission2.view.RootLayoutController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    
    private static M_CAN can = new M_CAN();
    
    @Override
    public void start(Stage primaryStage) {  

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
            Log.msg(1, "Error RootLayout.fxml | " + e.getMessage());
        }                

        Can_Xml.load();
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
