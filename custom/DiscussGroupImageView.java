package com.lingtuan.firefly.custom;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.lingtuan.firefly.R;
import com.lingtuan.firefly.vo.UserBaseVo;

import java.util.List;


public class DiscussGroupImageView extends RelativeLayout {

    private Context mContext;

    public DiscussGroupImageView(Context context) {
        super(context);
        initCache(context);

    }

    public DiscussGroupImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initCache(context);

    }

    public DiscussGroupImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        initCache(context);
    }

    private void initCache(Context context) {
        mContext = context;
    }

    private int dip2px(float dipValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * Set head need to gender and thumb
     *
     * @param members
     */
    public void setMember(List<UserBaseVo> members) {
        this.removeAllViews();
        if (members.size() == 1) {
            CharAvatarView image1 = new CharAvatarView(mContext);
            LayoutParams lp1 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            lp1.addRule(RelativeLayout.CENTER_IN_PARENT);
            String username = members.get(0).getShowName();
            if (TextUtils.isEmpty(username)) {
                username = "C";
            }
            image1.setText(username, image1, members.get(0).getThumb());
            image1.setPadding(dip2px(3), dip2px(3), dip2px(3), dip2px(3));
            addView(image1, lp1);
        } else if (members.size() >= 2) {
            CharAvatarView image1 = new CharAvatarView(mContext);
            LayoutParams lp1 = new LayoutParams(dip2px(33), dip2px(33));
            lp1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            lp1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            lp1.setMargins(dip2px(1), dip2px(1), 0, 0);
            String username = members.get(0).getShowName();
            if (TextUtils.isEmpty(username)) {
                username = "C";
            }
            image1.setText(username, image1, members.get(0).getThumb());
            addView(image1, lp1);

            CharAvatarView image2 = new CharAvatarView(mContext);
            LayoutParams lp2 = new LayoutParams(dip2px(33), dip2px(33));
            lp2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            lp2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            lp2.setMargins(0, 0, dip2px(1), dip2px(1));
            image2.setBackgroundResource(R.drawable.shape_round_avatar_write);
            image2.setPadding(dip2px(1), dip2px(1), dip2px(1), dip2px(1));
            String username1 = members.get(1).getShowName();
            if (TextUtils.isEmpty(username1)) {
                username1 = "C";
            }
            image2.setText(username1, image2, members.get(1).getThumb());
            addView(image2, lp2);

        }
    }
}
