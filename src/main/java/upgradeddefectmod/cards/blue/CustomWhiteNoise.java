package upgradeddefectmod.cards.blue;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import upgradeddefectmod.UpgradedDefect;

public class CustomWhiteNoise extends CustomCard {


    public static final String ID = "UpgradedDefect:WhiteNoise";
    private static final String IMG_NAME = UpgradedDefect.makeCardPath(ID.split(":")[1]);
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    private static final int COST = 1;

    public CustomWhiteNoise() {
        super(ID, NAME, IMG_NAME, COST, DESCRIPTION, CardType.SKILL, CardColor.BLUE, CardRarity.UNCOMMON, CardTarget.NONE);
        this.baseMagicNumber = 1;
        this.exhaust = true;
    }

    public AbstractCard makeCopy() {
        return new CustomWhiteNoise();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
            this.exhaust = false;

        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractCard c = AbstractDungeon.returnTrulyRandomCardInCombat(CardType.POWER).makeCopy();
        c.setCostForTurn(0);
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(c, true));
    }
}
