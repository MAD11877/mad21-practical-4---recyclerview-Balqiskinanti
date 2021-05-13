package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "List Activity";
    ArrayList<User>  userArray = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        userArray = initUserArray(userArray);
        initRecyclerView();
        //alert();
        Log.v(TAG, "Create");
    }
    private int getRandomInt(){
        int randomInt = new Random().nextInt();
        return randomInt;
    }
    private boolean getRandomBool(){
        boolean randomBoolean = new Random().nextBoolean();
        return randomBoolean;
    }
    public ArrayList<User> initUserArray(ArrayList<User> userArray){
        for(int i = 0; i < 20; i++){
            String randomName = "Name"+getRandomInt();
            String randomDesc = "Description:" + " " + Integer.toString(getRandomInt());
            boolean randomIsFoll = getRandomBool();
            User user = new User(randomName, randomDesc, i, randomIsFoll);
            userArray.add(user);
        }
        return userArray;
    }
    private void initRecyclerView(){
        RecyclerView listRecyclerView = findViewById(R.id.list_recycler);
        ListAdapter listAdapter = new ListAdapter(ListActivity.this,userArray);

        LinearLayoutManager listLayoutManager = new LinearLayoutManager(this);
        listRecyclerView.setLayoutManager(listLayoutManager);
        listRecyclerView.setItemAnimator(new DefaultItemAnimator());
        listRecyclerView.setAdapter(listAdapter);
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "Start");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "Resume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "Pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "Stop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "Destroy");
    }
}