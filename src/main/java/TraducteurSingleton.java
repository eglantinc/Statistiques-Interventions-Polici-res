public class TraducteurSingleton {
    private static Traducteur instance;

    public static Traducteur getInstance() {
        if (instance == null) {
            instance = new Traducteur();
        }
        return instance;
    }

}
