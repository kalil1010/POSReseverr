package com.github.devnied.emvnfccard.model;

import com.github.devnied.emvnfccard.model.enums.ApplicationStepEnum;
import java.util.List;

/* loaded from: classes.dex */
public class Application extends AbstractData implements Comparable<Application> {
    private static final long serialVersionUID = 2917341864815087679L;
    private byte[] aid;
    private String applicationLabel;
    private List<EmvTransactionRecord> listTransactions;
    private ApplicationStepEnum readingStep = ApplicationStepEnum.NOT_SELECTED;
    private int transactionCounter = -1;
    private int leftPinTry = -1;
    private int priority = 1;
    private float amount = -1.0f;

    public String getApplicationLabel() {
        return this.applicationLabel;
    }

    public void setApplicationLabel(String applicationLabel) {
        this.applicationLabel = applicationLabel;
    }

    public int getTransactionCounter() {
        return this.transactionCounter;
    }

    public void setTransactionCounter(int transactionCounter) {
        this.transactionCounter = transactionCounter;
    }

    public int getLeftPinTry() {
        return this.leftPinTry;
    }

    public void setLeftPinTry(int leftPinTry) {
        this.leftPinTry = leftPinTry;
    }

    public List<EmvTransactionRecord> getListTransactions() {
        return this.listTransactions;
    }

    public void setListTransactions(List<EmvTransactionRecord> listTransactions) {
        this.listTransactions = listTransactions;
    }

    public byte[] getAid() {
        return this.aid;
    }

    public void setAid(byte[] aid) {
        if (aid != null) {
            this.aid = aid;
        }
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override // java.lang.Comparable
    public int compareTo(Application arg0) {
        return this.priority - arg0.getPriority();
    }

    public ApplicationStepEnum getReadingStep() {
        return this.readingStep;
    }

    public void setReadingStep(ApplicationStepEnum readingStep) {
        this.readingStep = readingStep;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
