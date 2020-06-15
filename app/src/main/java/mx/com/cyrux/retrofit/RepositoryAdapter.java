package mx.com.cyrux.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {
    private List<Repository> repositoryList;

    public RepositoryAdapter(List<Repository> repositoryList) {
        this.repositoryList = repositoryList;
    }

    @NonNull
    @Override
    public RepositoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View repositoryView = layoutInflater.inflate(R.layout.item_repository, parent, false);

        return new ViewHolder(repositoryView);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryAdapter.ViewHolder holder, int position) {
        Repository repository = repositoryList.get(position);

        holder.tvName.setText(repository.getName());
        holder.tvDescription.setText(repository.getDescription());
    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
