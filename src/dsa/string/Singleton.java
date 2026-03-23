package dsa.string;

public class Singleton {

    Singleton instance;

    private Singleton(){}

    public   Singleton  getInstance() {
        synchronized(this) {
            if (instance == null)
                return new Singleton();
            return instance;
        }
    }

    public static void main(String[] args) {
            Singleton s1 = new Singleton();

            System.out.println(s1);

    }
}
