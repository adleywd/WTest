package br.com.adley.wtest.ui.articles;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.adley.wtest.R;
import br.com.adley.wtest.Models.ArticleItem;

public class ArticleRecyclerViewAdapter extends RecyclerView.Adapter<ArticleRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "ArticlerViewAdapter";

    public List<ArticleItem> getArticles() {
        return mArticles;
    }
    private Context mContext;

    public void setArticles(List<ArticleItem> mArticles) {
        this.mArticles = mArticles;
    }

    private List<ArticleItem> mArticles;

    public ArticleRecyclerViewAdapter(Context context, List<ArticleItem> articleList) {
        this.mArticles = articleList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_article, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "called");

        ArticleItem article = mArticles.get(position);

        holder.title.setText(article.getTitle());
        holder.author.setText(article.getAuthor());
        holder.body.setText(article.getBody());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "CLICKED in ");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView author;
        TextView body;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.text_title);
            author = itemView.findViewById(R.id.text_author);
            body = itemView.findViewById(R.id.text_body);
            parentLayout = itemView.findViewById(R.id.layout_article_parent);
        }
    }
}
