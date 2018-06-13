package com.example.emad.inventoryappp;

import android.provider.BaseColumns;

/**
 * Created by EMAD on 2/14/2018.
 */

public class InventoryContract  {



    public InventoryContract() {
    }

    public static final class InventoryEntry implements BaseColumns {

        public static final String TABLE_NAME = "stock";

        public static final String _ID = BaseColumns._ID;
        public static final String C_NAME = "name";
        public static final String C_PRICE = "price";
        public static final String C_QUANTITY = "quantity";
        public static final String C_SUPPLIER_NAME = "supplier_name";
        public static final String C_SUPPLIER_PHONE = "supplier_phone";
        public static final String C_SUPPLIER_EMAIL = "supplier_email";
        public static final String C_IMAGE = "image";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                InventoryContract.InventoryEntry.TABLE_NAME + "(" +
                InventoryContract.InventoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                InventoryContract.InventoryEntry.C_NAME + " TEXT NOT NULL," +
                InventoryContract.InventoryEntry.C_PRICE + " TEXT NOT NULL," +
                InventoryContract.InventoryEntry.C_QUANTITY + " INTEGER NOT NULL DEFAULT 0," +
                InventoryContract.InventoryEntry.C_SUPPLIER_NAME + " TEXT NOT NULL," +
                InventoryContract.InventoryEntry.C_SUPPLIER_PHONE + " TEXT NOT NULL," +
                InventoryContract.InventoryEntry.C_SUPPLIER_EMAIL + " TEXT NOT NULL," +
                InventoryEntry.C_IMAGE + " TEXT NOT NULL" + ");";
    }




}
