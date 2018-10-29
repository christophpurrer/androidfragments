package androidfragments.christophpurrer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            FrameLayout layout = new FrameLayout(this);
            layout.setId(View.generateViewId());
            setContentView(layout);
            getSupportFragmentManager().beginTransaction().replace(layout.getId(), new
                    SettingsFragment()).commit();
        }
    }
}
