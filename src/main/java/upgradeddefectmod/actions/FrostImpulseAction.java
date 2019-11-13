package upgradeddefectmod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;
import com.megacrit.cardcrawl.orbs.Frost;

import java.util.Iterator;

public class FrostImpulseAction extends AbstractGameAction {

    public FrostImpulseAction() {
        this.duration = Settings.ACTION_DUR_FAST;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST && !AbstractDungeon.player.orbs.isEmpty()) {

            for (AbstractOrb o : AbstractDungeon.player.orbs) {
                if (o instanceof Frost) {
                    o.onStartOfTurn();
                    o.onEndOfTurn();
                }
            }

            if (AbstractDungeon.player.hasRelic("Cables") && !(AbstractDungeon.player.orbs.get(0) instanceof EmptyOrbSlot) && AbstractDungeon.player.orbs.get(0) instanceof Frost) {
                (AbstractDungeon.player.orbs.get(0)).onStartOfTurn();
                (AbstractDungeon.player.orbs.get(0)).onEndOfTurn();
            }
        }

        this.tickDuration();
    }

}
