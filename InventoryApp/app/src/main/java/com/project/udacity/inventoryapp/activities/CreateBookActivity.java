package com.project.udacity.inventoryapp.activities;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.project.udacity.inventoryapp.R;
import com.project.udacity.inventoryapp.models.Book;
import com.project.udacity.inventoryapp.providers.BookDAO;
import com.project.udacity.inventoryapp.utils.ValidatorUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("WeakerAccess")
public class CreateBookActivity extends AppCompatActivity {

    private static final String LOG_TAG = CreateBookActivity.class.getSimpleName();

    @BindView(R.id.product_name)
    EditText mProductNameField;

    @BindView(R.id.product_price)
    EditText mProductPriceField;

    @BindView(R.id.product_quantity)
    EditText mProductQuantityField;

    @BindView(R.id.supplier_name)
    EditText mProductSupplierNameField;

    @BindView(R.id.supplier_phone_number)
    EditText mProductSupplierPhoneNumberField;

    @BindView(R.id.layout_product_name)
    TextInputLayout mProductNameLayoutLabel;

    @BindView(R.id.layout_product_price)
    TextInputLayout mProductPriceLayoutLabel;

    @BindView(R.id.layout_product_quantity)
    TextInputLayout mProductQuantityLayoutLabel;

    @BindView(R.id.layout_supplier_name)
    TextInputLayout mProductSupplierNameLayoutLabel;

    @BindView(R.id.layout_supplier_phone_number)
    TextInputLayout mProductSupplierPhoneNumberLayoutLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book);
        ButterKnife.bind(this);
    }

    private boolean validateForm() {
        boolean resultValidate = true;

        if (TextUtils.isEmpty(mProductNameField.getText())) {
            mProductNameLayoutLabel.setError(getString(R.string.required_field));
            resultValidate = false;
        } else {
            mProductNameLayoutLabel.setError("");
        }

        if (TextUtils.isEmpty(mProductPriceField.getText())) {
            mProductPriceLayoutLabel.setError(getString(R.string.required_field));
            resultValidate = false;
        } else {
            double productPrice = Double.parseDouble(mProductPriceField.getText().toString().trim());
            if (productPrice < Book.MIN_BOOK_PRICE_){
                mProductPriceLayoutLabel.setError(getString(R.string.cannot_be_negative));
            }
            else {
                mProductPriceLayoutLabel.setError("");
            }
        }

        if (TextUtils.isEmpty(mProductQuantityField.getText())) {
            mProductQuantityLayoutLabel.setError(getString(R.string.required_field));
            resultValidate = false;
        } else {
            int productQuantity = Integer.parseInt(mProductQuantityField.getText().toString().trim());
            if (productQuantity < Book.MIN_BOOK_QUANTITY){
                mProductQuantityLayoutLabel.setError(getString(R.string.cannot_be_negative));
            }
            else {
                mProductQuantityLayoutLabel.setError("");
            }
        }

        if (TextUtils.isEmpty(mProductSupplierNameField.getText())) {
            mProductSupplierNameLayoutLabel.setError(getString(R.string.required_field));
            resultValidate = false;
        } else {
            mProductSupplierNameLayoutLabel.setError("");
        }

        if (TextUtils.isEmpty(mProductSupplierPhoneNumberField.getText())) {
            mProductSupplierPhoneNumberLayoutLabel.setError(getString(R.string.required_field));
            resultValidate = false;
        } else {
            if (ValidatorUtil.isValidPhoneNumber(mProductSupplierPhoneNumberField.getText().toString().trim())){
                mProductSupplierPhoneNumberLayoutLabel.setError(getString(R.string.error_invalid_phone_number));
            } else {
                mProductSupplierPhoneNumberLayoutLabel.setError("");
            }
        }

        return resultValidate;
    }

    private void insertBook() {

        if (!validateForm()) {
            Log.v(LOG_TAG, getString(R.string.form_contain_errors));
            return;
        }

        String productName = mProductNameField.getText().toString().trim();
        double productPrice = Double.parseDouble(mProductPriceField.getText().toString().trim());
        int productQuantity = Integer.parseInt(mProductQuantityField.getText().toString().trim());
        String supplierName = mProductSupplierNameField.getText().toString().trim();
        String supplierPhoneNumber = mProductSupplierPhoneNumberField.getText().toString().trim();

        Book book = new Book(productName, productPrice, productQuantity, supplierName, supplierPhoneNumber);
        BookDAO bookDAO = new BookDAO(this);

        long id = bookDAO.create(book);
        if (id <= 0) {
            Toast.makeText(this, R.string.error_insert_book_table, Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, getString(R.string.error_insert_book_table));
        } else {
            Toast.makeText(this, getString(R.string.success_insert_book_table) + id, Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, getString(R.string.success_insert_book_table) + id);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        Log.d(LOG_TAG, "Open menu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                insertBook();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
