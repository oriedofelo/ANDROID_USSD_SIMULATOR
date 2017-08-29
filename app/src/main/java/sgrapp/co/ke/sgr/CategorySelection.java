package sgrapp.co.ke.sgr;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class CategorySelection extends Activity {
    private RecyclerView recyclerView;
    private EditText selectedOption;
    private SgrAdapter sgrAdapter;
    private EditText phoneOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_selection);
        recyclerView = (RecyclerView) findViewById(R.id.sgrOptions);
        selectedOption = (EditText)findViewById(R.id.selectedOption);
        phoneOption = (EditText)findViewById(R.id.phoneOption);
        final ArrayList<SgrItem> sgrList = new ArrayList<>();
        SgrItem item = new SgrItem();
        item.setOptionString("Business");
        item.setOption(1);
        sgrList.add(item);
        SgrItem item2 = new SgrItem();
        item2.setOptionString("Economy");
        item2.setOption(2);
        sgrList.add(item2);
        sgrAdapter = new SgrAdapter(sgrList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sgrAdapter);
        sgrAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume(){
        super.onResume();
        phoneOption.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    if(selectedOption.getText().toString().trim().contains("1")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(CategorySelection.this);
                        builder.setMessage("Business class full, please try Economy")
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.dismiss();
                                    }
                                });
                        builder.create();
                        builder.show();

                    }
                    else if(selectedOption.getText().toString().trim().contains("2")) {{
                        final ProgressDialog loading = ProgressDialog.show(CategorySelection.this,null,"USSD CODE RUNNING...",false,false);
                        RequestQueue queue = Volley.newRequestQueue(CategorySelection.this);
                        String phone = phoneOption.getText().toString();

                        String url ="http://google.com";

// Request a string response from the provided URL.
                        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        loading.dismiss();
                                        finish();
                                        // Display the first 500 characters of the response string.

                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                loading.dismiss();
                                finish();

                            }
                        });
// Add the request to the RequestQueue.
                        queue.add(stringRequest);
                    }

                    }
                    return true;
                }
                return false;
            }
        });
    }
}
