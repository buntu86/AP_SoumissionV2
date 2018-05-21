package ap.dev.soumission2.tools;

public class Toolbox {
   public static int getInt(String test){
        try{
            return Integer.parseInt(test.trim());
        }catch(Exception e){
            return 0;
        }
    } 
   
   public static float getFloat(String test){
        try{
            return Float.parseFloat(test.trim());
        }catch(Exception e){
            return 0;
        }
    }
   
   public static String getString(int i){
       return String.valueOf(i);
   }
}