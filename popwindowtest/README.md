
# 注意两种显示popwindow方式的不同

     // 以下拉方式显示popupwindow ，这个直接是子控件button
     this.showAsDropDown(parent, 0, 0);

    //在最底部显示，这个也是子控件 button
    popupWindow.showAtLocation((View) v.getParent(), Gravity.AXIS_X_SHIFT | Gravity.BOTTOM, 0, 0);