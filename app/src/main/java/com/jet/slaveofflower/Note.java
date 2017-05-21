package com.jet.slaveofflower;

import java.util.Date;
import java.util.UUID;

/**
 * Created by shenqianqian on 2017/5/13.
 */
public class Note {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    public Note(){
        this(UUID.randomUUID());
    }
    public Note(UUID id){
        mId=id;
        mDate=new Date();
    }
    public String getTitle(){
        return mTitle;
    }
    public void setTitle(String title){
        mTitle=title;
    }
    public Date getDate(){
        return mDate;
    }
    public void setDate(Date date){
        mDate=date;
    }
    public UUID getId(){
        return mId;
    }
    public String getPhotoFilename(){
        return "IMG_"+getId().toString()+".jpg";
    }
}
