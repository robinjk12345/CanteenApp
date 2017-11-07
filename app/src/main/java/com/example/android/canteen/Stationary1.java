package com.example.android.canteen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;

import static android.R.attr.value;
import static com.example.android.canteen.LoginActivity.MY_PREFS_NAME;

public class Stationary1 extends AppCompatActivity {
    int quantity = 0;
    int value = 0;
    int val=0;
    int price=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stationary1);



    }
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }
    public void increment1(View view) {
        value = value+ 1;
        displayValue(value);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }
    public void decrement1(View view) {
        value = value - 1;
        displayValue(value);
    }
    /**
     * This method is called when the plus button is clicked.
     */

    /**
     * This method is called when the minus button is clicked.
     */

    /**
     * This method is called when the order button is clicked.
     */
    public void increment2(View view) {
        val = val + 1;
        displayValu(val);
    }

    public void decrement2(View view) {
        val = val - 1;
        displayValu(val);
    }

    public void submitOrder(View view) {


        displayPrice(quantity*190 + value*5 + val);
         price=quantity*190 + value*5+ val;
        String priceMessage= "cost=Rs" + price + "\n";
        priceMessage=priceMessage+"thankyou";
        displayMessage(priceMessage);



        if(quantity>0)
        {
            String order= "bundle paper="+quantity;
            displayMessage11(order);
        }

        if(value>0)
        {
            String order= "hardbound=="+value;
            displayMessage22(order);
        }

        if(val>0)
        {
            String order= "sheets="+val;
            displayMessage33(order);
        }
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given value ka value on the screen.
     */
    private void displayValue(int number) {
        TextView quantiTextView = (TextView) findViewById(
                R.id.quanti_text_view);
        quantiTextView.setText("" + number);
    }

    private void displayValu(int number) {
        TextView quantiTextView = (TextView) findViewById(
                R.id.quant_text_view);
        quantiTextView.setText("" + number);
    }


    /**
     * This method displays the given price value on the screen.
     */
    private void displayPrice(int number) {
        TextView billTextView = (TextView) findViewById(R.id.bill_text_view);
        billTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView billTextView = (TextView) findViewById(R.id.bill_text_view);
        billTextView.setText(message);
    }

    private void displayMessage22(String message) {
        TextView billTextView = (TextView) findViewById(R.id.order2);
        billTextView.setText(message);
    }


    private void displayMessage33(String message) {
        TextView billTextView = (TextView) findViewById(R.id.order3);
        billTextView.setText(message);
    }

    private void displayMessage11(String message) {
        TextView billTextView = (TextView) findViewById(R.id.order1);
        billTextView.setText(message);
    }
    public void proceed2(View view)
    {

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        String    name1 = prefs.getString("name2","rob");



        String name=name1;
        int BundlePapers=quantity;
        int HardBound=value;
        int IndexGraph=val;
        int cost=price;







        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        Intent intent = new Intent(Stationary1.this, Options.class);
                       Stationary1.this.startActivity(intent);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        StatDb registerRequest = new StatDb(name, BundlePapers, HardBound, IndexGraph ,cost ,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Stationary1.this);
        queue.add(registerRequest);
    }
}



