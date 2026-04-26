package com.example.jnidemo;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public native boolean isDebugDetected();
    public native String helloFromJNI();
    public native int factorial(int n);

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvStatus = findViewById(R.id.tvStatus);
        TextView tvHello = findViewById(R.id.tvHello);
        TextView tvFact = findViewById(R.id.tvFact);

        boolean suspicious = isDebugDetected();

        if (suspicious) {
            tvStatus.setText("⚠️ Environnement suspect détecté !");
            tvStatus.setTextColor(Color.RED);
            tvHello.setText("Fonction désactivée");
            tvFact.setText("Calcul bloqué");
        } else {
            tvStatus.setText("✅ Sécurité : OK");
            tvStatus.setTextColor(Color.parseColor("#2E7D32"));
            tvHello.setText(helloFromJNI());
            tvFact.setText("Factoriel de 10 = " + factorial(10));
        }
    }
}