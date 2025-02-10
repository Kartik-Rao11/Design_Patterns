package Structural_Design_Patterns;

/*
 * The Proxy Pattern acts as a substitute or intermediary to control access to
 * an object.
 * 
 * Types of Proxy:
 * Virtual Proxy: Delays expensive object creation until needed.
 * Protection Proxy: Controls access based on permissions.
 * Remote Proxy: Represents objects in different memory spaces or networks.
 * Working
 * A Proxy Class implements the same interface as the real object.
 * The Client interacts with the Proxy, which controls access to the real
 * object.
 */
// Subject Interface
interface Internet {
    void connectTo(String website);
}

// Real Subject
class RealInternet implements Internet {
    public void connectTo(String website) {
        System.out.println("Connecting to " + website);
    }
}

// Proxy Class (Controls access)
class InternetProxy implements Internet { // kind a works like middleware
    private Internet realInternet = new RealInternet();
    private static final java.util.List<String> blockedSites = java.util.Arrays.asList("banned.com", "blocked.com");

    @Override
    public void connectTo(String website) {
        if (blockedSites.contains(website.toLowerCase())) {
            System.out.println("Access Denied to " + website);
        } else {
            realInternet.connectTo(website);
        }
    }
}

// Client Code
class Main {
    public static void main(String[] args) {
        Internet proxy = new InternetProxy();

        proxy.connectTo("example.com");
        // Output: Connecting to example.com

        proxy.connectTo("banned.com");
        // Output: Access Denied to banned.com
    }
}
