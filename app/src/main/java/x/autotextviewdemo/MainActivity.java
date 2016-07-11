package x.autotextviewdemo;

import android.animation.TimeAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnNext;
    private Button mBtnPrev;
    private Button auto;
    private AutoTextView mTextView02;
    private static int sCount = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        // TODO Auto-generated method stub
        mBtnNext = (Button) findViewById(R.id.next);
        auto = (Button) findViewById(R.id.auto);
        mBtnPrev = (Button) findViewById(R.id.prev);
        mTextView02 = (AutoTextView) findViewById(R.id.switcher02);
        mBtnPrev.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
        auto.setOnClickListener(this);
        final ArrayList<Model> listData=new ArrayList<Model>();
        listData.add(new Model());
        listData.add(new Model());
        listData.add(new Model());
        listData.add(new Model());
        listData.add(new Model());
        mTextView02.setListData(listData);
        mTextView02.setOnClickListener(new AutoTextView.setClickListener() {
            @Override
            public void onClick(int count) {
                System.out.println(count + "");
                Toast.makeText(MainActivity.this,""+listData.get(count).title.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getId()) {
            case R.id.next:
                mTextView02.next();
                sCount++;
                break;
            case R.id.prev:
                mTextView02.previous();
                sCount--;
                break;
            case R.id.auto:
                mTextView02.startAutoTimer();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTextView02.stopAutoTimer();
    }
}