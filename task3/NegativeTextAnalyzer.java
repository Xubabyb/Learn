package platform.kata.academy.task3;

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    public NegativeTextAnalyzer() {
    }

    @Override
    public Label processText(String text) {
        for (String key : getKeywords()) {
            if (text.contains(key)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

    @Override
    protected String[] getKeywords() {
        return new String[]{":(", "=(", ":|."};
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
