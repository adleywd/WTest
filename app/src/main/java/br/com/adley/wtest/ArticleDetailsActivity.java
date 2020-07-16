package br.com.adley.wtest;

import android.content.Intent;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;

import br.com.adley.wtest.Models.ArticleItem;

public class ArticleDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView heroImage = findViewById(R.id.image_hero);
        TextView title = findViewById(R.id.text_details_title);
        TextView author = findViewById(R.id.text_details_author);
        TextView date = findViewById(R.id.text_details_data);
        TextView body = findViewById(R.id.text_details_body);


        // Get object passed through Intent
        Intent intent = getIntent();
        ArticleItem article = (ArticleItem)intent.getSerializableExtra("Article");

        if(article != null){
            Picasso.get().load(article.getHero())
                    .noPlaceholder()
                    .into(heroImage);

            title.setText(article.getTitle());
            author.setText(article.getAuthor());
            date.setText(article.getPublishedAt());
            body.setText(article.getBody());
        }

    }
}