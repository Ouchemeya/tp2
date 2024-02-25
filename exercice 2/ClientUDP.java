import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            // Configuration du client
            String serveurIP = "127.0.0.1";  // Adresse IP du serveur
            int serveurPort = 12345;

            // Création de l'objet Voiture
            Voiture voitureClient = new Voiture("Toyota", "Corolla");
            voitureClient.setCarburant(50);

            // Sérialisation de l'objet Voiture
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(voitureClient);

            // Envoi des données au serveur
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serveurAdresse = InetAddress.getByName(serveurIP);
            byte[] sendData = byteArrayOutputStream.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serveurAdresse, serveurPort);
            clientSocket.send(sendPacket);

            System.out.println("Données envoyées au serveur.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
