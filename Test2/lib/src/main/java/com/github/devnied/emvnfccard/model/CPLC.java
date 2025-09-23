package com.github.devnied.emvnfccard.model;

import com.github.devnied.emvnfccard.parser.apdu.annotation.Data;
import com.github.devnied.emvnfccard.parser.apdu.impl.AbstractByteBean;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class CPLC extends AbstractByteBean<CPLC> implements Serializable {
    public static final int SIZE = 42;
    private static final long serialVersionUID = -7955013273912185280L;

    @Data(index = 8, size = 16)
    private Integer ic_batch_id;

    @Data(dateStandard = 2, index = 12, size = 16)
    private Date ic_embedding_date;

    @Data(dateStandard = 2, index = 6, size = 16)
    private Date ic_fabric_date;

    @Data(index = 1, size = 16)
    private Integer ic_fabricator;

    @Data(index = 9, size = 16)
    private Integer ic_module_fabricator;

    @Data(dateStandard = 2, index = 10, size = 16)
    private Date ic_packaging_date;

    @Data(index = 7, size = 32)
    private Integer ic_serial_number;

    @Data(index = 2, size = 16)
    private Integer ic_type;

    @Data(index = 11, size = 16)
    private Integer icc_manufacturer;

    /* renamed from: os */
    @Data(index = 3, size = 16)
    private Integer f64os;

    @Data(dateStandard = 2, index = 4, size = 16)
    private Date os_release_date;

    @Data(index = 5, size = 16)
    private Integer os_release_level;

    @Data(dateStandard = 2, index = 17, size = 16)
    private Date perso_date;

    @Data(index = 18, size = 32)
    private Integer perso_equipment;

    @Data(index = 16, size = 16)
    private Integer perso_id;

    @Data(dateStandard = 2, index = 14, size = 16)
    private Date preperso_date;

    @Data(index = 15, size = 32)
    private Integer preperso_equipment;

    @Data(index = 13, size = 16)
    private Integer preperso_id;

    public Integer getIcFabricator() {
        return this.ic_fabricator;
    }

    public Integer getIcType() {
        return this.ic_type;
    }

    public Integer getOs() {
        return this.f64os;
    }

    public Date getOsReleaseDate() {
        return this.os_release_date;
    }

    public Integer getOsReleaseLevel() {
        return this.os_release_level;
    }

    public Date getIcFabricDate() {
        return this.ic_fabric_date;
    }

    public Integer getIcSerialNumber() {
        return this.ic_serial_number;
    }

    public Integer getIcBatchId() {
        return this.ic_batch_id;
    }

    public Integer getIcModuleFabricator() {
        return this.ic_module_fabricator;
    }

    public Date getIcPackagingDate() {
        return this.ic_packaging_date;
    }

    public Integer getIccManufacturer() {
        return this.icc_manufacturer;
    }

    public Date getIcEmbeddingDate() {
        return this.ic_embedding_date;
    }

    public Integer getPrepersoId() {
        return this.preperso_id;
    }

    public Date getPrepersoDate() {
        return this.preperso_date;
    }

    public Integer getPrepersoEquipment() {
        return this.preperso_equipment;
    }

    public Integer getPersoId() {
        return this.perso_id;
    }

    public Date getPersoDate() {
        return this.perso_date;
    }

    public Integer getPersoEquipment() {
        return this.perso_equipment;
    }
}
