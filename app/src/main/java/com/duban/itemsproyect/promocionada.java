package com.duban.itemsproyect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class promocionada extends AppCompatActivity {

    TextView tvTitulo, tvPromocionada;
    Button btnVerDetalles, btnCrearActividad;
    Switch switchPromocion;
    LinearLayout detallesLayout;
    boolean detallesVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promocionada);

        // Inicializar vistas
        tvTitulo = findViewById(R.id.tvTitulo);
        tvPromocionada = findViewById(R.id.tvPromocionada);
        btnVerDetalles = findViewById(R.id.btnVerDetalles);
        btnCrearActividad = findViewById(R.id.btnCrearActividad);
        switchPromocion = findViewById(R.id.switchPromocion);
        detallesLayout = new LinearLayout(this);

        // Configurar el layout de detalles que se mostrará/ocultará

        // Ejemplo de datos
        String titulo = "Actividad de Inglés";
        tvTitulo.setText(titulo);
        tvPromocionada.setText("Promocionada");
        switchPromocion.setChecked(true);

        // Botón Ver Detalles - mostrar/ocultar detalles
        btnVerDetalles.setOnClickListener(v -> {
            if (detallesVisible) {
                detallesLayout.setVisibility(View.GONE);
                btnVerDetalles.setText("Ver Detalles");
            } else {
                detallesLayout.setVisibility(View.VISIBLE);
                btnVerDetalles.setText("Ocultar Detalles");
            }
            detallesVisible = !detallesVisible;
        });

        // Botón Crear Actividad - ir a nueva pantalla
        btnCrearActividad.setOnClickListener(v -> {
            Intent intent = new Intent(promocionada.this, CrearAct.class);
            startActivity(intent);
        });

        // Switch para desactivar promoción
        switchPromocion.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (!isChecked) {
                Toast.makeText(this, "La actividad ha sido eliminada de promoción", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(promocionada.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
    }}