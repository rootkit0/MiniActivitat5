package com.coreservlets.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ArrayAdapter<String> gridAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getFutureAndroidVendors());
        ListView list = (ListView) findViewById(R.id.listview);
        list.setAdapter(gridAdapter);
        list.setOnItemClickListener(new ListViewClass());
    }

    private List<String> getFutureAndroidVendors() {
        String[] vendorArray = { "Acer", "Dell", "HTC", "Huawei", "Kyocera", "LG", "Motorola", "Nexus", "Samsung", "Sony Ericsson", "T-Mobile", "Neptune" };
        List<String> vendorList = Arrays.asList(vendorArray);
        Collections.shuffle(vendorList);
        return(vendorList);
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private class ListViewClass implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> grid, View selectedView, int selectedIndex, long id) {
            String selection = grid.getItemAtPosition(selectedIndex).toString();
            String message = String.format(getString(R.string.plantilla_mensaje_gridview), selection);
            showToast(message);
        }
    }
}
