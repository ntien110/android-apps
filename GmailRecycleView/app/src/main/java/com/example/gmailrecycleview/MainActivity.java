package com.example.GmailRecycleView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GmailRecycleView.adapter.MailItemAdapter;
import com.example.GmailRecycleView.model.MailItemModel;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {
    List<MailItemModel> mails = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_recycleview);
        for (int i = 0; i < 20; i++) {
            Faker faker = new Faker("vi");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
            String strDate = formatter.format(faker.time.backward(100));
            mails.add(new MailItemModel(faker.name.name(), faker.lorem.sentence(), faker.lorem.paragraph(), strDate));
        }
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        Button button = findViewById(R.id.btn_favorite);
        final boolean[] statusBtn = {false};
        SearchView searchView = findViewById(R.id.edit_search);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<MailItemModel> emails;
                if (!statusBtn[0]) {
                    emails = mails.stream().filter(MailItemModel::isFavorite).collect(Collectors.toList());
                    statusBtn[0] = true;
                    System.out.println(emails);
                } else {
                    emails = mails;
                    statusBtn[0] = false;
                }
                MailItemAdapter adapter = new MailItemAdapter(emails);
                recyclerView.setAdapter(adapter);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String str) {
                List<MailItemModel> emails;
                if (str.length() > 2) {
                    emails = mails.stream().filter(item -> item.getName().toLowerCase().contains(str.toLowerCase())).collect(Collectors.toList());
                } else {
                    emails = mails;
                }
                MailItemAdapter adapter = new MailItemAdapter(emails);
                recyclerView.setAdapter(adapter);
                return true;
            }
        });
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MailItemAdapter adapter = new MailItemAdapter(mails);
        recyclerView.setAdapter(adapter);
    }
}
