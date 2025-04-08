package com.duban.itemsproyect;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class promocionada extends AppCompatActivity {


        TextView tvTitulo, tvPromocionada;
        Button btnVerDetalles;
        Switch switchPromocion;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tvTitulo = findViewById(R.id.tvTitulo);
            tvPromocionada = findViewById(R.id.tvPromocionada);
            btnVerDetalles = findViewById(R.id.btnVerDetalles);
            switchPromocion = findViewById(R.id.switchPromocion);

            // Cargar datos que ya ingresaste antes (puedes cambiar esto dinámicamente)
            String titulo = "Actividad de Inglés";
            boolean estaPromocionada = true;

            tvTitulo.setText(titulo);
            tvPromocionada.setText(estaPromocionada ? "Promocionada" : "");
            switchPromocion.setChecked(estaPromocionada);

            // Acción al presionar "Ver Detalles"
            btnVerDetalles.setOnClickListener(v -> {
                Toast.makeText(this, "Mostrando detalles de: " + titulo, Toast.LENGTH_SHORT).show();
                // Aquí podrías abrir una nueva Activity o mostrar un diálogo
            });

            // Activar o desactivar etiqueta "Promocionada"
            switchPromocion.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    tvPromocionada.setText("Promocionada");
                    Toast.makeText(this, "Promoción activada", Toast.LENGTH_SHORT).show();
                } else {
                    tvPromocionada.setText("");
                    Toast.makeText(this, "Promoción desactivada", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }