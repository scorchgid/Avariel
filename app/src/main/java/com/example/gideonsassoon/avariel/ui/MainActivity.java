package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Sheet;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import okhttp3.OkHttpClient;

public class MainActivity extends FragmentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    MainFragmentAdaptor mMainFragmentAdaptor;
    Sheet sheet;
    Realm realm;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.et_character_name)
    EditText et_character_name;
    @BindView(R.id.et_race)
    EditText et_race;
    @BindView(R.id.et_alignment)
    EditText et_alignment;
    @BindView(R.id.et_class)
    EditText et_class;
    @BindView(R.id.et_current_hp)
    EditText et_current_hp;
    @BindView(R.id.et_total_hp)
    EditText et_total_hp;
    @BindView(R.id.et_exp)
    EditText et_exp;
    @BindView(R.id.et_strength)
    EditText et_strength;
    @BindView(R.id.et_dexterity)
    EditText et_dexterity;
    @BindView(R.id.et_constitution)
    EditText et_constitution;
    @BindView(R.id.et_intelligence)
    EditText et_intelligence;
    @BindView(R.id.et_wisdom)
    EditText et_wisdom;
    @BindView(R.id.et_charisma)
    EditText et_charisma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        ButterKnife.bind(this);

        realmInit();
        playerInit();

        mMainFragmentAdaptor = new MainFragmentAdaptor(getSupportFragmentManager());
        mViewPager.setAdapter(mMainFragmentAdaptor);

        realm.where(Sheet.class).findAll().addChangeListener(new RealmChangeListener<RealmResults<Sheet>>() {
            @Override
            public void onChange(RealmResults<Sheet> sheets) {
                addPlayerToUI(sheets.first());
            }
        });

        et_character_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange characterName: " + hasFocus);
                if (hasFocus) {
                    final String name = ((TextView) v).getText().toString();
                    try {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setCharacterName(name);
                            }
                        });
                    } catch (Exception e) {
                        Log.e("REALM SET PLAYER ERROR", e.toString());
                    }
                }
            }
        });
    }

    private void playerInit() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Log.i("Avariel REALM SET", "Before create object");
                sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();
                if (sheet == null) {
                    sheet = new Sheet();
                    sheet.setSheetID(0);
                    sheet = realm.copyToRealm(sheet);
                }
                Log.i("Avariel REALM SET", "after create object");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        addPlayerToUI(sheet);
                    }
                });
            }
        });
    }

    private void realmInit() {
        /**
         * https://realm.io/docs/java/latest/#getting-started
         * http://facebook.github.io/stetho/
         * https://github.com/uPhyca/stetho-realm
         * chrome://inspect/#devices
         */
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());
        RealmInspectorModulesProvider.builder(this)
                .withFolder(getCacheDir())
                .withMetaTables()
                .withDescendingOrder()
                .withLimit(1000)
                .databaseNamePattern(Pattern.compile(".+\\.realm"))
                .build();
        Stetho.initializeWithDefaults(this);
        Realm.init(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        realm = Realm.getDefaultInstance();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (realm != null) { // guard against weird low-budget phones
            realm.close();
            realm = null;
        }
    }

    //This might in the wrong place by the errors it seems that you're inserting this before it's set up
    void addPlayerToUI(Sheet sheet) {
        et_character_name.setText(sheet.getCharacterName());
        et_race.setText(sheet.getRaceName());
        et_alignment.setText(sheet.getAlignment());
        et_class.setText(sheet.getPlayerClass().toString());
        et_current_hp.setText(String.valueOf(sheet.getCurrentHitPoints()));
        et_total_hp.setText(String.valueOf(sheet.getTotalHitPoints()));
        et_exp.setText(String.valueOf(sheet.getExperiencePoint()));
    }
}