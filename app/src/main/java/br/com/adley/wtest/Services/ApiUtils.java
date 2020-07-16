package br.com.adley.wtest.Services;

public class ApiUtils {
        public static IArticleService Articles(String baseUrl) {
            return RetrofitClient.getClient(baseUrl).create(IArticleService.class);
    }
}
