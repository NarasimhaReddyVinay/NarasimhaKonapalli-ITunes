package com.example.narasimhakonapalli_itunes;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class fragmentsAdapter extends FragmentStateAdapter {
    public fragmentsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new Rock();
            case 1:
                return new Classic();
            default:
                return new Pop();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
