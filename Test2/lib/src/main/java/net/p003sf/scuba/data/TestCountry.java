package net.p003sf.scuba.data;

/* loaded from: classes.dex */
public class TestCountry extends Country {

    /* renamed from: DV */
    public static final TestCountry f587DV;
    private static final TestCountry[] VALUES;
    private static final long serialVersionUID = 6977914731950342700L;
    private String alpha2Code;
    private String alpha3Code;
    private int code;
    private String name;
    private String nationality;

    /* renamed from: UT */
    public static final TestCountry f588UT = new TestCountry(-1, "UT", "UTO", "Utopia", "Utopian");

    /* renamed from: BP */
    public static final TestCountry f586BP = new TestCountry(-1, "BP", "XBP", "BP", "BP");

    static {
        TestCountry testCountry = new TestCountry(-1, "DV", "XDV", "DV", "DV");
        f587DV = testCountry;
        VALUES = new TestCountry[]{f588UT, f586BP, testCountry};
    }

    private TestCountry() {
    }

    private TestCountry(int code, String alpha2Code, String alpha3Code, String name, String nationality) {
        this.code = code;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.name = name;
        this.nationality = nationality;
    }

    public static TestCountry[] values() {
        return VALUES;
    }

    @Override // net.p003sf.scuba.data.Country
    public int valueOf() {
        return this.code;
    }

    @Override // net.p003sf.scuba.data.Country
    public String getName() {
        return this.name;
    }

    @Override // net.p003sf.scuba.data.Country
    public String getNationality() {
        return this.nationality;
    }

    @Override // net.p003sf.scuba.data.Country
    public String toAlpha2Code() {
        return this.alpha2Code;
    }

    @Override // net.p003sf.scuba.data.Country
    public String toAlpha3Code() {
        return this.alpha3Code;
    }

    public String toString() {
        return this.alpha2Code;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!getClass().equals(other.getClass())) {
            return false;
        }
        TestCountry otherCountry = (TestCountry) other;
        return this.alpha3Code.equals(otherCountry.alpha3Code);
    }

    public int hashCode() {
        return (this.alpha3Code.hashCode() * 2) + 31;
    }
}
