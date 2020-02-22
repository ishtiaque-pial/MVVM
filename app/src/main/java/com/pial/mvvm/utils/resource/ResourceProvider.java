package com.pial.mvvm.utils.resource;

import android.content.Context;

import javax.inject.Inject;

public class ResourceProvider implements ResourceService{
    private Context context;

    @Inject
    public ResourceProvider(Context context) {
        this.context = context;
    }

    @Override
    public String getString(int resourceIdentifier) {
        return context.getResources().getString(resourceIdentifier);
    }
}
