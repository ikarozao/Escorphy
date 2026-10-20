package com.escorphy.app;

import android.os.Bundle;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pega a referência do WebView criado pelo Capacitor
        WebView webView = this.bridge.getWebView();

        // Define um WebChromeClient para tratar o pedido de GPS do site
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                // Permite que o site (origin) use a localização.
                // O Android ainda vai pedir a permissão real para o usuário na primeira vez.
                callback.invoke(origin, true, false);
            }
        });
    }
}