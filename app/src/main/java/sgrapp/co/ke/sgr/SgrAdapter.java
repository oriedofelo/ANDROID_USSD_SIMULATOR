package sgrapp.co.ke.sgr;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by felix.ojiem on 8/29/2017.
 */

public class SgrAdapter extends RecyclerView.Adapter<SgrAdapter.MyViewHolder> {

    private List<SgrItem> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.optionText);
        }
    }


    public SgrAdapter(List<SgrItem> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sgr_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SgrItem movie = moviesList.get(position);
        holder.title.setText(movie.toString());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}