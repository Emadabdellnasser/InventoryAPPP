package com.example.emad.inventoryappp;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by EMAD on 2/14/2018.
 */

public class CursorAdapter extends android.widget.CursorAdapter {


    private final MainActivity activity;

    public CursorAdapter(MainActivity context, Cursor c) {
        super(context, c, 0);
        this.activity = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        return LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        TextView nameTextView = (TextView) view.findViewById(R.id.product_name);
        TextView quantityTextView = (TextView) view.findViewById(R.id.product_Quantity);
        TextView priceTextView = (TextView) view.findViewById(R.id.product_price);
        Button btsale= (Button) view.findViewById(R.id.button_sale);
        ImageView image = (ImageView) view.findViewById(R.id.imagespace);

        String name = cursor.getString(cursor.getColumnIndex(InventoryContract.InventoryEntry.C_NAME));
        final int quantity = cursor.getInt(cursor.getColumnIndex(InventoryContract.InventoryEntry.C_QUANTITY));
        String price = cursor.getString(cursor.getColumnIndex(InventoryContract.InventoryEntry.C_PRICE));

        image.setImageURI(Uri.parse(cursor.getString(cursor.getColumnIndex(InventoryContract.InventoryEntry.C_IMAGE))));

        nameTextView.setText(name);
        quantityTextView.setText(String.valueOf(quantity));
        priceTextView.setText(price);

        final long id = cursor.getLong(cursor.getColumnIndex(InventoryContract.InventoryEntry._ID));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.clickingOnAnyItem(id);
            }
        });

        btsale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.Sale(id,
                        quantity);
            }
        });
    }

}
