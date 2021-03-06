package upgradeddefectmod.cards.blue;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.DecreaseMaxOrbAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.FocusPower;
import upgradeddefectmod.UpgradedDefect;
import upgradeddefectmod.powers.LoseOrbSlotsNextTurnPower;

public class CustomConsume extends CustomCard {


    public static final String ID = "UpgradedDefect:Consume";
    private static final String IMG_NAME = UpgradedDefect.makeCardPath(ID.split(":")[1]);
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    private static final int COST = 2;

    public CustomConsume() {
        super(ID, NAME, IMG_NAME, COST, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCard.CardColor.BLUE, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.NONE);
        this.exhaust = true;
        this.baseMagicNumber = 3;
        this.magicNumber = baseMagicNumber;
    }

    public AbstractCard makeCopy() {
        return new CustomConsume();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(2);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new FocusPower(p, this.magicNumber), this.magicNumber));
        AbstractDungeon.actionManager.addToBottom(new DecreaseMaxOrbAction(1));
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new LoseOrbSlotsNextTurnPower(p, 1)));

    }
}
