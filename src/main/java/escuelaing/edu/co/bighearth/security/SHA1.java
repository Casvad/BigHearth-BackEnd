
package escuelaing.edu.co.bighearth.security;

/**
 *
 * @author martinjhm271
 */
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.SimpleByteSource;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.*;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public abstract class SHA1 {


    public static String generateHash(String password) throws Exception {
        byte[] salt = new byte[16];
        // Genera la sal de forma aleatoria
        Random random=new Random();
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        try {
            // Obtiene una instancia para el algoritmo
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBEWithHmacSHA256AndAES_128");
            // Genera el hash
            byte[] hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();
            // convierte hash y sal a cadena de texto
            return new HashSalt(enc.encodeToString(hash), enc.encodeToString(salt)).getHash();
        }
        catch(NoSuchAlgorithmException e) {
        }
        catch (InvalidKeySpecException e) {
        }

        Exception e= new Exception("No se pudo crear hash");
        return null;
    }

    public static boolean ValidatePass(String password, String stringHash, String stringSalt) {
        Base64.Decoder dec = Base64.getDecoder();
        // Convierte la sal a arreglo de bytes
        byte[] salt = dec.decode(stringSalt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        try {
            // Obtiene instancia del algoritmo
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBEWithHmacSHA256AndAES_128");
            // Genera el hash como arreglo de bytes
            byte[] hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();
            // convierte el hash a cadena de texto
            String currentHash = enc.encodeToString(hash);
            // compara si los hash son iguales
            return currentHash.equals(stringHash);
        }
        catch(NoSuchAlgorithmException e) {
        }
        catch (InvalidKeySpecException e) {
        }

        return false;
    }

}

class HashSalt {
    private String hash;
    private String salt;

    public HashSalt(String hash, String salt) {
        this.hash = hash;
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }



}
