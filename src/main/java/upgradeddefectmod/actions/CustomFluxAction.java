package upgradeddefectmod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Lightning;

import java.util.Iterator;

public class CustomFluxAction extends AbstractGameAction {
    public CustomFluxAction(AbstractPlayer p, int magicNumber) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.source = p;
        this.target = source;
        this.amount = magicNumber;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST && !AbstractDungeon.player.orbs.isEmpty()) {
            Iterator var1 = AbstractDungeon.player.orbs.iterator();

            while(var1.hasNext()) {
                AbstractOrb o = (AbstractOrb)var1.next();
                if (o instanceof Lightning) {
                    AbstractDungeon.actionManager.addToBottom(new GainBlockAction(this.target, this.source, this.amount, true));
                }
            }

        }

        this.tickDuration();
    }
}

