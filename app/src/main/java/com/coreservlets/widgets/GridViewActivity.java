package com.coreservlets.widgets;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GridViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        ArrayAdapter<String> gridAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getFutureAndroidVendors());
        GridView grid = (GridView)findViewById(R.id.gridview);
        grid.setAdapter(gridAdapter);
        grid.setOnItemClickListener(new GridViewClass());
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

    private class GridViewClass implements OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> grid, View selectedView, int selectedIndex, long id) {
            String selection = grid.getItemAtPosition(selectedIndex).toString();
            String message = String.format(getString(R.string.plantilla_mensaje_gridview), selection);
            showToast(message);
        }
    }
}
