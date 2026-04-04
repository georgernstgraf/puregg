package de.gaffga.betterlist;

import android.view.View;

/* loaded from: classes.dex */
public interface IBetterListElementHandler<T> {
    int getListItemResourceId();

    void setupView(View view, T t);
}
