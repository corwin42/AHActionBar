package de.amberhome.SimpleActionBar;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.SpinnerAdapter;

final class ListNavigationDropdown extends PopupWindow {
    public static class Builder implements View.OnClickListener {
        private final Context mContext;
        private final ListNavigationDropdown mDropdown;
        private SpinnerAdapter mAdapter;
        private OnClickListener mListener;
        private View mParent;
        
        public Builder(Context context) {
            mContext = context;
            mDropdown = new ListNavigationDropdown(context);
        }
        
        public Builder setAdapter(SpinnerAdapter adapter, OnClickListener listener) {
            mAdapter = adapter;
            mListener = listener;
            return this;
        }
        
        public Builder setParent(View parent) {
            this.mParent = parent;
            return this;
        }
        
		public void show() {
            //LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //View contentView = inflater.inflate(R.layout.actionbar_list_dropdown, null, false);
            
            LinearLayout l1 = new LinearLayout(mContext);
            @SuppressWarnings("deprecation")
			LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
            l1.setLayoutParams(lp);
            // TODO: Set Background Image
            //l1.setBackgroundDrawable(d);
            
            ScrollView sc = new ScrollView(mContext);
            sc.setLayoutParams(lp);
            
            l1.addView(sc);
            
            LinearLayout list = new LinearLayout(mContext);
            list.setLayoutParams(lp);
            list.setOrientation(LinearLayout.VERTICAL);
            
            sc.addView(list);
            		
            View contentView = l1;
            
            //LinearLayout list = (LinearLayout) contentView.findViewById(R.id.actionbar_list_dropdown);
            for (int i = 0; i < mAdapter.getCount(); i++) {
                View item = mAdapter.getDropDownView(i, null, list);
                item.setFocusable(true);
                item.setTag(new Integer(i));
                item.setOnClickListener(this);
                list.addView(item);
            }
            
            mDropdown.setContentView(contentView);
            mDropdown.setFocusable(true);
            mDropdown.setWindowLayoutMode(0, LayoutParams.WRAP_CONTENT);
            mDropdown.setWidth(mParent.getWidth());
            mDropdown.showAsDropDown(mParent);
        }

        @Override
        public void onClick(View view) {
            mDropdown.dismiss();
            mListener.onClick(null, (Integer)view.getTag());
        }
    }
    
    private ListNavigationDropdown(Context context) {
        super(context);
    }
}