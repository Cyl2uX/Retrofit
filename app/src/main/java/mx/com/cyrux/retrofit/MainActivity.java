package mx.com.cyrux.retrofit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvRepositories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRepositories = findViewById(R.id.rvRepositories);
        rvRepositories.setLayoutManager(new LinearLayoutManager(this));
        rvRepositories.setAdapter(new RepositoryAdapter(Repository.getRepositories()));
    }
}