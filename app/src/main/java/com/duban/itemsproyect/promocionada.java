package com.duban.itemsproyect;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class promocionada extends AppCompatActivity {

    TextView tvTitulo, tvPromocionada;
    Button btnVerDetalles;
    Switch switchPromocion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promocionada); // IMPORTANTE: asegúrate que este XML exista

        tvTitulo = findViewById(R.id.tvTitulo);
        tvPromocionada = findViewById(R.id.tvPromocionada);
        btnVerDetalles = findViewById(R.id.btnVerDetalles);
        switchPromocion = findViewById(R.id.switchPromocion);

        String titulo = "Actividad de Inglés";
        tvTitulo.setText(titulo);
        tvPromocionada.setText("Promocionada");
        switchPromocion.setChecked(true); // Esta pantalla inicia como promocionada

        btnVerDetalles.setOnClickListener(v ->
                Toast.makeText(this, "Mostrando detalles de: " + titulo, Toast.LENGTH_SHORT).show()
        );

        switchPromocion.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (!isChecked) {
                Toast.makeText(this, "La actividad ha sido eliminada de promoción", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(promocionada.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish(); // Cerramos esta pantalla
            }
        });
    }
}
