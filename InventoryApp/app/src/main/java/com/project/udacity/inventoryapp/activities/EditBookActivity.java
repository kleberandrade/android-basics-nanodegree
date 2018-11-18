package com.project.udacity.inventoryapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.project.udacity.inventoryapp.R;
import com.project.udacity.inventoryapp.models.Book;
import com.project.udacity.inventoryapp.providers.BookDAO;
import com.project.udacity.inventoryapp.utils.ValidatorUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressWarnings("WeakerAccess")
public class EditBookActivity extends AppCompatActivity {

    private static final String LOG_TAG = EditBookActivity.class.getSimpleName();

    public static final String EXTRA_BOOK_EDIT = "extra_book_edit";

    private Book mCurrentBook;

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
        setContentView(R.layout.activity_edit_book);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mCurrentBook = (Book) intent.getSerializableExtra(EXTRA_BOOK_EDIT);

        initializeFormWithBook();
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
            if (productPrice < Book.MIN_BOOK_PRICE_) {
                mProductPriceLayoutLabel.setError(getString(R.string.cannot_be_negative));
            } else {
                mProductPriceLayoutLabel.setError("");
            }
        }

        if (TextUtils.isEmpty(mProductQuantityField.getText())) {
            mProductQuantityLayoutLabel.setError(getString(R.string.required_field));
            resultValidate = false;
        } else {
            int productQuantity = Integer.parseInt(mProductQuantityField.getText().toString().trim());
            if (productQuantity < Book.MIN_BOOK_QUANTITY) {
                mProductQuantityLayoutLabel.setError(getString(R.string.cannot_be_negative));
            } else {
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
            if (ValidatorUtil.isValidPhoneNumber(mProductSupplierPhoneNumberField.getText().toString().trim())) {
                mProductSupplierPhoneNumberLayoutLabel.setError(getString(R.string.error_invalid_phone_number));
            } else {
                mProductSupplierPhoneNumberLayoutLabel.setError("");
            }
        }

        return resultValidate;
    }


    private void initializeFormWithBook() {
        mProductNameField.setText(mCurrentBook.getName());
        mProductPriceField.setText(String.valueOf(mCurrentBook.getPrice()));
        mProductQuantityField.setText(String.valueOf(mCurrentBook.getQuantity()));
        mProductSupplierNameField.setText(mCurrentBook.getSupplierName());
        mProductSupplierPhoneNumberField.setText(mCurrentBook.getSupplierPhoneNumber());
    }

    @OnClick(R.id.increase_quantity_button)
    public void increaseQuantityOnClick(View view) {
        mCurrentBook.setQuantity(mCurrentBook.getQuantity() + 1);
        mProductQuantityField.setText(String.valueOf(mCurrentBook.getQuantity()));
    }

    @OnClick(R.id.decrease_quantity_button)
    public void decreaseQuantityOnClick(View view) {
        if (mCurrentBook.getQuantity() > Book.MIN_BOOK_QUANTITY) {
            mCurrentBook.setQuantity(mCurrentBook.getQuantity() - 1);
            mProductQuantityField.setText(String.valueOf(mCurrentBook.getQuantity()));
        }
    }

    private void setBookByForm() {
        String productName = mProductNameField.getText().toString().trim();
        double productPrice = Double.parseDouble(mProductPriceField.getText().toString().trim());
        int productQuantity = Integer.parseInt(mProductQuantityField.getText().toString().trim());
        String supplierName = mProductSupplierNameField.getText().toString().trim();
        String supplierPhoneNumber = mProductSupplierPhoneNumberField.getText().toString().trim();

        mCurrentBook.setName(productName);
        mCurrentBook.setPrice(productPrice);
        mCurrentBook.setQuantity(productQuantity);
        mCurrentBook.setSupplierName(supplierName);
        mCurrentBook.setSupplierPhoneNumber(supplierPhoneNumber);
    }

    @OnClick(R.id.book_save_button)
    public void saveOnClick(View view) {

        if (!validateForm()) {
            Log.v(LOG_TAG, getString(R.string.form_contain_errors));
            return;
        }

        setBookByForm();

        BookDAO bookDAO = new BookDAO(this);
        bookDAO.update(mCurrentBook);
        Toast.makeText(this, R.string.success_edit_book, Toast.LENGTH_LONG).show();
        finish();
    }

    @OnClick(R.id.book_delete_button)
    public void deleteOnClick() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.message_delete_book);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                BookDAO bookDAO = new BookDAO(EditBookActivity.this);
                bookDAO.delete(mCurrentBook);
                Toast.makeText(EditBookActivity.this, R.string.confirm_delete_book, Toast.LENGTH_LONG).show();
                finish();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @OnClick(R.id.book_order_button)
    public void callSupplierOnClick(View view) {

        if (!validateForm()) {
            Log.v(LOG_TAG, getString(R.string.form_contain_errors));
            return;
        }

        Intent supplierNumberIntent = new Intent(Intent.ACTION_DIAL);
        String supplierContact = mCurrentBook.getSupplierPhoneNumber();
        supplierContact = supplierContact.replace("-","").replace("(","").replace(")","");
        supplierNumberIntent.setData(Uri.parse("tel:" + supplierContact));
        startActivity(supplierNumberIntent);
    }

}
