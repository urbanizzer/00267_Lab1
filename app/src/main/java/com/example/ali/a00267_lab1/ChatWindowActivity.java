package com.example.ali.a00267_lab1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindowActivity extends AppCompatActivity {

    ListView ChatList;
    EditText Message;
    Button SendButton;
    Button BackButton;
    ArrayList<String> Messages;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_chat_window );

        ChatList = findViewById(R.id.chat_list);
        Message = findViewById(R.id.message);
        SendButton = findViewById(R.id.sendbutton);
        Messages = new ArrayList<>();

        final ChatAdapter messageAdapter =new ChatAdapter( this );
        ChatList.setAdapter (messageAdapter);

        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Messages.add(Message.getText().toString());
                messageAdapter.notifyDataSetChanged();
                Message.setText("");
            }
        });
        }

    private class ChatAdapter extends ArrayAdapter<String> {
        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        @Override
        public int getCount() {
            return Messages.size();
        }

        @Nullable
        @Override
        public String getItem(int position) {
            return Messages.get(position);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = ChatWindowActivity.this.getLayoutInflater();
            View result = null ;
            if(position%2 == 0) {
                result = inflater.inflate(R.layout.chat_row_incoming, null);

                TextView message = (TextView)result.findViewById(R.id.message_text_out);
                message.setText(   getItem(position)  ); // get the string at position
            }
            else{
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
                TextView message = (TextView)result.findViewById(R.id.message_text_In);
                message.setText(   getItem(position)  ); // get the string at position
            }


            return result;

        }

    }
}
