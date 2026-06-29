package com.example.cuceimart.actividades;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cuceimart.R;
import com.example.cuceimart.databinding.ActividadPrincipalBinding;
import com.google.android.material.snackbar.Snackbar;

/**
 * Actividad Principal del proyecto CUCEI MART.
 * Gestiona la navegación y la interfaz central basada en el README.
 */
public class ActividadPrincipal extends AppCompatActivity {

    private AppBarConfiguration configuracionBarraSuperior;
    private ActividadPrincipalBinding vinculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar la vista usando ViewBinding
        vinculo = ActividadPrincipalBinding.inflate(getLayoutInflater());
        setContentView(vinculo.getRoot());

        // Configurar la barra de herramientas (Toolbar)
        setSupportActionBar(vinculo.barraSuperiorPrincipal.toolbar);

        // Configurar clics en las categorías
        configurarClicsCategorias();

        // Configurar clic en emprendedor destacado
        vinculo.barraSuperiorPrincipal.contenidoPrincipal.tarjetaDestacado.setOnClickListener(v -> 
            mostrarMensaje("Abriendo perfil de emprendedor destacado"));

        // Configurar botón "Ver todos"
        vinculo.barraSuperiorPrincipal.contenidoPrincipal.botonVerTodos.setOnClickListener(v -> 
            mostrarMensaje("Mostrando todos los emprendedores recientes"));
    }

    /**
     * Configura los escuchadores de clics para cada categoría.
     */
    private void configurarClicsCategorias() {
        vinculo.barraSuperiorPrincipal.contenidoPrincipal.catComida.setOnClickListener(v -> 
            mostrarMensaje("Categoría: Comida y Bebida"));
            
        vinculo.barraSuperiorPrincipal.contenidoPrincipal.catRopa.setOnClickListener(v -> 
            mostrarMensaje("Categoría: Ropa y Accesorios"));
            
        vinculo.barraSuperiorPrincipal.contenidoPrincipal.catTech.setOnClickListener(v -> 
            mostrarMensaje("Categoría: Tecnología"));
            
        vinculo.barraSuperiorPrincipal.contenidoPrincipal.catServicios.setOnClickListener(v -> 
            mostrarMensaje("Categoría: Servicios"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú de opciones (incluye el ícono de configuración/paleta)
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        // Manejar selección de paleta o configuración
        if (id == R.id.nav_palette) {
            mostrarMensaje("Seleccionador de Paleta (GestorPaleta)");
            return true;
        } else if (id == R.id.nav_profile) {
            mostrarMensaje("Perfil de Usuario");
            return true;
        } else if (id == R.id.nav_settings) {
            mostrarMensaje("Configuración");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Muestra un mensaje rápido al usuario.
     * @param mensaje Texto a mostrar.
     */
    private void mostrarMensaje(String mensaje) {
        Snackbar.make(vinculo.getRoot(), mensaje, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        try {
            NavController controladorNavegacion = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            return NavigationUI.navigateUp(controladorNavegacion, configuracionBarraSuperior)
                    || super.onSupportNavigateUp();
        } catch (Exception e) {
            return super.onSupportNavigateUp();
        }
    }
}
