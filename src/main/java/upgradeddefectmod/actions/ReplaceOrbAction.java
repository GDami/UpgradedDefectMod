package upgradeddefectmod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;

public class ReplaceOrbAction extends AbstractGameAction {

    private AbstractOrb orb;
    private int index;

    public ReplaceOrbAction(int index, AbstractOrb orbToPlace) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.orb = orbToPlace;
        this.index = index;
    }

    @Override
    public void update() {

        if (this.duration == Settings.ACTION_DUR_FAST) {
            AbstractPlayer p = AbstractDungeon.player;
            p.orbs.set(this.index, this.orb);
            p.orbs.get(this.index).setSlot(this.index, p.maxOrbs);
            this.orb.applyFocus();
        }

        this.tickDuration();
    }
}
