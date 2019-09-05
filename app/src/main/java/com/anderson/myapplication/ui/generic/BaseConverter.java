package com.anderson.myapplication.ui.generic;

import androidx.lifecycle.LiveData;

public interface BaseConverter<INPUT, RETURN> {

    LiveData<RETURN> convert(INPUT input);

}
