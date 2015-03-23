package com.cogniance.logoanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends Activity {

    //constants for the ID of the menu items
    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_TRANSLATE_ID = 3;
    final int MENU_ROTATE_ID = 4;
    final int MENU_COMBO_ID = 5;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        imageView = (ImageView) findViewById(R.id.logo);
        //register context menu for imageView
        registerForContextMenu(imageView);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v.getId() == R.id.logo) {
                //add menu items
                menu.add(0, MENU_ALPHA_ID, 0, "alpha");
                menu.add(0, MENU_SCALE_ID, 0, "scale");
                menu.add(0, MENU_TRANSLATE_ID, 0, "translate");
                menu.add(0, MENU_ROTATE_ID, 0, "rotate");
                menu.add(0, MENU_COMBO_ID, 0, "combo");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public boolean onContextItemSelected(MenuItem item) {
        Animation anim = null;
        //define which item is clicked
        if (item.getItemId() == MENU_ALPHA_ID) {
            anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        } else if (item.getItemId() == MENU_SCALE_ID) {
            anim = AnimationUtils.loadAnimation(this, R.anim.scale);
        } else if (item.getItemId() == MENU_TRANSLATE_ID) {
            anim = AnimationUtils.loadAnimation(this, R.anim.trans);
        } else if (item.getItemId() == MENU_ROTATE_ID) {
            anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        } else if (item.getItemId() == MENU_COMBO_ID) {
            anim = AnimationUtils.loadAnimation(this, R.anim.combo);
        }
        //run animation for imageView
        imageView.startAnimation(anim);
        return super.onContextItemSelected(item);
    }
}
