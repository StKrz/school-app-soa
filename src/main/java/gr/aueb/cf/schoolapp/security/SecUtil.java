package gr.aueb.cf.schoolapp.security;

import org.mindrot.jbcrypt.BCrypt;

public class SecUtil {
    private SecUtil() {

    }

    public static boolean checkPassword(String inputPassword, String storePassword) {
        return BCrypt.checkpw(inputPassword, storePassword);
    }

    public static String hashPassword(String inputPassword) {
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        return BCrypt.hashpw(inputPassword, salt);
    }
}
