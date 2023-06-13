package me.maharana.singleton;

public class Singleton {

    private String name;
    private String email;
    private int weightInKgs;
    private int heightInCms;

    private static Singleton instance;

    private Singleton(String name, String email, int weightInKgs, int heightInCms) {
        this.name = name;
        this.email = email;
        this.weightInKgs = weightInKgs;
        this.heightInCms = heightInCms;
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Singleton [name=" + name + ", email=" + email + ", weightInKgs=" + weightInKgs + ", heightInCms=" + heightInCms
                + "]";
    }
}
