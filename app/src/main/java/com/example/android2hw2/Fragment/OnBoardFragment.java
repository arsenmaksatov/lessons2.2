package com.example.android2hw2.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android2hw2.Adapter.BoardAdapter;
import com.example.android2hw2.MainActivity;
import com.example.android2hw2.Model.BoardModel;
import com.example.android2hw2.R;
import com.example.android2hw2.SecondActivity;
import com.example.android2hw2.databinding.FragmentOnBoardBinding;

import java.util.ArrayList;


public class OnBoardFragment extends Fragment {
    FragmentOnBoardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        setupListener();
        pagerListener();
    }

    private ArrayList<BoardModel> getBoardList() {
        ArrayList<BoardModel> list = new ArrayList<>();
        list.add(new BoardModel(R.drawable.photo1, "Экономь время"));
        list.add(new BoardModel(R.drawable.photo2, "Достигай целей"));
        list.add(new BoardModel(R.drawable.photo3, "Развивайся"));
        return list;
    }

    private void initAdapter() {
        BoardAdapter adapter = new BoardAdapter(getBoardList());
        binding.pager.setAdapter(adapter);
        binding.wormDotsIndicator.setViewPager2(binding.pager);
    }
    private void setupListener() {
        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.nextBtn.getText() == "Начинаем") {
                    Intent intent = new Intent(getActivity(),SecondActivity.class);
                    startActivity(intent);

                } else {
                    binding.pager.setCurrentItem(binding.pager.getCurrentItem() + 1);
                }
            }
        });
    }

    private void pagerListener() {
        binding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 2) {
                    binding.nextBtn.setText("Начинаем");
                } else {
                    binding.nextBtn.setText("Дальше");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }
}




