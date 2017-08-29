package sgrapp.co.ke.sgr;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private EditText selectedOption;
    private SgrAdapter sgrAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.sgrOptions);
        selectedOption = (EditText)findViewById(R.id.selectedOption);

        final ArrayList<SgrItem> sgrList = new ArrayList<>();
        SgrItem item = new SgrItem();
        item.setOptionString("Book Train");
        item.setOption(1);
        sgrList.add(item);
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
        selectedOption.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    finish();
                    Intent intent = new Intent(MainActivity.this,CategorySelection.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }
}
