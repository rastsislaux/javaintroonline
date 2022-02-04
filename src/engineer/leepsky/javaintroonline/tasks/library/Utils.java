package engineer.leepsky.javaintroonline.tasks.library;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Utils {

    public static String sha256(String string) {
        try {
            return Base64.getEncoder().encodeToString(
                    MessageDigest.getInstance("SHA-256").digest(string.getBytes(StandardCharsets.UTF_8))
            );
        } catch (NoSuchAlgorithmException e) { return ""; }
    }

}
