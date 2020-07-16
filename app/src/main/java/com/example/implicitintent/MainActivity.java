package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etWeb, etLoc, etShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        etWeb = findViewById(R.id.etweb);
        etLoc = findViewById(R.id.etlocname);
        etShare = findViewById(R.id.etshare);
    }

    public void onWeb(View view) {
        String url = etWeb.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }
    public void onLoc(View view) {
        String locationName = etLoc.getText().toString();
        Uri location = Uri.parse("geo:0,0?q="+locationName);
        Intent intent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(intent);

    }
    public void onShare(View view) {
        String shareText = etShare.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(shareText)
                .startChooser();
    }
}