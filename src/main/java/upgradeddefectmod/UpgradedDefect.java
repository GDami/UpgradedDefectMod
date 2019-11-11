package upgradeddefectmod;

import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import upgradeddefectmod.cards.blue.*;
import upgradeddefectmod.relics.Kaleidoscope;
import upgradeddefectmod.relics.Stalactite;

@SpireInitializer
public class UpgradedDefect implements EditKeywordsSubscriber, EditRelicsSubscriber, EditCardsSubscriber, EditStringsSubscriber {

    private static final String ASSETS_FOLDER = "img/";

    private static final Logger logger = LogManager.getLogger(UpgradedDefect.class.getName());

    public UpgradedDefect() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new UpgradedDefect();
    }

    @Override
    public void receiveEditCards() {
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
        BaseMod.addCard(new Hack());
        BaseMod.addCard(new FrostBarrage());
        BaseMod.addCard(new CustomClaw());
        BaseMod.addCard(new ClawSnap());

        UnlockTracker.unlockCard(ClawSnap.ID);
        UnlockTracker.unlockCard(CustomClaw.ID);
        UnlockTracker.unlockCard(FrostBarrage.ID);
        UnlockTracker.unlockCard(Hack.ID);
        UnlockTracker.unlockCard(RoboticWalls.ID);
        UnlockTracker.unlockCard(Infuse.ID);
        UnlockTracker.unlockCard(IcePalm.ID);
        UnlockTracker.unlockCard(Flux.ID);
        UnlockTracker.unlockCard(Accelerate.ID);
        UnlockTracker.unlockCard(Parasite.ID);
        UnlockTracker.unlockCard(Shelter.ID);
        UnlockTracker.unlockCard(ShockingTouch.ID);
        UnlockTracker.unlockCard(IceBeam.ID);


        BaseMod.removeCard("Cold Snap", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Claw", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Barrage", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Overclock", AbstractCard.CardColor.BLUE);
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
        String cardStrings = "localization/UpgradedDefect-cardStrings.json";
        String powerStrings = "localization/UpgradedDefect-powerStrings.json";
        String relicStrings = "localization/UpgradedDefect-relicStrings.json";

        BaseMod.loadCustomStringsFile(CardStrings.class, cardStrings);
        BaseMod.loadCustomStringsFile(PowerStrings.class, powerStrings);
        BaseMod.loadCustomStringsFile(RelicStrings.class, relicStrings);
    }

    @Override
    public void receiveEditRelics() {
        logger.info("editing relics");
        BaseMod.addRelic(new Stalactite(), RelicType.BLUE);
        BaseMod.addRelic(new Kaleidoscope(), RelicType.BLUE);
        logger.info("done editing relics");
    }

    @Override
    public void receiveEditKeywords() {
        String[] host = {"host"};
        BaseMod.addKeyword(host, "The parasite eats away at the host, who loses more HP every turn.");
        String[] claw = {"claw"};
        BaseMod.addKeyword(claw, "Increase the damage of ALL Claw cards by 1 this combat.");

    }

}