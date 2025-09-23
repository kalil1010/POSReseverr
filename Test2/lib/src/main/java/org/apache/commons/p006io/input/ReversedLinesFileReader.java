package org.apache.commons.p006io.input;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p006io.Charsets;
import org.apache.commons.p006io.IOUtils;

/* loaded from: classes.dex */
public class ReversedLinesFileReader implements Closeable {
    private final int avoidNewlineSplitBufferSize;
    private final int blockSize;
    private final int byteDecrement;
    private FilePart currentFilePart;
    private final Charset encoding;
    private final byte[][] newLineSequences;
    private final RandomAccessFile randomAccessFile;
    private final long totalBlockCount;
    private final long totalByteLength;
    private boolean trailingNewlineOfFileSkipped;

    @Deprecated
    public ReversedLinesFileReader(File file) throws IOException {
        this(file, 4096, Charset.defaultCharset());
    }

    public ReversedLinesFileReader(File file, Charset charset) throws IOException {
        this(file, 4096, charset);
    }

    public ReversedLinesFileReader(File file, int blockSize, Charset encoding) throws IOException {
        this.trailingNewlineOfFileSkipped = false;
        this.blockSize = blockSize;
        this.encoding = encoding;
        Charset charset = Charsets.toCharset(encoding);
        CharsetEncoder charsetEncoder = charset.newEncoder();
        float maxBytesPerChar = charsetEncoder.maxBytesPerChar();
        if (maxBytesPerChar == 1.0f || charset == StandardCharsets.UTF_8 || charset == Charset.forName("Shift_JIS") || charset == Charset.forName("windows-31j") || charset == Charset.forName("x-windows-949") || charset == Charset.forName("gbk") || charset == Charset.forName("x-windows-950")) {
            this.byteDecrement = 1;
        } else if (charset == StandardCharsets.UTF_16BE || charset == StandardCharsets.UTF_16LE) {
            this.byteDecrement = 2;
        } else {
            if (charset == StandardCharsets.UTF_16) {
                throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
            }
            throw new UnsupportedEncodingException("Encoding " + encoding + " is not supported yet (feel free to submit a patch)");
        }
        byte[][] bArr = {IOUtils.LINE_SEPARATOR_WINDOWS.getBytes(encoding), "\n".getBytes(encoding), StringUtils.f866CR.getBytes(encoding)};
        this.newLineSequences = bArr;
        this.avoidNewlineSplitBufferSize = bArr[0].length;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        this.randomAccessFile = randomAccessFile;
        long length = randomAccessFile.length();
        this.totalByteLength = length;
        int lastBlockLength = (int) (length % blockSize);
        if (lastBlockLength > 0) {
            this.totalBlockCount = (length / blockSize) + 1;
        } else {
            this.totalBlockCount = length / blockSize;
            if (length > 0) {
                lastBlockLength = blockSize;
            }
        }
        this.currentFilePart = new FilePart(this.totalBlockCount, lastBlockLength, null);
    }

    public ReversedLinesFileReader(File file, int blockSize, String encoding) throws IOException {
        this(file, blockSize, Charsets.toCharset(encoding));
    }

    public String readLine() throws IOException {
        String line = this.currentFilePart.readLine();
        while (line == null) {
            FilePart filePartRollOver = this.currentFilePart.rollOver();
            this.currentFilePart = filePartRollOver;
            if (filePartRollOver == null) {
                break;
            }
            line = filePartRollOver.readLine();
        }
        if ("".equals(line) && !this.trailingNewlineOfFileSkipped) {
            this.trailingNewlineOfFileSkipped = true;
            String line2 = readLine();
            return line2;
        }
        return line;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.randomAccessFile.close();
    }

    private class FilePart {
        private int currentLastBytePos;
        private final byte[] data;
        private byte[] leftOver;

        /* renamed from: no */
        private final long f863no;

