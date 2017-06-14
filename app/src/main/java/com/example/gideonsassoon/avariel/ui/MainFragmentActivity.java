package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.EditText;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.database.RealmManager;
import com.example.gideonsassoon.avariel.datamodels.Player;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import io.realm.Realm;
import okhttp3.OkHttpClient;

public class MainFragmentActivity extends FragmentActivity {

    MainFragmentAdaptor mMainFragmentAdaptor;
    ViewPager mViewPager;
    Player player;
    Player newPlayer;
    Realm realm;

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

    @OnTextChanged(R.id.et_character_name)
    protected void onTextChanged(CharSequence text) {
        String name = text.toString();
        player.setName(name);

        try {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {

                    Log.i("Avariel REALM SET", "Before create object");
                    realm.copyToRealmOrUpdate(player);
                    player.setCurrentHP(37);
//                  Player.create(new Random().nextInt(), "Lola", "The Gravekeeper", "Human", "Lawful Evil", "Fighter", "A wandering Warrior", 0, 30, 0, null, null, null, null, null, null, null, null, null, 0);
                    Log.i("Avariel REALM SET", "after create object");
                }
            });
        } catch (Exception e) {
            Log.e("REALM SET PLAYER ERROR", e.toString());
        }
    }


    EditText mNameEditText = null;
    EditText mRaceEditText = null;
    EditText mAlignmentEditText = null;
    EditText mClassEditText = null;
    EditText mCurrentHPEditText = null;
    EditText mTotalHPEditText = null;
    EditText mExperiencePointsEditText = null;

    EditText mStrEditText = null;
    EditText mDexEditText = null;
    EditText mConEditText = null;
    EditText mIntEditText = null;
    EditText mWisEditText = null;
    EditText mChaEditText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

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
        RealmManager realmManager = new RealmManager(realm);
        //Search Terms for research (Android SQLite check if DB Exists)!
        newPlayer = null;
        setContentView(R.layout.activity_main_fragment);
        //mMainFragmentAdaptor = new MainFragmentAdaptor(getSupportFragmentManager(), mDbHelper);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mMainFragmentAdaptor);

        try {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Log.i("Avariel REALM SET", "Before create object");
                    player = realm.createObject(Player.class);
                    player.setCurrentHP(37);
//                  Player.create(new Random().nextInt(), "Lola", "The Gravekeeper", "Human", "Lawful Evil", "Fighter", "A wandering Warrior", 0, 30, 0, null, null, null, null, null, null, null, null, null, 0);
                    Log.i("Avariel REALM SET", "after create object");
                }
            });
        } catch (Exception e) {
            Log.e("REALM SET PLAYER ERROR", e.toString());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (realm != null) { // guard against weird low-budget phones
            realm.close();
            realm = null;
        }
    }

    //This might in the wrong play by the errors it seems that you're inserting this before it's set up
    void addPlayerToUI(Player player) {

        mNameEditText = (EditText) findViewById(R.id.et_character_name);
        mRaceEditText = (EditText) findViewById(R.id.et_race);
        mAlignmentEditText = (EditText) findViewById(R.id.et_alignment);
        mClassEditText = (EditText) findViewById(R.id.et_class);
        mCurrentHPEditText = (EditText) findViewById(R.id.et_current_hp);
        mTotalHPEditText = (EditText) findViewById(R.id.et_total_hp);
        mExperiencePointsEditText = (EditText) findViewById(R.id.et_exp);

        //TODO: Pull in Abilities table so that this information can be shown, you will need to create the abilities table.
        mStrEditText = (EditText) findViewById(R.id.et_strength);
        mDexEditText = (EditText) findViewById(R.id.et_dexterity);
        mConEditText = (EditText) findViewById(R.id.et_constitution);
        mIntEditText = (EditText) findViewById(R.id.et_intelligence);
        mWisEditText = (EditText) findViewById(R.id.et_wisdom);
        mChaEditText = (EditText) findViewById(R.id.et_charisma);

        mNameEditText.setText(player.getName());
        mRaceEditText.setText(player.getRaceName());
        mAlignmentEditText.setText(player.getAlignment());
        mClassEditText.setText(player.getPlayerClass());
        mCurrentHPEditText.setText(String.valueOf(player.getCurrentHP()));
        mTotalHPEditText.setText(String.valueOf(player.getTotalHP()));
        mExperiencePointsEditText.setText(String.valueOf(player.getExperiencePoint()));
    }

    void addPlayerToUIRealm() {
        // RealmConfiguration config = new RealmConfiguration.Builder().build();
        // realm = Realm.getDefaultInstance();


        // realm.executeTransaction();
    }
}