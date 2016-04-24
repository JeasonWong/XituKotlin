package me.wangyuwei.xitukotlin.ui.hot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.wangyuwei.xitukotlin.entity.ResultsEntity;

/**
 * 作者： 巴掌 on 16/4/22 18:17
 */
public class HotAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<ResultsEntity> mList = new ArrayList<>();

    public HotAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<ResultsEntity> resultsEntities){
        if (resultsEntities != null){
            mList = resultsEntities;
        }else {
            mList.clear();
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotViewHolder(new HotItemView(mContext));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HotViewHolder){
            HotViewHolder hotViewHolder = (HotViewHolder) holder;
            hotViewHolder.setData(mList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class HotViewHolder extends RecyclerView.ViewHolder{

        private HotItemView itemView;

        public HotViewHolder(HotItemView itemView) {
            super(itemView.getView());
            this.itemView = itemView;
        }

        public void setData(ResultsEntity resultsEntity){
            itemView.setData(resultsEntity);
        }
    }

}
