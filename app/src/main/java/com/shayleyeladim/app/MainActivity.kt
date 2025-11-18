package com.shayleyeladim.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private val websiteUrl = "https://shayleyeladim.org.il/%D7%A0%D7%95%D7%A9%D7%90%D7%99%D7%9D-%D7%A8%D7%90%D7%A9%D7%99%D7%99%D7%9D/%D7%A4%D7%A8%D7%A9%D7%AA-%D7%94%D7%A9%D7%91%D7%95%D7%A2.html"

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)

        // Configure WebView settings
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            setSupportZoom(true)
            builtInZoomControls = true
            displayZoomControls = false
            loadWithOverviewMode = true
            useWideViewPort = true
            allowFileAccess = true
            allowContentAccess = true
        }

        // Set WebViewClient to handle page navigation
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                // Allow navigation within the same domain
                url?.let {
                    if (it.contains("shayleyeladim.org.il")) {
                        view?.loadUrl(it)
                        return true
                    }
                }
                return false
            }
        }

        // Set WebChromeClient for better browser functionality
        webView.webChromeClient = WebChromeClient()

        // Load the website
        webView.loadUrl(websiteUrl)
    }

    // Handle back button to navigate through web history
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        webView.restoreState(savedInstanceState)
    }
}
