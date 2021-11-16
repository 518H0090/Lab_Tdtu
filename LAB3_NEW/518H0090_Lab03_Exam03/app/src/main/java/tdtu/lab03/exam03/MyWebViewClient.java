package tdtu.lab03.exam03;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//518H0090 - Huỳnh Trần Trung Hiếu
public class MyWebViewClient extends WebViewClient {

    private String url;

    public MyWebViewClient() {
    }

    public MyWebViewClient(String url) {
        this.url = url;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

}
