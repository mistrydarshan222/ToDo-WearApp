package com.example.todoappwear.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.todoappwear.R;
import com.example.todoappwear.databinding.ActivityMainBinding;
import com.example.todoappwear.model.Task;
import com.example.todoappwear.utils.ConfirmUtils;
import com.example.todoappwear.utils.Constants;
import com.example.todoappwear.utils.TaskUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    private List<Task> mytasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        init();
    }


    private void init(){
        setLayout();
        initTask();
    }

    private void setLayout()
    {
        mainBinding.wrcViewTask.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mainBinding.wrcViewTask.setLayoutManager(mLayoutManager);
    }


    private void initTask() {
        mainBinding.addtask.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String text = v.getText().toString();
                    if (!TextUtils.isEmpty(text)) {
                        Task task = createTask(null, text);
                        updateTask(task, Constants.ACTION_ADD);
                        v.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private Task createTask(String id, String task){
        if (id == null){
            id = String.valueOf(System.currentTimeMillis());
        }
        return new Task(id, task);
    }

    private void updateTask(Task task, int action){
        if (action == Constants.ACTION_ADD){
            TaskUtils.saveTask(task, this);
            ConfirmUtils.showSavedMessage(getString( R.string.task_saved ), this);
        }
    }

    protected void onResume(){
        super.onResume();
        updateTaskAdapter();
    }

    private void updateTaskAdapter() {
        myTasks.clear();
        myTasks.addAll(TaskUtils.getAllTasks(this));
        bindAdapter();
    }


}