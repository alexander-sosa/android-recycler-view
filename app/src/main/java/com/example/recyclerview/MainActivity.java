package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<ModeloItem> lista;
    RecyclerAdapter adapter;
    RecyclerView rvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<>();
        adapter = new RecyclerAdapter(lista);
        rvLista = findViewById(R.id.rvLista);

        rvLista.setAdapter(adapter);

        cargarLista();
        // Lista de una columna en vertical o en horizontal
        rvLista.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Item elegido: " + lista.get(rvLista.getChildAdapterPosition(v)).getTitulo(), Toast.LENGTH_SHORT).show();
                //lista.get(rvLista.getChildAdapterPosition(v)).setColor(Color.argb(255, 0, 0, 0));
                lista.get(rvLista.getChildAdapterPosition(v)).setSelected(true);
                rvLista.setAdapter(adapter);
            }
        });

        //rvLista.setLayoutManager(new GridLayoutManager(this, 2));
    }

    public void cargarLista(){
        lista.add(new ModeloItem(R.drawable.daredevil, "DAREDEVIL", "Awesome series for selling!", randomColor(), false));
        lista.add(new ModeloItem(R.drawable.punisher, "PUNISHER", "Awesome series for selling!", randomColor(), false));
        lista.add(new ModeloItem(R.drawable.starwars, "STAR WARS", "Awesome series for selling!", randomColor(), false));
        lista.add(new ModeloItem(R.drawable.vector, "VECTOR", "Awesome series for selling!", randomColor(), false));
        lista.add(new ModeloItem(R.drawable.ghos, "GHOST", "Awesome series for selling!", randomColor(), false));
        lista.add(new ModeloItem(R.drawable.cosmos, "COSMOS", "Awesome series for selling!", randomColor(), false));
        lista.add(new ModeloItem(R.drawable.ravenclaw, "RAVENCLAW", "Awesome series for selling!", randomColor(), false));
        lista.add(new ModeloItem(R.drawable.knights, "KNIGHTS", "Awesome series for selling!", randomColor(), false));
    }

    public int randomColor(){
        Random rnd = new Random();
        // Generar cadenas en hexadecimal
        //String cad = "#" + rnd.nextInt(999999);
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256),rnd.nextInt(256));
        return color;
    }
}