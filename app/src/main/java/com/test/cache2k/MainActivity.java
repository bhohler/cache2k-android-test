package com.test.cache2k;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import org.cache2k.Cache;
import org.cache2k.Cache2kBuilder;

public class MainActivity extends AppCompatActivity {

  private static final Cache<String, String> cache =
      new Cache2kBuilder<String, String>() {}.name("test").eternal(true).entryCapacity(100).build();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    cache.put("key", "test value");

    TextView textView = findViewById(R.id.textview);
    textView.setText("Value from cache: " + cache.get("key"));
  }
}
