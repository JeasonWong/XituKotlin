package me.wangyuwei.xitukotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.widget.LinearLayout
import me.wangyuwei.xitukotlin.R
import org.jetbrains.anko.find

/**
 * 作者： 巴掌 on 16/4/24 18:42
 */
class WebViewActivity : AppCompatActivity() {

    companion object {
        public val EXTRA_URL: String = "url"
    }

    private val lly_web_view: LinearLayout by lazy { find<LinearLayout>(R.id.lly_web_view) }
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView = WebView(this)
        lly_web_view.addView(webView)

        val bundle: Bundle = intent.extras

        webView.settings.setJavaScriptEnabled(true);
        webView.settings.setBuiltInZoomControls(true);
        webView.settings.setLoadWithOverviewMode(true);
        webView.settings.setDisplayZoomControls(false);
        webView.settings.setUseWideViewPort(true);
        webView.settings.setAppCacheEnabled(true);
        webView.loadUrl(bundle.getString(EXTRA_URL))
    }

    override fun onDestroy() {
        super.onDestroy()
        webView.destroy()
        lly_web_view.removeView(webView)
    }
}

