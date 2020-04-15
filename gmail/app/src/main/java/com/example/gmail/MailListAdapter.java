package com.example.gmail;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;

import java.util.List;
import java.util.Random;

public class MailListAdapter extends BaseAdapter {

    private List<MailModel> mails;

    MailListAdapter(List<MailModel> mails) {
        this.mails = mails;
    }

    @Override
    public int getCount() {
        return mails.size();
    }

    @Override
    public Object getItem(int i) {
        return mails.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mail_item, viewGroup, false);
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            viewHolder = new ViewHolder();
            viewHolder.textFullName = view.findViewById(R.id.txt_name);
            viewHolder.textDescription = view.findViewById(R.id.txt_description);
            viewHolder.textAvatar = view.findViewById((R.id.txt_avatar));
            viewHolder.textAvatar.setBackgroundColor(color);
            viewHolder.imageFavorite = view.findViewById(R.id.image_favorite);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final MailModel mail = mails.get(i);
        viewHolder.textFullName.setText(mail.getFullName());
        viewHolder.textDescription.setText(mail.getDescription());
        viewHolder.textAvatar.setText(mail.getFullName().substring(0, 1));
        if (mail.isFavorite()) {
            viewHolder.imageFavorite.setImageResource(R.drawable.ic_star_favorite);
        } else viewHolder.imageFavorite.setImageResource(R.drawable.ic_star_normal);
        viewHolder.imageFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isSelected = mails.get(i).isFavorite();
                mails.get(i).setFavorite(!isSelected);
                notifyDataSetChanged();
            }
        });
        return view;
    }

    class ViewHolder {
        TextView textFullName;
        TextView textDescription;
        ImageView imageFavorite;
        TextView textAvatar;
    }
}

