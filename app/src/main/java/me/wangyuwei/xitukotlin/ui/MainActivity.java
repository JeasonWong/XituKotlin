package me.wangyuwei.xitukotlin.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import me.wangyuwei.xitukotlin.R;
import me.wangyuwei.xitukotlin.entity.HotList;
import me.wangyuwei.xitukotlin.mvp.presenter.MainPresenter;
import me.wangyuwei.xitukotlin.mvp.views.MainView;
import me.wangyuwei.xitukotlin.ui.hot.HotAdapter;

/**
 * 作者： 巴掌 on 16/4/22 18:09
 */
public class MainActivity extends AppCompatActivity implements MainView{

    private RecyclerView rv_hot;
    private HotAdapter mHotAdapter;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_hot = (RecyclerView) this.findViewById(R.id.rv_hot);

        mHotAdapter = new HotAdapter(this);
        rv_hot.setAdapter(mHotAdapter);
        rv_hot.setLayoutManager(new LinearLayoutManager(this));

        mainPresenter = new MainPresenter(this);
        mainPresenter.loadData();

    }

    @Override
    public void showHotList(HotList hotList) {
        mHotAdapter.setData(hotList.getResults());
    }
}
