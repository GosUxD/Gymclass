package classgym.example.com.gymclass.view;

import classgym.example.com.gymclass.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Sfd.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
