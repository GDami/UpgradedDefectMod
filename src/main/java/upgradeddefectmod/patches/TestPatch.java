package upgradeddefectmod.patches;


import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import javassist.CannotCompileException;
import javassist.CtBehavior;
import upgradeddefectmod.UpgradedDefect;

@SpirePatch(
        clz = GameActionManager.class,
        method = "update"
)
public class TestPatch {

    @SpireInsertPatch(
            locator = Locator.class
    )
    public static void patchName(GameActionManager __instance) {
    //    UpgradedDefect.logger.info(__instance.currentAction.toString());
    }

    private static class Locator extends SpireInsertLocator {

        public int[] Locate(CtBehavior ctMethodToPatch) throws CannotCompileException, PatchingException {
            Matcher matcher = new Matcher.MethodCallMatcher(AbstractGameAction.class, "update");
            return new int[]{LineFinder.findInOrder(ctMethodToPatch, matcher)[0]};
        }
    }

}
