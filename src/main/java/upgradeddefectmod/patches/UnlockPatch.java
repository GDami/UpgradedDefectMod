package upgradeddefectmod.patches;


import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.unlock.AbstractUnlock;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.unlock.cards.DefectCards.EchoFormUnlock;
import com.megacrit.cardcrawl.unlock.cards.DefectCards.SunderUnlock;
import com.megacrit.cardcrawl.unlock.cards.DefectCards.TurboUnlock;
import com.megacrit.cardcrawl.unlock.cards.DefectCards.UndoUnlock;
import javassist.CtBehavior;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@SpirePatch(
        clz = UnlockTracker.class,
        method = "getUnlockBundle"
)
public class UnlockPatch {

    private static final Logger logger = LogManager.getLogger(UnlockPatch.class.getName());

    public static SpireReturn<ArrayList<AbstractUnlock>> Prefix(AbstractPlayer.PlayerClass c, int unlockLevel) {
        if (c.equals(AbstractPlayer.PlayerClass.DEFECT)) {
            ArrayList<AbstractUnlock> patchBundle = new ArrayList();
            switch (unlockLevel) {
                case 0:
                    patchBundle.add(new UndoUnlock());
                    patchBundle.add(new EchoFormUnlock());
                    return SpireReturn.Return(patchBundle);
                case 1:
                    return SpireReturn.Return(patchBundle);
            }
        }
        return SpireReturn.Continue();
    }/*

    @SpireInsertPatch(
        rloc = 71, localvars = {"tmpBundle"}
    )
    public static void getBundlePatch(AbstractPlayer.PlayerClass c, int unlockLevel, @ByRef ArrayList<AbstractUnlock>[] tmpBundle) {
        if (c == AbstractPlayer.PlayerClass.DEFECT && unlockLevel == 1) {
            //tmpBundle.clear();
        }
        logger.info("rloc " + c + " " + unlockLevel);

    }

    @SpireInsertPatch(
            locator = Locator0.class,
            localvars = {"tmpBundle"}
    )
    public static void test2(AbstractPlayer.PlayerClass c, int unlockLevel, @ByRef ArrayList<AbstractUnlock>[] tmpBundle) {
        logger.info("locator " + c + " " + unlockLevel);
    }

    private static class Locator0 extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher matcher = new Matcher.MethodCallMatcher(ArrayList.class, "add");
            return new int[]{LineFinder.findAllInOrder(ctMethodToPatch, matcher)[30]};
        }
    }

    private static class Locator1 extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher matcher = new Matcher.MethodCallMatcher(ArrayList.class, "add");
            return new int[]{LineFinder.findAllInOrder(ctMethodToPatch, matcher)[33]};
        }
    }*/

}
