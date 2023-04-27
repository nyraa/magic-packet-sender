import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class Magic
{
    // send magic packet to the specified address in static method
    public static void sendMagicPacket(byte[] macAddress) throws IOException
    {
        // create a socket
        DatagramSocket socket = new DatagramSocket();
        // set the address to broadcast
        InetAddress address = InetAddress.getByName("255.255.255.255");
        // create a byte array to store the magic packet
        byte[] bytes = new byte[102];
        // set the first 6 bytes to 0xFF
        for (int i = 0; i < 6; i++) {
            bytes[i] = (byte) 0xff;
        }
        // set the next 16 times 6 bytes to the mac address
        for (int i = 6; i < 102; i += 6) {
            // convert the bytes to hex and store them in the byte array
            for (int j = 0; j < 6; j++) {
                bytes[i + j] = macAddress[j];
            }
        }
        // create a datagram packet with the byte array and the address
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 9);
        // send the packet
        socket.send(packet);
        // close the socket
        socket.close();
    }
}