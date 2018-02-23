package com.wangcpp.appstore.ui.impl.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.wangcpp.appstore.R;
import com.wangcpp.appstore.presenter.bean.AppBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WANGCPP on 2018/2/13.
 * 应用商店界面的recyclerview 数据适配器
 */
public class AppStoreAdapter extends RecyclerView.Adapter<AppStoreAdapter.ItemViewHolder> {

    private final String TAG = AppStoreAdapter.class.getSimpleName();

    private Context mContext = null;

    /**
     * App列表
     */
    private List<AppBean> mAppList = null;

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_appstore_recycview, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        AppBean appBean = mAppList.get(position);
        holder.setData(appBean);
    }

    @Override
    public int getItemCount() {
        if (null == mAppList) {
            return 0;
        }
        return mAppList.size();
    }

    public AppStoreAdapter(Context context) {
        this.mContext = context;
    }

    public void setAppList(List<AppBean> appList) {
        this.mAppList = appList;
        notifyDataSetChanged();
    }

    /**
     * item viewholder
     */
    class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivAppPic = null;

        private TextView tvAppName = null;


        ItemViewHolder(View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            tvAppName = itemView.findViewById(R.id.tv_appstore_recycview_item_appname);
            ivAppPic = itemView.findViewById(R.id.iv_appstore_recycview_item_apppic);
        }

        public void setData(AppBean appBean) {
            ImageLoader.getInstance().displayImage(appBean.getIcon(), ivAppPic);
            tvAppName.setText(appBean.getName());
        }
    }
}
