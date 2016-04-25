package me.wangyuwei.xitukotlin.ui.hot;

import android.content.Context;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import me.wangyuwei.xitukotlin.R;
import me.wangyuwei.xitukotlin.entity.ResultsEntity;

/**
 * 作者： 巴掌 on 16/4/24 21:25
 */
public class HotAdapter extends RecyclerView.Adapter {

    private static final int TYPE_FOOTER = 0;
    private static final int TYPE_ITEM = 1;

    private Context mContext;
    private List<ResultsEntity> mList = new ArrayList<>();

    public HotAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<ResultsEntity> resultsEntities) {
        if (resultsEntities != null) {
            mList = resultsEntities;
        } else {
            mList.clear();
        }
        notifyDataSetChanged();
    }

    public void addData(List<ResultsEntity> resultsEntities) {
        if (resultsEntities != null) {
            mList.addAll(resultsEntities);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ITEM:
                return new HotViewHolder(new HotItemView(mContext));
            case TYPE_FOOTER:
                View footerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_footer, parent, false);
                return new FooterViewHolder(footerView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HotViewHolder) {
            HotViewHolder hotViewHolder = (HotViewHolder) holder;
            hotViewHolder.setData(mList.get(position));
        }else if (holder instanceof FooterViewHolder){
            Log.d("@=>FooterViewHolder", "FooterViewHolder");
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isFooter(position)) return TYPE_FOOTER;
        else return TYPE_ITEM;
    }

    private boolean isFooter(int position) {
        return position == mList.size();
    }

    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }

    static class HotViewHolder extends RecyclerView.ViewHolder {

        private HotItemView itemView;

        public HotViewHolder(HotItemView itemView) {
            super(itemView.getView());
            this.itemView = itemView;
        }

        public void setData(ResultsEntity resultsEntity) {
            itemView.setData(resultsEntity);
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {

        public ContentLoadingProgressBar progressBar;

        public FooterViewHolder(View itemView) {
            super(itemView);
            progressBar = (ContentLoadingProgressBar) itemView.findViewById(R.id.loading_more_progress);
            progressBar.setVisibility(View.VISIBLE);
        }
    }

}
