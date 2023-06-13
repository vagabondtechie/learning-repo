package me.maharana.designpatterns;

public class Singleton {

    private String name;
    private String email;
    private int weight;
    private int heightInCms;

    private static Singleton instance;

    private Singleton(String name, String email, int weight, int heightInCms) {
        this.name = name;
        this.email = email;
        this.weight = weight;
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

    // @Override
    // public String toString() {
    //     return "Singleton [name=" + name + ", email=" + email + ", weight=" + weight + ", heightInCms=" + heightInCms
    //             + "]";
    // }
}
