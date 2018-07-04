package dem.bar.app.bottomappbardem;

import android.content.Context;
import android.os.Bundle;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BottomAppBar bottomAppBar;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomAppBar = findViewById(R.id.bar);
        fab = findViewById(R.id.fab);

        setSupportActionBar(bottomAppBar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater()
                .inflate(R.menu.bottom_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                new BottomNavigationDrawerFragment().show(getSupportFragmentManager(), "menu");
                break;

            case R.id.action_update:
                toast(this, "Refresh");
                bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                fab.setImageResource(R.drawable.ic_add);
                break;

            case R.id.action_rate:
                bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
                fab.setImageResource(R.drawable.ic_settings);
                toast(this, "Rate");
                break;

            case R.id.action_settings:
                toast(this, "Settings");
                break;

        }

        return true;

    }

    public void toast(Context context, String message){

        Toast toast = Toast.makeText(context,message,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,365);
        toast.show();

    }

}
