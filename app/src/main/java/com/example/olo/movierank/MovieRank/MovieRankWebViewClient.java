package com.example.olo.movierank.MovieRank;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.olo.movierank.R;

/**
 * Created by OLO on 2018/2/26.
 * 啟動網頁瀏覽服務
 */

public class MovieRankWebViewClient extends Activity {


    public static final String EXTRA_NAME = "cheese_name";
    private WebView myWebView;
    private ProgressBar mProgressBar;
    private RelativeLayout rlayout;
    private String TAG = "MovieRankWebViewClient";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_webview);
        Log.d(TAG, "onCreate");

        mProgressBar = (ProgressBar ) findViewById(R.id.progressBar);
        rlayout= (RelativeLayout) findViewById(R.id.web_rl);
        myWebView = (WebView) findViewById(R.id.Web_browser);
        Intent intent = getIntent();
        String url = intent.getStringExtra(EXTRA_NAME);

        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.requestFocus();
        myWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mProgressBar.setProgress(newProgress);

            }
        });
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return super.shouldOverrideUrlLoading(view, url);
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                MovieRankWebViewClient.this.setTitle("讀取中........") ;
                super.onPageStarted(view, url, favicon);
                mProgressBar.setVisibility(View.VISIBLE);
                setProgressBarIndeterminateVisibility(true);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mProgressBar.setVisibility(View.GONE);
                setProgressBarIndeterminateVisibility(false);
            }
        });

        myWebView.loadUrl(url);



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(myWebView != null) {
            try
            {
                rlayout.removeView(myWebView);

                myWebView.removeAllViews();
                myWebView.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}





