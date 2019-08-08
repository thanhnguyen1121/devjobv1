package com.thanhnguyen.devjob.View.ActivityView.CourseDetailActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.thanhnguyen.devjob.Model.ModelCourse.CourseItem;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.View.ActivityView.BlogDetailActivity.BlogDetailActivity;
import com.thanhnguyen.devjob.View.ActivityView.EventPostDetailActivity.ImageGetterAsyncTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CourseDetailActivity extends AppCompatActivity {

    @BindView(R.id.course_post_detail_txt_title)
    TextView coursePostDetailTxtTitle;
    @BindView(R.id.course_post_detail_txt_time)
    TextView coursePostDetailTxtTime;
    @BindView(R.id.course_post_detail_txt_content)
    TextView coursePostDetailTxtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        CourseItem courseItem = (CourseItem) intent.getSerializableExtra("course");
        initView(courseItem);
    }

    @OnClick(R.id.blog_post_detail_img_back)
    public void onViewClicked() {
        this.finish();
    }

    private void initView(CourseItem courseItem){
        coursePostDetailTxtTitle.setText(courseItem.getTitle());
        coursePostDetailTxtTime.setText(courseItem.getCreatedAt().split(" ")[0]);
        Spanned spanned = Html.fromHtml(courseItem.getContent(),
                new Html.ImageGetter() {
                    @Override
                    public Drawable getDrawable(String source) {
                        LevelListDrawable d = new LevelListDrawable();
                        Drawable empty = getResources().getDrawable(R.drawable.abc_btn_check_material);;
                        d.addLevel(0, 0, empty);
                        d.setBounds(0, 0, empty.getIntrinsicWidth(), empty.getIntrinsicHeight());
                        new ImageGetterAsyncTask(CourseDetailActivity.this, source, d).execute(coursePostDetailTxtContent);
                        return d;
                    }
                }, null);
        coursePostDetailTxtContent.setText(spanned);
    }
}
