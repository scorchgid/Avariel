package com.example.gideonsassoon.avariel.datamodels;

import android.util.Log;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by scorchgid on 03/07/17.
 */

public class Sheet extends RealmObject {
    private static final String TAG = Sheet.class.getSimpleName();
    public static final String FIELD_SHEET_ID = "sheetID";

    @PrimaryKey
    private int sheetID;

    private int strengthScore;
    private int dexterityScore;
    private int constitutionScore;
    private int intelligenceScore;
    private int wisdomScore;
    private int charismaScore;

    private int experiencePoint;

    private String playerName;
    private String characterName;
    private String background;

    private int race;
    private int playerClass;
    private int alignment;

    private int temporaryHitPoints;
    private int currentHitPoints;
    private int totalHitPoints;
    private int inspiration;
    private int successDeathSaves;
    private int failureDeathSaves;
    private boolean savingThrowStrengthProficiency;

    private boolean savingThrowDexterityProficiency;
    private boolean savingThrowConstitutionProficiency;
    private boolean savingThrowIntelligenceProficiency;
    private boolean savingThrowWisdomProficiency;
    private boolean savingThrowCharismaProficiency;

    private RealmList<Weapon> weaponList;
    private RealmList<Equipment> equipmentList;
    private RealmList<Proficiencies> proficienciesList;

    private boolean acrobaticsProficiency = false;
    private boolean animalHealingProficiency = false;
    private boolean arcanaProficiency = false;
    private boolean athleticsProficiency = false;
    private boolean deceptionProficiency = false;
    private boolean historyProficiency = false;
    private boolean insightProficiency = false;
    private boolean intimidationProficiency = false;
    private boolean investigationProficiency = false;
    private boolean medicineProficiency = false;
    private boolean natureProficiency = false;
    private boolean perceptionProficiency = false;
    private boolean performanceProficiency = false;
    private boolean persuasionProficiency = false;
    private boolean religionProficiency = false;
    private boolean sleightOfHandProficiency = false;
    private boolean stealthProficiency = false;
    private boolean survivalProficiency = false;

    private int acrobaticsProficiencyInt;
    private int animalHealingProficiencyInt;
    private int arcanaProficiencyInt;
    private int athleticsProficiencyInt;
    private int deceptionProficiencyInt;
    private int historyProficiencyInt;
    private int insightProficiencyInt;
    private int intimidationProficiencyInt;
    private int investigationProficiencyInt;
    private int medicineProficiencyInt;
    private int natureProficiencyInt;
    private int perceptionProficiencyInt;
    private int performanceProficiencyInt;
    private int persuasionProficiencyInt;
    private int religionProficiencyInt;
    private int sleightOfHandProficiencyInt;
    private int stealthProficiencyInt;
    private int survivalProficiencyInt;

    private String personalityTraits;
    private String ideals;
    private String bonds;
    private String flaws;

    private int copperCoins;
    private int silverCoins;
    private int electrumCoins;
    private int goldCoins;
    private int platinumCoins;

    private int abilityLv4;
    private int abilityLv8;
    private int abilityLv12;
    private int abilityLv16;
    private int abilityLv19;

    private int bonusLanguage;
    private int halfElfAbility1;
    private int halfElfAbility2;

    private String notes;

    public int getSheetID() {
        return sheetID;
    }

    public void setSheetID(int sheetID) {
        this.sheetID = sheetID;
    }

    public int getStrengthScore() {
        return strengthScore;
    }

    public void setStrengthScore(int strengthScore) {
        this.strengthScore = strengthScore;
    }

    public int getDexterityScore() {
        return dexterityScore;
    }

    public void setDexterityScore(int dexterityScore) {
        this.dexterityScore = dexterityScore;
    }

    public int getConstitutionScore() {
        return constitutionScore;
    }

    public void setConstitutionScore(int constitutionScore) {
        this.constitutionScore = constitutionScore;
    }

    public int getIntelligenceScore() {
        return intelligenceScore;
    }

    public void setIntelligenceScore(int intelligenceScore) {
        this.intelligenceScore = intelligenceScore;
    }

    public int getWisdomScore() {
        return wisdomScore;
    }

    public void setWisdomScore(int wisdomScore) {
        this.wisdomScore = wisdomScore;
    }

    public int getCharismaScore() {
        return charismaScore;
    }

