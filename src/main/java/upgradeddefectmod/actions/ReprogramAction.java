package upgradeddefectmod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.FocusPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class ReprogramAction extends AbstractGameAction {

    public ReprogramAction(AbstractCreature c) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.target = c;
    }

    @Override
    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            for (AbstractPower p: this.target.powers) {
                if ((p instanceof StrengthPower) || (p instanceof DexterityPower) || (p instanceof FocusPower)) {
                    AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.target, this.target, p.ID));
                }
            }
        }

        this.tickDuration();
    }
}
