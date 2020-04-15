package com.example.gmail;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MailListView extends AppCompatActivity {
    List<MailModel> mails = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail_listview);

        mails.add(new MailModel("Nguyen van A", "This is a description"));
        mails.add(new MailModel("Tran Van B", "This is a description"));
        mails.add(new MailModel("Do Thi C", "This is a description"));
        mails.add(new MailModel("This is a name", "This is a description"));
        mails.add(new MailModel("This is a name", "This is a description"));
        mails.add(new MailModel("This is a name", "This is a description"));
        mails.add(new MailModel("This is a name", "This is a description"));
        mails.add(new MailModel("This is a name", "This is a description"));
        mails.add(new MailModel("This is a name", "This is a description"));
        mails.add(new MailModel("This is a name", "This is a description"));
        mails.add(new MailModel("This is a name", "This is a description"));
        mails.add(new MailModel("This is a name", "This is a description"));
        mails.add(new MailModel("This is a name", "This is a description"));
        mails.add(new MailModel("Pham Van Z", "This is a description"));

        MailListAdapter adapter = new MailListAdapter(mails);
        ListView listView = findViewById(R.id.mail_list);
        listView.setAdapter(adapter);
    }
}
