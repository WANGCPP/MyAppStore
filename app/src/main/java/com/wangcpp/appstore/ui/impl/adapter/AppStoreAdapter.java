package com.wangcpp.appstore.ui.impl.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

    private OnItemEventListener onItemEventListener = null;

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
        Log.d(TAG, "id = " + appBean.getAppId() + " verid =" + appBean.getAppVersion());
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

        private AppBean appBean = null;

        private ImageView ivAppPic = null;

        private TextView tvAppName = null;

        private ProgressBar pbAppPro = null;


        ItemViewHolder(View itemView) {
            super(itemView);
            initView();
            initEvent();
        }

        private void initView() {
            tvAppName = itemView.findViewById(R.id.tv_appstore_recycview_item_appname);
            ivAppPic = itemView.findViewById(R.id.iv_appstore_recycview_item_apppic);
            pbAppPro = itemView.findViewById(R.id.pb_appstore_recycview_item_progressbar);
        }

        private void initEvent() {
            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.pb_appstore_recycview_item_progressbar:
                            Toast.makeText(mContext, "clclc", Toast.LENGTH_SHORT).show();
                            if (null != onItemEventListener) {
                                onItemEventListener.onBtnClick(appBean);
                            }
                            break;
                        default:
                            break;
                    }
                }
            };

            pbAppPro.setOnClickListener(clickListener);
        }

        public void setData(AppBean appBean) {
            this.appBean = appBean;
            ImageLoader.getInstance().displayImage(appBean.getIcon(), ivAppPic);
            tvAppName.setText(appBean.getName());
        }
    }

    public interface OnItemEventListener {
        /**
         * 下载按钮点击事件
         *
         * @param appBean 待下载的AppBean
         */
        void onBtnClick(AppBean appBean);

        void onItemClick();
    }

    public void setOnItemEventListener(OnItemEventListener onItemEventListener) {
        this.onItemEventListener = onItemEventListener;
    }
}
