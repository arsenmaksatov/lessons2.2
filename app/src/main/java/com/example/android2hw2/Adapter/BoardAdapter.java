package com.example.android2hw2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android2hw2.Model.BoardModel;
import com.example.android2hw2.databinding.ItemBoardBinding;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {

    public BoardAdapter(ArrayList<BoardModel> list){
        this.list = list;
    }

    ArrayList<BoardModel> list;
    @NonNull
    @Override
    public BoardAdapter.BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBoardBinding binding =
                ItemBoardBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent , false);

        return new BoardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardAdapter.BoardViewHolder holder, int position) {
     holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        ItemBoardBinding binding;

        public BoardViewHolder(@NonNull ItemBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void onBind(BoardModel boardModel) {
            binding.boardIm.setImageResource(boardModel.getImage());
            binding.descriptionTv.setText(boardModel.getDescription());
        }
    }
}
