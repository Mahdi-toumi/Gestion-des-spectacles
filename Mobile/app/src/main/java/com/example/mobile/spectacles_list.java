package com.example.mobile;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class spectacles_list extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SpectacleAdapter adapter;
    private List<Spectacle> spectacleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spectacles_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.spectaclesList), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        spectacleList = new ArrayList<>();
        spectacleList.add(new Spectacle("Spectacle Nouba", "Théâtre municipal de Carthage", "19:00", "30", R.drawable.nouba));
        spectacleList.add(new Spectacle("Le Hakka Le Hakka", "Théatre municipal de Bizerte", "20:30", "15", R.drawable.lehakka));
        // Tu peux en ajouter d'autres ici

        // 👉 Lier l'adapter
        adapter = new SpectacleAdapter(spectacleList);
        recyclerView.setAdapter(adapter);

    }
}