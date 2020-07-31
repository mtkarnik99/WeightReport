package com.example.weightreporter;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etWeight;
    Button btnShare,btnWhatsapp,btnEmail;
    FloatingActionButton fabDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.etWeight);
        btnShare =  findViewById(R.id.btnShare);
        btnWhatsapp = findViewById(R.id.btnWhatsapp);
        btnEmail = findViewById(R.id.btnEmail);
        fabDial  = findViewById(R.id.fabDial);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w = etWeight.getText().toString();
                if(w.length() == 0)
                {
                    Snackbar.make(v,"weight is empty",Snackbar.LENGTH_SHORT).show();
                    etWeight.requestFocus();
                    return;
                }
                Intent a = new Intent(Intent.ACTION_SEND);
                a.setType("text/plain");
                a.putExtra(Intent.EXTRA_TEXT,"my weight is " + w + "kgs");
                startActivity(a);
            }
        });

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w = etWeight.getText().toString();
                if(w.length() == 0)
                {
                    etWeight.setError("Enter valid weight");
                    etWeight.requestFocus();
                    return;
                }
                Intent a = new Intent(Intent.ACTION_SEND);
                a.setType("text/plain");
                a.setPackage("com.whatsapp");
                a.putExtra(Intent.EXTRA_TEXT,"my weight is " + w + "kgs");
                try {
                    startActivity(a);
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Download whatsapp", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w = etWeight.getText().toString();
                if(w.length() == 0)
                {
                    Toast.makeText(MainActivity.this, "enter valid weight", Toast.LENGTH_SHORT).show();
                    etWeight.requestFocus();
                    return;
                }
                Intent a = new Intent(Intent.ACTION_SENDTO);
                a.setData(Uri.parse("mailto:"+ "meet.karnik99@gmail.com"));
                a.putExtra(Intent.EXTRA_SUBJECT,"Your current weight");
                a.putExtra(Intent.EXTRA_TEXT,"my weight is " + w + "kgs");
                startActivity(a);
            }
        });

        fabDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(Intent.ACTION_DIAL);
                a.setData(Uri.parse("tel:" + "9819674681"));
                startActivity(a);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.m1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(R.id.aboutus == item.getItemId())
        {
            Toast.makeText(this, "app by MK", Toast.LENGTH_SHORT).show();
        }
        if(R.id.website == item.getItemId())
        {
            Intent a= new Intent(Intent.ACTION_VIEW);
            a.setData(Uri.parse("http://" + "www.google.com"));
            startActivity(a);
        }
        return super.onOptionsItemSelected(item);
    }
}
