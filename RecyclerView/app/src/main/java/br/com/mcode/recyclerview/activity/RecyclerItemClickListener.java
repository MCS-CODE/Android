package br.com.mcode.recyclerview.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;


public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mListener;
    GestureDetector mGestureDetector;

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        View childView = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(motionEvent)){
            return true;
        }
        return false;
    }


    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }

    public interface OnItemClickListener extends AdapterView.OnItemClickListener{

        public void onItemClick(View view, int position);
        public void onLongItemlick(View view, int position);

    }

    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener){
        mListener = listener;
        mGestureDetector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && mListener != null){
                    mListener.onItemClick(child, recyclerView.getChildAdapterPosition(child));
                    return true;
                }
                return false;

            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && mListener != null){
                    mListener.onLongItemlick(child, recyclerView.getChildAdapterPosition(child));
                }
                super.onLongPress(e);
            }
        });


    }
}
