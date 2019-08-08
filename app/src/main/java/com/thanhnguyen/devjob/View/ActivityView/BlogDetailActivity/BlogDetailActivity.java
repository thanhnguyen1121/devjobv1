package com.thanhnguyen.devjob.View.ActivityView.BlogDetailActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.thanhnguyen.devjob.Model.ModelBlog.BlogItem;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.View.ActivityView.EventPostDetailActivity.EventPostDetailActivity;
import com.thanhnguyen.devjob.View.ActivityView.EventPostDetailActivity.ImageGetterAsyncTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BlogDetailActivity extends AppCompatActivity {

    @BindView(R.id.blog_post_detail_txt_title)
    TextView blogPostDetailTxtTitle;
    @BindView(R.id.blog_post_detail_txt_time)
    TextView blogPostDetailTxtTime;
    @BindView(R.id.blog_post_detail_txt_content)
    TextView blogPostDetailTxtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        BlogItem blogItem = (BlogItem) intent.getSerializableExtra("blog");
        setContent(blogItem);
    }

    @OnClick(R.id.blog_post_detail_img_back)
    public void onViewClicked() {
        this.finish();
    }

    private void setContent(BlogItem blogItem){
        blogPostDetailTxtTitle.setText(blogItem.getTitle());
        String time = blogItem.getCreatedAt().split(" ")[0];
        blogPostDetailTxtTime.setText(time);

        Spanned spanned = Html.fromHtml(blogItem.getContent(),
                new Html.ImageGetter() {
                    @Override
                    public Drawable getDrawable(String source) {
                        LevelListDrawable d = new LevelListDrawable();
                        Drawable empty = getResources().getDrawable(R.drawable.abc_btn_check_material);;
                        d.addLevel(0, 0, empty);
                        d.setBounds(0, 0, empty.getIntrinsicWidth(), empty.getIntrinsicHeight());
                        new ImageGetterAsyncTask(BlogDetailActivity.this, source, d).execute(blogPostDetailTxtContent);
                        return d;
                    }
                }, null);
        blogPostDetailTxtContent.setText(spanned);
    }
}
