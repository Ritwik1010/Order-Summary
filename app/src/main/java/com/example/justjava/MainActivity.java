package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView quantity;
    private TextView price;
    private CheckBox hascream;
    private CheckBox haschoco;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = findViewById(R.id.quantity);
        price = findViewById(R.id.price);
        hascream = findViewById(R.id.cream);
        haschoco = findViewById(R.id.choco);
        name = findViewById(R.id.nametext);
    }
    boolean whippedcreamhas = false;
    boolean chocolatehas = false;
    int fixed_price = 5;
    int whipped_price = 1;
    int chocolate_price = 2;
    String nameis;
    public void increment(View view)
    {
        String a = quantity.getText().toString();
        int n=Integer.parseInt(a)+1;
        if(n<101)
        quantity.setText(""+n);
    }

    public void decrement(View view)
    {
        String a = quantity.getText().toString();
        int n=Integer.parseInt(a)-1;
        if (n>-1)
        {quantity.setText(""+n);}
    }
    public void calculate(View view)
    {
        String a = quantity.getText().toString();
        int number_of_quantity=Integer.parseInt(a);
        display(number_of_quantity);
    }

    public void display(int number)
    {
        whippedcreamhas = hascream.isChecked();
        chocolatehas= haschoco.isChecked();
        nameis = name.getText().toString();
        int totalprice = fixed_price;
        if(chocolatehas==true)
            totalprice = totalprice+chocolate_price;
        if(whippedcreamhas==true)
            totalprice = totalprice+whipped_price;
        price.setText("Name:"+nameis+"\nHAS WHIPPED CREAM:"+whippedcreamhas+"\nHAS CHOCOLATE:"+chocolatehas+"\nTotal:"+NumberFormat.getCurrencyInstance().format(number*totalprice)+"\nThank You");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL,getString(R.string.emailid));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject));
        intent.putExtra(Intent.EXTRA_TEXT, "Name:"+nameis+"\nHAS WHIPPED CREAM:"+whippedcreamhas+"\nHAS CHOCOLATE:"+chocolatehas+"\nTotal:"+NumberFormat.getCurrencyInstance().format(number*totalprice)+"\nThank You");

        startActivity(Intent.createChooser(intent, "Send Email"));
    }
}