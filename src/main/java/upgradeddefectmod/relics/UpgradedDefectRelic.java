package upgradeddefectmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.orbs.AbstractOrb;

public class UpgradedDefectRelic extends CustomRelic {

    UpgradedDefectRelic(String id, Texture texture, RelicTier tier, LandingSound sfx) {
        super(id, texture, tier, sfx);
    }

    public UpgradedDefectRelic(String id, Texture texture, Texture outline, RelicTier tier, LandingSound sfx) {
        super(id, texture, outline, tier, sfx);
    }

    public UpgradedDefectRelic(String id, String imgName, RelicTier tier, LandingSound sfx) {
        super(id, imgName, tier, sfx);
    }

    public void onChannel(AbstractOrb o) {

    }

}
