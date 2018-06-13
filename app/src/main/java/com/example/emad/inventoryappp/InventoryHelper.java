package com.example.emad.inventoryappp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by EMAD on 2/14/2018.
 */

public class InventoryHelper extends SQLiteOpenHelper {


    public final static String DB_NAME = "inventorydata.db";
    public final static int DB_VERSION = 1;
    public final static String LOG_TAG = InventoryContract.class.getCanonicalName();

    public InventoryHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(InventoryContract.InventoryEntry.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertingItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.C_NAME, item.getProductName());
        values.put(InventoryContract.InventoryEntry.C_PRICE, item.getPrice());
        values.put(InventoryContract.InventoryEntry.C_QUANTITY, item.getQuantity());
        values.put(InventoryContract.InventoryEntry.C_SUPPLIER_NAME, item.getSupplierName());
        values.put(InventoryContract.InventoryEntry.C_SUPPLIER_PHONE, item.getSupplierPhone());
        values.put(InventoryContract.InventoryEntry.C_SUPPLIER_EMAIL, item.getSupplierEmail());
        values.put(InventoryContract.InventoryEntry.C_IMAGE, item.getImage());
        long id = db.insert(InventoryContract.InventoryEntry.TABLE_NAME, null, values);

    }

    public Cursor readingAllProducts() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                InventoryContract.InventoryEntry._ID,
                InventoryContract.InventoryEntry.C_NAME,
                InventoryContract.InventoryEntry.C_PRICE,
                InventoryContract.InventoryEntry.C_QUANTITY,
                InventoryContract.InventoryEntry.C_SUPPLIER_NAME,
                InventoryContract.InventoryEntry.C_SUPPLIER_PHONE,
                InventoryContract.InventoryEntry.C_SUPPLIER_EMAIL,
                InventoryContract.InventoryEntry.C_IMAGE
        };
        Cursor cursor = db.query(
                InventoryContract.InventoryEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    public Cursor readingOneItem(long itemId) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                InventoryContract.InventoryEntry._ID,
                InventoryContract.InventoryEntry.C_NAME,
                InventoryContract.InventoryEntry.C_PRICE,
                InventoryContract.InventoryEntry.C_QUANTITY,
                InventoryContract.InventoryEntry.C_SUPPLIER_NAME,
                InventoryContract.InventoryEntry.C_SUPPLIER_PHONE,
                InventoryContract.InventoryEntry.C_SUPPLIER_EMAIL,
                InventoryContract.InventoryEntry.C_IMAGE
        };
        String selection = InventoryContract.InventoryEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(itemId) };

        Cursor cursor = db.query(
                InventoryContract.InventoryEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }

    public void updatingItem(long currentItemId, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.C_QUANTITY, quantity);
        String selection = InventoryContract.InventoryEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(currentItemId) };
        db.update(InventoryContract.InventoryEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }

    public void sellOneItem(long Id, int q) {
        SQLiteDatabase db = getWritableDatabase();
        int newq = 0;
        if (q > 0) {
            newq = q -1;
        }
        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.C_QUANTITY, newq);
        String selection = InventoryContract.InventoryEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(Id) };
        db.update(InventoryContract.InventoryEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }
}
