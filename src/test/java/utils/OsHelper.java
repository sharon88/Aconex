package utils;

public class OsHelper {

    public static OS getOperatingSystem() {
        OS osName = null;
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            osName = OS.MAC;
        } else if ((os.contains("win"))) {
            osName = OS.WINDOWS;
        }
        return osName;
    }


}
