package edu.fvtc.teams;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public  class Navbar {
    public static void initSettingsButton(Activity activity){

        ImageButton ibSettings = activity.findViewById(R.id.imageButtonSettings);
        setupListenerEvent(ibSettings, activity, TeamsSettingsActivity.class);
    }

    public static void initMapButton(Activity activity){

        ImageButton ibMap = activity.findViewById(R.id.imageButtonMap);
        setupListenerEvent(ibMap, activity, TeamsMapActivity.class);
    }
    public static void initListButton(Activity activity){

        ImageButton ibList = activity.findViewById(R.id.imageButtonList);
        setupListenerEvent(ibList, activity, TeamsListActivity.class);
    }
    private static void setupListenerEvent(ImageButton imageButton,
                                           Activity fromactivity,
                                           Class<?> destinationActivityClass) {

        //disable the button, one of them

        imageButton.setEnabled(fromactivity.getClass() != destinationActivityClass);


        //setup a listener
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //attempt to swhitch screens. where Iam going from and where I'm going to
                Intent intent = new Intent(fromactivity, destinationActivityClass);
                intent.addFlags((Intent.FLAG_ACTIVITY_CLEAR_TOP));
                fromactivity.startActivity(intent);
            }
        });
    }
}
