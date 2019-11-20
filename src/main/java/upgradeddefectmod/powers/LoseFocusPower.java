package upgradeddefectmod.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.FocusPower;
import upgradeddefectmod.UpgradedDefect;

public class LoseFocusPower extends UpgradedDefectPower {

    private AbstractGameAction ac;
    private static final String POWER_ID = "UpgradedDefect:LoseFocus";

    public LoseFocusPower(AbstractCreature owner, int amount) {
        super(POWER_ID, owner, amount);
        this.type = PowerType.DEBUFF;
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    @Override
    public void atStartOfTurnPostDraw() {
        this.flash();
        ac = new ApplyPowerAction(this.owner, this.owner, new FocusPower(this.owner, -this.amount), -this.amount);
        AbstractDungeon.actionManager.addToBottom(ac);

        AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));

    }

    public void onRemove() {
        if (ac != null) {
            AbstractDungeon.actionManager.actions.remove(ac);
        }
    }
}
