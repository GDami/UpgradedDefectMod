package upgradeddefectmod;

import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.Keyword;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import upgradeddefectmod.cards.blue.*;
import upgradeddefectmod.relics.Battery;
import upgradeddefectmod.relics.Kaleidoscope;
import upgradeddefectmod.relics.Stalactite;
import upgradeddefectmod.variables.SecondNumber;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@SpireInitializer
public class UpgradedDefect implements EditKeywordsSubscriber, EditRelicsSubscriber, EditCardsSubscriber, EditStringsSubscriber {

    private static final String ASSETS_FOLDER = "img/";

    public static final Logger logger = LogManager.getLogger(UpgradedDefect.class.getName());

    public UpgradedDefect() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new UpgradedDefect();
    }

    @Override
    public void receiveEditCards() {

        logger.info("adding variables");
        BaseMod.addDynamicVariable(new SecondNumber());
        logger.info("done adding variables");

        logger.info("editing cards");
        BaseMod.addCard(new IceBeam());
        BaseMod.addCard(new ShockingTouch());
        BaseMod.addCard(new Shelter());
        BaseMod.addCard(new Parasite());
        BaseMod.addCard(new Accelerate());
        BaseMod.addCard(new Flux());
        BaseMod.addCard(new IcePalm());
        BaseMod.addCard(new Infuse());
        BaseMod.addCard(new RoboticWalls());
        BaseMod.addCard(new CustomSkim());
        //BaseMod.addCard(new FrostBarrage());
        BaseMod.addCard(new CustomClaw());
        BaseMod.addCard(new ClawSnap());
        BaseMod.addCard(new Clawbound());
        BaseMod.addCard(new CustomStack());
        BaseMod.addCard(new CustomBattery());
        BaseMod.addCard(new CustomBeamCell());
        BaseMod.addCard(new GlacierSlam());
        BaseMod.addCard(new LightningAura());
        BaseMod.addCard(new Install());
        BaseMod.addCard(new ClawLightning());
        BaseMod.addCard(new CustomChaos());
        BaseMod.addCard(new CustomChill());
        BaseMod.addCard(new CustomMachineLearning());
        BaseMod.addCard(new Discharge());
        BaseMod.addCard(new ClawCounter());
        BaseMod.addCard(new Clawrd());
        BaseMod.addCard(new CleanUp());
        BaseMod.addCard(new CustomReprogram());
        BaseMod.addCard(new CustomTurbo());
        BaseMod.addCard(new DarkWave());
        BaseMod.addCard(new CustomAutoShields());
        BaseMod.addCard(new CustomForceField());
        BaseMod.addCard(new CustomHologram());
        BaseMod.addCard(new SweepingClaw());
        BaseMod.addCard(new CustomConsume());
        BaseMod.addCard(new CustomHelloWorld());
        BaseMod.addCard(new Hack());
        BaseMod.addCard(new DarkAura());
        BaseMod.addCard(new FrostAura());
        BaseMod.addCard(new ClearMind());
        BaseMod.addCard(new CustomWhiteNoise());
        BaseMod.addCard(new Metabolism());
        BaseMod.addCard(new CustomRecycle());

        UnlockTracker.unlockCard(CustomRecycle.ID);
        UnlockTracker.unlockCard(Metabolism.ID);
        UnlockTracker.unlockCard(CustomWhiteNoise.ID);
        UnlockTracker.unlockCard(ClearMind.ID);
        UnlockTracker.unlockCard(FrostAura.ID);
        UnlockTracker.unlockCard(DarkAura.ID);
        UnlockTracker.unlockCard(Hack.ID);
        UnlockTracker.unlockCard(CustomHelloWorld.ID);
        UnlockTracker.unlockCard(CustomConsume.ID);
        UnlockTracker.unlockCard(SweepingClaw.ID);
        UnlockTracker.unlockCard(CustomHologram.ID);
        UnlockTracker.unlockCard(CustomForceField.ID);
        UnlockTracker.unlockCard(CustomAutoShields.ID);
        UnlockTracker.unlockCard(DarkWave.ID);
        UnlockTracker.unlockCard(CustomTurbo.ID);
        UnlockTracker.unlockCard(CustomReprogram.ID);
        UnlockTracker.unlockCard(CleanUp.ID);
        UnlockTracker.unlockCard(Clawrd.ID);
        UnlockTracker.unlockCard(ClawCounter.ID);
        UnlockTracker.unlockCard(Discharge.ID);
        UnlockTracker.unlockCard(CustomMachineLearning.ID);
        UnlockTracker.unlockCard(CustomChill.ID);
        UnlockTracker.unlockCard(CustomChaos.ID);
        UnlockTracker.unlockCard(ClawLightning.ID);
        UnlockTracker.unlockCard(Install.ID);
        UnlockTracker.unlockCard(LightningAura.ID);
        UnlockTracker.unlockCard(GlacierSlam.ID);
        UnlockTracker.unlockCard(CustomBeamCell.ID);
        UnlockTracker.unlockCard(CustomBattery.ID);
        UnlockTracker.unlockCard(CustomStack.ID);
        UnlockTracker.unlockCard(Clawbound.ID);
        UnlockTracker.unlockCard(ClawSnap.ID);
        UnlockTracker.unlockCard(CustomClaw.ID);
        //UnlockTracker.unlockCard(FrostBarrage.ID);
        UnlockTracker.unlockCard(CustomSkim.ID);
        UnlockTracker.unlockCard(RoboticWalls.ID);
        UnlockTracker.unlockCard(Infuse.ID);
        UnlockTracker.unlockCard(IcePalm.ID);
        UnlockTracker.unlockCard(Flux.ID);
        UnlockTracker.unlockCard(Accelerate.ID);
        UnlockTracker.unlockCard(Parasite.ID);
        UnlockTracker.unlockCard(Shelter.ID);
        UnlockTracker.unlockCard(ShockingTouch.ID);
        UnlockTracker.unlockCard(IceBeam.ID);


        BaseMod.removeCard("Recycle", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Sunder", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("White Noise", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Rip and Tear", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Steam Power", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Heatsinks", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Reinforced Body", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Hello World", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Consume", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Sweeping Beam", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Hologram", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Force Field", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Auto Shields", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Redo", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Turbo", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Reprogram", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Meteor Strike", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Multi-Cast", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Streamline", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Melter", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Machine Learning", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Chill", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Chaos", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Ball Lightning", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Coolheaded", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Blizzard", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Glacier", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Beam Cell", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Conserve Battery", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Stack", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Rebound", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Cold Snap", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Gash", AbstractCard.CardColor.BLUE);
        //BaseMod.removeCard("Barrage", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Skim", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Self Repair", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Thunder Strike", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Go for the Eyes", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Compile Driver", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Reboot", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Buffer", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Aggregate", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Storm", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("FTL", AbstractCard.CardColor.BLUE);

        logger.info("done editing cards");
    }

    public static String makeCardPath(String resource) {
        return makePath("cards/" + resource);
    }
    public static String makePowerPath(String resource) {
        return makePath("powers/" + resource);
    }
    public static String makeRelicPath(String resource) { return makePath("relics/" + resource); }

    private static String makePath(String resource) {
        String result = ASSETS_FOLDER + resource;

        if (! hasExtension(resource)) {
            result += ".png";
        }

        return result;
    }

    private static boolean hasExtension(String filename) {
        return filename.lastIndexOf('.') > 0;
    }

    @Override
    public void receiveEditStrings() {

        String language = "eng";
        if (Settings.language == Settings.GameLanguage.FRA) language = "fra";

        String cardStrings = "localization/" + language + "/UpgradedDefect-cardStrings.json";
        String powerStrings = "localization/" + language + "/UpgradedDefect-powerStrings.json";
        String relicStrings = "localization/" + language + "/UpgradedDefect-relicStrings.json";

        BaseMod.loadCustomStringsFile(CardStrings.class, cardStrings);
        BaseMod.loadCustomStringsFile(PowerStrings.class, powerStrings);
        BaseMod.loadCustomStringsFile(RelicStrings.class, relicStrings);
    }

    @Override
    public void receiveEditRelics() {
        logger.info("editing relics");
        BaseMod.addRelic(new Stalactite(), RelicType.BLUE);
        BaseMod.addRelic(new Kaleidoscope(), RelicType.BLUE);
        BaseMod.addRelic(new Battery(), RelicType.BLUE);
        logger.info("done editing relics");
    }

    @Override
    public void receiveEditKeywords() {

        String language = "eng";
        if (Settings.language == Settings.GameLanguage.FRA) language = "fra";

        Type typeToken = new TypeToken<Map<String, Keyword>>(){}.getType();
        Gson gson = new Gson();
        String strings = loadJson("localization/" + language + "/UpgradedDefect-keywordStrings.json");
        Map<String,Keyword> keywords = gson.fromJson(strings, typeToken);
        for (Keyword kw : keywords.values()) {
            BaseMod.addKeyword(kw.NAMES, kw.DESCRIPTION);
        }
        logger.info("done editing keywords");


    }

    private static String loadJson(String jsonPath) {
        return Gdx.files.internal(jsonPath).readString(String.valueOf(StandardCharsets.UTF_8));
    }

}