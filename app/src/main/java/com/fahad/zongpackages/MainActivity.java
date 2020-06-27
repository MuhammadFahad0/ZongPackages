package com.fahad.zongpackages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.BuildConfig;

public class MainActivity extends AppCompatActivity {
    String message;
    String text;
    EditText edt;
    AlertDialog.Builder dialogBuilder;
    LayoutInflater inflater;
    View dialogView;
    AlertDialog b;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    View navHeaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout=findViewById(R.id.drawer_layout2);
        navigationView=findViewById(R.id.nav_view2);
        toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_toc_black_24dp);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.balance:
                        balance1();
                        return true;
                    case R.id.sms:
                        sms1();
                        return true;
                    case R.id.internet:
                        internet1();
                        return true;
                    case R.id.minuts:
                        minuts1();
                        return true;
                    case R.id.recharge:
                        recharge1();
                        return true;
                    case R.id.advance:
                        advance1();
                        return true;
                    case R.id.balanceshare:
                        balanceshare1();
                        return true;
                    case R.id.nav_share:
                        try {
                            Intent shareIntent = new Intent(Intent.ACTION_SEND);
                            shareIntent.setType("text/plain");
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "All Pakistan Network Packages");
                            String shareMessage= "\nCheck out this Packages App have all Latest Updates\n\n";
                            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                            startActivity(Intent.createChooser(shareIntent, "Choose one"));
                        } catch(Exception e) {
                            //e.toString();
                        }
                        return true;
                    case R.id.supportus:
                        try{
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
                        }
                        catch (ActivityNotFoundException e){
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                        }
                        return true;
                    case R.id.policy:

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/1rVNmMh_CPex20XRlzM5YEF_d9ayn-Kk7/view?usp=sharing")));
                        return true;
                    case R.id.exit:
                        onBackPressed();
                        return true;

                    default:
                        return false;
                }     }
        });

        navHeaderView = navigationView.inflateHeaderView(R.layout.headersecond);

        message = "zong";

 }


    public void all(View view) { newwcativty("ALL IN ONE"); }

    public void call(View view)
    {
        newwcativty("CALL");
    }

    public void internet(View view)
    {
        newwcativty("INTERNET");
    }

    public void band(View view)
    {
        newwcativty("BROADBAND");
    }

    public void sms(View view) { newwcativty("MESSAGE"); }

    void newwcativty(String PPosition)
    {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("Key1", message);
        intent.putExtra("Key2", PPosition);

        if( message.equals("ufone") && PPosition.equals("BROADBAND"))
        {
            Toast.makeText(this,"Sorry !! "+System.getProperty("line.separator")+" Not Available from Ufone Company",Toast.LENGTH_SHORT).show();
        }else
        {
            startActivity(intent);
        }
    }



    void balance1()
    {
                fuck("*222#");
}

    void sms1()
    {
                fuck("*102*2#");
    }

    void internet1()
    {
                fuck("*102*4#");
    }

    void minuts1()
    {
                fuck("*102*3#");
    }

    void recharge1()
    {
        dialogBuilder = new AlertDialog.Builder(this);

        dialogBuilder.setCancelable(false);
        inflater = this.getLayoutInflater();
        dialogView = inflater.inflate(R.layout.alartdailog, null);
        dialogBuilder.setView(dialogView);
        edt = dialogView.findViewById(R.id.editText);

        Button sent = dialogView.findViewById(R.id.button5);
        sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = edt.getText().toString();
                if(text.length() == 14)
                {
                            fuck("*101*"+ text +"#");

                    b.dismiss();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please Enter 14 Digit Card Number",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button cancel = dialogView.findViewById(R.id.button6);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.dismiss();
            }
        });

        b = dialogBuilder.create();
        b.show();    }

    void advance1()
    {
                fuck("*911#");
    }

    void balanceshare1()
    {
            fuck("*828#");
            Toast.makeText(getApplicationContext(),"Dial *828# \n then Enter Number \n then Amount \n then Reply 1",Toast.LENGTH_LONG).show();


    }

    void fuck(String code)
    {
        Intent out = new Intent();
        out.setAction(Intent.ACTION_DIAL);
        out.setData(Uri.parse("tel:" + Uri.encode(code)));
        startActivity(out);

    }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
