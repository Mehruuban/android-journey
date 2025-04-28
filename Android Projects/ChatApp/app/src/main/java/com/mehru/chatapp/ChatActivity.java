package com.mehru.chatapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.mehru.chatapp.Adapter.ChatRecyclerAdapter;
import com.mehru.chatapp.Utils.AndroidUtil;
import com.mehru.chatapp.Utils.FirebaseUtils;
import com.mehru.chatapp.model.ChatMessageModel;
import com.mehru.chatapp.model.ChatRoomModel;
import com.mehru.chatapp.model.UserModel;

import java.util.Arrays;

public class ChatActivity extends AppCompatActivity {
    String chatRoomId;

    UserModel otherUser;
    TextView profileUserName;
    EditText messageChatInput;
    ImageButton messageSendBtn;

    ImageView backBtn;
    RecyclerView recyclerView ;

    ChatRoomModel chatRoomModel ;
    ChatRecyclerAdapter adapter ;
    ImageView imageView ;
    Context context ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat);

        otherUser = AndroidUtil.getUserModelFromIntent(getIntent());
        chatRoomId = FirebaseUtils.getChatRoomId(FirebaseUtils.currentUserId(),otherUser.getUserId());

        backBtn = findViewById(R.id.backbtn);
        messageSendBtn = findViewById(R.id.message_send_btn);
        messageChatInput =findViewById(R.id.message_chat_input);
        profileUserName = findViewById(R.id.profile_userName);
        recyclerView = findViewById(R.id.chat_recycler_view);
        imageView = findViewById(R.id.profile_pic_imageView);


        FirebaseUtils.getOtherProfilePicStorageReference(otherUser.getUserId()).getDownloadUrl()
                .addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()){
                            Uri uri = task.getResult();AndroidUtil.setProfilePic(context,uri,imageView);
                        }
                    }
                });

        profileUserName.setText(otherUser.getUserName());

        backBtn.setOnClickListener(v -> {
            onBackPressed();
       });

        messageSendBtn.setOnClickListener(v -> {
            String message = messageChatInput.getText().toString().trim();
            if (message.isEmpty())
                return;
            sendMessageToUser(message);
        });
        setUpChatRecyclerView();
       getOrCreateChatRoomModel();

    }

    void setUpChatRecyclerView(){
        Query query =FirebaseUtils.getChatRoomMessageReference(chatRoomId)
                .orderBy("timestamp",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<ChatMessageModel> options = new FirestoreRecyclerOptions.Builder<ChatMessageModel>()
                .setQuery(query,ChatMessageModel.class).build();

        adapter = new ChatRecyclerAdapter(options,getApplicationContext());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setReverseLayout(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.startListening();
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                recyclerView.smoothScrollToPosition(0);
            }
        });
    }
    void sendMessageToUser(String message){

        chatRoomModel.setLastMessageTimeStamp(Timestamp.now());
        chatRoomModel.setLastMessageSender(FirebaseUtils.currentUserId());
        chatRoomModel.setLastMessage(message);
        FirebaseUtils.getChatRoomReference(chatRoomId).set(chatRoomModel);
        ChatMessageModel chatMessageModel = new ChatMessageModel(message,FirebaseUtils.currentUserId(),Timestamp.now());

        FirebaseUtils.getChatRoomMessageReference(chatRoomId).add(chatMessageModel)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()){
                            messageChatInput.setText("");
                        }

                    }
                });
    }

    void getOrCreateChatRoomModel(){
        FirebaseUtils.getChatRoomReference(chatRoomId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    chatRoomModel = task.getResult().toObject(ChatRoomModel.class);

                    if (chatRoomModel==null){
                        // if chatting first time
                        chatRoomModel =  new ChatRoomModel(
                                chatRoomId,
                                Arrays.asList(FirebaseUtils.currentUserId(),otherUser.getUserId()),
                                Timestamp.now(),
                                ""
                        );
                        FirebaseUtils.getChatRoomReference(chatRoomId).set(chatRoomModel);
                    }
                }
            }
        });
    }
}