    public void setCharismaScore(int charismaScore) {
        this.charismaScore = charismaScore;
    }

    public int getExperiencePoint() {
        return experiencePoint;
    }

    public void setExperiencePoint(int experiencePoint) {
        this.experiencePoint = experiencePoint;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public SheetEnum.Race getRace() {
        return SheetEnum.Race.getEnumValue(race);
    }

    public int getRaceInt() {
        return race;
    }

    public void setRace(SheetEnum.Race race) {
        this.race = race.getKey();
    }

    public void setRace(int race) {
        this.race = race;
    }

    public SheetEnum.Class getPlayerClass() {
        return SheetEnum.Class.getEnumValue(playerClass);
    }

    public int getPlayerClassInt() {
        return playerClass;
    }

    public void setPlayerClass(SheetEnum.Class playerClass) {
        this.playerClass = playerClass.getKey();
    }

    public void setPlayerClass(int playerClass) {
        this.playerClass = playerClass;
    }

    public int getAlignment() {
        return alignment;
    }

    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    public int getTemporaryHitPoints() {
        return temporaryHitPoints;
    }

    public void setTemporaryHitPoints(int temporaryHitPoints) {
        this.temporaryHitPoints = temporaryHitPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getTotalHitPoints() {
        return totalHitPoints;
    }

    public void setTotalHitPoints(int totalHitPoints) {
        this.totalHitPoints = totalHitPoints;
    }

    public int getInspiration() {
        return inspiration;
    }

    public void setInspiration(int inspiration) {
        this.inspiration = inspiration;
    }

    public int getSuccessDeathSaves() {
        return successDeathSaves;
    }

    public void setSuccessDeathSaves(int successDeathSaves) {
        this.successDeathSaves = successDeathSaves;
    }

    public int getFailureDeathSaves() {
        return failureDeathSaves;
    }

    public void setFailureDeathSaves(int failureDeathSaves) {
        this.failureDeathSaves = failureDeathSaves;
    }

    public boolean isSavingThrowStrengthProficiency() {
        return savingThrowStrengthProficiency;
    }

    public void setSavingThrowStrengthProficiency(boolean savingThrowStrengthProficiency) {
        this.savingThrowStrengthProficiency = savingThrowStrengthProficiency;
    }

    public boolean isSavingThrowDexterityProficiency() {
        return savingThrowDexterityProficiency;
    }

    public void setSavingThrowDexterityProficiency(boolean savingThrowDexterityProficiency) {
        this.savingThrowDexterityProficiency = savingThrowDexterityProficiency;
    }

    public boolean isSavingThrowConstitutionProficiency() {
        return savingThrowConstitutionProficiency;
    }

    public void setSavingThrowConstitutionProficiency(boolean savingThrowConstitutionProficiency) {
        this.savingThrowConstitutionProficiency = savingThrowConstitutionProficiency;
    }

    public boolean isSavingThrowIntelligenceProficiency() {
        return savingThrowIntelligenceProficiency;
    }

    public void setSavingThrowIntelligenceProficiency(boolean savingThrowIntelligenceProficiency) {
        this.savingThrowIntelligenceProficiency = savingThrowIntelligenceProficiency;
    }

    public boolean isSavingThrowWisdomProficiency() {
        return savingThrowWisdomProficiency;
    }

    public void setSavingThrowWisdomProficiency(boolean savingThrowWisdomProficiency) {
        this.savingThrowWisdomProficiency = savingThrowWisdomProficiency;
    }

    public boolean isSavingThrowCharismaProficiency() {
        return savingThrowCharismaProficiency;
    }

    public void setSavingThrowCharismaProficiency(boolean savingThrowCharismaProficiency) {
        this.savingThrowCharismaProficiency = savingThrowCharismaProficiency;
    }

    public RealmList<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(RealmList<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    public RealmList<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(RealmList<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public RealmList<Proficiencies> getProficienciesList() {
        return proficienciesList;
    }

    public void setProficienciesList(RealmList<Proficiencies> proficienciesList) {
        this.proficienciesList = proficienciesList;
    }

    public boolean isAcrobaticsProficiency() {
        return acrobaticsProficiency;
    }

    public void setAcrobaticsProficiency(boolean acrobaticsProficiency) {
        this.acrobaticsProficiency = acrobaticsProficiency;
    }

    public boolean isAnimalHealingProficiency() {
        return animalHealingProficiency;
    }

    public void setAnimalHealingProficiency(boolean animalHealingProficiency) {
        this.animalHealingProficiency = animalHealingProficiency;
    }

    public boolean isArcanaProficiency() {
        return arcanaProficiency;
    }

    public void setArcanaProficiency(boolean arcanaProficiency) {
        this.arcanaProficiency = arcanaProficiency;
    }

    public boolean isAthleticsProficiency() {
        return athleticsProficiency;
    }

    public void setAthleticsProficiency(boolean athleticsProficiency) {
        this.athleticsProficiency = athleticsProficiency;
    }

    public boolean isDeceptionProficiency() {
        return deceptionProficiency;
    }

    public void setDeceptionProficiency(boolean deceptionProficiency) {
        this.deceptionProficiency = deceptionProficiency;
    }

    public boolean isHistoryProficiency() {
        return historyProficiency;
    }

    public void setHistoryProficiency(boolean historyProficiency) {
        this.historyProficiency = historyProficiency;
    }

    public boolean isInsightProficiency() {
        return insightProficiency;
    }

    public void setInsightProficiency(boolean insightProficiency) {
        this.insightProficiency = insightProficiency;
    }

    public boolean isIntimidationProficiency() {
        return intimidationProficiency;
    }

    public void setIntimidationProficiency(boolean intimidationProficiency) {
        this.intimidationProficiency = intimidationProficiency;
    }

    public boolean isInvestigationProficiency() {
        return investigationProficiency;
    }

    public void setInvestigationProficiency(boolean investigationProficiency) {
        this.investigationProficiency = investigationProficiency;
    }

    public boolean isMedicineProficiency() {
        return medicineProficiency;
    }

    public void setMedicineProficiency(boolean medicineProficiency) {
        this.medicineProficiency = medicineProficiency;
    }

    public boolean isNatureProficiency() {
        return natureProficiency;
    }

    public void setNatureProficiency(boolean natureProficiency) {
        this.natureProficiency = natureProficiency;
    }

    public boolean isPerceptionProficiency() {
        return perceptionProficiency;
    }

    public void setPerceptionProficiency(boolean perceptionProficiency) {
        this.perceptionProficiency = perceptionProficiency;
    }

    public boolean isPerformanceProficiency() {
        return performanceProficiency;
    }

    public void setPerformanceProficiency(boolean performanceProficiency) {
        this.performanceProficiency = performanceProficiency;
    }

    public boolean isPersuasionProficiency() {
        return persuasionProficiency;
    }

    public void setPersuasionProficiency(boolean persuasionProficiency) {
        this.persuasionProficiency = persuasionProficiency;
    }

    public boolean isReligionProficiency() {
        return religionProficiency;
    }

    public void setReligionProficiency(boolean religionProficiency) {
        this.religionProficiency = religionProficiency;
    }

    public boolean isSleightOfHandProficiency() {
        return sleightOfHandProficiency;
    }

    public void setSleightOfHandProficiency(boolean sleightOfHandProficiency) {
        this.sleightOfHandProficiency = sleightOfHandProficiency;
    }

    public boolean isStealthProficiency() {
        return stealthProficiency;
    }

    public void setStealthProficiency(boolean stealthProficiency) {
        this.stealthProficiency = stealthProficiency;
    }

    public boolean isSurvivalProficiency() {
        return survivalProficiency;
    }

    public void setSurvivalProficiency(boolean survivalProficiency) {
        this.survivalProficiency = survivalProficiency;
    }

    public String getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(String personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public int getAcrobaticsProficiencyInt() {
        return acrobaticsProficiencyInt;
    }

    public void setAcrobaticsProficiencyInt(int acrobaticsProficiencyInt) {
        this.acrobaticsProficiencyInt = acrobaticsProficiencyInt;
    }

    public int getAnimalHealingProficiencyInt() {
        return animalHealingProficiencyInt;
    }

    public void setAnimalHealingProficiencyInt(int animalHealingProficiencyInt) {
        this.animalHealingProficiencyInt = animalHealingProficiencyInt;
    }

    public int getArcanaProficiencyInt() {
        return arcanaProficiencyInt;
    }

    public void setArcanaProficiencyInt(int arcanaProficiencyInt) {
        this.arcanaProficiencyInt = arcanaProficiencyInt;
    }

    public int getAthleticsProficiencyInt() {
        return athleticsProficiencyInt;
    }

    public void setAthleticsProficiencyInt(int athleticsProficiencyInt) {
        this.athleticsProficiencyInt = athleticsProficiencyInt;
    }

    public int getDeceptionProficiencyInt() {
        return deceptionProficiencyInt;
    }

    public void setDeceptionProficiencyInt(int deceptionProficiencyInt) {
        this.deceptionProficiencyInt = deceptionProficiencyInt;
    }

    public int getHistoryProficiencyInt() {
        return historyProficiencyInt;
    }

    public void setHistoryProficiencyInt(int historyProficiencyInt) {
        this.historyProficiencyInt = historyProficiencyInt;
    }

    public int getInsightProficiencyInt() {
        return insightProficiencyInt;
    }

    public void setInsightProficiencyInt(int insightProficiencyInt) {
        this.insightProficiencyInt = insightProficiencyInt;
    }

    public int getIntimidationProficiencyInt() {
        return intimidationProficiencyInt;
    }

    public void setIntimidationProficiencyInt(int intimidationProficiencyInt) {
        this.intimidationProficiencyInt = intimidationProficiencyInt;
    }

    public int getInvestigationProficiencyInt() {
        return investigationProficiencyInt;
    }

    public void setInvestigationProficiencyInt(int investigationProficiencyInt) {
        this.investigationProficiencyInt = investigationProficiencyInt;
    }

    public int getMedicineProficiencyInt() {
        return medicineProficiencyInt;
    }

    public void setMedicineProficiencyInt(int medicineProficiencyInt) {
        this.medicineProficiencyInt = medicineProficiencyInt;
    }

    public int getNatureProficiencyInt() {
        return natureProficiencyInt;
    }

    public void setNatureProficiencyInt(int natureProficiencyInt) {
        this.natureProficiencyInt = natureProficiencyInt;
    }

    public int getPerceptionProficiencyInt() {
        return perceptionProficiencyInt;
    }

    public void setPerceptionProficiencyInt(int perceptionProficiencyInt) {
        this.perceptionProficiencyInt = perceptionProficiencyInt;
    }

    public int getPerformanceProficiencyInt() {
        return performanceProficiencyInt;
    }

    public void setPerformanceProficiencyInt(int performanceProficiencyInt) {
        this.performanceProficiencyInt = performanceProficiencyInt;
    }

    public int getPersuasionProficiencyInt() {
        return persuasionProficiencyInt;
    }

    public void setPersuasionProficiencyInt(int persuasionProficiencyInt) {
        this.persuasionProficiencyInt = persuasionProficiencyInt;
    }

    public int getReligionProficiencyInt() {
        return religionProficiencyInt;
    }

    public void setReligionProficiencyInt(int religionProficiencyInt) {
        this.religionProficiencyInt = religionProficiencyInt;
    }

    public int getSleightOfHandProficiencyInt() {
        return sleightOfHandProficiencyInt;
    }

    public void setSleightOfHandProficiencyInt(int sleightOfHandProficiencyInt) {
        this.sleightOfHandProficiencyInt = sleightOfHandProficiencyInt;
    }

    public int getStealthProficiencyInt() {
        return stealthProficiencyInt;
    }

    public void setStealthProficiencyInt(int stealthProficiencyInt) {
        this.stealthProficiencyInt = stealthProficiencyInt;
    }

    public int getSurvivalProficiencyInt() {
        return survivalProficiencyInt;
    }

    public void setSurvivalProficiencyInt(int survivalProficiencyInt) {
        this.survivalProficiencyInt = survivalProficiencyInt;
    }

    public String getIdeals() {
        return ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getBonds() {
        return bonds;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public String getFlaws() {
        return flaws;
    }

    public void setFlaws(String flaws) {
        this.flaws = flaws;
    }

    public int getCopperCoins() {
        return copperCoins;
    }

    public void setCopperCoins(int copperCoins) {
        this.copperCoins = copperCoins;
    }

    public int getSilverCoins() {
        return silverCoins;
    }

    public void setSilverCoins(int silverCoins) {
        this.silverCoins = silverCoins;
    }

    public int getElectrumCoins() {
        return electrumCoins;
    }

    public void setElectrumCoins(int electrumCoins) {
        this.electrumCoins = electrumCoins;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public int getPlatinumCoins() {
        return platinumCoins;
    }

    public void setPlatinumCoins(int platinumCoins) {
        this.platinumCoins = platinumCoins;
    }

    public int getAbilityLv4() {
        return abilityLv4;
    }

    public void setAbilityLv4(int abilityLv4) {
        this.abilityLv4 = abilityLv4;
    }

    public int getAbilityLv8() {
        return abilityLv8;
    }

    public void setAbilityLv8(int abilityLv8) {
        this.abilityLv8 = abilityLv8;
    }

    public int getAbilityLv12() {
        return abilityLv12;
    }

    public void setAbilityLv12(int abilityLv12) {
        this.abilityLv12 = abilityLv12;
    }

    public int getAbilityLv16() {
        return abilityLv16;
    }

    public void setAbilityLv16(int abilityLv16) {
        this.abilityLv16 = abilityLv16;
    }

    public int getAbilityLv19() {
        return abilityLv19;
    }

    public void setAbilityLv19(int abilityLv19) {
        this.abilityLv19 = abilityLv19;
    }

    public int getBonusLanguage() {
        return bonusLanguage;
    }

    public void setBonusLanguage(SheetEnum.Language bonusLanguage) {
        this.bonusLanguage = bonusLanguage.getKey();
    }

    public void setBonusLanguage(int bonusLanguage) {
        this.bonusLanguage = bonusLanguage;
    }

    public void setHalfElfAbility1(SheetEnum.Ability halfElfAbility1) {
        this.halfElfAbility1 = halfElfAbility1.getKey();
    }

    public void setHalfElfAbility2(SheetEnum.Ability halfElfAbility2) {
        this.halfElfAbility2 = halfElfAbility2.getKey();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getStrengthModified() {
        int score = 0;
        int returnValue;
        switch (getRace()) {
            case DRAGONBORN:
                score = 2;
                break;
            case HILL_DWARF:
                //null
                break;
            case MOUNTAIN_DWARF:
                score = 2;
                break;
            case DROW_ELF:
                //null
                break;
            case HIGH_ELF:
                //null
                break;
            case WOOD_ELF:
                //null
                break;
            case ROCK_GNOME:
                //null
                break;
            case FOREST_GNOME:
                //null
                break;
            case HALF_ELF:
                score = halfElfCheck(SheetEnum.Ability.STRENGTH);
                break;
            case HALF_ORC:
                score = 2;
                break;
            case HALFLING_LIGHTFOOT:
                //null
                break;
            case HALFLING_STOUT:
                //null
                break;
            case HUMAN:
                score = 1;
                break;
            case TIEFLING:
                //null
                break;
            default:
                throw new RuntimeException("Unsupported Race: " + race);
        }
        returnValue = getModifier(strengthScore + score);
        //getCurrentLevel();
        return returnValue;
    }

    public int getDexterityModified() {
        int returnValue;
        int score = 0;
        switch (getRace()) {
            case DRAGONBORN:
                //null
                break;
            case HILL_DWARF:
                //null
                break;
            case MOUNTAIN_DWARF:
                //null
                break;
            case DROW_ELF:
                score = 2;
                break;
            case HIGH_ELF:
                score = 2;
                break;
            case WOOD_ELF:
                score = 2;
                break;
            case ROCK_GNOME:
                //null
                break;
            case FOREST_GNOME:
                score = 1;
                break;
            case HALF_ELF:
                score = halfElfCheck(SheetEnum.Ability.DEXTERITY);
                break;
            case HALF_ORC:
                //null
                break;
            case HALFLING_LIGHTFOOT:
                score = 2;
                break;
            case HALFLING_STOUT:
                score = 2;
                break;
            case HUMAN:
                score = 1;
                break;
            case TIEFLING:
                //null
                break;
            default:
                throw new RuntimeException("Unsupported Race: " + race);
        }
        returnValue = getModifier(dexterityScore + score);
        //getRace();
        return returnValue;
    }

    public int getConstitutionModified() {
        int score = 0;
        int returnValue;
        switch (getRace()) {
            case DRAGONBORN:
                //null
                break;
            case HILL_DWARF:
                score = 2;
                break;
            case MOUNTAIN_DWARF:
                score = 2;
                break;
            case DROW_ELF:
                //null
                break;
            case HIGH_ELF:
                //null
                break;
            case WOOD_ELF:
                //null
                break;
            case ROCK_GNOME:
                score = 1;
                break;
            case FOREST_GNOME:
                //null
                break;
            case HALF_ELF:
                score = halfElfCheck(SheetEnum.Ability.CONSTITUTION);
                break;
            case HALF_ORC:
                score = 1;
                break;
            case HALFLING_LIGHTFOOT:
                //null
                break;
            case HALFLING_STOUT:
                score = 1;
                break;
            case HUMAN:
                score = 1;
                break;
            case TIEFLING:
                //null
                break;
            default:
                throw new RuntimeException("Unsupported Race: " + race);
        }
        returnValue = getModifier(constitutionScore + score);
        //getCurrentLevel();
        //getPlayerClass();
        return returnValue;
    }

    public int getIntelligenceModified() {
        int score = 0;
        int returnValue;
        switch (getRace()) {
            case DRAGONBORN:
                //null
                break;
            case HILL_DWARF:
                //null
                break;
            case MOUNTAIN_DWARF:
                //null
                break;
            case DROW_ELF:
                //null
                break;
            case HIGH_ELF:
                score = 1;
                break;
            case WOOD_ELF:
                //null
                break;
            case ROCK_GNOME:
                score = 2;
                break;
            case FOREST_GNOME:
                score = 2;
                break;
            case HALF_ELF:
                score = halfElfCheck(SheetEnum.Ability.INTELLIGENCE);
                break;
            case HALF_ORC:
                //null
                break;
            case HALFLING_LIGHTFOOT:
                //null
                break;
            case HALFLING_STOUT:
                //null
                break;
            case HUMAN:
                score = 1;
                break;
            case TIEFLING:
                score = 1;
                break;
            default:
                throw new RuntimeException("Unsupported Race: " + race);
        }
        returnValue = getModifier(intelligenceScore + score);
        //getCurrentLevel();
        //getPlayerClass();
        return returnValue;
    }

    public int getWisdomModified() {
        int score = 0;
        int returnValue;
        switch (getRace()) {
            case DRAGONBORN:
                //null
                break;
            case HILL_DWARF:
                score = 1;
                break;
            case MOUNTAIN_DWARF:
                //null
                break;
            case DROW_ELF:
                //null
                break;
            case HIGH_ELF:
                //null
                break;
            case WOOD_ELF:
                score = 1;
                break;
            case ROCK_GNOME:
                //null
                break;
            case FOREST_GNOME:
                //null
                break;
            case HALF_ELF:
                score = halfElfCheck(SheetEnum.Ability.WISDOM);
                break;
            case HALF_ORC:
                //null
                break;
            case HALFLING_LIGHTFOOT:
                //null
                break;
            case HALFLING_STOUT:
                //null
                break;
            case HUMAN:
                score = 1;
                break;
            case TIEFLING:
                //null
                break;
            default:
                throw new RuntimeException("Unsupported Race: " + race);
        }
        returnValue = getModifier(wisdomScore + score);
        //getCurrentLevel();
        //getPlayerClass();
        return returnValue;
    }

    public int getCharismaModified() {
        int score = 0;
        int returnValue;
        switch (getRace()) {
            case DRAGONBORN:
                score = 1;
                break;
            case HILL_DWARF:
                //null
                break;
            case MOUNTAIN_DWARF:
                //null
                break;
            case DROW_ELF:
                score = 1;
                break;
            case HIGH_ELF:
                //null
                break;
            case WOOD_ELF:
                //null
                break;
            case ROCK_GNOME:
                //null
                break;
            case FOREST_GNOME:
                //null
                break;
            case HALF_ELF:
                score = 2;
                break;
            case HALF_ORC:
                //null
                break;
            case HALFLING_LIGHTFOOT:
                score = 1;
                break;
            case HALFLING_STOUT:
                //null
                break;
            case HUMAN:
                score = 1;
                break;
            case TIEFLING:
                score = 2;
                break;
            default:
                throw new RuntimeException("Unsupported Race: " + race);
        }
        returnValue = getModifier(charismaScore + score);
        //getCurrentLevel();
        //getPlayerClass();
        return returnValue;
    }

    /*
    TODO UNABLE Implement infrastructure RaceSpeed refresh
    This will need to be done when a race is selected and updated, however while the method can presently be run with no difficulties the infrastructure to support it has not been implemented
     */
    public int getRaceSpeed() {
        switch (getRace()) {
            case DRAGONBORN:
                return 30;
            case HILL_DWARF:
                return 25;
            case MOUNTAIN_DWARF:
                return 25;
            case DROW_ELF:
                return 30;
            case HIGH_ELF:
                return 30;
            case WOOD_ELF:
                return 30;
            case ROCK_GNOME:
                return 25;
            case FOREST_GNOME:
                return 25;
            case HALF_ELF:
                return 30;
            case HALF_ORC:
                return 30;
            case HALFLING_LIGHTFOOT:
                return 25;
            case HALFLING_STOUT:
                return 25;
            case HUMAN:
                return 30;
            case TIEFLING:
                return 30;
            default:
                throw new RuntimeException("Unsupported Race: " + race);
        }
    }

    public List<SheetEnum.Language> getRaceLanguage() {
        switch (getRace()) {
            case DRAGONBORN:
                List<SheetEnum.Language> drList = new ArrayList<>();
                drList.add(SheetEnum.Language.COMMON);
                drList.add(SheetEnum.Language.DRACONIC);
                return drList;
            case HILL_DWARF:
                List<SheetEnum.Language> hdList = new ArrayList<>();
                hdList.add(SheetEnum.Language.COMMON);
                hdList.add(SheetEnum.Language.DWARVISH);
                return hdList;
            case MOUNTAIN_DWARF:
                List<SheetEnum.Language> mdList = new ArrayList<>();
                mdList.add(SheetEnum.Language.COMMON);
                mdList.add(SheetEnum.Language.DWARVISH);
                return mdList;
            case DROW_ELF:
                List<SheetEnum.Language> deList = new ArrayList<>();
                deList.add(SheetEnum.Language.COMMON);
                deList.add(SheetEnum.Language.ELVISH);
                return deList;
            case HIGH_ELF:
                List<SheetEnum.Language> heList = new ArrayList<>();
                heList.add(SheetEnum.Language.COMMON);
                heList.add(SheetEnum.Language.ELVISH);
                return heList;
            case WOOD_ELF:
                List<SheetEnum.Language> weList = new ArrayList<>();
                weList.add(SheetEnum.Language.COMMON);
                weList.add(SheetEnum.Language.ELVISH);
                return weList;
            case ROCK_GNOME:
                List<SheetEnum.Language> rgList = new ArrayList<>();
                rgList.add(SheetEnum.Language.COMMON);
                rgList.add(SheetEnum.Language.GNOMISH);
                return rgList;
            case FOREST_GNOME:
                List<SheetEnum.Language> fgList = new ArrayList<>();
                fgList.add(SheetEnum.Language.COMMON);
                fgList.add(SheetEnum.Language.GNOMISH);
                return fgList;
            case HALF_ELF:
                List<SheetEnum.Language> haeList = new ArrayList<>();
                haeList.add(SheetEnum.Language.COMMON);
                haeList.add(SheetEnum.Language.ELVISH);
                haeList.add(SheetEnum.Language.getEnumValue(bonusLanguage));
                return haeList;
            case HALF_ORC:
                List<SheetEnum.Language> horcList = new ArrayList<>();
                horcList.add(SheetEnum.Language.COMMON);
                horcList.add(SheetEnum.Language.ORC);
                return horcList;
            case HALFLING_LIGHTFOOT:
                List<SheetEnum.Language> hlList = new ArrayList<>();
                hlList.add(SheetEnum.Language.COMMON);
                hlList.add(SheetEnum.Language.HALFLING);
                return hlList;
            case HALFLING_STOUT:
                List<SheetEnum.Language> hsList = new ArrayList<>();
                hsList.add(SheetEnum.Language.COMMON);
                hsList.add(SheetEnum.Language.HALFLING);
                return hsList;
            case HUMAN:
                List<SheetEnum.Language> hList = new ArrayList<>();
                hList.add(SheetEnum.Language.COMMON);
                hList.add(SheetEnum.Language.getEnumValue(bonusLanguage));
                return hList;
            case TIEFLING:
                List<SheetEnum.Language> tList = new ArrayList<>();
                tList.add(SheetEnum.Language.COMMON);
                tList.add(SheetEnum.Language.INFERNAL);
                return tList;
            default:
                throw new RuntimeException("Unsupported Race: " + race);
        }
    }

    public ArrayList<String> getRaceLanguageAsReadableString() {
        ArrayList<String> stringList = new ArrayList<>();
        List<SheetEnum.Language> enumList = getRaceLanguage();
        try {
            for (SheetEnum.Language languageEnum : enumList) {
                String language = String.valueOf(languageEnum);
                language = language.substring(0, 1).toUpperCase() + language.substring(1).toLowerCase();
                stringList.add(language);
            }
        } catch (Exception e) {
            Log.e(TAG, "LanAsReadableString", e);
        }
        return stringList;
    }

    public boolean isRaceBonusLanguage() {
        switch (getRace()) {
            case DRAGONBORN:
                return false;
            case HILL_DWARF:
                return false;
            case MOUNTAIN_DWARF:
                return false;
            case DROW_ELF:
                return false;
            case HIGH_ELF:
                return false;
            case WOOD_ELF:
                return false;
            case ROCK_GNOME:
                return false;
            case FOREST_GNOME:
                return false;
            case HALF_ELF:
                return true;
            case HALF_ORC:
                return false;
            case HALFLING_LIGHTFOOT:
                return false;
            case HALFLING_STOUT:
                return false;
            case HUMAN:
                return true;
            case TIEFLING:
                return false;
            default:
                throw new RuntimeException("Unsupported Race: " + race);
        }
    }

//https://stackoverflow.com/questions/34620494/jetbrains-contract-annotation

    //    @Contract(pure = true)
    private static int getModifier(int value) {
        return value / 2 - 5;
    }

    @Contract(pure = true)
    public int getCurrentLevel() {
        if (experiencePoint < 300)
            return 1;
        else if (experiencePoint < 900)
            return 2;
        else if (experiencePoint < 2700)
            return 3;
        else if (experiencePoint < 6500)
            return 4;
        else if (experiencePoint < 14000)
            return 5;
        else if (experiencePoint < 23000)
            return 6;
        else if (experiencePoint < 34000)
            return 7;
        else if (experiencePoint < 48000)
            return 8;
        else if (experiencePoint < 64000)
            return 9;
        else if (experiencePoint < 85000)
            return 10;
        else if (experiencePoint < 100000)
            return 11;
        else if (experiencePoint < 120000)
            return 12;
        else if (experiencePoint < 140000)
            return 13;
        else if (experiencePoint < 165000)
            return 14;
        else if (experiencePoint < 195000)
            return 15;
        else if (experiencePoint < 225000)
            return 16;
        else if (experiencePoint < 265000)
            return 17;
        else if (experiencePoint < 305000)
            return 18;
        else if (experiencePoint < 355000)
            return 19;
        else
            return 20;
    }

    int getBaseProficiencyBonus() throws Exception {
        int currentLevel = getCurrentLevel();
        switch (currentLevel) {
            case 1:
            case 2:
            case 3:
            case 4:
                return 2;
            case 5:
            case 6:
            case 7:
            case 8:
                return 3;
            case 9:
            case 10:
            case 11:
            case 12:
                return 4;
            case 13:
            case 14:
            case 15:
            case 16:
                return 5;
            case 17:
            case 18:
            case 19:
            case 20:
                return 6;
            default:
                throw new Exception("getBaseProficiencyBonus Exception");
        }
    }

    //TODO UNABLE this has yet to be used.
    /* Half Elf */
    private int halfElfCheck(SheetEnum.Ability ability) {
        int abilityNum = ability.getKey();
        if (halfElfAbility1 == abilityNum || (halfElfAbility2 == abilityNum))
            return 1;
        else
            return 0;
    }

    /*Dwarf */
    void getHillDwarf() {
        switch (getCurrentLevel()) {
            case 1:
        }
    }

    public int getAbilityBonus(SheetEnum.Ability ability) {
        switch (ability) {
            case STRENGTH:
                return getStrengthModified();

            case DEXTERITY:
                return getDexterityModified();

            case CONSTITUTION:
                return getConstitutionModified();

            case INTELLIGENCE:
                return getIntelligenceModified();

            case WISDOM:
                return getWisdomModified();

            case CHARISMA:
                return getCharismaModified();

            case FINESSE:
                return Math.max(getStrengthModified(), getDexterityModified());
            //Unhandled = I don't know how to handle/what to do with this thing you passed me
            default:
                throw new RuntimeException("Unhandled Ability: " + ability);
        }
    }
}
