package com.project.udacity.inventoryapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project.udacity.inventoryapp.R;
import com.project.udacity.inventoryapp.activities.EditBookActivity;
import com.project.udacity.inventoryapp.models.Book;
import com.project.udacity.inventoryapp.providers.BookDAO;

import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private static final String LOG_TAG = BookAdapter.class.getSimpleName();

    private final Context mContext;
    private List<Book> mBookList;

    public BookAdapter(Context context, List<Book> bookList) {
        mContext = context;
        mBookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_book, viewGroup, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BookViewHolder bookViewHolder, int position) {
        final Book book = mBookList.get(position);

        bookViewHolder.nameText.setText(book.getName());

        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        bookViewHolder.priceText.setText(defaultFormat.format(book.getPrice()));
        bookViewHolder.quantityText.setText(String.valueOf(book.getQuantity()));
        bookViewHolder.sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = book.getQuantity();
                if (quantity > 0){
                    quantity--;
                    book.setQuantity(quantity);

                    BookDAO bookDAO = new BookDAO(mContext);
                    bookDAO.update(book);
                    notifyItemChanged(bookViewHolder.getAdapterPosition());
                } else {
                    Toast.makeText(mContext, mContext.getString(R.string.error_zero_book), Toast.LENGTH_LONG).show();
                    Log.d(LOG_TAG, mContext.getString(R.string.error_zero_book));
                }
            }
        });
        bookViewHolder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EditBookActivity.class);
                intent.putExtra(EditBookActivity.EXTRA_BOOK_EDIT, book);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }

    @SuppressWarnings("WeakerAccess")
    static class BookViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.book_name)
        TextView nameText;

        @BindView(R.id.book_price)
        TextView priceText;

        @BindView(R.id.book_quantity)
        TextView quantityText;

        @BindView(R.id.book_sell_button)
        Button sellButton;

        @BindView(R.id.book_edit_button)
        Button editButton;

        BookViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}