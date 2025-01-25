import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.HashMap;

public class VirusScanner {
    private static HashMap<String, String> virusSignatures = new HashMap<>();

    // Load known virus signatures
    static {
        virusSignatures.put("5d41402abc4b2a76b9719d911017c592", "ExampleVirus1"); // MD5 hash
        virusSignatures.put("d8578edf8458ce06fbc5bb76a58c5ca4", "ExampleVirus2"); // MD5 hash
    }

    // Calculate the hash of a file
    public static String calculateHash(File file) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream fis = new FileInputStream(file);

        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = fis.read(buffer)) != -1) {
            md.update(buffer, 0, bytesRead);
        }

        byte[] hashBytes = md.digest();

        // Convert bytes to hex string
        StringBuilder hashString = new StringBuilder();
        for (byte b : hashBytes) {
            hashString.append(String.format("%02x", b));
        }

        fis.close();
        return hashString.toString();
    }

    // Scan a file for viruses
    public static void scanFile(File file) throws Exception {
        String fileHash = calculateHash(file);
        if (virusSignatures.containsKey(fileHash)) {
            System.out.println("Virus detected: " + virusSignatures.get(fileHash));
        } else {
            System.out.println("File is clean: " + file.getName());
        }
    }

    public static void main(String[] args) {
        try {
            File fileToScan = new File("testfile.txt"); // Replace with file path
            scanFile(fileToScan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
