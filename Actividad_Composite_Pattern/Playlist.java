import java.util.ArrayList;

public class Playlist implements IComponent {
    public String playlistName;
    public ArrayList<IComponent> playlist;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.playlist = new ArrayList<>();
    }

    public void play() {
        System.out.println("Abriendo playlist: " + this.playlistName);
        for (IComponent component : playlist) {
            component.play();
        }
        System.out.println("Fin de la playlist: " + this.playlistName);
    }

    public void setPlaybackSpeed(float speed) {
        System.out.println("Acelerando todo en " + this.playlistName + " a " + speed + "x");
        for (IComponent component : playlist) {
            component.setPlaybackSpeed(speed);
        }
    }

    public String getName() {
        return this.playlistName;
    }

    public void add(IComponent component) {
        this.playlist.add(component);
        System.out.println("Agregado " + component.getName() + " a " + this.playlistName);
    }

    public void remove(IComponent component) {
        this.playlist.remove(component);
        System.out.println("Quitado " + component.getName() + " de " + this.playlistName);
    }
}
