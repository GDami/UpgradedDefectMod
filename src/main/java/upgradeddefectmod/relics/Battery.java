package upgradeddefectmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.powers.FocusPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import upgradeddefectmod.UpgradedDefect;

public class Battery extends UpgradedDefectRelic {

    public static final String ID = "Battery";
    private static final String IMG_NAME = UpgradedDefect.makeRelicPath(ID);

    public Battery() {
        super(ID, new Texture(IMG_NAME), RelicTier.RARE, LandingSound.SOLID);
        this.counter = 0;
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    public void onChannel(AbstractOrb o) {
        if (o instanceof Lightning) {
            this.counter++;
            if (this.counter == 10) {
                this.counter = 0;
                this.flash();
                AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
                AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new FocusPower(AbstractDungeon.player, 1), 1, true));
            }
        }
    }

    public AbstractRelic makeCopy() {
        return new Battery();
    }

}
