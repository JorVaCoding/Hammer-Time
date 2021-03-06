package com.ewyboy.hammertime.Loaders;

import com.ewyboy.hammertime.Utillity.Logger;
import com.ewyboy.hammertime.Utillity.StringMap;
import com.google.common.base.Stopwatch;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ConfigLoader {

    public static int durabilityMultiplier, efficiencyReducerMultiplier;
    public static boolean disableWoodenHammer,disableStoneHammer,disableIronHammer,disableGoldenHammer,disableDiamondHammer;
        public static boolean[] disableHammers = {disableWoodenHammer, disableStoneHammer, disableIronHammer, disableGoldenHammer, disableDiamondHammer};
    public static boolean disableWoodenExcavator,disableStoneExcavator,disableIronExcavator,disableGoldenExcavator,disableDiamondExcavator;
        public static boolean[] disableExcavators = {disableWoodenExcavator, disableStoneExcavator, disableIronExcavator, disableGoldenExcavator, disableDiamondExcavator};
    public static boolean disableWoodenAxe, disableStoneAxe, disableIronAxe, disableGoldenAxe, disableDiamondAxe;
        public static boolean[] disableAxes = {disableWoodenAxe, disableStoneAxe, disableIronAxe, disableGoldenAxe, disableDiamondAxe};
    public static boolean disableWoodenSickle, disableStoneSickle, disableIronSickle, disableGoldenSickle, disableDiamondSickle;
        public static boolean[] disableSickles = {disableWoodenSickle, disableStoneSickle, disableIronSickle, disableGoldenSickle, disableDiamondSickle};

    public static void init(File file) {
        String spacing = "  ";
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("Loading configs started");
                Configuration config = new Configuration(file);
                    Logger.info(spacing + "Reading " + config);
                        config.load();
                            durabilityMultiplier = config.getInt("Durability Multiplier", StringMap.ConfigCategoryTweaks, 3, 1, 10, "Takes the base durability from the material type and multiplying it to fit the hammer");
                                Logger.info(spacing + "Durability Multiplier = " + durabilityMultiplier);
                            efficiencyReducerMultiplier = config.getInt("Efficiency Reducer Multiplier", StringMap.ConfigCategoryTweaks, 3, 1, 10, "Takes the base efficiency of the material and reduces it to fit the hammer");
                                Logger.info(spacing + "Efficiency Reducer Multiplier = " + efficiencyReducerMultiplier);

                            for (int i = 0; i < MaterialLoader.Materials.length; i++) {
                                disableHammers[i] = config.getBoolean("Disable " + StringMap.Hammers[i], StringMap.ConfigCategoryTogglables, false, "Disables the " + StringMap.Hammers[i] + " crafting recipe");
                                    Logger.info(spacing + StringMap.Hammers[i] + " = " + disableHammers[i]);
                                disableExcavators[i] = config.getBoolean("Disable " + StringMap.Excavators[i], StringMap.ConfigCategoryTogglables, false, "Disables the " + StringMap.Excavators[i] + " crafting recipe");
                                    Logger.info(spacing + StringMap.Excavators[i] + " = " + disableExcavators[i]);
                                disableAxes[i] = config.getBoolean("Disable " + StringMap.LumberAxes[i], StringMap.ConfigCategoryTogglables, false, "Disables the " + StringMap.LumberAxes[i] + " crafting recipe");
                                    Logger.info(spacing + StringMap.LumberAxes[i] + " = " + disableAxes[i]);
                                disableSickles[i] = config.getBoolean("Disable " + StringMap.Sickles[i], StringMap.ConfigCategoryTogglables, false, "Disables the " + StringMap.Sickles[i] + " crafting recipe");
                                    Logger.info(spacing + StringMap.Sickles[i] + " = " + disableSickles[i]);
                            }
                        config.save();
                    Logger.info(spacing + "Saving " + config);
                Logger.info("Loading configs finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }
}
