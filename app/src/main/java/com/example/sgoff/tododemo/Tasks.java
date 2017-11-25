package com.example.sgoff.tododemo;

/**
 * Created by sgoff on 25-11-2017.
 */

public class Tasks {
   private int _id;
   private String _taskname;


   public void Tasks(){

   }
   public Tasks(String _taskname){
       this._taskname=_taskname;
   }

    public int get_id() {
        return _id;
    }

    public void set_taskname(String _taskname) {
        this._taskname = _taskname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_taskname() {
        return _taskname;
    }
}
