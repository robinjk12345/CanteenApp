package com.example.android.canteen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;

import static android.R.attr.password;
import static android.R.attr.value;
import static com.example.android.canteen.LoginActivity.MY_PREFS_NAME;
import static com.example.android.canteen.R.id.bRegister;
import static com.example.android.canteen.R.id.etAge;
import static com.example.android.canteen.R.id.etName;
import static com.example.android.canteen.R.id.etPassword;
import static com.example.android.canteen.R.id.etUsername;

public class ThirdScreen extends AppCompatActivity {
int j;
    public String pNamee;
    public int pPricee;
    public String name1;

          @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screen);
              SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

                  name1 = prefs.getString("name2","rob");



              final Button bproceed = (Button) findViewById(R.id.bproceed);

        TextView showCartContent    = (TextView) findViewById(R.id.showCart);

        //Get Global Controller Class object (see application tag in AndroidManifest.xml)
        final Controller aController = (Controller) getApplicationContext();

   final      int  cartSize = aController.getCart().getCartSize();

        String showString = "";

/******** Show Cart Products on screen - Start ********/

        for(int i=0;i<cartSize;i++)
        {
            //Get product details
     pNamee 	= aController.getCart().getProducts(i).getProductName();

             pPricee   	= aController.getCart().getProducts(i).getProductPrice();
            String pDisc   	= aController.getCart().getProducts(i).getProductDesc();

            showString += "\n\nProduct Name : "+pNamee+"\n"+
                    "Price : "+pPricee+"\n"+
                    "Discription : "+pDisc+""+
                    "\n -----------------------------------";

        }


        showCartContent.setText(showString);


/******** Show Cart Products on screen - End ********/
              bproceed.setOnClickListener(new View.OnClickListener() {

                  @Override
                  public void onClick(View v) {
                      for (int i = 0; i < cartSize; i++) {
                          //Get product details
                          final Controller aController = (Controller) getApplicationContext();
                          pNamee = aController.getCart().getProducts(i).getProductName();

                          pPricee = aController.getCart().getProducts(i).getProductPrice();

                          final String pName = pNamee;
                          final int pPrice = pPricee;
                          final String name12=name1;
                          Response.Listener<String> responseListener = new Response.Listener<String>() {
                              @Override
                              public void onResponse(String response) {
                                  try {
                                      JSONObject jsonResponse = new JSONObject(response);
                                      boolean success = jsonResponse.getBoolean("success");
                                      if (success) {
                                          Intent intent = new Intent(ThirdScreen.this, Options.class);
                                          ThirdScreen.this.startActivity(intent);
                                      } else {
                                          AlertDialog.Builder builder = new AlertDialog.Builder(ThirdScreen.this);
                                          builder.setMessage("Register Failed")
                                                  .setNegativeButton("Retry", null)
                                                  .create()
                                                  .show();
                                      }
                                  } catch (JSONException e) {
                                      e.printStackTrace();
                                  }
                              }
                          };

                          ThirdRequest Request = new ThirdRequest(name12,pName, pPrice, responseListener);
                          RequestQueue queue = Volley.newRequestQueue(ThirdScreen.this);
                          queue.add(Request);
                      }
                  }

              });

    }

}