        private FilePart(long no, int length, byte[] leftOverOfLastFilePart) throws IOException {
            this.f863no = no;
            int dataLength = (leftOverOfLastFilePart != null ? leftOverOfLastFilePart.length : 0) + length;
            this.data = new byte[dataLength];
            long off = (no - 1) * ReversedLinesFileReader.this.blockSize;
            if (no > 0) {
                ReversedLinesFileReader.this.randomAccessFile.seek(off);
                int countRead = ReversedLinesFileReader.this.randomAccessFile.read(this.data, 0, length);
                if (countRead != length) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (leftOverOfLastFilePart != null) {
                System.arraycopy(leftOverOfLastFilePart, 0, this.data, length, leftOverOfLastFilePart.length);
            }
            this.currentLastBytePos = this.data.length - 1;
            this.leftOver = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FilePart rollOver() throws IOException {
            if (this.currentLastBytePos > -1) {
                throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
            }
            if (this.f863no > 1) {
                ReversedLinesFileReader reversedLinesFileReader = ReversedLinesFileReader.this;
                return reversedLinesFileReader.new FilePart(this.f863no - 1, reversedLinesFileReader.blockSize, this.leftOver);
            }
            if (this.leftOver != null) {
                throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.leftOver, ReversedLinesFileReader.this.encoding));
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
        
            if (r1 == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
        
            if (r9.leftOver == null) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:
        
            r3 = new java.lang.String(r9.leftOver, r9.this$0.encoding);
            r9.leftOver = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
        
            return r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        
            return r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String readLine() throws java.io.IOException {
            /*
                r9 = this;
                r0 = 0
                long r1 = r9.f863no
                r3 = 0
                r4 = 1
                r5 = 1
                int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r7 != 0) goto Ld
                r1 = 1
                goto Le
            Ld:
                r1 = 0
            Le:
                int r2 = r9.currentLastBytePos
            L10:
                r5 = -1
                if (r2 <= r5) goto L6d
                if (r1 != 0) goto L21
                org.apache.commons.io.input.ReversedLinesFileReader r5 = org.apache.commons.p006io.input.ReversedLinesFileReader.this
                int r5 = org.apache.commons.p006io.input.ReversedLinesFileReader.access$600(r5)
                if (r2 >= r5) goto L21
                r9.createLeftOver()
                goto L6d
            L21:
                byte[] r5 = r9.data
                int r5 = r9.getNewLineMatchByteCount(r5, r2)
                r6 = r5
                if (r5 <= 0) goto L61
                int r5 = r2 + 1
                int r7 = r9.currentLastBytePos
                int r7 = r7 - r5
                int r7 = r7 + r4
                if (r7 < 0) goto L4a
                byte[] r4 = new byte[r7]
                byte[] r8 = r9.data
                java.lang.System.arraycopy(r8, r5, r4, r3, r7)
                java.lang.String r3 = new java.lang.String
                org.apache.commons.io.input.ReversedLinesFileReader r8 = org.apache.commons.p006io.input.ReversedLinesFileReader.this
                java.nio.charset.Charset r8 = org.apache.commons.p006io.input.ReversedLinesFileReader.access$500(r8)
                r3.<init>(r4, r8)
                r0 = r3
                int r3 = r2 - r6
                r9.currentLastBytePos = r3
                goto L6d
            L4a:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r8 = "Unexpected negative line length="
                r4.append(r8)
                r4.append(r7)
                java.lang.String r4 = r4.toString()
                r3.<init>(r4)
                throw r3
            L61:
                org.apache.commons.io.input.ReversedLinesFileReader r5 = org.apache.commons.p006io.input.ReversedLinesFileReader.this
                int r5 = org.apache.commons.p006io.input.ReversedLinesFileReader.access$700(r5)
                int r2 = r2 - r5
                if (r2 >= 0) goto L10
                r9.createLeftOver()
            L6d:
                if (r1 == 0) goto L84
                byte[] r3 = r9.leftOver
                if (r3 == 0) goto L84
                java.lang.String r3 = new java.lang.String
                byte[] r4 = r9.leftOver
                org.apache.commons.io.input.ReversedLinesFileReader r5 = org.apache.commons.p006io.input.ReversedLinesFileReader.this
                java.nio.charset.Charset r5 = org.apache.commons.p006io.input.ReversedLinesFileReader.access$500(r5)
                r3.<init>(r4, r5)
                r0 = r3
                r3 = 0
                r9.leftOver = r3
            L84:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.input.ReversedLinesFileReader.FilePart.readLine():java.lang.String");
        }

        private void createLeftOver() {
            int lineLengthBytes = this.currentLastBytePos + 1;
            if (lineLengthBytes > 0) {
                byte[] bArr = new byte[lineLengthBytes];
                this.leftOver = bArr;
                System.arraycopy(this.data, 0, bArr, 0, lineLengthBytes);
            } else {
                this.leftOver = null;
            }
            this.currentLastBytePos = -1;
        }

        private int getNewLineMatchByteCount(byte[] data, int i) {
            for (byte[] newLineSequence : ReversedLinesFileReader.this.newLineSequences) {
                boolean match = true;
                for (int j = newLineSequence.length - 1; j >= 0; j--) {
                    int k = (i + j) - (newLineSequence.length - 1);
                    match &= k >= 0 && data[k] == newLineSequence[j];
                }
                if (match) {
                    return newLineSequence.length;
                }
            }
            return 0;
        }
    }
}
