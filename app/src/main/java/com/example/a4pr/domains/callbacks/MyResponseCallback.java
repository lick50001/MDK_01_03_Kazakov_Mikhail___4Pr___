package com.example.a4pr.domains.callbacks;

public interface MyResponseCallback {
    void onCompile(String result);

    void onError(String error);
}
