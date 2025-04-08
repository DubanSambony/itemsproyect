package com.duban.itemsproyect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    Switch switchPromocion;
    TextView tvAgregarAsistentes;
    ImageView iconoAgregarAsistentes;
    MaterialButton btnVerDetalles;
    ImageButton btnCompartir, btnEditar, btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itenscoop); // Asegúrate que existe este XML

        inicializarVistas();
        configurarListeners();
    }

    void inicializarVistas() {
        switchPromocion = findViewById(R.id.switchPromocion);
        tvAgregarAsistentes = findViewById(R.id.tvAgregarAsistentes);
        iconoAgregarAsistentes = findViewById(R.id.iconoAgregarAsistentes);
        btnVerDetalles = findViewById(R.id.btnVerDetalles);
        btnCompartir = findViewById(R.id.btnCompartir);
        btnEditar = findViewById(R.id.btnEditar);
        btnEliminar = findViewById(R.id.btnEliminar);
    }

    void configurarListeners() {
        configurarSwitchPromocion();
        configurarAgregarAsistentes();
        configurarBotonVerDetalles();
        configurarBotonesAccion();
    }

    void configurarSwitchPromocion() {
        switchPromocion.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                switchPromocion.setChecked(false); // Para que no quede activado al volver
                Intent intent = new Intent(MainActivity.this, promocionada.class);
                startActivity(intent);
            } else {
                mostrarToast("Promoción desactivada");
            }
        });
    }

    void configurarAgregarAsistentes() {
        View.OnClickListener listener = v -> mostrarToast("Agregar asistentes");
        tvAgregarAsistentes.setOnClickListener(listener);
        iconoAgregarAsistentes.setOnClickListener(listener);
    }

    void configurarBotonVerDetalles() {
        btnVerDetalles.setOnClickListener(v -> mostrarToast("Ver detalles"));
    }

    void configurarBotonesAccion() {
        btnCompartir.setOnClickListener(v -> mostrarToast("Compartiendo actividad..."));
        btnEditar.setOnClickListener(v -> mostrarToast("Editar actividad"));
        btnEliminar.setOnClickListener(v -> mostrarToast("Actividad eliminada"));
    }

    void mostrarToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
