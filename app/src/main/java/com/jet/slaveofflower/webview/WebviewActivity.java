package com.jet.slaveofflower.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jet.slaveofflower.R;
import com.jet.slaveofflower.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebviewActivity extends BaseActivity {
    @BindView(R.id.webview)
    WebView webview;
    private String url;
    public static String EXTRA_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webview=(WebView)findViewById(R.id.webview);
        ButterKnife.bind(this);
        applyKitKatTranslucency();
        initData();
        initView();
    }
    private void initData(){
        Intent intent=getIntent();
        if(intent!=null){
            url=  intent.getStringExtra(EXTRA_URL);
        }
    }

    private void initView(){

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);// 支持JS
        //settings.setBuiltInZoomControls(true);// 显示放大缩小按钮
        //settings.setUseWideViewPort(true);// 支持双击放大缩小
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);


            }

            /**
             * 所有跳转的链接都在此方法中回调
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });
        webview.loadUrl(url);
    }
    @Override
    public String setActName() {
        return null;
    }


}
