package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Sheet;
import com.example.gideonsassoon.avariel.datamodels.SheetEnum;
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
    @BindView(R.id.s_race)
    Spinner s_race;
    @BindView(R.id.s_alignment)
    Spinner s_alignment;
    @BindView(R.id.s_class)
    Spinner s_class;
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
    @BindView(R.id.tv_strength_mod)
    TextView tv_strength_mod;
    @BindView(R.id.tv_dexterity_mod)
    TextView tv_dexterity_mod;
    @BindView(R.id.tv_constitution_mod)
    TextView tv_constitution_mod;
    @BindView(R.id.tv_intelligence_mod)
    TextView tv_intelligence_mod;
    @BindView(R.id.tv_wisdom_mod)
    TextView tv_wisdom_mod;
    @BindView(R.id.tv_charisma_mod)
    TextView tv_charisma_mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        ButterKnife.bind(this);
        realmInit();

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
                if (!hasFocus) {
                    final String name = ((TextView) v).getText().toString();
                    try {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setCharacterName(name);
                            }
                        });
                    } catch (Exception e) {
                        Log.e("REALM SET C NAME ERROR", e.toString());
                    }
                }
            }
        });

        ArrayAdapter<CharSequence> raceAdapter = ArrayAdapter.createFromResource(this, R.array.race, android.R.layout.simple_spinner_dropdown_item);
        s_race.setAdapter(raceAdapter);
        s_race.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, final int position, long id) {
                Log.d(TAG, "onItemSelectedChange race: " + position);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Log.d(TAG, "onItemSelectedChange race execute " + position);
                        sheet.setRace(position);
                    }
                });

                //final String race = ((TextView) v).getText().toString();
                //final SheetEnum.Race raceEnum = SheetEnum.Race.valueOf(race.toUpperCase());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

/*          @Override
            public void onItemSelected() {

                if (!hasFocus) {

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setRace(raceEnum);
                            }
                        });

                }
            }
        });

        s_class.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange class: " + hasFocus);
                if (!hasFocus) {
                    final String classString = ((EditText) v).getText().toString();
                    final SheetEnum.Class classEnum = SheetEnum.Class.valueOf(classString.toUpperCase());


                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setPlayerClass(classEnum);
                            }
                        });

                }
            }
        });
*/
/*
        et_current_hp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange currentHP: " + hasFocus);
                if (!hasFocus) {
                    final String currentHPString = ((EditText) v).getText().toString();
                    final int currentHP = Integer.parseInt(currentHPString);

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setCurrentHitPoints(currentHP);
                            }
                        });

                }
            }
        });

        et_total_hp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange characterName: " + hasFocus);
                if (!hasFocus) {
                    final String totalHPString = ((EditText) v).getText().toString();
                    final int totalHP = Integer.parseInt(totalHPString);

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setTotalHitPoints(totalHP);
                            }
                        });

                }
            }
        });

        et_exp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange characterName: " + hasFocus);
                if (!hasFocus) {
                    final String expString = ((EditText) v).getText().toString();
                    final int exp = Integer.parseInt(expString);

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setExperiencePoint(exp);
                            }
                        });

                }
            }
        });


        et_exp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange characterName: " + hasFocus);
                if (!hasFocus) {
                    final String expString = ((EditText) v).getText().toString();
                    final int exp = Integer.parseInt(expString);

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setExperiencePoint(exp);
                            }
                        });
                }
            }
        });

*/
        playerInit();
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
        s_race.setSelection(sheet.getRaceInt());
        //s_alignment.setText(sheet.getAlignment());
        s_class.setSelection(sheet.getPlayerClassInt());
        et_current_hp.setText(String.valueOf(sheet.getCurrentHitPoints()));
        et_total_hp.setText(String.valueOf(sheet.getTotalHitPoints()));
        et_exp.setText(String.valueOf(sheet.getExperiencePoint()));

        et_strength.setText((String.valueOf(sheet.getStrengthScore())));
        et_dexterity.setText((String.valueOf(sheet.getDexterityScore())));
        et_constitution.setText((String.valueOf(sheet.getConstitutionScore())));
        et_intelligence.setText((String.valueOf(sheet.getIntelligenceScore())));
        et_wisdom.setText((String.valueOf(sheet.getWisdomScore())));
        et_charisma.setText((String.valueOf(sheet.getCharismaScore())));

        tv_strength_mod.setText((String.valueOf(sheet.getStrengthModified())));
        tv_dexterity_mod.setText((String.valueOf(sheet.getDexterityModified())));
        tv_constitution_mod.setText((String.valueOf(sheet.getCharismaModified())));
        tv_intelligence_mod.setText((String.valueOf(sheet.getIntelligenceModified())));
        tv_wisdom_mod.setText((String.valueOf(sheet.getWisdomModified())));
        tv_charisma_mod.setText((String.valueOf(sheet.getCharismaModified())));
    }
}