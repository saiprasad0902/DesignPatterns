package src.com.prasad.learnings.abstractfactory;

import src.com.prasad.learnings.abstractfactory.CardType;
import src.com.prasad.learnings.abstractfactory.CreditCardFactory;

public class VisaFactory extends CreditCardFactory {

    @Override
    public CreditCard getCreditCard(CardType cardType){
        switch (cardType){
            case GOLD:
                return new VisaGoldCreditCard();
            case PLATINUM:
                return new VisaBlackCreditCard();
        }
        return null;
    }

    @Override
    public Validator getValidator(CardType cardType){
        return new VisaValidator();
    }

}
