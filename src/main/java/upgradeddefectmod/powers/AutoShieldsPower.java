package upgradeddefectmod.powers;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Lightning;

public class AutoShieldsPower extends UpgradedDefectPower {

    private static final String POWER_ID = "UpgradedDefect:AutoShields";

    public AutoShieldsPower(AbstractCreature owner, int amount) {
        super(POWER_ID, owner, amount);
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    @Override
    public void onChannel(AbstractOrb o) {
        if (o instanceof Lightning) {
            AbstractPlayer p = AbstractDungeon.player;
            AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.amount, true));
        }
    }
}
