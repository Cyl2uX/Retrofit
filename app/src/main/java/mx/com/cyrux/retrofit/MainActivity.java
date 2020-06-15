package mx.com.cyrux.retrofit;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvRepositories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRepositories = findViewById(R.id.rvRepositories);
        rvRepositories.setLayoutManager(new LinearLayoutManager(this));

        GitHubService service = ServiceGenerator.createService(GitHubService.class);

        Call<List<Repository>> call = service.reposForUser("cyl2ux");
        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if (response.isSuccessful()) {
                    rvRepositories.setAdapter(new RepositoryAdapter(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Log.e("Request failed", "Cannot Request GitHub repositories");
            }
        });
    }
}