package com.cyj.dialoglib;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * 描述：抽屉式选择框
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5 15:12
 * 修改人：
 * 修改时间：
 */
public class ActionSheetDialog implements AdapterView.OnItemClickListener {
    private Context context;
    private Dialog dialog;
    private TextView txt_title;
    private TextView txt_cancel;
    private ListView lLayout_contents;
    private boolean showTitle = false;
    private List<String> sheetItemList;
    private Display display;
    private OnSheetItemClickListener itemClickListener;

    public ActionSheetDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public ActionSheetDialog builder() {
        // 获取Dialog布局
        View view = LayoutInflater.from(context).inflate(
                R.layout.view_actionsheet, null);

        // 设置Dialog最小宽度为屏幕宽度
        view.setMinimumWidth(display.getWidth());

        lLayout_contents = (ListView) view
                .findViewById(R.id.lLayout_content);
        txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_cancel = (TextView) view.findViewById(R.id.txt_cancel);
        txt_cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        // 定义Dialog布局和参数
        dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
        dialog.setContentView(view);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.LEFT | Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.x = 0;
        lp.y = 0;
        dialogWindow.setAttributes(lp);

        return this;
    }

    public ActionSheetDialog setTitle(String title) {
        showTitle = true;
        txt_title.setVisibility(View.VISIBLE);
        txt_title.setText(title);
        return this;
    }

    public ActionSheetDialog setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public ActionSheetDialog setCanceledOnTouchOutside(boolean cancel) {
        dialog.setCanceledOnTouchOutside(cancel);
        return this;
    }


    public ActionSheetDialog addSheetItem(List<String> sheetItemList) {
        this.sheetItemList = sheetItemList;
        lLayout_contents.setAdapter(new ArrayAdapter<String>(context, R.layout.text_item, sheetItemList));
        lLayout_contents.setOnItemClickListener(this);
        return this;
    }

    public void setOnSimpleListItemClickListener(OnSheetItemClickListener listener) {
        itemClickListener = listener;
    }

    /**
     * 设置条目布局
     */
    private void setSheetItems() {
        if (sheetItemList == null || sheetItemList.size() <= 0) {
            return;
        }

        int size = sheetItemList.size();

        // TODO 高度控制，非最佳解决办法
        // 添加条目过多的时候控制高度
        if (size >= 7) {
            LayoutParams params = (LayoutParams) lLayout_contents
                    .getLayoutParams();
            params.height = display.getHeight() / 2;
            lLayout_contents.setLayoutParams(params);
        }

        // 循环添加条目
//		for (int i = 1; i <= size; i++) {
//			final int index = i;
//			String strItem = sheetItemList.get(i - 1);
//			final OnSheetItemClickListener listener = (OnSheetItemClickListener) sheetItem.itemClickListener;
//
//			TextView textView = new TextView(context);
//			textView.setText(strItem);
//			textView.setTextSize(18);
//			textView.setGravity(Gravity.CENTER);
//
//			// 背景图片
//			if (size == 1) {
//				if (showTitle) {
//					textView.setBackgroundResource(R.drawable.actionsheet_bottom_selector);
//				} else {
//					textView.setBackgroundResource(R.drawable.actionsheet_single_selector);
//				}
//			} else {
//				if (showTitle) {
//					if (i >= 1 && i < size) {
//						textView.setBackgroundResource(R.drawable.actionsheet_middle_selector);
//					} else {
//						textView.setBackgroundResource(R.drawable.actionsheet_bottom_selector);
//					}
//				} else {
//					if (i == 1) {
//						textView.setBackgroundResource(R.drawable.actionsheet_top_selector);
//					} else if (i < size) {
//						textView.setBackgroundResource(R.drawable.actionsheet_middle_selector);
//					} else {
//						textView.setBackgroundResource(R.drawable.actionsheet_bottom_selector);
//					}
//				}
//			}
//
//			// 高度
//			float scale = context.getResources().getDisplayMetrics().density;
//			int height = (int) (45 * scale + 0.5f);
//			textView.setLayoutParams(new LinearLayout.LayoutParams(
//					LayoutParams.MATCH_PARENT, height));
//
//			// 点击事件
//			textView.setOnClickListener(new OnClickListener() {
//				@Override
//				public void onClick(View v) {
//					listener.onClick(index);
//					dialog.dismiss();
//				}
//			});
//
//			lLayout_contentS.addView(textView);
//		}
    }

    public ActionSheetDialog show() {
        setSheetItems();
        dialog.show();
        return this;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (itemClickListener != null) {
            itemClickListener.onClick(position);
            dialog.dismiss();
        }


    }


    public interface OnSheetItemClickListener {
        void onClick(int which);
    }

    public enum SheetItemColor {
        Blue("#037BFF"), Red("#FD4A2E");

        private String name;

        private SheetItemColor(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
