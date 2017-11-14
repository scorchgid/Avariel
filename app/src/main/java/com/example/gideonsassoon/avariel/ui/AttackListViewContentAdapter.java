package com.example.gideonsassoon.avariel.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Sheet;
import com.example.gideonsassoon.avariel.datamodels.SheetEnum;
import com.example.gideonsassoon.avariel.datamodels.Weapon;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Gideon on 28/10/2017.
 */

public class AttackListViewContentAdapter extends ArrayAdapter<Weapon> {

    private static final String TAG = MainActivity.class.getSimpleName();
    private final Sheet sheet;
    private Realm realm;

    public AttackListViewContentAdapter(Context context, Sheet sheet, Realm realm, List<Weapon> weaponList) {
        super(context, 0, weaponList);
        this.sheet = sheet;
        this.realm = realm;
    }

    /*
    * GridView Adaptor is now ListView
    * As the adaptor adds views to the list, it calls getivew in order to know what to put at the view.
    * Contex is an android real core component of android.
    * A root context of an android app is the application context.
    * Each activity also has a contex. And lasts for the lifecycle of that activity
    * Accessing system services and system resources
    * Activity extends context (so it is a type of context)
    * Inflater - give me an xml and return an android view.
    * ViewGroup - an android view container. Examples are LineaLayout, RelativeLayout
     */

    @Override
    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {
        final Weapon weapon = getItem(position);
        Integer[] diceType = new Integer[]{4, 6, 8, 10, 12, 20, 100};

        if (convertView == null)
            //Because you're returning the view (AttachToRoot is false) the ArrayAdaptor (This class) will handle adding the view to the list.
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.attack_view_grid_item, parent, false);

        EditText et_name_value = (EditText) convertView.findViewById(R.id.et_name_value);
        TextView tv_attack_bonus_value = (TextView) convertView.findViewById(R.id.tv_attack_bonus_value);
        final Spinner s_damage_die_type_value = (Spinner) convertView.findViewById(R.id.s_damage_die_type_value);
        EditText et_damage_number_of_die_value = (EditText) convertView.findViewById(R.id.et_damage_number_of_die_value);
        final Spinner s_damage_type_value = (Spinner) convertView.findViewById(R.id.s_damage_type_value);
        Button b_delete_attack_spellcasting_row = (Button) convertView.findViewById(R.id.b_delete_attack_spellcasting_row);

        et_name_value.setText(weapon.getWeaponName());
        SheetEnum.Ability ability = SheetEnum.Ability.getEnumValue(weapon.getWeaponStatBonus());
        tv_attack_bonus_value.setText(String.valueOf(sheet.getAbilityBonus(ability)));

        ArrayAdapter<Integer> damageDieTypeAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, diceType);
        s_damage_die_type_value.setAdapter(damageDieTypeAdapter);
        s_damage_die_type_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, final int position, long id) {
                Log.d(TAG, "onItemSelectedChange damage die type: " + position);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        weapon.setWeaponDamageDieType(position);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<CharSequence> damageTypeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.alignment, android.R.layout.simple_spinner_dropdown_item);
        s_damage_type_value.setAdapter(damageTypeAdapter);
        s_damage_type_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, View v, final int position, long id) {
                Log.d(TAG, "onItemSelectedChange damage type: " + position);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        weapon.setWeaponDamageType(parent.getItemAtPosition(position).toString());
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        b_delete_attack_spellcasting_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weapon.deleteFromRealm();
            }
        });
        return convertView;
    }
}
