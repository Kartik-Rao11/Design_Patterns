package Structural_Design_Patterns;

/**
 * The Facade Pattern provides a simplified interface to a complex system,
 * making it easier to use.
 * 
 * Working
 * A Facade Class provides a single interface for multiple subsystems.
 * The Client interacts with the Facade, rather than dealing with complex
 * subsystems directly.
 * 
 * Use Case:
 * Spring Framework's JdbcTemplate acts as a facade for JDBC operations.
 * Media Players that provide a play button instead of exposing internal
 * decoding logic
 */

class AudioSystem {
    public void volumeUp() {
        System.out.println("Turning on audio");
    }

    public void volumeDown() {
        System.out.println("Turning off audio");
    }
}

class VideoSystem {
    public void playVideo() {
        System.out.println("Playing video...");
    }

    public void stopVideo() {
        System.out.println("Turning off video...");
    }
}

class Light {
    public void turnOn() {
        System.out.println("Turning of lights");
    }

    public void turnOff() {
        System.out.println("Turning off lights");
    }
}

class HomeTheatreFacade {
    private AudioSystem audio;
    private VideoSystem video;
    private Light light;

    public HomeTheatreFacade() {
        this.audio = new AudioSystem();
        this.light = new Light();
        this.video = new VideoSystem();
    }

    public void watchMovie() {
        audio.volumeUp();
        video.playVideo();
        light.turnOff();
    }

    public void stopMovie() {
        audio.volumeDown();
        video.stopVideo();
        light.turnOn();
    }
}

class Main {
    public static void main(String[] args) {
        HomeTheatreFacade homeTv = new HomeTheatreFacade();
        homeTv.watchMovie();
        homeTv.stopMovie();
    }
}