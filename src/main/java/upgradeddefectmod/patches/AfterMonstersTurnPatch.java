package upgradeddefectmod.patches;


import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.MonsterGroup;
import com.megacrit.cardcrawl.powers.AbstractPower;
import upgradeddefectmod.powers.UpgradedDefectPower;


// To trigger things after the end of round, after turn-based effects are triggered
@SpirePatch(
        clz = MonsterGroup.class,
        method = "applyEndOfTurnPowers"
)
public class AfterMonstersTurnPatch {

    public static void Postfix(MonsterGroup __instance) {
        for (AbstractPower p : AbstractDungeon.player.powers) {
            if (p instanceof UpgradedDefectPower) {
                ((UpgradedDefectPower) p).afterMonstersTurn();
            }
        }
    }




}
