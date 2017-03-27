# InspiringPeopleAndroidApp
Android app about inspiring people in history of computing. 

Task description:
Create simple app which offers information about 3 persons in history of computing who had large influence on computing development. 
For each person application must contain person's picture, date of birth and death and short biography.
By clicking on the picture, short qoute of the person appears in a form of a Toast message.

Description of program solutions & problems:

*User interface:

Application has one xml layout. It is vertical LinearLayout and it consists of three horizontal linear layouts.
Each horizontal layout consists of one ImageView and one TextView.

*Scrollable TextViews: 

Each TextView contains text which full height is greater than the picture's height. 
In order to place a person's TextView and ImageView in a same containter of a particular width and height it was necessary to make TextView scrollable so a user can read whole biography.

In xml define:
android:scrollbars="vertical"
android:scrollbarAlwaysDrawVerticalTrack="true"

In activity define:

private static TextView firstTextView;
this.firstTextView = (TextView) findViewById(R.id.TextView1);
this.firstTextView.setMovementMethod(new ScrollingMovementMethod());

Source:
http://stackoverflow.com/questions/1748977/making-textview-scrollable-in-android

*Class InspiringPeople:

Class InspiringPeople contains 2 string variables (attributes): text and qoute.
Class constructor receives 2 strings and sets attributes to received values. 
Class also contains get and set methods for each attribute. 


*Toast method for qoute:

In activity define:
private static ImageView firstImageView;
this.firstImageView = (ImageView) findViewById(R.id.ImageView1);
this.firstImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                displayToast(first_person.getquote());
            }
        });
private void displayToast(String message) {
      Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
}

Source: 
https://loomen.carnet.hr/pluginfile.php/768221/mod_resource/content/1/LV1%20-%20predlo%C5%BEak%20%282017%29.pdf

*Handling orientation changes:

First idea was to solve this by onConfigurationChanged method and 2 different views (portrait and landscape).

Source: https://developer.android.com/guide/topics/resources/runtime-changes.html

It was actually solved more easily by wrapping main LinearLayout in ScrollView.
Another problem appeared, and it was caused by wrapping one ScrollView in another. 
Parent ScrollView had advantage in relation to child ScrollView, so scrolling both at the time was not possible.
It is solved by Overriding onTouch method for each child ScrollView (i.e. TextView with property scrollbars="vertical") so it disallows scrolling on parent ScrollViews when user touches TextView.

firstTextView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

Source: 
http://stackoverflow.com/questions/4490821/scrollview-inside-scrollview/31182274#31182274

*Application icon:

App icon was changed in AndroidManifest.xml by declaring android:icon="@mipmap/app_icon".
6 different-size icons have been added to res/drawable.

Source: 
http://stackoverflow.com/questions/5350624/set-icon-for-android-application