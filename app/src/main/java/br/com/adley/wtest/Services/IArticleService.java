package br.com.adley.wtest.Services;

import br.com.adley.wtest.Models.Article;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IArticleService {
    @GET("mobile/1-1/articles")
    Call<Article> getArticles(
            @Query("page") int page,
            @Query("limit") int limit );
}
