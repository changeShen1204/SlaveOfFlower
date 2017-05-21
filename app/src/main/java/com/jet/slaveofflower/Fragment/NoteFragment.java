package com.jet.slaveofflower.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.jet.slaveofflower.DatePickerFragment;
import com.jet.slaveofflower.Note;
import com.jet.slaveofflower.NoteLab;
import com.jet.slaveofflower.PictureUtils;
import com.jet.slaveofflower.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by shenqianqian on 2017/5/13.
 */
public class NoteFragment extends Fragment {
    private static final String ARG_NOTE_ID="note_id";
    private static final int REQUEST_DATE=0;
    private static final int REQUEST_CONTACT=1;
    private static final int REQUEST_PHOTO=2;
    private Note mNote;
    private File mPhotoFile;
    private EditText mTitleField;
    private Button mDateButton;
    private ImageButton mPhotoButton;
    private ImageView mPhotoView;;
    SimpleDateFormat df=new SimpleDateFormat("yyyy'-'MM'-'dd'  'HH':'mm':'ss");
    public static NoteFragment newInstance(UUID noteId){
        Bundle args=new Bundle();
        args.putSerializable(ARG_NOTE_ID, noteId);
        NoteFragment fragment=new NoteFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID noteId=(UUID)getArguments().getSerializable(ARG_NOTE_ID);
        mNote= NoteLab.get(getActivity()).getNote(noteId);
        mPhotoFile=NoteLab.get(getActivity()).getPhotoFile(mNote);
    }
    @Override
    public void onPause(){
        super.onPause();
        NoteLab.get(getActivity()).updateNote(mNote);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.fragment_note,container,false);
        mTitleField =(EditText)v.findViewById(R.id.crime_title);
        mTitleField.setText(mNote.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                mNote.setTitle(c.toString());
            }

            @Override
            public void afterTextChanged(Editable c) {
            }
        });
        mDateButton=(Button)v.findViewById(R.id.note_date);
        updateDate();
        PackageManager packageManager=getActivity().getPackageManager();
        mPhotoButton=(ImageButton)v.findViewById(R.id.note_camera);
        final Intent captureImage=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        boolean canTakePhoto=mPhotoFile!=null&&captureImage.resolveActivity(packageManager)!=null;
        mPhotoButton.setEnabled(canTakePhoto);
        if (canTakePhoto){
            Uri uri=Uri.fromFile(mPhotoFile);
            captureImage.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        }
        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(captureImage, REQUEST_PHOTO);
            }
        });
        mPhotoView=(ImageView)v.findViewById(R.id.crime_photo);
        updatePhotoView();

        return v;
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        if(resultCode!= Activity.RESULT_OK){
            return;
        }
        if(requestCode==REQUEST_DATE){
            Date date=(Date)data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mNote.setDate(date);
            updateDate();
        }else if (requestCode==REQUEST_CONTACT&& data!=null){
            Uri contactUri=data.getData();
            String[] queryFields=new String[]{
                    ContactsContract.Contacts.DISPLAY_NAME
            };
            Cursor c=getActivity().getContentResolver().query(contactUri,queryFields,null,null,null);
            try{
                if (c.getCount()==0){
                    return;
                }
                c.moveToFirst();
            }finally {
                c.close();
            }
        }else if (requestCode==REQUEST_PHOTO){
            updatePhotoView();
        }
    }
    private void updateDate() {
        mDateButton.setText(df.format(mNote.getDate()));
    }

    private void updatePhotoView(){
        if (mPhotoFile==null||!mPhotoFile.exists()){
            mPhotoView.setImageDrawable(null);
        }else{
            Bitmap bitmap= PictureUtils.getScaledBitmap(mPhotoFile.getPath(), getActivity());
            mPhotoView.setImageBitmap(bitmap);
        }
    }
}
