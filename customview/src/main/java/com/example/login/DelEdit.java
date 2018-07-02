package com.example.login;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.customview.R;


/**
 * 自定义文本框
 */
public class DelEdit extends FrameLayout {
    private EditText input;
    private ImageView imgClear;
    private ImageView imgShow;
    private RelativeLayout rlRoot;
    private ImageView imgIcon;
    private boolean mShowable;
    private String exp;//正则匹配
    private OnExpressionListener expLis;
    public DelEdit(Context context) {
        super(context);
        init(null);
    }

    public DelEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DelEdit(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_deledit, this);
        imgIcon = (ImageView) findViewById(R.id.edit_icon);
        imgClear = (ImageView) findViewById(R.id.edit_clear);
        input = (EditText) findViewById(R.id.edit_input);
        imgShow = (ImageView) findViewById(R.id.edit_show);
        rlRoot = (RelativeLayout) findViewById(R.id.edit_root);
        imgClear.setOnClickListener(clickListener);
        imgShow.setTag(false);//设置是否显示铭文标记(密码的),先默认密码不可见（密码本来默认是不可见的），密码的可见与否通过view.setTag()来使用
        imgShow.setOnClickListener(clickListener);
        input.setOnFocusChangeListener(focusChangeListener);
        input.addTextChangedListener(watcher);
        if (attrs == null) return;
        //从布局中获取值
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.DelEdit,0,0);
        int N = a.getIndexCount();
        for (int i = 0; i < N; i++) {
            int index = a.getIndex(i);
            switch (index) {
                case R.styleable.DelEdit_mInputType:
                    int type = a.getInt(index, 0);
                    setInputType(InputType.getType(type));
                    break;
                case R.styleable.DelEdit_mMaxLength:
                    int len = a.getInt(index, -1);
                    input.setFilters(new InputFilter[]{new InputFilter.LengthFilter(len)});
                    break;
                case R.styleable.DelEdit_mShowAble:
                    mShowable = a.getBoolean(index, false);
                    break;
                case R.styleable.DelEdit_mText:
                    input.setText(a.getString(index));
                    break;
                case R.styleable.DelEdit_mTextColor:
                    input.setTextColor(a.getColor(index, Color.BLACK));
                    break;
                case R.styleable.DelEdit_mTextSize:
                    input.setTextSize(TypedValue.COMPLEX_UNIT_PX, a.getDimensionPixelSize(index, 20));
                    break;
                case R.styleable.DelEdit_mHint:
                    input.setHint(a.getString(index));
                    break;
                case R.styleable.DelEdit_mHintColor:
                    input.setHintTextColor(a.getColor(index,Color.BLACK));
                    break;
            }
        }

        a.recycle();
    }



    private AfterTextWatcher watcher = new AfterTextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            int len = s.length();
            if (len > 0) {
                imgClear.setVisibility(View.VISIBLE);
                if (!TextUtils.isEmpty(exp) && expLis != null) {
                    String str = s.toString();
                    //匹配正则并通知回调
                    expLis.onExpression(DelEdit.this, str.matches(exp));
                }
            } else {
                imgClear.setVisibility(View.INVISIBLE);
                if (expLis != null) {
                    expLis.onExpression(DelEdit.this, false);
                }
            }
        }
    };
    private OnFocusChangeListener focusChangeListener = new OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            rlRoot.setSelected(hasFocus);
            if (hasFocus) {
                if (input.getText().length() > 0) {
                    imgClear.setVisibility(View.VISIBLE);
                }
                if (mShowable) {
//                    imgShow.setTag(true);
                    imgShow.setVisibility(View.VISIBLE);
                }
            } else {
                imgClear.setVisibility(View.INVISIBLE);
//                if (mShowable)
                imgShow.setVisibility(View.INVISIBLE);

            }
        }
    };
    private OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.edit_clear:
                    input.getText().clear();
                    break;
                case R.id.edit_show:
                    boolean f = (boolean) imgShow.getTag();
                    if (f) {
                        setInputType(InputType.PASSWORD);
                        imgShow.setTag(false);
                    } else {
                        setInputType(InputType.TEXT);
                        imgShow.setTag(true);
                    }
                    break;
            }
        }
    };

    public void setInputType(InputType type) {
        switch (type) {
            case TEXT:
                input.setInputType(android.text.InputType.TYPE_CLASS_TEXT);
                break;
            case NUMBER:
                input.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
                break;
            case PASSWORD:
                input.setInputType(android.text.InputType.TYPE_CLASS_TEXT |
                        android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);
                break;
        }
    }

    public enum InputType {
        TEXT, NUMBER, PASSWORD;

        public static InputType getType(int type) {
            switch (type) {
                case 1:
                    return NUMBER;
                case 2:
                    return PASSWORD;
                default:
                    return TEXT;
            }
        }
    }
    public void setIconImageBackGround(int R){
        imgIcon.setBackgroundResource(R);
    }
    public String getText() {
        return input.getText().toString().trim();
    }

    public void setText(String text) {
        input.setText(text);
    }

    public void setText(int resId) {
        input.setText(resId);
    }

    public void setExpression(String exp, OnExpressionListener l) {
        this.exp = exp;
        this.expLis = l;
    }

    public interface OnExpressionListener {//正则验证监听

        void onExpression(DelEdit de, boolean matched);//匹配时调用，参数：是否匹配成功
    }
}
