package pro.mitapp.lessonfive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


    public class FragmentAdapter extends RecyclerView.Adapter<FragmentAdapter.ViewHolder>{

        LayoutInflater layoutInflater;
        List<String> list = new ArrayList();

        public FragmentAdapter(Context context){
            this.layoutInflater = LayoutInflater.from(context);
        }

        public void addTask(String title){
            this.list.add(title);
            notifyDataSetChanged();
        }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.item_text,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(FragmentAdapter.ViewHolder holder, int position) {
            holder.txtTitle.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_item);
        }
    }
    }
