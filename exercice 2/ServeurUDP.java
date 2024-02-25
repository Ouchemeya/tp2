import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            // Configuration du serveur
            int port = 12345;

            // Création du socket UDP
            DatagramSocket serverSocket = new DatagramSocket(port);

            System.out.println("Serveur en attente de messages...");

            while (true) {
                // Réception des données
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Désérialisation de l'objet Voiture
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(receivePacket.getData());
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                Voiture voitureRecue = (Voiture) objectInputStream.readObject();

                System.out.println("Voiture reçue: " + voitureRecue.getMarque() + " " +
                        voitureRecue.getModele() + " - Carburant: " + voitureRecue.getCarburant());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
