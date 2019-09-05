package com.anderson.myapplication.ui.generic;

import androidx.annotation.LayoutRes;

public interface GenericLayouter {
    @LayoutRes
    int getLayout();
    void initialize();
}
