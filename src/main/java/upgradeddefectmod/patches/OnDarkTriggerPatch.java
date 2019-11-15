package upgradeddefectmod.patches;


// To do things when a Dark Orb triggers

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.Dark;
import com.megacrit.cardcrawl.powers.AbstractPower;
import upgradeddefectmod.powers.UpgradedDefectPower;

@SpirePatch(
        clz = Dark.class,
        method = "onEndOfTurn"
)
public class OnDarkTriggerPatch {

    public static void Postfix (Dark __instance) {
        for (AbstractPower p : AbstractDungeon.player.powers) {
            if (p instanceof UpgradedDefectPower) {
                ((UpgradedDefectPower) p).onDarkTrigger(__instance);
            }
        }
    }

}
