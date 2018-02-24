
package escuelaing.edu.co.bighearth.security;

/**
 *
 * @author martinjhm271
 */
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.SimpleByteSource;

public abstract class SHA1 {

    public static String generateHash(String password) {
        DefaultHashService hashService = new DefaultHashService();
        hashService.setHashIterations(500000); // 500000
        hashService.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);

        // Same salt as in shiro.ini, but NOT base64-encoded!!
        hashService.setPrivateSalt(new SimpleByteSource("myprivatesalt"));
        hashService.setGeneratePublicSalt(true);

        DefaultPasswordService passwordService = new DefaultPasswordService();
        passwordService.setHashService(hashService);
        String encryptedPassword = passwordService.encryptPassword(password);
        return encryptedPassword;

    }

}
