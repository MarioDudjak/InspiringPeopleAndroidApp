package hr.ferit.mdudjak.inspiringpeople;

/**
 * Created by Mario on 20.3.2017..
 */

public class InspiringPeople {
    private String text;
    private String quote;

    InspiringPeople(String s1,String s2){
        text=s1;
        quote=s2;
    }
    public  String gettext(){
        return this.text;
    }
    public  void settext(String s){
        this.text=s;
    }
    public String getquote(){
        return this.quote;
    }
    public void setqoute(String s){
        this.quote=s;
    }
}

