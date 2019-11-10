package upgradeddefectmod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;
import com.megacrit.cardcrawl.orbs.Lightning;

import java.util.Iterator;

public class LightningImpulseAction extends AbstractGameAction {
    public LightningImpulseAction() {
        this.duration = Settings.ACTION_DUR_FAST;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST && !AbstractDungeon.player.orbs.isEmpty()) {
            Iterator var1 = AbstractDungeon.player.orbs.iterator();

            while(var1.hasNext()) {
                AbstractOrb o = (AbstractOrb)var1.next();
                if (o instanceof Lightning) {
                    o.onStartOfTurn();
                    o.onEndOfTurn();
                }
            }

            if (AbstractDungeon.player.hasRelic("Cables") && !(AbstractDungeon.player.orbs.get(0) instanceof EmptyOrbSlot) && AbstractDungeon.player.orbs.get(0) instanceof Lightning) {
                (AbstractDungeon.player.orbs.get(0)).onStartOfTurn();
                (AbstractDungeon.player.orbs.get(0)).onEndOfTurn();
            }
        }

        this.tickDuration();
    }
}

