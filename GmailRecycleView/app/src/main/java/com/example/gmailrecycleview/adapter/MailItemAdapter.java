package com.example.GmailRecycleView.adapter;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GmailRecycleView.R;
import com.example.GmailRecycleView.model.MailItemModel;

import java.util.List;
import java.util.Random;

public class MailItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MailItemModel> mails;

    public MailItemAdapter(List<MailItemModel> mails) {
        this.mails = mails;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_item, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmailViewHolder viewHolder = (EmailViewHolder) holder;

        MailItemModel item = mails.get(position);

        viewHolder.textLetter.setText(item.getName().substring(0, 1));
        viewHolder.textName.setText(item.getName());
        viewHolder.textSubject.setText(item.getTitle());
        viewHolder.textTime.setText(item.getTime());
        viewHolder.textContent.setText(item.getContent());

        if (item.isFavorite())
            viewHolder.imageFavorite.setImageResource(R.drawable.ic_star);
        else
            viewHolder.imageFavorite.setImageResource(R.drawable.ic_star_border);
    }

    @Override
    public int getItemCount() {
        return mails.size();
    }

    class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView textLetter;
        TextView textName;
        TextView textTime;
        ImageView imageFavorite;
        TextView textSubject;
        TextView textContent;


        EmailViewHolder(@NonNull View itemView) {
            super(itemView);

            textLetter = itemView.findViewById(R.id.txt_letter);
            textName = itemView.findViewById(R.id.txt_name);
            textTime = itemView.findViewById(R.id.txt_time);
            textSubject = itemView.findViewById(R.id.txt_subject);
            imageFavorite = itemView.findViewById(R.id.image_favorite);
            textContent = itemView.findViewById(R.id.txt_content);


            Random random = new Random();
            Drawable background = textLetter.getBackground();
            background.setColorFilter(new PorterDuffColorFilter(random.nextInt(), PorterDuff.Mode.SRC_ATOP));

            imageFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isFavorite = mails.get(getAdapterPosition()).isFavorite();
                    mails.get(getAdapterPosition()).setFavorite(!isFavorite);
                    notifyDataSetChanged();
                }
            });
        }
    }
}
