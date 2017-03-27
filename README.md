# InspiringPeopleAndroidApp
Android app about inspiring people in history of computing. 

Task description:
Create simple app which offers information about 3 persons in history of computing who had large influence on computing development. 
For each person application must contain person's picture, date of birth and death and short biography.
By clicking on the picture, short qoute of the person appears in a form of a Toast message.

Description of program solutions & problems:

*User interface:

*Scrollable TextViews: 
Each TextView contains text which full height is greater than the picture's height. 
In order to place a person's TextView and ImageView in a same containter of a particular width and height it was necessary to make TextView scrollable so a user can read whole biography.

Solution: 
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









