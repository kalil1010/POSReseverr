package net.p003sf.scuba.smartcards;

/* loaded from: classes.dex */
public abstract class AbstractFileSystemStructured implements FileSystemStructured {
    public static final short MF_ID = 16128;
    private ISOFileInfo fileInfo;
    private int length;

    /* renamed from: p2 */
    private int f835p2;
    private int selectLe;
    private short selectedFID;
    private CardService service;

    @Override // net.p003sf.scuba.smartcards.FileSystemStructured
    public abstract byte[] readBinary(int i, int i2);

    public AbstractFileSystemStructured(CardService service) {
        this.service = null;
        this.selectedFID = (short) 0;
        this.length = -1;
        this.f835p2 = 0;
        this.selectLe = 256;
        this.fileInfo = null;
        this.service = service;
    }

    public AbstractFileSystemStructured(CardService service, boolean fileInfo) {
        this.service = null;
        this.selectedFID = (short) 0;
        this.length = -1;
        this.f835p2 = 0;
        this.selectLe = 256;
        this.fileInfo = null;
        this.service = service;
        this.f835p2 = fileInfo ? 0 : 12;
        this.selectLe = fileInfo ? 256 : 0;
    }

    public int getFileLength() throws CardServiceException {
        return this.length;
    }

    public short getSelectedFID() {
        return this.selectedFID;
    }

    private void selectFile(byte[] data, int p1) throws CardServiceException {
        CommandAPDU command = createSelectFileAPDU(p1, this.f835p2, data, this.selectLe);
        ResponseAPDU response = this.service.transmit(command);
        int respSW = response.getSW();
        byte[] respData = response.getData();
        if (respSW != -28672) {
            throw new CardServiceException("File could not be selected.", respSW);
        }
        ISOFileInfo iSOFileInfo = new ISOFileInfo(respData);
        this.fileInfo = iSOFileInfo;
        if (iSOFileInfo.fid != -1) {
            this.selectedFID = this.fileInfo.fid;
        }
        if (this.fileInfo.fileLength != -1) {
            this.length = this.fileInfo.fileLength;
        }
    }

    private void selectFile(short fid, int p1) throws CardServiceException {
        byte[] fidbytes = fid == 0 ? new byte[0] : new byte[]{(byte) ((fid >> 8) & 255), (byte) (fid & 255)};
        selectFile(fidbytes, p1);
    }

    @Override // net.p003sf.scuba.smartcards.FileSystemStructured
    public void selectFile(short fid) throws CardServiceException {
        selectFile(fid, 0);
    }

    public void selectMF() throws CardServiceException {
        selectFile((short) 0, 0);
    }

    public void selectParent() throws CardServiceException {
        selectFile((short) 0, 3);
    }

    public void selectEFRelative(short fid) throws CardServiceException {
        selectFile(fid, 2);
    }

    public void selectDFRelative(short fid) throws CardServiceException {
        selectFile(fid, 1);
    }

    public void selectAID(byte[] aid) throws CardServiceException {
        selectFile(aid, 4);
    }

    public void selectPath(byte[] path) throws CardServiceException {
        selectFile(path, 8);
    }

    public void selectPathRelative(byte[] path) throws CardServiceException {
        selectFile(path, 9);
    }

    private CommandAPDU createSelectFileAPDU(int p1, int p2, byte[] data, int le) {
        if (le == 0) {
            return new CommandAPDU(0, -92, p1, p2, data);
        }
        return new CommandAPDU(0, -92, p1, p2, data, le);
    }
}
