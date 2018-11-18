package com.project.udacity.inventoryapp.providers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.project.udacity.inventoryapp.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO implements SQLiteGenericDAO<Book> {

    private final DatabaseHelper dbHelper;

    public BookDAO(Context context) {
        this.dbHelper = DatabaseHelper.getInstance(context);
    }

    @Override
    public long create(Book book) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = getContentValues(book);

        long id = database.insert(DatabaseContract.BookEntry.TABLE_NAME, null, contentValues);
        if (id != -1) {
            book.setId(id);
            Log.e(DatabaseContract.BookEntry.TABLE_NAME, book.toString());
        }

        database.close();
        return id;
    }

    @Override
    public void update(Book book) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = getContentValues(book);
        database.update(DatabaseContract.BookEntry.TABLE_NAME, contentValues, DatabaseContract.BookEntry.WHERE_BOOK_ID_EQUAL, new String[]{String.valueOf(book.getId())});
        database.close();
    }

    @Override
    public void delete(Book book) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.delete(DatabaseContract.BookEntry.TABLE_NAME, DatabaseContract.BookEntry.WHERE_BOOK_ID_EQUAL, new String[]{String.valueOf(book.getId())});
        database.close();
    }

    @Override
    public Book searchById(long id) {

        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(DatabaseContract.BookEntry.SELECT_BOOK_BY_ID, new String[]{String.valueOf(id)});

        if (cursor != null)
            cursor.moveToNext();

        assert cursor != null;
        Book book = getItemFromCursor(cursor);

        cursor.close();
        database.close();
        return book;
    }

    @Override
    public List<Book> searchAll() {
        List<Book> bookList = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(DatabaseContract.BookEntry.SELECT_ALL_BOOKS, null);

        if (cursor.moveToFirst()) {
            do {
                Book book = getItemFromCursor(cursor);
                bookList.add(book);
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return bookList;
    }

    private Book getItemFromCursor(Cursor cursor){
        long id = Long.parseLong(cursor.getString(0));
        String name = cursor.getString(1);
        double price = cursor.getDouble(2);
        int quantity = cursor.getInt(3);
        String supplierName = cursor.getString(4);
        String supplierPhoneNumber = cursor.getString(5);

        return new Book(id, name, price, quantity, supplierName, supplierPhoneNumber);
    }

    private ContentValues getContentValues(Book book) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseContract.BookEntry.COLUMN_PRODUCT_NAME, book.getName());
        contentValues.put(DatabaseContract.BookEntry.COLUMN_PRODUCT_PRICE, book.getPrice());
        contentValues.put(DatabaseContract.BookEntry.COLUMN_PRODUCT_QUANTITY, book.getQuantity());
        contentValues.put(DatabaseContract.BookEntry.COLUMN_SUPPLIER_NAME, book.getSupplierName());
        contentValues.put(DatabaseContract.BookEntry.COLUMN_SUPPLIER_PHONE_NUMBER, book.getSupplierPhoneNumber());

        return contentValues;
    }
}