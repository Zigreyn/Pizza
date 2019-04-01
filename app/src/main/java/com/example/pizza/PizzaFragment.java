package com.example.pizza;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class  PizzaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView pizzaRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_pizza, container, false);
        String pizzaNames[] = new String[Pizza.pizzas.length];
        int pizzaImg[] = new int[Pizza.pizzas.length];

        for(int i = 0; i < Pizza.pizzas.length; i++){
            pizzaNames[i] = Pizza.pizzas[i].getName();
            pizzaImg[i] = Pizza.pizzas[i].getImageResourceId();
        }

        CaptionedImagesAdapter captionedImagesAdapter = new CaptionedImagesAdapter(pizzaNames, pizzaImg);
        pizzaRecyclerView.setAdapter(captionedImagesAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecyclerView.setLayoutManager(layoutManager);

        captionedImagesAdapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return pizzaRecyclerView;
    }
}
