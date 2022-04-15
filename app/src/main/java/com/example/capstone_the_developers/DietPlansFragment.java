package com.example.capstone_the_developers;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;

public class DietPlansFragment extends Fragment {

    private static final String TAG = "FifthFragment";
    private CardStackLayoutManager manager;
    private CardStackAdapter adapter;
    int pos=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fifth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardStackView cardStackView = (CardStackView) view.findViewById(R.id.card_stack_view);

        manager = new CardStackLayoutManager(getActivity(), new CardStackListener() {

            @Override
            public void onCardDragging(Direction direction, float ratio) {
                Log.d(TAG, "onCardDragging: d=" + direction.name() + " ratio=" + ratio);
                if (pos==0 && direction.name().equals("Top")){
                    Intent i=new Intent(getActivity(),FirstDietPlanActivity.class);
                    startActivity(i);
                }
                if (pos==1 && direction.name().equals("Top")){
                    Intent i=new Intent(getActivity(),SecondDietPlanActivity.class);
                    startActivity(i);
                }
                if (pos==2 && direction.name().equals("Top")){
                    Intent i=new Intent(getActivity(),ThridDietPlanActivity.class);
                    startActivity(i);
                }

            }

            @Override
            public void onCardSwiped(Direction direction) {
                Log.d(TAG, "onCardSwiped: p=" + manager.getTopPosition() + " d=" + direction);

                if (manager.getTopPosition() == adapter.getItemCount() - 5){
                    paginate();
                }
            }

            @Override
            public void onCardRewound() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardCanceled() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardAppeared(View view, int position) {
//                TextView tv = view.findViewById(R.id.item_name);
               Log.d(TAG, "onCardAppeared: " + position );
               pos=position;
            }

            @Override
            public void onCardDisappeared(View view, int position) {
//                TextView tv = view.findViewById(R.id.item_name);
//                Log.d(TAG, "onCardAppeared: " + position + ", name: " + tv.getText());
            }
        });
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.FREEDOM);
        manager.setCanScrollHorizontal(true);
        manager.setSwipeableMethod(SwipeableMethod.Manual);
        manager.setOverlayInterpolator(new LinearInterpolator());
        adapter = new CardStackAdapter(addList());
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());
    }

    private void paginate() {
        List<ItemModel> oldItems = adapter.getItems();
        List<ItemModel> newItems = new ArrayList<>(addList());
        CardStackCallback callback = new CardStackCallback(oldItems, newItems);
        DiffUtil.DiffResult hasil = DiffUtil.calculateDiff(callback);
        adapter.setItems(newItems);
        hasil.dispatchUpdatesTo(adapter);
    }

    private List<ItemModel> addList() {
        List<ItemModel> items = new ArrayList<>();
        items.add(new ItemModel(R.drawable.plan1, "Diet Plan 1", "Plan 1 description", "Plan 1"));
        items.add(new ItemModel(R.drawable.plan2, "Diet Plan 2", "Plan 2 description", "Plan 2"));
        items.add(new ItemModel(R.drawable.plan3, "Diet Plan 3", "Plan 3 description", "Plan 3"));

        return items;

    }
}