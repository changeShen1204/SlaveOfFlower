package com.jet.slaveofflower.datebase;

/**
 * Created by shenqianqian on 2017/5/13.
 */
public class NoteDbSchema {
    public static final class NoteTable{
        public static final String NAME="notes";
        public static final class Cols{
            public static final String UUID="uuid";
            public static final String TITLE="title";
            public static final String DATE="date";
        }
    }
}
