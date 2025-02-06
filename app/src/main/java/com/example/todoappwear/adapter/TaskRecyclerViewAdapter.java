package com.example.todoappwear.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoappwear.databinding.TaskRowBinding;
import com.example.todoappwear.model.Task;
import com.example.todoappwear.utils.TaskUtils;

import java.util.List;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bindview(mTasks.get(position).getTaskDetails(),position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private List<Task> mTasks;
    Context context;

    public TaskRecyclerViewAdapter(List<Task> taskList, Context objContext){
        super();
        this.mTasks = taskList;
        this.context = objContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        TaskRowBinding taskRowBinding = TaskRowBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(taskRowBinding);
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TaskRowBinding recycleRowBinding ;
        public ViewHolder(TaskRowBinding taskRowBinding) {
            super(taskRowBinding.getRoot());
            this.recycleRowBinding = taskRowBinding ;
        }

        void bindview(final String taskdetails, final int position){
            recycleRowBinding.txtTask.setText(taskdetails);
        }
    }
}
