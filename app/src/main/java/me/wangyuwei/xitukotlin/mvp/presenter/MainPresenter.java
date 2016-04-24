package me.wangyuwei.xitukotlin.mvp.presenter;

import android.util.Log;

import me.wangyuwei.xitukotlin.entity.HotListEntity;
import me.wangyuwei.xitukotlin.mvp.views.MainView;
import me.wangyuwei.xitukotlin.rest.ApiUtil;
import me.wangyuwei.xitukotlin.rest.XituApi;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者： 巴掌 on 16/4/24 00:18
 */
public class MainPresenter {

    private MainView mainView;
    private XituApi xituApi;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        xituApi = ApiUtil.createApi(XituApi.class);
    }

    public void loadData(){
        xituApi.getHotList("user,user.installation", "-rankIndex", 30)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HotListEntity>() {
                    @Override
                    public void call(HotListEntity hotList) {
                        mainView.showHotList(hotList);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("@=>e", throwable.getMessage());
                    }
                });
    }
}
