package com.mvp.yetanothermvplibrary.view;

/**
 * Created by grishberg on 09.10.16.
 */
public abstract class ViewCommand<View extends MvpView> {
    private final String mTag;

    protected ViewCommand(final String tag) {
        this.mTag = tag;
    }

    public abstract void apply(View var1);

    public String getTag() {
        return this.mTag;
    }
}

