
public class Atm {

    private static final String ACCOUNT_NUMBER = "accountNumber";
    private static final String ACCOUNT_BALANCE = "accountBalance";
    private static final String ACCOUNT_PIN = "accountPin";

    private static final String CREDIT_CARD = "creditCard";
    private static final String CREDIT_CARD_NUMBER = "creditCardNumber";


    public static void main(String[] args) {
        BruteForceIE atm = new BruteForceIE();

        Fact account1 = new Fact("Account1")
                .addProperty(ACCOUNT_NUMBER, 1234)
                .addProperty(ACCOUNT_PIN, 5678)
                .addProperty(ACCOUNT_BALANCE, 1000000);

        Fact account2 = new Fact("Account2")
                .addProperty(ACCOUNT_NUMBER, 42)
                .addProperty(ACCOUNT_PIN, 4242)
                .addProperty(ACCOUNT_BALANCE, 42000000);

        atm.addFact(account1);
        atm.addFact(account2);


        Rule processCreditCard = new Rule()
                .addCondition(ClauseOperators.exists,
                        new Fact(CREDIT_CARD)
                                .addProperty(CREDIT_CARD_NUMBER, 1234)
                )
                .addConsequence(ClauseOperators.assertFact,
                        new Fact("pinNumber")
                                .addProperty("pin", null)
                );
        atm.addRule(processCreditCard);

        Fact insertCreditCard = new Fact("insertCreditCard")
                .addProperty(CREDIT_CARD, 1234);
        atm.addFact(insertCreditCard);

        atm.checkRules();
    }
}
