package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class VPNManager {

    private static final String VPN_NAME = "LivemedyVPN";

    public static void startVPN() throws InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(
                "osascript",
                "-e",
                "tell application \"System Events\" to tell current location of network preferences to connect service \"" + VPN_NAME + "\""
        );
        pb.redirectErrorStream(true);

        try {
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();  // Ensure the process has completed
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        Thread.sleep(10000);
    }


    public static void stopVPN() {
        try {
            ProcessBuilder pb = new ProcessBuilder("scutil", "--nc", "stop", VPN_NAME);
            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
