package hr.ferit.mdudjak.inspiringpeople;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static TextView firstTextView;
    private static TextView secondTextView;
    private static TextView thirdTextView;
    private static ImageView firstImageView;
    private static ImageView secondImageView;
    private static ImageView thirdImageView;


    InspiringPeople first_person;
    InspiringPeople second_person;
    InspiringPeople third_person;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
    }

    public void initializeUI() {
        this.firstTextView = (TextView) findViewById(R.id.TextView1);
        this.secondTextView = (TextView) findViewById(R.id.TextView2);
        this.thirdTextView = (TextView) findViewById(R.id.TextView3);

        this.firstImageView = (ImageView) findViewById(R.id.ImageView1);
        this.secondImageView = (ImageView) findViewById(R.id.ImageView2);
        this.thirdImageView = (ImageView) findViewById(R.id.ImageView3);

        this.firstTextView.setMovementMethod(new ScrollingMovementMethod());
        this.secondTextView.setMovementMethod(new ScrollingMovementMethod());
        this.thirdTextView.setMovementMethod(new ScrollingMovementMethod());

        firstTextView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        secondTextView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        thirdTextView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        first_person = new InspiringPeople(getResources().getString(R.string.firstman), getResources().getString(R.string.firstman_quote));
        second_person = new InspiringPeople(getResources().getString(R.string.secondman),getResources().getString(R.string.secondman_quote));
        third_person = new InspiringPeople(getResources().getString(R.string.thirdman),getResources().getString(R.string.thirdman_quote));

        /*Moglo se samo definirati 3 objekta za svaku klasu, pa pomoću set metoda postaviti varijable text i quote, ali izabrao sam konstruktor.
         Mislim da je krajnji rezultat jednak. */


        this.firstImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                displayToast(first_person.getquote());
            }
        });

        this.secondImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                displayToast(second_person.getquote());
            }
        });

        this.thirdImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                displayToast(third_person.getquote());
            }
        });
    }

    private void displayToast(String message) {
       Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
  }

}

