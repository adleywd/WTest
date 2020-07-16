package br.com.adley.wtest.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Article implements Serializable {

    @SerializedName("items")
    @Expose
    private List<ArticleItem> items = null;

    public List<ArticleItem> getItems() {
        return items;
    }

    public void setItems(List<ArticleItem> items) {
        this.items = items;
    }

}
