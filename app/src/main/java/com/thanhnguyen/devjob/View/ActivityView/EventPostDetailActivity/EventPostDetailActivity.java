package com.thanhnguyen.devjob.View.ActivityView.EventPostDetailActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.thanhnguyen.devjob.Model.ModelEvent.EventItem;
import com.thanhnguyen.devjob.Presenter.FragmentEventDetailPresenter.FragmentEventDetailImp;
import com.thanhnguyen.devjob.Presenter.FragmentEventDetailPresenter.FragmentEventDetailLogic;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventPostDetailActivity extends AppCompatActivity implements EventPostDetailViewImp {

    @BindView(R.id.event_post_detail_txt_title)
    TextView eventPostDetailTxtTitle;
    @BindView(R.id.event_post_detail_txt_time)
    TextView eventPostDetailTxtTime;
    @BindView(R.id.event_post_detail_txt_content)
    TextView eventPostDetailTxtContent;
    private FragmentEventDetailImp fragmentEventDetailImp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_post_detail);
        Intent intent = getIntent();
        ButterKnife.bind(this);
        EventItem eventItem = (EventItem) intent.getSerializableExtra("eventdetail");
        fragmentEventDetailImp = new FragmentEventDetailLogic(this);
        fragmentEventDetailImp.getEventDetail(Constant.token, eventItem.getSlug());


    }

    @Override
    public void getData(EventItem eventItem) {
        eventPostDetailTxtTitle.setText(eventItem.getTitle());
        eventPostDetailTxtTime.setText(eventItem.getDay());

        Spanned spanned = Html.fromHtml(eventItem.getContent(),
                new Html.ImageGetter() {
                    @Override
                    public Drawable getDrawable(String source) {
                        LevelListDrawable d = new LevelListDrawable();
                        Drawable empty = getResources().getDrawable(R.drawable.abc_btn_check_material);;
                        d.addLevel(0, 0, empty);
                        d.setBounds(0, 0, empty.getIntrinsicWidth(), empty.getIntrinsicHeight());
                        new ImageGetterAsyncTask(EventPostDetailActivity.this, source, d).execute(eventPostDetailTxtContent);
                        return d;
                    }
                }, null);
        eventPostDetailTxtContent.setText(spanned);
    }

    @Override
    public void getError(String error) {
        Log.d("aaa", "getError: " + error);
    }

    @OnClick(R.id.event_post_detail_img_back)
    public void onViewClicked() {
        this.finish();
    }

}
