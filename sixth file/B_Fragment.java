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
        View view = inflater.inflate(R.layout.fragment_b_, container, false);

        webView = (WebView) view.findViewById(R.id.cctvweb);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("http://192.168.35.61:8081/");

        //ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_b_, container, false);
        ///return inflater.inflate(R.layout.fragment_b_, container, false);
        Button btn = view.findViewById(R.id.button);
        Button button = view.findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:전화번호"));
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
        return view;
    }
}
