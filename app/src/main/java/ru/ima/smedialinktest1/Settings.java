package ru.ima.smedialinktest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import ru.ima.smedialinktest1.myitems.MyitemsContentProvider;
import ru.ima.smedialinktest1.myitems.MyitemsHistoryContentProvider;
import ru.ima.smedialinktest1.myitems.TextNButtonAdapter;


public class Settings extends Activity {

    private static ArrayAdapter<MyitemsContentProvider.MyListItem>  historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        ListView histList = (ListView)findViewById(R.id.settingsHistoryList);
        historyAdapter = new TextNButtonAdapter(this, MyitemsHistoryContentProvider.ITEMS);
        histList.setAdapter(historyAdapter);
    }

    public void btnOkHandler(View view) {
        try {
            String rownum = ((EditText)findViewById(R.id.rownum)).getText().toString();
            float fillRatio = Float.parseFloat(((EditText)findViewById(R.id.fillratio)).getText().toString());
            if (fillRatio<0.0f || fillRatio>1.0f){
                throw new NumberFormatException();
            }
            MyitemsContentProvider.ITEM_MAP.get(rownum).fillRatio = fillRatio;
            historyAdapter.add(MyitemsContentProvider.ITEM_MAP.get(rownum).clone());

            Toast.makeText(this,"Row "+String.valueOf(rownum)+" set to "+String.valueOf(fillRatio),Toast.LENGTH_LONG).show();
        } catch (NumberFormatException ne) {
            Toast.makeText(this,"Please enter [0..1] float value",Toast.LENGTH_LONG).show();
        } catch (Exception e){
            Toast.makeText(this,"An error has occured "+e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, TextnbtnListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        NavUtils.navigateUpTo(this, new Intent(this, TextnbtnListActivity.class));
    }
}
