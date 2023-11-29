import java.util.Locale;
import java.util.ResourceBundle;

public class TraducteurFrancaisToAnglais {

    public void traduireAnglaisEnFrancais() {
        Locale locale = new Locale.Builder().setLanguage("en").build();
        ResourceBundle message = ResourceBundle.getBundle("src/main/resources/message.properties", locale);
        String greeting = message.getString("erreurChampManquant");

    }

    public static void main(String[] args) {
        Locale locale = new Locale.Builder().setLanguage("en").build();
        ResourceBundle message = ResourceBundle.getBundle("message", locale);
        String greeting = message.getString("erreurChampManquant");
        System.out.println(greeting);
    }


}
