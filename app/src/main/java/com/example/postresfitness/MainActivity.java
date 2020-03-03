package com.example.postresfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.postresfitness.adapters.DataFitAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DataFitAdapter.OnItemClickListener {

    private RecyclerView reView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reView = findViewById(R.id.reView);
        reView.setHasFixedSize(true);
        GridLayoutManager grid = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        reView.setLayoutManager(grid);
        DataFitAdapter adapter = new DataFitAdapter(this, initPostres());
        adapter.setOnItemClickListener(this);
        reView.setAdapter(adapter);
    }

    public List<Postres> initPostres(){
        List<Postres> lista = new ArrayList<Postres>();
        lista.add(new Postres(R.drawable.brownie_banana, "Platano"));
        lista.add(new Postres(R.drawable.galletas_rapidas_de_auyama_y_banano, "Galleta"));
        lista.add(new Postres(R.drawable.mandocas_hormenadas, "Horneado"));
        lista.add(new Postres(R.drawable.muffins_de_pan_con_zanohoria, "Zanahoria"));
        lista.add(new Postres(R.drawable.muffins_integrales, "Integral"));
        lista.add(new Postres(R.drawable.palmeritas_de_banana, "Palmera"));
        lista.add(new Postres(R.drawable.pan_de_calabacin_750x300, "Calabaza"));
        lista.add(new Postres(R.drawable.panquecas_de_cacao_con_topping_de_banana, "Cacao"));
        return lista;
    }

    @Override
    public void onClick(Postres postre) {
        Bundle bundle = new Bundle();
        bundle.putInt("imagen", postre.getImage());
        bundle.putString("info", postre.getInfo());
        Intent inten = new Intent(this, DetailActivity.class);
        inten.putExtras(bundle);
        startActivity(inten);
    }
}
