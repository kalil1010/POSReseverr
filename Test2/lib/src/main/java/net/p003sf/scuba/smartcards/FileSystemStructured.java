package net.p003sf.scuba.smartcards;

/* loaded from: classes.dex */
public interface FileSystemStructured {
    FileInfo[] getSelectedPath() throws CardServiceException;

    byte[] readBinary(int i, int i2) throws CardServiceException;

    void selectFile(short s) throws CardServiceException;
}
