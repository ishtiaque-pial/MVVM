package com.pial.mvvm.core.network.response;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.JsonElement;

import static com.pial.mvvm.core.network.response.Status.ERROR;
import static com.pial.mvvm.core.network.response.Status.LOADING;
import static com.pial.mvvm.core.network.response.Status.SUCCESS;

public class ApiResponse<T> {

    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final Throwable error;

    public ApiResponse(Status status, @Nullable T data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse loading() {
        return new ApiResponse(LOADING, null, null);
    }

    public static<T> ApiResponse success(@NonNull T data) {
        return new ApiResponse(SUCCESS, data, null);
    }

    public static ApiResponse error(@NonNull Throwable error) {
        return new ApiResponse(ERROR, null, error);
    }
}
