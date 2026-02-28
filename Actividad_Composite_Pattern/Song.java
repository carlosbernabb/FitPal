public class Song implements IComponent {
    public String songName;
    public String artist;
    public float speed;

    public Song(String songName, String artist) {
        this.songName = songName;
        this.artist = artist;
        this.speed = 1.0f;
    }

    public void play() {
        System.out.println("Reproduciendo: " + this.songName + " de " + this.artist + " a velocidad " + this.speed + "x");
    }

    public void setPlaybackSpeed(float speed) {
        this.speed = speed;
        System.out.println("Se cambio la velocidad de " + this.songName + " a " + this.speed + "x");
    }

    public String getName() {
        return this.songName;
    }

    public String getArtist() {
        return this.artist;
    }
}
