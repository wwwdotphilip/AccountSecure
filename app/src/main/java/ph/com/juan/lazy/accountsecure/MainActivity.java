package ph.com.juan.lazy.accountsecure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.scottyab.aescrypt.AESCrypt;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Is release? "+BuildConfig.release+"");

        String password = "password";
        String message = "hello world";
        try {
            String encryptedMsg = AESCrypt.encrypt(password, message);
            String decryptedMsg = AESCrypt.decrypt(password, encryptedMsg);
            Log.v(TAG, "Encrypted message: "+encryptedMsg);
            Log.v(TAG, "Decrypted message: "+decryptedMsg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
