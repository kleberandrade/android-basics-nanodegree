package com.project.udacity.inventoryapp.providers;

import android.provider.BaseColumns;

class DatabaseContract {

    private DatabaseContract() {
    }

    public static class BookEntry implements BaseColumns {

        private BookEntry() {
        }

        public static final String TABLE_NAME = "books";

        static final String COLUMN_PRODUCT_ID = BaseColumns._ID;
        public static final String COLUMN_PRODUCT_NAME = "product_name";
        public static final String COLUMN_PRODUCT_PRICE = "price";
        public static final String COLUMN_PRODUCT_QUANTITY = "quantity";
        public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_SUPPLIER_PHONE_NUMBER = "supplier_phone_number";

        public static final String CREATE_BOOK_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                + COLUMN_PRODUCT_PRICE + " REAL NOT NULL DEFAULT 0, "
                + COLUMN_PRODUCT_QUANTITY + " INTEGER NOT NULL DEFAULT 0, "
                + COLUMN_SUPPLIER_NAME + " TEXT NOT NULL, "
                + COLUMN_SUPPLIER_PHONE_NUMBER + " TEXT NOT NULL );";

        public static final String DROP_BOOK_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String WHERE_BOOK_ID_EQUAL = COLUMN_PRODUCT_ID + " = ? ";

        public static final String SELECT_ALL_BOOKS = "SELECT * FROM " + TABLE_NAME;

        public static final String SELECT_BOOK_BY_ID = SELECT_ALL_BOOKS + " WHERE " + WHERE_BOOK_ID_EQUAL;
    }
}
