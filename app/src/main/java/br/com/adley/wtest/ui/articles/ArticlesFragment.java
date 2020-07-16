package br.com.adley.wtest.ui.articles;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.adley.wtest.ArticleDetailsActivity;
import br.com.adley.wtest.R;
import br.com.adley.wtest.Services.ApiUtils;
import br.com.adley.wtest.Services.IArticleService;
import br.com.adley.wtest.Models.Article;
import br.com.adley.wtest.Utils.RecyclerItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlesFragment extends Fragment {

    private IArticleService mArticleService;
    private ArticleRecyclerViewAdapter mArticlesRecyclerViewAdapter;
    private RecyclerView mRecyclerView;

    String url_base = "https://5bb1cd166418d70014071c8e.mockapi.io/";

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_articles, container, false);
        mRecyclerView = root.findViewById(R.id.layout_article_recyclerview);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mArticlesRecyclerViewAdapter = new ArticleRecyclerViewAdapter(getContext(),new ArrayList<>());
        mRecyclerView.setAdapter(mArticlesRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        mRecyclerView.addOnItemTouchListener( new RecyclerItemClickListener(getContext(), mRecyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if(mArticlesRecyclerViewAdapter.getItemCount() > 0) {
                            NavigateToArticleDetaisl(position);
                        }
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        if(mArticlesRecyclerViewAdapter.getItemCount() > 0) {
                            NavigateToArticleDetaisl(position);
                        }
                    }
                }));
        GetArticles(1, 10);

    }

    public void NavigateToArticleDetaisl(int position){
        Intent intent = new Intent(getActivity(), ArticleDetailsActivity.class);
        intent.putExtra("Article", mArticlesRecyclerViewAdapter.getArticles().get(position));
        getActivity().startActivity(intent);
    }

    public void GetArticles (int page, int limit) {
        // Start new retrofit client
        mArticleService = ApiUtils.Articles(getString(R.string.url_base_article));
        mArticleService.getArticles(page, limit).enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                if (response.isSuccessful()){
                    if (response.body() != null && !response.body().getItems().isEmpty()) {
                        mArticlesRecyclerViewAdapter.setArticles(response.body().getItems());
                        mArticlesRecyclerViewAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {

            }
        });
    }
}