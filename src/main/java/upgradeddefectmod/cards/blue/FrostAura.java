package upgradeddefectmod.cards.blue;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;
import com.megacrit.cardcrawl.orbs.Frost;
import upgradeddefectmod.UpgradedDefect;

public class FrostAura extends CustomCard {


    public static final String ID = "UpgradedDefect:FrostAura";
    private static final String IMG_NAME = UpgradedDefect.makeCardPath(ID.split(":")[1]);
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    private static final int COST = 1;

    public FrostAura() {
        super(ID, NAME, IMG_NAME, COST, DESCRIPTION, CardType.SKILL, AbstractCard.CardColor.BLUE, AbstractCard.CardRarity.COMMON, CardTarget.NONE);
        this.exhaust = true;
    }

    public AbstractCard makeCopy() {
        return new FrostAura();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.isInnate = true;
            this.upgradeName();
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!p.orbs.isEmpty()) {
            for (int i=0 ; i < p.orbs.size() ; i++) {
                if (p.orbs.get(i) instanceof EmptyOrbSlot) {
                    AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Frost()));
                }
            }
        }
    }
}
