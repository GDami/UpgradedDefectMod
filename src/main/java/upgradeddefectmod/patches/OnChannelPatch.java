package upgradeddefectmod.patches;



// To call custom methods when channeling orbs

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Dark;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import javassist.CannotCompileException;
import javassist.CtBehavior;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import upgradeddefectmod.relics.UpgradedDefectRelic;

import java.util.ArrayList;
import java.util.Iterator;

@SpirePatch(
        clz = AbstractPlayer.class,
        method = "channelOrb"
)
public class OnChannelPatch {

    private static final Logger logger = LogManager.getLogger(OnChannelPatch.class.getName());

    @SpireInsertPatch(
            locator = Locator.class
    )
    public static void patchName(AbstractPlayer __instance, AbstractOrb orbToSet) {
        for (AbstractRelic r : __instance.relics) {
            if (r instanceof UpgradedDefectRelic) {
                ((UpgradedDefectRelic) r).onChannel(orbToSet);
            }
        }
    }

    public static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws CannotCompileException, PatchingException {

            Matcher matcher = new Matcher.MethodCallMatcher(AbstractOrb.class, "applyFocus");
            return LineFinder.findInOrder(ctMethodToPatch, matcher);
        }
    }

}
