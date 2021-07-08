package com.example.home_cctv_;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;


public class B_Fragment extends Fragment {
    WebView webView;
    WebSettings webSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b_,container,false);

        webView = (WebView)view.findViewById(R.id.cctvweb);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadData("<html><head><style type='text/css'>body{margin:auto;text-align:center;}"+
                        "img{width:100%25;}div{overflow: hidden;}</style></head>"+
                        "<body><div><img src='http://192.168.35.61.8081/'/></div></body></html>",
                "text/html", "UTF-8");

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_b_, container, false);
        //return inflater.inflate(R.layout.fragment_b_, container, false);
        Button btn = rootView.findViewById(R.id.button);
        Button button = rootView.findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:112"));
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.onFragmentChanged(0);
            }
        });
        return rootView;
    }
}
