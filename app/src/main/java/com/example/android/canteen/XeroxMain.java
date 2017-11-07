package com.example.android.canteen;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;

import static com.example.android.canteen.LoginActivity.MY_PREFS_NAME;

public class XeroxMain extends AppCompatActivity {
    int quantity = 1;
    int value = 1;
    int price=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xerox_main);
    }
    /**
     * This method is called when the plus button is clicked.
     */
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
    public void submitOrder(View view) {


        displayPrice(quantity * value);
         price=quantity*value;
        String priceMessage= "cost=Rs" + price + "\n";
        priceMessage=priceMessage+"thankyou";
        displayMessage(priceMessage);


        if(quantity>0)
        {
            String order= "pages="+quantity;
            displayMessage11(order);
        }


        if(value>0)
        {
            String order= "copies="+quantity;
            displayMessage12(order);
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
    private void displayMessage11(String message) {
        TextView billTextView = (TextView) findViewById(R.id.order1);

        billTextView.setText(message);
    }
    private void displayMessage12(String message) {
        TextView billTextView = (TextView) findViewById(R.id.order2);

        billTextView.setText(message);
    }


    public void proceed1(View view)
    {

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

    String    name1 = prefs.getString("name2","rob");



            String name=name1;
            int pages=quantity;
            int copies=value;
            int cost=price;







                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(XeroxMain.this, Options.class);
                                XeroxMain.this.startActivity(intent);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                XeroxDb registerRequest = new XeroxDb(name, pages,copies,cost, responseListener);
                RequestQueue queue = Volley.newRequestQueue(XeroxMain.this);
                queue.add(registerRequest);
            }
    }
    




