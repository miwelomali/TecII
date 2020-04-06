package com.example.eva2_8_sqlite3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Mascota> listaDeMascotas;
    private RecyclerView recyclerView;
    private AdaptadorMascotas adaptadorMascotas;
    private MascotasController mascotasController;
    private FloatingActionButton fabAgregarMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Definir el controlador
        mascotasController = new MascotasController(MainActivity.this);

        // Instanciar vistas
        recyclerView = findViewById(R.id.recyclerViewMascotas);
        fabAgregarMascota = findViewById(R.id.fabAgregarMascota);


        // Por defecto es una lista vacía,
        // Agregarla al adaptador y al RecyclerVIew
        listaDeMascotas = new ArrayList<>();
        adaptadorMascotas = new AdaptadorMascotas(listaDeMascotas);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adaptadorMascotas);

        // Una vez que ya configurado el RecyclerView le ponemos los datos de la BD
        refrescarListaDeMascotas();

        // Listener de los clicks en la lista, o sea el RecyclerView
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override // Un toque sencillo
            public void onClick(View view, int position) {
                // Pasar a la actividad EditarMascotaActivity.java
                Mascota mascotaSeleccionada = listaDeMascotas.get(position);
                Intent intent = new Intent(MainActivity.this, EditarMascotaActivity.class);
                intent.putExtra("idMascota", mascotaSeleccionada.getId());
                intent.putExtra("nombreMascota", mascotaSeleccionada.getNombre());
                intent.putExtra("edadMascota", mascotaSeleccionada.getEdad());
                startActivity(intent);
            }

            @Override // Un toque largo
            public void onLongClick(View view, int position) {
                final Mascota mascotaParaEliminar = listaDeMascotas.get(position);
                AlertDialog dialog = new AlertDialog
                        .Builder(MainActivity.this)
                        .setPositiveButton("Sí, eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mascotasController.eliminarMascota(mascotaParaEliminar);
                                refrescarListaDeMascotas();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setTitle("Confirmar")
                        .setMessage("¿Eliminar a la mascota " + mascotaParaEliminar.getNombre() + "?")
                        .create();
                dialog.show();

            }
        }));

        // Listener del FAB
        fabAgregarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambiar de actividad cuando se da click al boton flotante
                Intent intent = new Intent(MainActivity.this, AgregarMascotaActivity.class);
                startActivity(intent);
            }
        });

        // Créditos
        fabAgregarMascota.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Acerca de")
                        .setMessage("CRUD de Android con SQLite creado por parzibyte [parzibyte.me]\n\nIcons made by Freepik from www.flaticon.com ")
                        .setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogo, int which) {
                                dialogo.dismiss();
                            }
                        })
                        .setPositiveButton("Sitio web", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intentNavegador = new Intent(Intent.ACTION_VIEW, Uri.parse("https://parzibyte.me"));
                                startActivity(intentNavegador);
                            }
                        })
                        .create()
                        .show();
                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        refrescarListaDeMascotas();
    }

    public void refrescarListaDeMascotas() {

        if (adaptadorMascotas == null) return;
        listaDeMascotas = mascotasController.obtenerMascotas();
        adaptadorMascotas.setListaDeMascotas(listaDeMascotas);
        adaptadorMascotas.notifyDataSetChanged();
    }
}
