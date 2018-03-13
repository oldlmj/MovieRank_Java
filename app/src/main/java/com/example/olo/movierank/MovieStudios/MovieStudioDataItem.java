package com.example.olo.movierank.MovieStudios;

/**
 * Created by OLO on 2018/3/1.
 */

public class MovieStudioDataItem {
    private String[] name;
    private String[] link;
    private String[] adr;
    private String msItemadr;
    private String msItemname;
    private String msItemlink;


    public void setName(String[] name){
        this.name = name;
    }

    public String[] getName(){
        return this.name;
    }

    public void setLink(String[] link){
        this.link = link;
    }

    public String[] getLink(){
        return this.link;
    }

    public void setAdr(String[] adr){
        this.adr = adr;
    }

    public String[] getAdr(){
        return this.adr;
    }
    //////////////////////////////////////////////////////////////
    public void setMSItemadr(String msItemadr){
        this.msItemadr = msItemadr;
    }

    public String getMSItemadr(){
        return this.msItemadr;
    }

    public void setMSItemName(String msItemname){
        this.msItemname = msItemname;
    }

    public String getMSItemName(){
        return this.msItemname;
    }

    public void setMSItemUrl(String msItemlink){
        this.msItemlink = msItemlink;
    }

    public String getMSItemUrl(){
        return this.msItemlink;
    }

}
