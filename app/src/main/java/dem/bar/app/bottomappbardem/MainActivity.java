package dem.bar.app.bottomappbardem;

import android.content.Context;
import android.os.Bundle;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar bottomAppBar;
    private FloatingActionButton fab;
    private Button btn;
    private AnimationHekper animationHekper = new AnimationHekper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomAppBar = findViewById(R.id.bar);
        fab = findViewById(R.id.fab);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        fab.hide(

                                new FloatingActionButton.OnVisibilityChangedListener() {
                                    @Override
                                    public void onShown(FloatingActionButton fab) {
                                        super.onShown(fab);
                                    }

                                    @Override
                                    public void onHidden(FloatingActionButton fab) {
                                        super.onHidden(fab);

                                        toggleFabAlignment();

                                        bottomAppBar.replaceMenu(

                                                bottomAppBar.getFabAlignmentMode() == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER ?
                                                        R.menu.bottom_nav_drawer_menu_first :
                                                        R.menu.bottom_nav_drawer_menu_second

                                        );
                                        fab.setImageResource(

                                                bottomAppBar.getFabAlignmentMode() == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER ?
                                                        R.drawable.ic_add : R.drawable.triangle

                                        );

                                        fab.show();

                                    }
                                }

                        );

                        invalidateOptionsMenu();
                        bottomAppBar.setNavigationIcon(

                                bottomAppBar.getNavigationIcon() != null ? null :
                                        getDrawable(R.drawable.ic_menu)

                        );

                    }
                }

        );
    }

    private void toggleFabAlignment() {
        this.bottomAppBar.setFabAlignmentMode(bottomAppBar.getFabAlignmentMode() ^ 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater()
                .inflate(R.menu.bottom_nav_drawer_menu_first, menu);
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
                animationHekper.animateFabShow(fab);
                fab.setImageResource(R.drawable.ic_add);
                break;

            case R.id.action_rate:
                animationHekper.animateFabHide(fab);
                bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
                fab.setImageResource(R.drawable.ic_settings);
                toast(this, "Rate");
                break;

            case R.id.action_settings:
                toast(this, "Settings");
                bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                break;

        }

        return true;

    }

    public void toast(Context context, String message) {

        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 365);
        toast.show();

    }

}
