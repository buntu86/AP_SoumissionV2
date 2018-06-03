package ap.dev.soumission2.data;

import ap.dev.soumission2.tools.Log;
import java.util.Properties;

public class Soumission_Xml {

    private static String pathSoumission = "";
    
    public static void load(){
        Log.msg(0, "soumission load");
    }
    
    public static void save(){
        Log.msg(0, "soumission save");
    }    
}

/*

public class Can_Xml {
    private static String pathCAN = "";
    private static Properties prop = new Properties();    
    
    public static void load() {
        Log.msg(0, "load");
        
        ObservableList<M_Cahier> list = FXCollections.observableArrayList();        

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
    

}

*/