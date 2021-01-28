package generator.mail;

import dataProviders.mail.Mail;
import dataProviders.mail.MailDataProvider;
import generator.GeneratorPreprocessor;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailGeneratorPreprocessor extends GeneratorPreprocessor {
    private final MailDataProvider dataProvider;

    public MailGeneratorPreprocessor() {
        super();
        this.title = "SpamGruppeF";
        this.dataProvider = new MailDataProvider();
        processAttributeList();
        processDataList();
    }

    private void processAttributeList() {
        String inText = "_in_Text";
        String inSubject = "_in_Subject";
        addAttributeList(dataProvider.getBlackListedWords(), inText, "integer");
        addAttributeList(dataProvider.getBlackListedWords(), inSubject, "integer");
        addAttributeList(dataProvider.getWhiteListedWords(), inText, "integer");
        addAttributeList(dataProvider.getWhiteListedWords(), inSubject, "integer");
        attributeList.add("averageSentenceLength real");
        attributeList.add("maximumSentenceLength real");
        attributeList.add("biggerThanAverageSubjectLength integer");
        attributeList.add("biggerThanAverageTextLength integer");
    }

    private void addAttributeList(ArrayList<String> wordList, String context, String dataType) {
        for (String word : wordList) {
            word = word.replaceAll("\\s", "_");
            word = word.replaceAll("%", "");
            attributeList.add(word + context + " " + dataType);
        }
    }

    private void processDataList() {
        ExecutorService executor = Executors.newFixedThreadPool(12);

        for (Mail mail : dataProvider.getMails()) {
            System.out.println("neuer Thread MailProcessor");
            Runnable mailProcessor = () -> {
                mail.processAnalytics(
                        dataProvider.getWhiteListedWords(),
                        dataProvider.getBlackListedWords(),
                        dataProvider.getAverageSubjectLength(),
                        dataProvider.getAverageTextLength());
                System.out.println("Mail: " + mail.id + " wurde fertig Bearbeitet.");
            };
            executor.execute(mailProcessor);
        }
        executor.shutdown();

        while (!executor.isTerminated()) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ignored) {
            }
        }
        System.out.println("Finished all threads.");

        for (Mail mail : dataProvider.getMails()) {
            dataList.add(mail.getConvertedBoolArrays());
        }
    }
}
