import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        // Pre-cargamos nuestras canciones y listas (la estructura base)
        Song song1 = new Song("Bohemian Rhapsody", "Queen");
        Song song2 = new Song("Stairway to Heaven", "Led Zeppelin");
        Playlist rockPlaylist = new Playlist("Rock Clasicos");
        rockPlaylist.add(song1);
        rockPlaylist.add(song2);
        
        Song song3 = new Song("Hotel California", "Eagles");
        Playlist masterPlaylist = new Playlist("Mi Musica");
        masterPlaylist.add(rockPlaylist);
        masterPlaylist.add(song3);

        System.out.println("--- BIENVENIDO AL SISTEMA MUSICAL (COMPOSITE PATTERN) ---");

        while (opcion != 3) {
            System.out.println("\nSelecciona una opcion para probar:");
            System.out.println("1. Probar objetos individuales (Leaf)");
            System.out.println("2. Probar estructura completa anidada (Composite)");
            System.out.println("3. Salir");
            System.out.print("Tu eleccion: ");
            
            // Leemos lo que escriba el usuario
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                
                if (opcion == 1) {
                    System.out.println("\n--- PRUEBA LEAF (Canciones Indivudales) ---");
                    song1.play();
                    System.out.println(">> Cambiando velocidad a Stairway to Heaven a 1.5x");
                    song2.setPlaybackSpeed(1.5f);
                    song2.play();
                } else if (opcion == 2) {
                    System.out.println("\n--- PRUEBA COMPOSITE (Toda la Playlist Maestra) ---");
                    masterPlaylist.play();
                    System.out.println("\n>> Cambiando velocidad de tooooda la Playlist a 1.25x");
                    masterPlaylist.setPlaybackSpeed(1.25f);
                    masterPlaylist.play();
                } else if (opcion == 3) {
                    System.out.println("Cerrando programa...");
                } else {
                    System.out.println("Opcion no valida. Intenta 1, 2 o 3.");
                }
            } else {
                System.out.println("Por favor ingresa un numero valido.");
                scanner.next(); // Limpiamos la basura del scanner
            }
        }
        
        scanner.close();
    }
}
