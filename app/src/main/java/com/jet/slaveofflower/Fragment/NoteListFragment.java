package com.jet.slaveofflower.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jet.slaveofflower.Note;
import com.jet.slaveofflower.NoteLab;
import com.jet.slaveofflower.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * Created by shenqianqian on 2017/5/7.
 */
public class NoteListFragment extends Fragment{
    private RecyclerView mNoteRecyclerView;
    private NoteAdapter mAdapter;
    private Button addButton;
    public UUID myId;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    SimpleDateFormat df=new SimpleDateFormat("yyyy'-'MM'-'dd'    'HH'：'mm'：'ss");
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        mNoteRecyclerView=(RecyclerView)view.findViewById(R.id.note_recycler_view);
        mNoteRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        addButton=(Button)view.findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note();
                NoteLab.get(getActivity()).addNote(note);
                updateUI();
                Intent intent = NotePagerActivity.newIntent(getActivity(), note.getId());
                startActivity(intent);

            }
        });

        return view;
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.e("a","a");
        updateUI();
    }
    public static NoteListFragment newInstance(){
        Bundle args=new Bundle();
        NoteListFragment fragment=new NoteListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public void updateUI(){
        NoteLab noteLab=NoteLab.get(getActivity());
        List<Note> notes=noteLab.getNotes();
        if(mAdapter==null){
            mAdapter=new NoteAdapter(notes);
            mNoteRecyclerView.setAdapter(mAdapter);
        }
        else{
            mAdapter.setNotes(notes);
            mAdapter.notifyDataSetChanged();
        }
    }
    private class NoteHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Note mNote;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        public NoteHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView=(TextView)itemView.findViewById(R.id.list_item_note_title_text_view);
            mDateTextView=(TextView)itemView.findViewById(R.id.list_item_note_date_text_view);
        }
        public void bindNote(Note note){
            mNote=note;
            mTitleTextView.setText(mNote.getTitle());
            mDateTextView.setText(df.format(mNote.getDate()));
        }
        @Override
        public void onClick(View v){
            Intent intent=NotePagerActivity.newIntent(getActivity(),mNote.getId());
            myId=mNote.getId();
            startActivity(intent);
        }
    }
    private class NoteAdapter extends RecyclerView.Adapter<NoteHolder>{
        private List<Note> mNotes;
        public NoteAdapter(List<Note> notes){
            mNotes=notes;
        }
        @Override
        public NoteHolder onCreateViewHolder(ViewGroup parent,int ViewType){
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            View view=layoutInflater.inflate(R.layout.list_item_note,parent,false);
            return new NoteHolder(view);
        }
        @Override
        public void onBindViewHolder(NoteHolder holder,int position){
            Note note=mNotes.get(position);
            holder.bindNote(note);
        }
        @Override
        public int getItemCount(){
            return mNotes.size();
        }
        public void setNotes(List<Note> notes){
            mNotes=notes;
        }
    }

}
