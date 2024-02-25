import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            // Configuration du serveur
            int port = 1250;

            // Création du socket UDP
            DatagramSocket serverSocket = new DatagramSocket(port);

            System.out.println("Serveur en attente de datagrammes...");

            while (true) {
                // Réception des données
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Adresse IP et port de l'émetteur
                String clientAddress = receivePacket.getAddress().getHostAddress();
                int clientPort = receivePacket.getPort();

                // Obtenir la date et l'heure courante
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentDateTime = dateFormat.format(new Date());
                byte[] sendData = currentDateTime.getBytes();

                // Envoi du datagramme contenant la date et l'heure à l'émetteur
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sendPacket);

                System.out.println("Réponse envoyée à " + clientAddress + ":" + clientPort);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
