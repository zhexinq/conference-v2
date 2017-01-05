package cmu.cconfs.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cmu.cconfs.R;
import cmu.cconfs.model.parseModel.AuthorSession;

/**
 * Created by qiuzhexin on 1/5/17.
 */

public class ModeratorAdapter extends RecyclerView.Adapter<ModeratorAdapter.ViewHolder> {
    Context mContext;
    List<AuthorSession> mModerators;

    public ModeratorAdapter(Context c, List<AuthorSession> moderators) {
        mContext = c;
        mModerators = moderators;
    }

    @Override
    public ModeratorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ModeratorAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mModerators.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return mModerators.size();
    }

    // append more moderator data to the adapter
    public void appendMore(List<AuthorSession> more) {
        mModerators.addAll(more);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            itemView.setFocusableInTouchMode(true);
            itemView.setFocusable(true);
            itemView.setOnClickListener(this);
            mTextView = (TextView) itemView.findViewById(R.id.title);
        }

        @Override
        public void onClick(View v) {
            TextView text = (TextView) v.findViewById(R.id.title);
            Toast.makeText(v.getContext(), text.getText().toString() + " clicked.", Toast.LENGTH_SHORT).show();
        }
    }
}
